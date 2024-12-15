import java.util.*;
import java.util.concurrent.*;
import java.io.*;

public class EnhancedCricketGame {
    public static void main(String[] args) {
        CricketGame game = new CricketGame();
        game.start();
    }
}

enum MatchType {
    ODI(50),
    T20(20),
    CUSTOM(-1);

    final int overs;

    MatchType(int overs) {
        this.overs = overs;
    }
}

class CricketException extends Exception {
    CricketException(String message) {
        super(message);
    }
}

abstract class CricketEntity {
    String name;
    int runs;

    CricketEntity(String name) {
        this.name = name;
    }

    abstract void addRuns(int runs);
}

class Player extends CricketEntity {
    int ballsFaced;
    int fours;
    int sixes;
    boolean isOut;

    Player(String name) {
        super(name);
    }

    @Override
    void addRuns(int runs) {
        this.runs += runs;
        ballsFaced++;
        if (runs == 4) fours++;
        if (runs == 6) sixes++;
    }

    double getStrikeRate() {
        return ballsFaced == 0 ? 0 : (runs * 100.0) / ballsFaced;
    }
}

class Team extends CricketEntity {
    List<Player> players;
    int wickets;
    Extras extras;

    Team(String name) {
        super(name);
        players = new ArrayList<>();
        extras = new Extras();
    }

    @Override
    void addRuns(int runs) {
        this.runs += runs;
    }

    void addPlayer(Player player) {
        players.add(player);
    }

    void addWicket() {
        wickets++;
    }
}

class Extras {
    int wides;
    int noBalls;
    int byes;
    int legByes;

    int getTotal() {
        return wides + noBalls + byes + legByes;
    }
}

class InputValidator {
    static int validateRuns(String input) throws CricketException {
        try {
            int runs = Integer.parseInt(input);
            if (runs < 0 || runs > 6) {
                throw new CricketException("Invalid runs. Enter 0-6.");
            }
            return runs;
        } catch (NumberFormatException e) {
            throw new CricketException("Invalid input. Enter a number between 0 and 6.");
        }
    }

    static void validateBallType(String input) throws CricketException {
        if (!input.equals("W") && !input.equals("N") && !input.equals("WD") && !input.equals("B") && !input.equals("LB")) {
            throw new CricketException("Invalid ball type. Use W, N, WD, B, or LB.");
        }
    }
}

abstract class Match {
    Team team1;
    Team team2;
    Team battingTeam;
    Team bowlingTeam;
    int overs;
    Scanner scanner;
    boolean isPaused;
    static final String INPUT_GUIDE = "Enter: 0-6 (runs), W (wicket), N (no-ball), WD (wide), B (bye), LB (leg bye)";
    MatchStatistics matchStats;
    MatchSummary matchSummary;

    Match(Team team1, Team team2, Scanner scanner) {
        this.team1 = team1;
        this.team2 = team2;
        this.scanner = scanner;
        this.isPaused = false;
    }

    abstract void setMatchRules();

    void startMatch(MatchStatistics stats, MatchSummary summary) {
        this.matchStats = stats;
        this.matchSummary = summary;
        setMatchRules();
        toss();
        playInnings(battingTeam, bowlingTeam);
        Team temp = battingTeam;
        battingTeam = bowlingTeam;
        bowlingTeam = temp;
        playInnings(battingTeam, bowlingTeam);
        announceWinner();
    }

    private void toss() {
        System.out.println("\n--- Time for the toss! ---");
        System.out.print("Team " + team1.name + ", call Heads or Tails (H/T): ");
        String call = scanner.next().toUpperCase();
        boolean isHeads = Math.random() < 0.5;
        System.out.println("The coin shows: " + (isHeads ? "Heads" : "Tails"));
        
        Team tossWinner = (call.equals("H") == isHeads) ? team1 : team2;
        System.out.println(tossWinner.name + " wins the toss!");
        
        System.out.print("Choose to Bat or Bowl (BAT/BOWL): ");
        String choice = scanner.next().toUpperCase();
        if (choice.equals("BAT")) {
            battingTeam = tossWinner;
            bowlingTeam = (tossWinner == team1) ? team2 : team1;
        } else {
            bowlingTeam = tossWinner;
            battingTeam = (tossWinner == team1) ? team2 : team1;
        }
        System.out.println(battingTeam.name + " will bat first.");
    }

