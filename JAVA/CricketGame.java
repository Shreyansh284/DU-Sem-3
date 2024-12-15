import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Custom Exception handling for invalid inputs
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Team interface defining team-related methods
interface TeamInterface {
    void addRuns(int runs, boolean isWide, boolean isNoBall, boolean isWicket);

    void displayPlayerScores();
}

// Player interface defining player-related methods
interface PlayerInterface {
    void addRuns(int runs);

    void faceBall();

    void gotOut();

    void displayPlayerScores();
}

// Abstract class for the basic structure of a team
abstract class Team implements TeamInterface {
    String name;
    int totalScore;
    int wickets;
    int oversPlayed;
    int ballsPlayed;
    int total4s;
    int total6s;
    int wideBalls;
    int noBalls;
    int lastball;
    int totalBalls;
    int totalBallsPlayedByTeam;
    int extras;

    public Team(String name) {
        this.name = name;
        this.totalScore = 0;
        this.wickets = 0;
        this.oversPlayed = 0;
        this.ballsPlayed = 0;
        this.total4s = 0;
        this.total6s = 0;
        this.wideBalls = 0;
        this.noBalls = 0;
        this.lastball = 0;
        this.totalBalls = 0;
        this.totalBallsPlayedByTeam = 0;
        this.extras = 0;
    }

    // Abstract method to be implemented by child classes
    abstract void trackBallAndOversOfTeam(int overs, Scanner sc);
}

// Player class to keep track of individual player scores for player status
class Player implements PlayerInterface {
    String name;
    int runs;
    int ballsFaced;
    boolean out;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.out = false;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void faceBall() {
        this.ballsFaced++;
    }

    public void gotOut() {
        this.out = true;
    }

    public void displayPlayerScores() {
        double strikeRate = ballsFaced == 0 ? 0 : (runs * 100.0) / ballsFaced;
        System.out.printf("%-20s %-10d %-10d %-10.2f%n",
                name, runs, ballsFaced, strikeRate);
    }
}

class CricketTeam extends Team {
    ArrayList<Player> players;
    int currentPlayerIndex;
    final int numPlayers = 11;

    public CricketTeam(String name) {
        super(name);
        this.players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            this.players.add(new Player("Player " + i));
        }
        this.currentPlayerIndex = 0; // First player starts
    }

    @Override
    void trackBallAndOversOfTeam(int overs, Scanner sc) {
        System.out.println("\n" + name + " starts batting.");
        for (int i = 1; i <= overs; i++) {
            System.out.println("Over Number: " + i);
            totalBalls = 6;
            for (int j = 1; j <= totalBalls; j++) {
                System.out.print("Enter runs of ball " + j
                        + " (or write ('wicket') for wicket, ('wide') for wide, ('noball') for no-ball): ");
                String result = sc.next().toLowerCase();

                boolean isWide = result.equals("wide");
                boolean isNoBall = result.equals("noball");
                boolean isWicket = result.equals("wicket");
                int runs = 0;

                if (!isWide && !isNoBall && !isWicket) {
                    try {
                        runs = Integer.parseInt(result);
                        if (runs < 0 || runs >= 7) {
                            throw new InvalidInputException(
                                    "Runs cannot be negative and greater than 6.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid input! Please enter a valid number of runs or a valid keyword (wicket, wide, noball).");
                        j--; // Repeat the input for the same ball
                        continue; // Skip the rest of the loop and prompt again
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                        j--;
                        continue;
                    }
                }

                addRuns(runs, isWide, isNoBall, isWicket);
                if (wickets == 10) {
                    System.out.println(name + " is All-Out");
                    break;
                }

                lastball = (j >= 6) ? 0 : j;

                // Handle Extra
                if (isWide || isNoBall) {
                    j--;
                    totalBalls--;
                    extras++;
                }

                statasticsAfterEachDelivery();
            }
        }

        System.out.println("--------" + name + " Team Player Status--------\n");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Player", "Runs", "Balls", "S/R");
        System.out.println("---------------------------------------------------------------------------");

        displayPlayerScores();
    }

    @Override
    public void addRuns(int runs, boolean isWide, boolean isNoBall, boolean isWicket) {
        if (isWide) {
            this.totalScore += 1; // Wide ball adds 1 run
            this.wideBalls++;
            this.totalBalls++;
            this.totalBallsPlayedByTeam++;
            return; // Wide ball doesn't count as a valid delivery
        }

        if (isNoBall) {

            this.totalScore += 1; // No ball adds 1 run
            this.noBalls++;
            this.totalBalls++;
            this.totalBallsPlayedByTeam++;
            return; // No ball doesn't count as a valid delivery
        }

        if (isWicket) {
            this.players.get(currentPlayerIndex).gotOut();
            this.wickets++;
            this.currentPlayerIndex++; // Move to next player
            this.totalBallsPlayedByTeam++;
        } else {
            this.players.get(currentPlayerIndex).addRuns(runs);
            this.totalScore += runs;
            if (runs == 4)
                total4s++;
            if (runs == 6)
                total6s++;

            this.totalBallsPlayedByTeam++;
        }

        this.players.get(currentPlayerIndex).faceBall();
        this.ballsPlayed++;
        if (this.ballsPlayed % 6 == 0) {
            this.oversPlayed++; // Over is completed after 6 balls
        }
    }

    void statasticsAfterEachDelivery() {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%s: %d/%d in %d.%d overs | Fours: %d, Sixes: %d | Extras: %d [Wide: %d, No: %d]",
                name, totalScore, wickets, oversPlayed, lastball, total4s, total6s, extras, wideBalls, noBalls);
        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void finalScoreOfTeam(CricketTeam team) {
        // Score Summary
        System.out.println("\n" + team.name + " Team " + "Score Summary :");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-15s |\n",
                "Team", "Total Runs", "Wickets", "Overs", "Total Balls Played");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10d | %-10d | %d.%d        | %-15d |\n",
                team.name, team.totalScore, team.wickets, team.oversPlayed, team.lastball, team.totalBallsPlayedByTeam);
        System.out.println("---------------------------------------------------------------------------------------");

        // Detailed Stats
        System.out.println("\nDetailed Stats:");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-15s |\n",
                "Fours", "Sixes", "Wide Balls", "No Balls", "Extras (Total)");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-10d | %-10d | %-10d | %-10d | %-15d |\n",
                team.total4s, team.total6s, team.wideBalls, team.noBalls, team.extras);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Average Runs per Over: " + ((float) team.totalScore / (team.oversPlayed)));
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public static void result(CricketTeam team1, CricketTeam team2) {
        System.out.println("\n---------------------------------------------------");
        System.out.println("              Announcement of Winner               ");
        System.out.println("---------------------------------------------------");
        System.out.printf(" %-20s : %d runs\n", team1.name, team1.totalScore);
        System.out.printf(" %-20s : %d runs\n", team2.name, team2.totalScore);
        System.out.println("---------------------------------------------------");

        if (team1.totalScore > team2.totalScore) {
            System.out.println(
                    "        Result: " + team1.name + " wins by " + (team1.totalScore - team2.totalScore) + " runs!");
        } else if (team1.totalScore < team2.totalScore) {
            System.out.println(
                    "        Result: " + team2.name + " wins by " + (team2.totalScore - team1.totalScore) + " runs!");
        } else {
            System.out.println("        Result: The match is a tie!");
        }
        System.out.println("---------------------------------------------------\n");
    }

    @Override
    public void displayPlayerScores() {
        for (Player player : players) {
            player.displayPlayerScores();
        }
    }
}

