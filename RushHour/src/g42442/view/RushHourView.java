package g42442.view;

import g42442.model.Direction;
import g42442.model.RushHourException;
import java.util.Scanner;
import g42442.model.RushHourGame;
import static g42442.view.Display.displayBoard;
import static g42442.view.Display.gameOver;
import java.io.IOException;

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
        char carId;
        char charDirection;
        Display.displayBoard(game.getBoard());
        while (!game.isOver()) {
            try {
                carId = askId("\033[34m" + "Enter the id of "
                        + "the car you would like to move: " + "\033[0m");
                charDirection = askDirection("\033[34m"
                        + "Enter the direction: l(Left),u(UP),"
                        + " d(DOWN), r(RIGHT) " + "\033[0m");

                game.move(carId, convert(charDirection));
            } catch (RushHourException e) {
                System.out.println(e.getMessage());
            }

            displayBoard(game.getBoard());
        }
        gameOver();
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

    private static char askId(String msg) {
        System.out.println(msg);
        char id = in.next().charAt(0);
        while (!Character.isDigit(id)) {
            System.out.println("\033[31m" + "You have entered"
                    + " an invalid entry." + "\033[0m");
            System.out.println(msg);
            id = in.next().charAt(0);
        }
        return id;
    }

    private static char askDirection(String msg) {
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

}
