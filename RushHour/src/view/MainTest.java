package view;

import java.util.List;
import model.*;

/**
 *
 * @author Cordier Olivier
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board plateau = new Board();

        Car car1 = new Car('1', 2, Orientation.HORIZONTAL, new Position(2, 0));
        Car car2 = new Car('2', 3, Orientation.VERTICAL, new Position(2, 2));
        Car car3 = new Car('3', 3, Orientation.VERTICAL, new Position(2, 4));
        plateau.putCar(car1);
        plateau.putCar(car2);
        plateau.putCar(car3);

        Display.displayBoard(plateau);
        plateau.remove(car2);
        Display.displayBoard(plateau);
        if (plateau.canMove(car1, Direction.RIGHT)) {
            plateau.remove(car1);

        }
        Display.displayBoard(plateau);

    }

}
