package g42442.rushhour;

import g42442.model.Car;
import g42442.model.Position;
import g42442.model.RushHourException;
import java.util.ArrayList;
import java.util.List;
import g42442.model.RushHourGame;
import static g42442.view.Json.carJson;
import static g42442.view.Json.hasard;
import static g42442.view.Json.howManyCarsToPut;
import g42442.view.RushHourView;

/**
 * the main class to play the game
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {
        int sizeBoard = 6;
        int dice = hasard(3);
        int howManyCarToPut = howManyCarsToPut(dice);
        Car redCar = carJson(1, dice);
        List<Car> list = new ArrayList<>();
        for (int i = 2; i <= howManyCarToPut; ++i) {
            list.add(carJson(i, dice));
        }
        RushHourGame game = new RushHourGame(sizeBoard, sizeBoard,
                new Position(redCar.getCurrentPosition().getRow(), sizeBoard - 1), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();

    }

}
//