public class CricketGame {
    static CricketTeam team1;
    static CricketTeam team2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("---------- Cricket Scoreboard Menu ----------");
            System.out.println("1. Start Match");
            System.out.println("2. View Match Statistics");
            System.out.println("3. View Player Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startMatch(sc);
                    break;
                case 2:
                    viewMatchStatistics();
                    break;
                case 3:
                    viewPlayerDetails();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
                    break;
            }
        }

    }

    public static void startMatch(Scanner sc) {
        System.out.println("Enter type of match (ODI/T20/Custom Over(CO)): ");
        String matchType = sc.next().toLowerCase();
        int overs = 0;

        if (matchType.equals("odi")) {
            overs = 50;
        } else if (matchType.equals("t20")) {
            overs = 20;
        } else if (matchType.equals("custom over") || matchType.equals("co")) {
            System.out.println("Enter Number Of Overs: ");
            overs = sc.nextInt();
        } else {
            System.out.println("Invalid match type! Please try again.");
            return;
        }

        System.out.println("Enter the name of Team 1: ");
        String team1Name = sc.next();
        team1 = new CricketTeam(team1Name);

        System.out.println("Enter the name of Team 2: ");
        String team2Name = sc.next();
        team2 = new CricketTeam(team2Name);
        System.out.println();

        // Get the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a, EEEE, yyyy-MM-dd");
        String formattedDateTime = LocalDateTime.now().format(formatter);

        // Introductory message
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Match Start Time: " + formattedDateTime);
        System.out.println("Welcome to the match!");
        System.out.println("Let's get ready for an exciting game of cricket!\n");
        System.out.println("---------------------------------------------------------------------------------------\n");

        team1.trackBallAndOversOfTeam(overs, sc);
        CricketTeam.finalScoreOfTeam(team1);
        System.out.println("\n*******************************************************************************\n");
        System.out.println(team2.name + " Needs " + team1.totalScore + " Runs To Win " + " In " + overs * 6 + " Balls");
        System.out.println("\n*******************************************************************************\n");

        // Get the current date and time

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm:ss a, EEEE, yyyy-MM-dd");
        String formattedDateString = LocalDateTime.now().format(formatter2);

        // Introductory message
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Match Start Time: " + formattedDateString);
        System.out.println("Welcome to the match!");
        System.out.println("Let's get ready for an exciting second innings match!\n");
        System.out.println("---------------------------------------------------------------------------------------\n");

        team2.trackBallAndOversOfTeam(overs, sc);
        CricketTeam.finalScoreOfTeam(team2);

        // Declare the winner
        CricketTeam.result(team1, team2);
    }

    public static void viewMatchStatistics() {
        if (team1 != null && team2 != null) {
            System.out.println("Match Statistics:");
            CricketTeam.finalScoreOfTeam(team1);
            CricketTeam.finalScoreOfTeam(team2);
        } else {
            System.out.println("No match data available. Please start a match first.");
        }
    }

    public static void viewPlayerDetails() {
        if (team1 != null) {
            System.out.println("Player Details for " + team1.name + ":\n");
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-10s %-10s %-10s%n", "Player", "Runs", "Balls", "S/R");
            System.out.println("---------------------------------------------------------------------------");
            team1.displayPlayerScores();
        } else {
            System.out.println("No match data available for Team 1 Players.");
        }

        if (team2 != null) {
            System.out.println("\nPlayer Details for " + team2.name + ":");
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-20s %-10s %-10s %-10s%n", "Player", "Runs", "Balls", "S/R");
            System.out.println("---------------------------------------------------------------------------");
            team2.displayPlayerScores();
        } else {
            System.out.println("No match data available for Team 2 Players.");
        }
    }
}
