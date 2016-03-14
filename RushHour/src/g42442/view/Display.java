package g42442.view;

import g42442.model.Position;
import g42442.model.Board;

/**
 *
 * @author Cordier Olivier
 */
public class Display {

    static void displayBoard(Board board) {
        System.out.print(" ");
        for (int i = 0; i < board.getHeight() * 3; ++i) {
            System.out.print("--");
        }
        System.out.println(" ");

        for (int i = 0; i < board.getHeight(); ++i) {
            for (int z = 0; z < 3; ++z) {
            System.out.print("|");
            for (int j = 0; j < board.getWidth(); ++j) {
                if (board.getCarAt(new Position(i, j)) != null) {
                    for (int x = 0; x < 3; ++x) {
                        System.out.print(Color.color(board.getCarAt(new Position(i, j)).getId()) + " ");
                    }
                } else {
                    for (int x = 0; x < 3; ++x) {
                        System.out.print("  ");
                    }
                }

            }

            if (i == board.getExit().getRow()) {
                System.out.print("x");
            } else {
                System.out.print("|");
            }
            System.out.println("");
            }
        }
        System.out.print(" ");

        for (int i = 0; i < board.getHeight() * 3; ++i) {
            System.out.print("--");
        }
        System.out.println(" ");

    }
  

}
