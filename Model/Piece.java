package Model;

public class Piece {
    public static final Piece PAWN = null;
    public PieceType type;
    public PieceColor color;
    public int x, y;

    public Piece(PieceColor color, PieceType type, int x, int y) {
        this.color = color;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValidMove(int endX, int endY, Board board) {
        switch (type) {
            case KING:
                return isValidKingMove(endX, endY, board);
            case QUEEN:
                return isValidQueenMove(endX, endY, board);
            case ROOK:
                return isValidRookMove(endX, endY, board);
            case BISHOP:
                return isValidBishopMove(endX, endY, board);
            case KNIGHT:
                return isValidKnightMove(endX, endY, board);
            case PAWN:
                return isValidPawnMove(endX, endY, board);
            default:
                return false;
        }
    }

    public boolean isValidKingMove(int endX, int endY, Board board) {
        int dx = Math.abs(endX - x);
        int dy = Math.abs(endY - y);
        return dx <= 1 && dy <= 1 && (dx + dy > 0);
    }

    public boolean isValidQueenMove(int endX, int endY, Board board) {
        return isValidRookMove(endX, endY, board) || isValidBishopMove(endX, endY, board);
    }

    public boolean isValidRookMove(int endX, int endY, Board board) {
        if (x == endX) {
            for (int i = Math.min(y, endY) + 1; i < Math.max(y, endY); i++) {
                if (board.getPiece(x, i) != null) return false;
            }
            return true;
        }
        if (y == endY) {
            for (int i = Math.min(x, endX) + 1; i < Math.max(x, endX); i++) {
                if (board.getPiece(i, y) != null) return false;
            }
            return true;
        }
        return false;
    }

    public boolean isValidBishopMove(int endX, int endY, Board board) {
        if (Math.abs(endX - x) == Math.abs(endY - y)) {
            int dx = (endX - x) > 0 ? 1 : -1;
            int dy = (endY - y) > 0 ? 1 : -1;
            int i = x + dx;
            int j = y + dy;
            while (i != endX && j != endY) {
                if (board.getPiece(i, j) != null) return false;
                i += dx;
                j += dy;
            }
            return true;
        }
        return false;
    }

    public boolean isValidKnightMove(int endX, int endY, Board board) {
        int dx = Math.abs(endX - x);
        int dy = Math.abs(endY - y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    public boolean isValidPawnMove(int endX, int endY, Board board) {
        int direction = (color == PieceColor.White) ? -1 : 1;
        if (x + direction == endX && y == endY && board.getPiece(endX, endY) == null) {
            return true;
        }
        if (x + 2 * direction == endX && y == endY && x == (color == PieceColor.White ? 6 : 1) && board.getPiece(endX, endY) == null) {
            return true;
        }
        if (x + direction == endX && Math.abs(endY - y) == 1 && board.getPiece(endX, endY) != null) {
            return true;
        }
        return false;
    }
}
