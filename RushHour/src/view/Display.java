package view;

import model.*;

/**
 *
 * @author Cordier Olivier
 */
public class Display {

    static void displayBoard(Board board) {
        System.out.print(" ");
        for (int i = 0; i < board.getHeight(); ++i) {
            System.out.print("-");
        }
        System.out.println(" ");

        for (int i = 0; i < board.getHeight(); ++i) {
            System.out.print("|");
            for (int j = 0; j < board.getWidth(); ++j) {
                if (board.getCarAt(new Position(i, j)) != null) {
                    System.out.print(board.getCarAt(new Position(i, j)).getId());
                } else {
                    System.out.print(" ");
                }

            }
            if (i == board.getExit().getRow()) {
                System.out.println("x");
            } else {
                System.out.println("|");
            }
        }
        System.out.print(" ");
        for (int i = 0; i < board.getHeight(); ++i) {
            System.out.print("-");
        }
        System.out.println(" ");

    }

}

