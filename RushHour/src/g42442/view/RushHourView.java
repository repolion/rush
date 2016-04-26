package g42442.view;

import g42442.model.Direction;
import g42442.model.RushHourException;
import java.util.Scanner;
import g42442.model.RushHourGame;
import static g42442.view.Display.displayBoard;
import static g42442.view.Display.gameOver;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Cordier Olivier
 */
public class RushHourView {

    private static final Scanner in = new Scanner(System.in);

    //instance attributes
    private RushHourGame game;

    //constructor
    public RushHourView(RushHourGame game) {
        this.game = game;
    }

    //others methods
    /**
     * ask an id and a direction to move cars until the red one is at the exit
     */
    public void play() {
        int counter = 0;
        char carId;
        char charDirection;
        Display.displayBoard(game.getBoard());
        //begining time
        java.util.Date uDate = new java.util.Date(System.currentTimeMillis());
        while (!game.isOver()) {
            try {
                carId = askId("\033[34m" + "Enter the id of "
                        + "the car you would like to move: " + "\033[0m");
                charDirection = askDirection("\033[34m"
                        + "Enter the direction: l(Left),u(UP),"
                        + " d(DOWN), r(RIGHT) " + "\033[0m");
                if (game.isMulti(carId, convert(charDirection))) {
                    int max = game.maxMove(game.carId(carId), convert(charDirection));
                    int moves = -1;

                    while (moves < 0 || moves > max) {
                        moves = askNumber("\033[34m"
                                + "How many places you want to move?" + "\033[0m");
                        if (moves < 0 || moves > max) {
                            errorMessage();
                        }
                    }
                    game.move(carId, convert(charDirection), moves);
                    ++counter;
                } else {
                    game.move(carId, convert(charDirection));
                    ++counter;
                }
            } catch (RushHourException e) {
                System.out.println(e.getMessage());
            }

            displayBoard(game.getBoard());
        }
        //end of game time
        Date dateEnd = new Date(System.currentTimeMillis());

        gameOver();
        Date duration = new Date(System.currentTimeMillis());

        duration.setTime(dateEnd.getTime() - uDate.getTime());
        long seconds = duration.getTime() / 1000;
        long min = seconds / 60;
        seconds %= 60;

        System.out.println(
                "\033[32m"
                + "You resolved it in " + min + " minutes " + seconds
                + " seconds and " + counter + " moves!" + "\033[0m");
        System.out.println(
                " ");
    }

    /**
     * convert a char given by the user in a direction
     *
     * @param direction the direction letter given by the user
     * @return a direction to move a car
     */
    public Direction convert(char direction) {
        Direction dir = null;

        switch (direction) {
            case 'l':
                dir = Direction.LEFT;

                break;
            case 'r':
                dir = Direction.RIGHT;
                break;
            case 'u':
                dir = Direction.UP;
                break;
            case 'd':
                dir = Direction.DOWN;
                break;
            default:
                System.out.println("Default: This is not a valid direction ");
        }
        return dir;
    }

    private char askId(String msg) {
        Scanner idIn = new Scanner(System.in);
        System.out.println(msg);
        int counter = 0;
        while (!idIn.hasNext(Pattern.compile("[a-zA-Z0-9]"))) {
            ++counter;
            if (counter > 0) {
                System.out.println("\033[31m" + "You have entered"
                        + " an invalid entry." + "\033[0m");
            }
            System.out.println(msg);
            idIn.next();
        }
        return idIn.next().charAt(0);
    }

    /**
     * ask an Interger to the user
     *
     * @param msg the message to the user
     * @return a number asked to the user
     */
    public static int askNumber(String msg) {
        Scanner numberIn = new Scanner(System.in);
        System.out.println(msg);
        int counterError = 0;
        while (!numberIn.hasNextInt()) {
            if (counterError == 0) {
                System.out.println("\033[31m" + "You have entered"
                        + " an invalid entry." + "\033[0m");
            }
            System.out.println(msg);
            numberIn.next();
            ++counterError;
        }
        int number = numberIn.nextInt();

        return number;
    }

    private char askDirection(String msg) {
        System.out.println(msg);
        char direction = in.next().charAt(0);
        direction = Character.toLowerCase(direction);
        while (direction != 'l' && direction != 'r'
                && direction != 'u' && direction != 'd') {
            System.out.println("\033[31m" + "You have entered"
                    + " an invalid entry." + "\033[0m");
            System.out.println(msg);
            direction = in.next().charAt(0);
        }
        return direction;
    }

    /**
     * Display an error message
     */
    public static void errorMessage() {
        System.out.println("\033[31m" + "this movement"
                + " is not allowed!!! " + "\033[0m");
    }

}
