package g42442.rushhour;

import g42442.model.Car;
import g42442.model.Position;
import g42442.model.RushHourException;
import java.util.List;
import g42442.model.RushHourGame;
import static g42442.view.Json.*;
import g42442.view.RushHourView;

/**
 * the main class to play the game
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {
        int dice = hasard(1);
        int sizeBoard = boardSize(dice);
        Car redCar = redCar(dice);
        List<Car> list =listCars(dice);
        RushHourGame game = new RushHourGame(sizeBoard, sizeBoard,
                new Position(redCar.getCurrentPosition().getRow(), sizeBoard - 1), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();

    }

}
//
