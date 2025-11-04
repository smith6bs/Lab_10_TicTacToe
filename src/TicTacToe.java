import java.util.Scanner;

public class TicTacToe {
//put in my constants and varialbes
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String Board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//need to control the replay loop
        boolean playAgain = true;

//start the main game
        while (playAgain) {
//clear the board
            clearBoard();
            String currentPlayer = "X";
// X always goes first then move counter
            int moveCount = 0;
//indicate if game ends
            boolean gameOver = false;

            System.out.println("Welcome to Tic-Tac-Toe!");
// display empty board so play can begin
            display();
//prompt player to begin
            while (!gameOver) {
                System.out.println("Player " + currentPlayer + ", it's your turn.");

                int rowMove;
                int colMove;
                int rowIndex;
                int colIndex;

// Loop until a valid move. do while format makes sure at least one input

                do {
// Get coordinates 1–3 using SafeInput
                    rowMove = SafeInput.getRangedInt(in, "Enter row (1-3): ", 1, 3);
                    colMove = SafeInput.getRangedInt(in, "Enter column (1-3): ", 1, 3);

// Convert to array indices (0–2)
                    rowIndex = rowMove - 1;
                    colIndex = colMove - 1;

// If invalid, prompt again
                    if (!isValidMove(rowIndex, colIndex)) {
                        System.out.println("That spot is not available. Try again.");
                    }

                } while (!isValidMove(rowIndex, colIndex));
// Loop continues until user picks an empty space

// Record the valid move
                Board[rowIndex][colIndex] = currentPlayer;
                moveCount++;
//show the move chosen on the board
                display();

// If appropriate, check for win or tie, have to have at five moves to win or tie
                if (moveCount >= 5) {
                    if (isWin(currentPlayer)) {
//display winner then set game to end
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    } else if (moveCount == ROW * COL) {
                        System.out.println("It's a tie!");
                        gameOver = true;
                    }
                }
// Toggle the player if game continues so switch between  X and O
                if (!gameOver) {
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                }
            }

// Prompt to play again
            String answer;
            do {
                System.out.print("Do you want to play again? (y/n): ");
//Read in  answer and validate that its yes or no
                answer = in.next().trim().toLowerCase();
            } while (!answer.equals("y") && !answer.equals("n"));

            playAgain = answer.equals("y");
        }
//end the program
        System.out.println("Thanks for playing!");
        in.close();
    }

    // Clear the board and fill with spaces
    private static void clearBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                Board[r][c] = " ";   // empty space
            }
        }
    }

    // Display the current board
    private static void display() {
        System.out.println();
        System.out.println("   1   2   3");
        for (int r = 0; r < ROW; r++) {
            System.out.print((r + 1) + "  ");
            for (int c = 0; c < COL; c++) {
                String val = Board[r][c];
                if (val == null || val.equals(" ")) {
                    System.out.print(" ");
                } else {
                    System.out.print(val);
                }
                if (c < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (r < ROW - 1) {
                System.out.println("  -----------");
            }
        }
        System.out.println();
    }

    // Check if given row/col is a valid move (in bounds and empty)
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            return false;
        }
        return Board[row][col].equals(" ");
    }

    // Check if player has any kind of win
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
    }

    // Check for column win
    private static boolean isColWin(String player) {
        for (int c = 0; c < COL; c++) {
            if (Board[0][c].equals(player) &&
                    Board[1][c].equals(player) &&
                    Board[2][c].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Check for row win
    private static boolean isRowWin(String player) {
        for (int r = 0; r < ROW; r++) {
            if (Board[r][0].equals(player) &&
                    Board[r][1].equals(player) &&
                    Board[r][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Check for diagonal win (both diagonals)
    private static boolean isDiagnalWin(String player) {
        // Top-left to bottom-right
        if (Board[0][0].equals(player) &&
                Board[1][1].equals(player) &&
                Board[2][2].equals(player)) {
            return true;
        }

        // Top-right to bottom-left
        if (Board[0][2].equals(player) &&
                Board[1][1].equals(player) &&
                Board[2][0].equals(player)) {
            return true;
        }

        return false;
    }
}
