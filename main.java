import Model.*;
import java.util.Scanner;

public class main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        b.printkaro();

        ChessGame cg = new ChessGame();
        PieceColor p1 = cg.getCurrentTurn();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        boolean bluh = cg.move(startX, startY, endX, endY);

        if (bluh == true){
            b.printkaro();
        }



    }

}
