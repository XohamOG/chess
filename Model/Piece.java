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


    public PieceType gettype(){

        return type;

    }

    public PieceColor getColor(){

        return color;
    }

    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void setPosition(int x, int y){
        
        this.x=x;
        this.y=y;
    }
    

}
