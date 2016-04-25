package g42442.view;

import g42442.model.Position;
import g42442.model.Board;

/**
 * class to Display the board game
 *
 * @author Cordier Olivier
 */
public class Display {

    /**
     * to display the board
     *
     * @param board the board to display
     */
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
                            System.out.print(color(board.getCarAt(
                                    new Position(i, j)).getId()) + " ");
                        }
                    } else {
                        for (int x = 0; x < 3; ++x) {
                            System.out.print("  ");
                        }
                    }

                }

                if (i == board.getExit().getRow()) {
                    System.out.print("\033[31m" + "x" + "\033[0m");
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

    /**
     * to Diplay a ASCII Art GAME OVER
     */
    public static void gameOver() {

        System.out.println("\033[34m" + "   _____              __  __   ______      ____ " + "\033[0m"
                + "\033[34m" + "  __      __  ______   _____  \n" + "\033[0m"
                + "\033[34m" + "  / ____|     /\\     |  \\/  | |  ____|    / __ \\  \\ \\  " + "\033[0m"
                + "\033[34m" + "  / / |  ____| |  __ \\ \n" + "\033[0m"
                + "\033[34m" + " | |  __     /  \\    | \\  / | | |__      | |  | |  \\ \\ " + "\033[0m"
                + "\033[34m" + " / /  | |__    | |__) |\n" + "\033[0m"
                + "\033[34m" + " | | |_ |   / /\\ \\   | |\\/| | |  __|     | |  | |   \\ \\" + "\033[0m"
                + "\033[34m" + "/ /   |  __|   |  _  / \n" + "\033[0m"
                + "\033[34m" + " | |__| |  / ____ \\  | |  | | | |____    | |__| |    \\  / " + "\033[0m"
                + "\033[34m" + "   | |____  | | \\ \\ \n" + "\033[0m"
                + "\033[34m" + "  \\_____| /_/    \\_\\ |_|  |_| |______|    \\____/      \\" + "\033[0m"
                + "\033[34m" + "/     |______| |_|  \\_\\\n" + "\033[0m"
                + "\033[34m" + "                                                           " + "\033[0m"
                + "\033[34m" + "                   " + "\033[0m");

    }

    public static void rushHour() {
        System.out.println("\033[34m" +".______       __    __       _______. __    __      __    __    ______    __    __  .______      \n" + "\033[0m"
                + "\033[34m" + "|   _  \\     |  |  |  |     /       ||  |  |  |    |  |  |  |  /  __  \\  |  |  |  | |   _  \\     \n" + "\033[0m"
                + "\033[34m" + "|  |_)  |    |  |  |  |    |   (----`|  |__|  |    |  |__|  | |  |  |  | |  |  |  | |  |_)  |    \n" + "\033[0m"
                + "\033[34m" + "|      /     |  |  |  |     \\   \\    |   __   |    |   __   | |  |  |  | |  |  |  | |      /     \n" + "\033[0m"
                + "\033[34m" + "|  |\\  \\----.|  `--'  | .----)   |   |  |  |  |    |  |  |  | |  `--'  | |  `--'  | |  |\\  \\----.\n" + "\033[0m"
                + "\033[34m" + "| _| `._____| \\______/  |_______/    |__|  |__|    |__|  |__|  \\______/   \\______/  | _| `._____|\n" + "\033[0m"
                + "\033[34m" + "                                                                                                " + "\033[0m");
    }

    /**
     * to color a char converting it in String
     *
     * @param a the char to be converted in String
     * @return the char converted
     */
    public static String color(char a) {
        String car = Character.toString(a);

        switch (car) {
            case "1":
                car = "\033[31m" + "1" + "\033[0m";

                break;
            case "2":
                car = "\033[32m" + "2" + "\033[0m";
                break;
            case "3":
                car = "\033[34m" + "3" + "\033[0m";
                break;
            case "4":
                car = "\033[35m" + "4" + "\033[0m";
                break;
            case "5":
                car = "\033[36m" + "5" + "\033[0m";
                break;
            case "6":
                car = "\033[33m" + "6" + "\033[0m";
                break;
            case "7":
                car = "\033[35m" + "7" + "\033[0m";
                break;
            case "8":
                car = "\033[31m" + "8" + "\033[0m";
                break;
            case "9":
                car = "\033[32m" + "9" + "\033[0m";
                break;

        }

        return car;
    }
}
