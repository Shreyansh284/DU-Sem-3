import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception for invalid inputs
class MatchException extends Exception {
    public MatchException(String message) {
        super(message);
    }
}

// Abstract class representing a Match
abstract class Match {
    protected String matchType;
    protected Team team1;
    protected Team team2;
    protected int totalOvers;
    protected int currentOver;
    protected int currentBall;
    protected boolean isTeam1Batting;

    public Match(String matchType, Team team1, Team team2, int totalOvers) {
        this.matchType = matchType;
        this.team1 = team1;
        this.team2 = team2;
        this.totalOvers = totalOvers;
        this.currentOver = 0;
        this.currentBall = 0;
        this.isTeam1Batting = true;
    }

    public abstract void startMatch();

    protected void switchInnings() {
        isTeam1Batting = !isTeam1Batting;
        currentOver = 0;
        currentBall = 0;
    }
}

// Class representing a Team
class Team {
    private String name;
    private Player[] players;
    private int totalRuns;
    private int wickets;

    public Team(String name) {
        this.name = name;
        this.players = new Player[11];
        this.totalRuns = 0;
        this.wickets = 0;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

    public void updateScore(int runs) {
        totalRuns += runs;
    }

    public void wicketFallen() {
        wickets++;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getWickets() {
        return wickets;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getScore() {
        return totalRuns + "/" + wickets;
    }
}

// Class representing a Player
class Player {
    private String name;
    private int runsScored;

    public Player(String name) {
        this.name = name;
        this.runsScored = 0;
    }

    public void addRuns(int runs) {
        runsScored += runs;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public String getName() {
        return name;
    }
}

// Class for the Cricket Match
class CricketMatch extends Match {
    private int wideBalls;
    private int noBalls;
    private int sixes;
    private int fours;

    public CricketMatch(String matchType, Team team1, Team team2, int totalOvers) {
        super(matchType, team1, team2, totalOvers);
        this.wideBalls = 0;
        this.noBalls = 0;
        this.sixes = 0;
        this.fours = 0;
    }

    public void startMatch() {
        Scanner scanner = new Scanner(System.in);
        while (currentOver < totalOvers && team1.getWickets() < 11) {
            System.out.println("Over " + (currentOver + 1) + ": ");
            for (int ball = 0; ball < 6; ball++) {
                if (currentOver >= totalOvers || team1.getWickets() >= 11) break;
                System.out.print("Enter runs for ball " + (ball + 1) + ": ");
                String input = scanner.next();
                processBall(input);
            }
            currentOver++;
            switchInnings();
        }
        announceResult();
        scanner.close();
    }

    private void processBall(String input) {
        int runs = 0;
        try {
            if (input.equalsIgnoreCase("wide")) {
                wideBalls++;
                runs = 1;
            } else if (input.equalsIgnoreCase("no-ball")) {
                noBalls++;
                runs = 1;
            } else if (input.equalsIgnoreCase("wicket")) {
                team1.wicketFallen();
                return;
            } else {
                runs = Integer.parseInt(input);
            }
            team1.updateScore(runs);
            if (runs == 6) {
                sixes++;
            } else if (runs == 4) {
                fours++;
            }
            team1.getPlayers()[team1.getWickets()].addRuns(runs);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid score, 'wide', 'no-ball', or 'wicket'.");
        }
    }

    private void announceResult() {
        Team battingTeam = isTeam1Batting ? team1 : team2;
        Team bowlingTeam = isTeam1Batting ? team2 : team1;
        System.out.println("Match Finished!");
        System.out.println(battingTeam.getName() + " scored: " + battingTeam.getScore());
        System.out.println(bowlingTeam.getName() + " scored: " + bowlingTeam.getScore());
        System.out.println("Wides: " + wideBalls);
        System.out.println("No Balls: " + noBalls);
        System.out.println("Fours: " + fours);
        System.out.println("Sixes: " + sixes);
        System.out.println("Winner: " + (battingTeam.getTotalRuns() > bowlingTeam.getTotalRuns() ? battingTeam.getName() : bowlingTeam.getName()));
    }
}

// Main class
public class CricketScoreboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter match type (ODI/T20): ");
        String matchType = scanner.nextLine();
        
        Team team1 = new Team("Team A");
        Team team2 = new Team("Team B");

        for (int i = 0; i < 11; i++) {
            team1.addPlayer(new Player("Player A" + (i + 1)));
            team2.addPlayer(new Player("Player B" + (i + 1)));
        }

        System.out.print("Enter total number of overs: ");
        int totalOvers = scanner.nextInt();

        CricketMatch match = new CricketMatch(matchType, team1, team2, totalOvers);
        match.startMatch();
        
        scanner.close();
    }
}
