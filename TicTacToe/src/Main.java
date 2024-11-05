import java.util.Scanner;

public class Main {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            String currentPlayer = "X";
            int moveCount = 0;
            clearBoard();

            SafeInput.prettyHeader("Welcome to Tic Tac Toe!");

            // Main game loop
            while (true) {
                display();
                System.out.println("Player " + currentPlayer + "'s turn.");

                int row = SafeInput.getRangedInt(scanner, "Enter row (1-3)", 1, 3) - 1;
                int col = SafeInput.getRangedInt(scanner, "Enter col (1-3)", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moveCount++;

                    if (isWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    } else if (isTie(moveCount)) {
                        display();
                        System.out.println("The game is a tie!");
                        break;
                    }

                    // Switch player
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            // Ask the user if they want to play again
            scanner.nextLine(); // Clear the newline left after the last input
        } while (SafeInput.getYNConfirm(scanner, "Do you want to play again?"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("  1   2   3 ");
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                if (j < COLS - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < ROWS - 1) {
                System.out.println(" ---+---+---");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie(int moveCount) {
        return moveCount == ROWS * COLS;
    }
}