    private void playInnings(Team battingTeam, Team bowlingTeam) {
        System.out.println("\n--- " + battingTeam.name + " is batting ---");
        System.out.println(INPUT_GUIDE);
        int currentBatsman = 0;
        int nonStrikerBatsman = 1;
        for (int over = 1; over <= overs; over++) {
            for (int ball = 1; ball <= 6; ball++) {
                if (battingTeam.wickets == 10) break;
                System.out.print("\nOver " + over + ", Ball " + ball + ": ");
                String input = scanner.next().toUpperCase();
                
                if (input.equals("PAUSE")) {
                    pauseMatch();
                    ball--; // Repeat the ball
                    continue;
                }
                
                try {
                    if (input.equals("W") || input.equals("N") || input.equals("WD") || input.equals("B") || input.equals("LB")) {
                        switch (input) {
                            case "W":
                                battingTeam.addWicket();
                                currentBatsman = getNextBatsman(battingTeam);
                                System.out.println(Commentary.getCommentary("wicket"));
                                break;
                            case "N":
                                handleNoBall(battingTeam, currentBatsman, nonStrikerBatsman);
                                ball--; // Repeat the ball
                                break;
                            case "WD":
                                handleWideBall(battingTeam);
                                ball--; // Repeat the ball
                                break;
                            case "B":
                            case "LB":
                                handleByes(battingTeam, input);
                                break;
                        }
                    } else {
                        int runs = InputValidator.validateRuns(input);
                        battingTeam.addRuns(runs);
                        battingTeam.players.get(currentBatsman).addRuns(runs);
                        if (runs % 2 != 0) {
                            int temp = currentBatsman;
                            currentBatsman = nonStrikerBatsman;
                            nonStrikerBatsman = temp;
                        }
                        System.out.println(Commentary.getCommentary(String.valueOf(runs)));
                    }
                    matchSummary.addToSummary(String.format("Over %d.%d: %s", over, ball, input));
                    matchStats.createInningsStats().updateStats(battingTeam.runs, battingTeam.wickets);
                } catch (CricketException e) {
                    System.out.println(e.getMessage() + " " + INPUT_GUIDE);
                    ball--; // Repeat the ball
                }
            }
            // Switch strike at the end of the over
            int temp = currentBatsman;
            currentBatsman = nonStrikerBatsman;
            nonStrikerBatsman = temp;
            displayScore(battingTeam);
        }
    }

    private void pauseMatch() {
        isPaused = true;
        System.out.println("Match paused. Press ENTER to resume.");
        scanner.nextLine(); // Consume the newline
        scanner.nextLine(); // Wait for ENTER
        isPaused = false;
        System.out.println("Match resumed.");
    }

    private int getNextBatsman(Team team) {
        for (int i = 0; i < team.players.size(); i++) {
            if (!team.players.get(i).isOut) {
                return i;
            }
        }
        return -1; // All out
    }

