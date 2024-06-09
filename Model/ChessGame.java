package Model;

public class ChessGame {
    public Board board;
    private PieceColor currentTurn;
    //constructor
    public ChessGame() {
        board = new Board();
        currentTurn = PieceColor.White;
    }
    //move method
    public boolean move(int startX, int startY, int endX, int endY) {
        Piece piece = board.getPiece(startX, startY);
        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }

        // Validate the move (basic validation for now)
        if (isValidMove(piece, endX, endY)) {
            board.movePiece(startX, startY, endX, endY);
            switchTurn();
            return true;
        }
        return false;
    }
    //validation
    private boolean isValidMove(Piece piece, int endX, int endY) {
        // Implement piece-specific move validation
        // For now, just ensure the target position is within the board bounds
        if (endX < 0 || endX >= Board.BOARD_SIZE || endY < 0 || endY >= Board.BOARD_SIZE) {
            return false;
        }

        // Check if the piece can move to the destination according to its rules
        if (!piece.isValidMove(endX, endY, board)) {
            return false;
        }

        // Ensure the destination is not occupied by a piece of the same color
        Piece destinationPiece = board.getPiece(endX, endY);
        if (destinationPiece != null && destinationPiece.getColor() == piece.getColor()) {
            return false;
        }

        return true;

    }

    private void switchTurn() {
        currentTurn = (currentTurn == PieceColor.White) ? PieceColor.Black : PieceColor.White;
    }

    public PieceColor getCurrentTurn() {
        return currentTurn;
    }

    // Additional methods like check detection, game state, etc. can be added here
}
