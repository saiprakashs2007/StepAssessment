
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") &&
            computerMove.equals("Scissors")) {
            return "Player Wins";
        }

        if (playerMove.equals("Paper") &&
            computerMove.equals("Rock")) {
            return "Player Wins";
        }

        if (playerMove.equals("Scissors") &&
            computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            playerMoves[i] = sc.next();

            playerMoves[i] =
                playerMoves[i].substring(0, 1).toUpperCase()
                + playerMoves[i].substring(1).toLowerCase();

            int index = random.nextInt(3);
            computerMoves[i] = moves[index];

            results[i] = playRound(
                playerMoves[i], computerMoves[i]
            );

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println();
        }

        System.out.println("----- FINAL SCOREBOARD -----");
        System.out.printf("%-10s %-12s %-12s %-15s%n",
                "Round", "Player", "Computer", "Result");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d %-12s %-12s %-15s%n",
                    i + 1, playerMoves[i],
                    computerMoves[i], results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n",
                winPercentage);

        sc.close();
    }
}
