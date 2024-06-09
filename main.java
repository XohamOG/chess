import Model.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessGame game = new ChessGame();

        while (true) {
            game.board.printkaro();
            System.out.println("Current turn: " + game.getCurrentTurn());
            System.out.println("Enter your move (startX startY endX endY): ");
            
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            if (game.move(startX, startY, endX, endY)) {
                System.out.println("Move successful!");
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
