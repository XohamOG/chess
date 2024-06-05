package Model;

public class Piece {
    
    Boolean health;
    private PieceType type;
    private PieceColor color;
    private int x,y;

    public Piece(PieceColor color,PieceType type,int x,int y){

        this.color = color;
        this.type = type;
        this.health = true;
        this.x=x;
        this.y=y;

    }


    

}
