package g42442.view;

import g42442.model.Direction;
import java.util.Scanner;
import g42442.model.RushHourGame;
import static g42442.view.Display.displayBoard;

/**
 *
 * @author Cordier Olivier
 */
public class RushHourView {

    private static final Scanner in = new Scanner(System.in);

    //Attribut
    private RushHourGame game;

    //constructeur
    public RushHourView(RushHourGame game) {
        this.game = game;
    }

    //Méthode
    public void play() {
        char carId;
        char direction;
        Display.displayBoard(game.getBoard());
        while (!game.isOver()) {
            carId = askId("Enter the id of the car you would like to move: ");
            direction = askDirection("Enter the direction: l(Left),u(UP), d(DOWN), r(RIGHT) ");
            game.move(carId, convert(direction));
            displayBoard(game.getBoard());
        }
        System.out.println("Well done!!!  ");
        System.out.println("Game Over!!!  ");
    }

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
                System.out.println("This is not a valid direction ");
        }
        return dir;
    }

    private static char askId(String msg) {
        System.out.println(msg);
        char id = in.next().charAt(0);
        while (!Character.isDigit(id)) {
            System.out.println("You have entered an invalid entry.");
            System.out.println(msg);
            id = in.next().charAt(0);
        }
        return id;
    }

    private static char askDirection(String msg) {
        System.out.println(msg);
        char direction = in.next().charAt(0);
        direction = Character.toLowerCase(direction);
        while (direction != 'l' && direction != 'r' && direction != 'u' && direction != 'd') {
            System.out.println("You have entered an invalid entry.");
            System.out.println(msg);
            direction = in.next().charAt(0);
        }
        return direction;
    }

}
