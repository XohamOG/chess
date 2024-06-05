package Model;

public class Board{
    private Piece[][] Board;

    public Board(){
        Board = new Piece[8][8];
        initializeBoard();
    }

    private void getString(int x, int y){


    }

    private void initializeBoard(){
        for(int i=0; i<8; i++){
            Board[1][i] = new Piece(PieceColor.White, PieceType.pawn , 1, i);
            Board[6][i] = new Piece(PieceColor.Black, PieceType.pawn , 6, i);
        }
        Board[0][0] = new Piece(PieceColor.Black, PieceType.Rook , 0, 0);
        Board[0][7] = new Piece(PieceColor.Black, PieceType.Rook , 0, 7);
        Board[0][1] = new Piece(PieceColor.Black, PieceType.knight , 0, 1);
        Board[0][6] = new Piece(PieceColor.Black, PieceType.knight , 0, 6);
        Board[0][2] = new Piece(PieceColor.Black, PieceType.bishop , 0,2);
        Board[0][5] = new Piece(PieceColor.Black, PieceType.bishop , 0, 5);
        Board[0][3] = new Piece(PieceColor.Black, PieceType.king , 0, 3);
        Board[0][4] = new Piece(PieceColor.Black, PieceType.queen , 0, 4);

        Board[6][0] = new Piece(PieceColor.White, PieceType.Rook , 0, 0);
        Board[6][7] = new Piece(PieceColor.White, PieceType.Rook , 0, 7);
        Board[6][1] = new Piece(PieceColor.White, PieceType.knight , 0, 1);
        Board[6][6] = new Piece(PieceColor.White, PieceType.knight , 0, 6);
        Board[6][2] = new Piece(PieceColor.White, PieceType.bishop , 0,2);
        Board[6][5] = new Piece(PieceColor.White, PieceType.bishop , 0, 5);
        Board[6][3] = new Piece(PieceColor.White, PieceType.king , 0, 3);
        Board[6][4] = new Piece(PieceColor.White, PieceType.queen , 0, 4);
    }
}