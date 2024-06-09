package Model;

public class ChessGame {
    public Board board;
    private PieceColor currentTurn;

    public ChessGame() {
        board = new Board();
        currentTurn = PieceColor.White;
    }

    public boolean move(int startX, int startY, int endX, int endY) {
        Piece piece = board.getPiece(startX, startY);
        //extra printed here
        System.out.println(piece.gettype());
        System.out.println(piece.getColor());
        if (piece == null|| piece.getColor() != currentTurn) {
            System.out.println("No piece selected.");
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

    private boolean isValidMove(Piece piece, int endX, int endY) {
        // Implement piece-specific move validation
        // For now, just ensure the target position is within the board bounds
        return endX >= 0 && endX < 8 && endY >= 0 && endY < 8;
    }

    private void switchTurn() {
        currentTurn = (currentTurn == PieceColor.White) ? PieceColor.Black : PieceColor.White;
    }

    public PieceColor getCurrentTurn() {
        return currentTurn;
    }

    // Additional methods like check detection, game state, etc. can be added here
}
