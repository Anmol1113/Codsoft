import java.util.Scanner;

class TicTacToeAI {

    static char player = 'X';
    static char ai = 'O';
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        while (true) {
            playerMove();
            if (isGameOver()) break;
            aiMove();
            if (isGameOver()) break;
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            printBoard();
            System.out.println("Your turn! Enter row and column (0, 1, or 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public static void aiMove() {
        int[] bestMove = minimax(board, ai);
        board[bestMove[0]][bestMove[1]] = ai;
    }

    public static int[] minimax(char[][] board, char currentPlayer) {
        int[] bestMove = {-1, -1};
        int bestScore = (currentPlayer == ai) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    int score = minimaxScore(board, currentPlayer);
                    board[i][j] = ' ';

                    if ((currentPlayer == ai && score > bestScore) || (currentPlayer == player && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    public static int minimaxScore(char[][] board, char currentPlayer) {
        if (checkWinner(ai)) return 1;
        if (checkWinner(player)) return -1;
        if (isBoardFull()) return 0;

        int bestScore = (currentPlayer == ai) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    int score = minimaxScore(board, (currentPlayer == ai) ? player : ai);
                    board[i][j] = ' ';

                    if ((currentPlayer == ai && score > bestScore) || (currentPlayer == player && score < bestScore)) {
                        bestScore = score;
                    }
                }
            }
        }
        return bestScore;
    }

    public static boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isGameOver() {
        if (checkWinner(ai)) {
            printBoard();
            System.out.println("AI wins!");
            return true;
        }
        if (checkWinner(player)) {
            printBoard();
            System.out.println("You win!");
            return true;
        }
        if (isBoardFull()) {
            printBoard();
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }
}