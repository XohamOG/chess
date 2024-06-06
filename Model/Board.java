package Model;

public class Board {
    private Piece[][] Board;
    public static final int BOARD_SIZE = 8;

    public Board() {
        Board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            Board[1][i] = new Piece(PieceColor.White, PieceType.PAWN, 1, i);
            Board[6][i] = new Piece(PieceColor.Black, PieceType.PAWN, 6, i);
        }
        Board[0][0] = new Piece(PieceColor.Black, PieceType.ROOK, 0, 0);
        Board[0][7] = new Piece(PieceColor.Black, PieceType.ROOK, 0, 7);
        Board[0][1] = new Piece(PieceColor.Black, PieceType.KNIGHT, 0, 1);
        Board[0][6] = new Piece(PieceColor.Black, PieceType.KNIGHT, 0, 6);
        Board[0][2] = new Piece(PieceColor.Black, PieceType.BISHOP, 0, 2);
        Board[0][5] = new Piece(PieceColor.Black, PieceType.BISHOP, 0, 5);
        Board[0][3] = new Piece(PieceColor.Black, PieceType.KING, 0, 3);
        Board[0][4] = new Piece(PieceColor.Black, PieceType.QUEEN, 0, 4);

        Board[7][0] = new Piece(PieceColor.White, PieceType.ROOK, 7, 0);
        Board[7][7] = new Piece(PieceColor.White, PieceType.ROOK, 7, 7);
        Board[7][1] = new Piece(PieceColor.White, PieceType.KNIGHT, 7, 1);
        Board[7][6] = new Piece(PieceColor.White, PieceType.KNIGHT, 7, 6);
        Board[7][2] = new Piece(PieceColor.White, PieceType.BISHOP, 7, 2);
        Board[7][5] = new Piece(PieceColor.White, PieceType.BISHOP, 7, 5);
        Board[7][3] = new Piece(PieceColor.White, PieceType.KING, 7, 3);
        Board[7][4] = new Piece(PieceColor.White, PieceType.QUEEN, 7, 4);
    }

    public void printkaro() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.println("");
            System.out.println("---------------------------------------------------------------------");

            for (int column = 0; column < BOARD_SIZE; column++) {
                try {
                    if (Board[row][column].type == null) {
                        System.out.print("| " + " " + " ");
                    } else {
                        System.out.print("| " + Board[row][column].type + " ");
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
            return Board[x][y];
        }
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = getPiece(startX, startY);
        if (piece != null) {
            Board[endX][endY] = Board[startX][startY];
            Board[startX][startY] = null;
            piece.setPosition(endX, endY);
        }
    }

}