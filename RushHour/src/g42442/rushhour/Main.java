package g42442.rushhour;

import g42442.model.Car;
import g42442.model.Position;
import g42442.model.RushHourException;
import java.util.ArrayList;
import java.util.List;
import g42442.model.RushHourGame;
import static g42442.view.Json.carJson;
import static g42442.view.Json.hasard;
import g42442.view.RushHourView;

/**
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {
        int dice = hasard(3);
      //  String file = file(dice);
        Car redCar = carJson(1,dice);
        //Car redCar = new Car('1', 2, Orientation.HORIZONTAL, new Position(2, 0));
        List<Car> list = new ArrayList<>();
        for (int i = 2; i < 8; ++i) {
            list.add(carJson(i,dice));
        }
        RushHourGame game = new RushHourGame(6, 6,
                new Position(redCar.getCurrentPosition().getRow(), 5), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();

    }

}