    private void handleNoBall(Team battingTeam, int currentBatsman, int nonStrikerBatsman) {
        battingTeam.extras.noBalls++;
        battingTeam.addRuns(1);
        System.out.print("No ball! Runs scored (0-6) or W for wicket: ");
        String input = scanner.next().toUpperCase();
        if (input.equals("W")) {
            System.out.println("Batsman cannot be out on a no-ball, except for run out.");
        } else {
            try {
                int runs = InputValidator.validateRuns(input);
                battingTeam.addRuns(runs);
                battingTeam.players.get(currentBatsman).addRuns(runs);
                if (runs % 2 != 0) {
                    int temp = currentBatsman;
                    currentBatsman = nonStrikerBatsman;
                    nonStrikerBatsman = temp;
                }
            } catch (CricketException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Commentary.getCommentary("noball"));
    }

    private void handleWideBall(Team battingTeam) {
        battingTeam.extras.wides++;
        battingTeam.addRuns(1);
        System.out.println(Commentary.getCommentary("wide"));
    }

    private void handleByes(Team battingTeam, String type) {
        System.out.print("Runs scored: ");
        try {
            int runs = InputValidator.validateRuns(scanner.next());
            battingTeam.addRuns(runs);
            if (type.equals("B")) {
                battingTeam.extras.byes += runs;
            } else {
                battingTeam.extras.legByes += runs;
            }
            System.out.println(Commentary.getCommentary(type.toLowerCase()));
        } catch (CricketException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayScore(Team team) {
        System.out.println("\nScore: " + team.name + " - " + team.runs + "/" + team.wickets);
        System.out.println("Overs: " + overs);
    }

    private void announceWinner() {
        System.out.println("\n--- Match ended! ---");
        System.out.println(team1.name + ": " + team1.runs + "/" + team1.wickets);
        System.out.println(team2.name + ": " + team2.runs + "/" + team2.wickets);
        if (team1.runs > team2.runs) {
            System.out.println(team1.name + " wins by " + (team1.runs - team2.runs) + " runs!");
        } else if (team2.runs > team1.runs) {
            System.out.println(team2.name + " wins by " + (10 - team2.wickets) + " wickets!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

class ODIMatch extends Match {
    ODIMatch(Team team1, Team team2, Scanner scanner) {
        super(team1, team2, scanner);
    }

    @Override
    void setMatchRules() {
        this.overs = MatchType.ODI.overs;
        System.out.println("This is an ODI match with " + overs + " overs per innings.");
    }
}

class T20Match extends Match {
    T20Match(Team team1, Team team2, Scanner scanner) {
        super(team1, team2, scanner);
    }

    @Override
    void setMatchRules() {
        this.overs = MatchType.T20.overs;
        System.out.println("This is a T20 match with " + overs + " overs per innings.");
    }
}

class CustomMatch extends Match {
    CustomMatch(Team team1, Team team2, Scanner scanner) {
        super(team1, team2, scanner);
    }

    @Override
    void setMatchRules() {
        System.out.print("Enter the number of overs for this custom match: ");
        this.overs = scanner.nextInt();
        System.out.println("This is a custom match with " + overs + " overs per innings.");
    }
}

class Scoreboard {
    void displayDetailedScoreboard(Team team) {
        System.out.println("\n--- Detailed Scoreboard for " + team.name + " ---");
        System.out.println("Total: " + team.runs + "/" + team.wickets);
        System.out.println("Extras: " + team.extras.getTotal() + " (Wd " + team.extras.wides + 
                           ", NB " + team.extras.noBalls + ", B " + team.extras.byes + 
                           ", LB " + team.extras.legByes + ")");
        System.out.println("\nBatting:");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s%n", "Player", "Runs", "Balls", "4s", "6s", "S/R");
        for (Player player : team.players) {
            if (player.ballsFaced > 0 || player.isOut) {
                System.out.printf("%-20s %-10d %-10d %-10d %-10d %-10.2f%n", 
                                  player.name, player.runs, player.ballsFaced, player.fours, player.sixes, player.getStrikeRate());
            }
        }
    }

    void displayScoreboard(Team team) {
        System.out.println("\nScoreboard for " + team.name);
        System.out.println("Total: " + team.runs + "/" + team.wickets);
    }
}

class MainMenu {
    private Scanner scanner;
    private CricketGame game;

    MainMenu(Scanner scanner, CricketGame game) {
        this.scanner = scanner;
        this.game = game;
    }

    void display() {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Start a new match");
            System.out.println("2. View statistics");
            System.out.println("3. Adjust settings");
            
            System.out.println("4. View previous scores");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    game.startNewMatch();
                    break;
                case 2:
                    viewStatistics();
                    break;
                case 3:
                    adjustSettings();
                    break;
                case 4:
                    ScoreFileManager.displayPreviousScores();
                    break;
                case 5:
                    System.out.println("Thank you for playing!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewStatistics() {
        System.out.println("\n--- Statistics ---");
        CricketStats stats = CricketStats.getInstance();
        stats.displayAllStats();
    }

    private void adjustSettings() {
        System.out.println("\n--- Settings ---");
        System.out.println("1. Change commentary style");
        System.out.println("2. Toggle real-time updates");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                game.changeCommentaryStyle();
                break;
            case 2:
                game.toggleRealTimeUpdates();
                break;
            default:
                System.out.println("Invalid choice. No changes made.");
        }
    }
}

class CricketGame {
    private Scanner scanner;
    private Team team1;
    private Team team2;
    private Scoreboard scoreboard;
    private MainMenu mainMenu;
    private boolean realTimeUpdates;
    private CommentaryThread commentaryThread;

    public CricketGame() {
        scanner = new Scanner(System.in);
        scoreboard = new Scoreboard();
        mainMenu = new MainMenu(scanner, this);
        realTimeUpdates = false;
    }

    public void start() {
        System.out.println("Welcome to the Cricket Game!");
        mainMenu.display();
    }

    void startNewMatch() {
        createTeams();
        MatchType matchType = selectMatchType();
        Match match = createMatch(matchType);
        MatchStatistics matchStats = new MatchStatistics();
        MatchSummary matchSummary = new MatchSummary();

        if (realTimeUpdates) {
            commentaryThread = new CommentaryThread(match);
            commentaryThread.start();
        }

        match.startMatch(matchStats, matchSummary);

        if (realTimeUpdates) {
            commentaryThread.stopRunning();
            try {
                commentaryThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        displayFinalScoreboard();
        updateStatistics();
        ScoreFileManager.saveScore(team1, team2);
        displayMatchSummary(matchSummary);
        displayPlayerPerformances();
        matchStats.displayOverallStats();
    }

    private void createTeams() {
        System.out.println("\n--- Team Selection ---");
        System.out.println("1. Use preset teams");
        System.out.println("2. Create custom teams");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            createPresetTeams();
        } else {
            createCustomTeams();
        }
    }

    private void createPresetTeams() {
        System.out.println("Available preset teams: India, Australia, New Zealand");
        System.out.print("Enter name for Team 1: ");
        team1 = TeamFactory.getPresetTeam(scanner.nextLine());
        System.out.print("Enter name for Team 2: ");
        team2 = TeamFactory.getPresetTeam(scanner.nextLine());
    }

    private void createCustomTeams() {
        System.out.print("Enter name for Team 1: ");
        String team1Name = scanner.nextLine();
        team1 = TeamFactory.createCustomTeam(team1Name, scanner);

        System.out.print("Enter name for Team 2: ");
        String team2Name = scanner.nextLine();
        team2 = TeamFactory.createCustomTeam(team2Name, scanner);
    }

    private MatchType selectMatchType() {
        System.out.println("\n--- Select match type ---");
        System.out.println("1. ODI (50 overs)");
        System.out.println("2. T20 (20 overs)");
        System.out.println("3. Custom");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                return MatchType.ODI;
            case 2:
                return MatchType.T20;
            case 3:
                return MatchType.CUSTOM;
            default:
                throw new IllegalArgumentException("Invalid match type choice");
        }
    }

    private Match createMatch(MatchType matchType) {
        switch (matchType) {
            case ODI:
                return new ODIMatch(team1, team2, scanner);
            case T20:
                return new T20Match(team1, team2, scanner);
            case CUSTOM:
                return new CustomMatch(team1, team2, scanner);
            default:
                throw new IllegalArgumentException("Invalid match type");
        }
    }

    private void displayFinalScoreboard() {
        System.out.println("\n======= FINAL SCOREBOARD =======");
        scoreboard.displayDetailedScoreboard(team1);
        scoreboard.displayDetailedScoreboard(team2);
    }

    private void updateStatistics() {
        CricketStats stats = CricketStats.getInstance();
        for (Player player : team1.players) {
            stats.updatePlayerStats(player.name, player.runs);
        }
        for (Player player : team2.players) {
            stats.updatePlayerStats(player.name, player.runs);
        }
    }

    void changeCommentaryStyle() {
        System.out.println("Select commentary style:");
        System.out.println("1. Standard");
        System.out.println("2. Enthusiastic");
        System.out.println("3. Technical");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Commentary.setStyle(choice);
        System.out.println("Commentary style changed.");
    }

    void toggleRealTimeUpdates() {
        realTimeUpdates = !realTimeUpdates;
        System.out.println("Real-time updates " + (realTimeUpdates ? "enabled" : "disabled") + ".");
    }

    private void displayMatchSummary(MatchSummary summary) {
        System.out.println(summary.getSummary());
    }

    private void displayPlayerPerformances() {
        System.out.println("\nTop Performances:");
        List<PlayerPerformance> performances = new ArrayList<>();
        for (Player player : team1.players) {
            performances.add(new PlayerPerformance(player.name, player.runs, player.getStrikeRate()));
        }
        for (Player player : team2.players) {
            performances.add(new PlayerPerformance(player.name, player.runs, player.getStrikeRate()));
        }
        performances.sort((p1, p2) -> p2.getRuns().compareTo(p1.getRuns()));
        for (int i = 0; i < Math.min(3, performances.size()); i++) {
            System.out.println(performances.get(i));
        }
    }
}

class TeamFactory {
    private static final String[] INDIAN_PLAYERS = {"Virat Kohli", "Rohit Sharma", "KL Rahul", "Rishabh Pant", "Hardik Pandya", "Ravindra Jadeja", "Jasprit Bumrah", "Mohammed Shami", "Yuzvendra Chahal", "Shikhar Dhawan", "Bhuvneshwar Kumar"};
    private static final String[] AUSTRALIAN_PLAYERS = {"Steve Smith", "David Warner", "Aaron Finch", "Glenn Maxwell", "Pat Cummins", "Mitchell Starc", "Josh Hazlewood", "Adam Zampa", "Marcus Stoinis", "Alex Carey", "Matthew Wade"};
    private static final String[] NZ_PLAYERS = {"Kane Williamson", "Martin Guptill", "Ross Taylor", "Tom Latham", "Trent Boult", "Tim Southee", "Lockie Ferguson", "Mitchell Santner", "Jimmy Neesham", "Colin de Grandhomme", "Ish Sodhi"};

    static Team createTeam(String teamName, String[] playerNames) {
        Team team = new Team(teamName);
        for (String playerName : playerNames) {
            team.addPlayer(new Player(playerName));
        }
        return team;
    }

    static Team createCustomTeam(String teamName, Scanner scanner) {
        Team team = new Team(teamName);
        System.out.println("Enter names for 11 players:");
        for (int i = 1; i <= 11; i++) {
            System.out.print("Player " + i + ": ");
            String playerName = scanner.nextLine();
            team.addPlayer(new Player(playerName));
        }
        return team;
    }

    static Team getPresetTeam(String teamName) {
        switch (teamName.toLowerCase()) {
            case "india":
                return createTeam("India", INDIAN_PLAYERS);
            case "australia":
                return createTeam("Australia", AUSTRALIAN_PLAYERS);
            case "new zealand":
                return createTeam("New Zealand", NZ_PLAYERS);
            default:
                throw new IllegalArgumentException("Unknown preset team: " + teamName);
        }
    }
}

class Commentary {
    private static int style = 1; // 1: Standard, 2: Enthusiastic, 3: Technical
    private static final String[] GENERAL_COMMENTS = {
        "What a shot!",
        "Brilliant play by the batsman!",
        "The crowd goes wild!",
        "That's some exceptional cricket right there!",
        "The bowler looks frustrated after that one!",
        "A display of pure cricketing excellence!",
        "The batsman is really finding his rhythm now!"
    };
    
    private static final String[] REAL_LIFE_COMMENTS = {
        "He's picked the gap beautifully!",
        "That's gone like a tracer bullet!",
        "The batsman had no answer to that delivery!",
        "He's dancing down the track!",
        "That's a peach of a delivery!",
        "The fielder had no chance, it was hit with such power!",
        "He's thrown the kitchen sink at that one!"
    };
    
    static String getCommentary(String event) {
        String comment = GENERAL_COMMENTS[new Random().nextInt(GENERAL_COMMENTS.length)];
        String realLifeComment = REAL_LIFE_COMMENTS[new Random().nextInt(REAL_LIFE_COMMENTS.length)];
        
        String stylePrefix = "";
        switch (style) {
            case 2:
                stylePrefix = "Wow! ";
                break;
            case 3:
                stylePrefix = "Technically speaking, ";
                break;
        }
        
        switch (event) {
            case "4":
                return stylePrefix + "Four! " + comment + " " + realLifeComment;
            case "6":
                return stylePrefix + "Six! " + comment + " " + realLifeComment;
            case "wicket":
                return stylePrefix + "Out! " + realLifeComment + " The batsman is heading back to the pavilion. What a delivery!";
            case "noball":
                return stylePrefix + "No ball! Free hit coming up. " + realLifeComment + " The batsman has a chance to capitalize!";
            case "wide":
                return stylePrefix + "Wide ball! An extra run for the batting team. " + realLifeComment + " The bowler needs to improve his line.";
            case "bye":
            case "legbye":
                return stylePrefix + "And some more runs added to the extras. " + realLifeComment + " The fielding team needs to stay sharp.";
            default:
                return stylePrefix + comment + " " + realLifeComment;
        }
    }

    static void setStyle(int newStyle) {
        style = newStyle;
    }
}

class CricketStats {
    private static CricketStats instance;
    private Map<String, Integer> playerStats;

    private CricketStats() {
        playerStats = new HashMap<>();
    }

    public static CricketStats getInstance() {
        if (instance == null) {
            instance = new CricketStats();
        }
        return instance;
    }

    public void updatePlayerStats(String playerName, int runs) {
        playerStats.put(playerName, playerStats.getOrDefault(playerName, 0) + runs);
    }

    public int getPlayerStats(String playerName) {
        return playerStats.getOrDefault(playerName, 0);
    }

    public void displayAllStats() {
        System.out.println("\nPlayer Statistics:");
        for (Map.Entry<String, Integer> entry : playerStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " runs");
        }
    }
}

class MatchStatistics {
    private int totalRuns;
    private int totalWickets;

    class InningsStats {
        void updateStats(int runs, int wickets) {
            totalRuns += runs;
            totalWickets += wickets;
        }
    }

    InningsStats createInningsStats() {
        return new InningsStats();
    }

    void displayOverallStats() {
        System.out.println("Total Runs: " + totalRuns);
        System.out.println("Total Wickets: " + totalWickets);
    }
}

class PlayerPerformance implements Comparable<PlayerPerformance> {
    private String playerName;
    private Integer runs;
    private Double strikeRate;

    PlayerPerformance(String playerName, int runs, double strikeRate) {
        this.playerName = playerName;
        this.runs = runs;
        this.strikeRate = strikeRate;
    }

    public Integer getRuns() {
        return runs;
    }

    @Override
    public int compareTo(PlayerPerformance other) {
        return other.runs.compareTo(this.runs);
    }

    @Override
    public String toString() {
        return String.format("Player: %s, Runs: %d, Strike Rate: %.2f", 
                             playerName.toUpperCase(), runs, strikeRate);
    }
}

class MatchSummary {
    private StringBuffer summary;

    MatchSummary() {
        summary = new StringBuffer("Match Summary:\n");
    }

    void addToSummary(String event) {
        summary.append(event).append("\n");
    }

    String getSummary() {
        return summary.toString();
    }
}

class CommentaryThread extends Thread {
    private volatile boolean running = true;
    private Match match;

    CommentaryThread(Match match) {
        this.match = match;
    }

    public void run() {
        while (running && !match.isPaused) {
            System.out.println(Commentary.getCommentary("general"));
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopRunning() {
        running = false;
    }
}

class ScoreFileManager {
    private static final String FILENAME = "cricket_scores.txt";

    static void saveScore(Team team1, Team team2) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(team1.name + ": " + team1.runs + "/" + team1.wickets);
            writer.println(team2.name + ": " + team2.runs + "/" + team2.wickets);
            writer.println("--------------------");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the score.");
            e.printStackTrace();
        }
    }

    static void displayPreviousScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            System.out.println("\nPrevious Match Scores:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading previous scores.");
            e.printStackTrace();
        }
    }
}