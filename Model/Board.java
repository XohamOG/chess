package Model;

public class Board {
    private Piece[][] board;
    public static final int BOARD_SIZE = 8;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Piece(PieceColor.White, PieceType.PAWN, 1, i);
            board[1][i] = new Piece(PieceColor.Black, PieceType.PAWN, 6, i);
        }

        board[7][0] = new Piece(PieceColor.White, PieceType.ROOK, 7, 0);
        board[7][7] = new Piece(PieceColor.White, PieceType.ROOK, 7, 7);
        board[7][1] = new Piece(PieceColor.White, PieceType.KNIGHT, 7, 1);
        board[7][6] = new Piece(PieceColor.White, PieceType.KNIGHT, 7, 6);
        board[7][2] = new Piece(PieceColor.White, PieceType.BISHOP, 7, 2);
        board[7][5] = new Piece(PieceColor.White, PieceType.BISHOP, 7, 5);
        board[7][3] = new Piece(PieceColor.White, PieceType.KING, 7, 3);
        board[7][4] = new Piece(PieceColor.White, PieceType.QUEEN, 7, 4);

        board[0][0] = new Piece(PieceColor.Black, PieceType.ROOK, 0, 0);
        board[0][7] = new Piece(PieceColor.Black, PieceType.ROOK, 0, 7);
        board[0][1] = new Piece(PieceColor.Black, PieceType.KNIGHT, 0, 1);
        board[0][6] = new Piece(PieceColor.Black, PieceType.KNIGHT, 0, 6);
        board[0][2] = new Piece(PieceColor.Black, PieceType.BISHOP, 0, 2);
        board[0][5] = new Piece(PieceColor.Black, PieceType.BISHOP, 0, 5);
        board[0][3] = new Piece(PieceColor.Black, PieceType.KING, 0, 3);
        board[0][4] = new Piece(PieceColor.Black, PieceType.QUEEN, 0, 4);

    }

    public void printkaro() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.println("");
            System.out.println("---------------------------------------------------------------------");

            for (int column = 0; column < BOARD_SIZE; column++) {
                try {
                    if (board[row][column].type == null) {
                        System.out.print("| " + " " + " ");
                    } else {
                        System.out.print("| " + board[row][column].type + " ");
                    }
                } catch (Exception e) {
                    System.out.print("| " + "     " + " ");
                }
            }
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
    }

    public Piece getPiece(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        } else {
            return board[x][y];
        }
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = getPiece(startX, startY);
        if (piece != null) {
            board[endX][endY] = board[startX][startY];
            board[startX][startY] = null;
            piece.setPosition(endX, endY);
        }
    }

}