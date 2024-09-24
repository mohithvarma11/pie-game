import java.util.Scanner;

public class PieGame {
    private int pieces;

    public PieGame(int totalPieces) {
        this.pieces = totalPieces;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String currentPlayer = "Player 1";

        while (pieces > 0) {
            System.out.println(currentPlayer + ", there are " + pieces + " pieces of pie left.");
            System.out.print("How many pieces will you take (1-3)? ");

            int takenPieces = scanner.nextInt();

            // Validate input
            if (takenPieces < 1 || takenPieces > 3 || takenPieces > pieces) {
                System.out.println("Invalid number. You can take 1 to 3 pieces, and not more than remaining pieces.");
                continue;
            }

            pieces -= takenPieces;
            System.out.println(currentPlayer + " took " + takenPieces + " pieces.");

            if (pieces == 0) {
                System.out.println(currentPlayer + " wins!");
                break;
            }

            // Switch players
            currentPlayer = currentPlayer.equals("Player 1") ? "Player 2" : "Player 1";
        }

        scanner.close();
    }

    public static void main(String[] args) {
        PieGame game = new PieGame(10); // Start with 10 pieces of pie
        game.play();
    }
}
