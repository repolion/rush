package g42442.rushhour;

import g42442.model.Car;
import g42442.model.Position;
import g42442.model.RushHourException;
import java.util.ArrayList;
import java.util.List;
import g42442.model.RushHourGame;
import static g42442.view.Json.carJson;
import static g42442.view.Json.hasard;
import static g42442.view.Json.file;
import g42442.view.RushHourView;


/**
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {
        int de=hasard();
        String file=file(de);
        Car redCar=carJson(1,file);
        //Car redCar = new Car('1', 2, Orientation.HORIZONTAL, new Position(2, 0));
        List<Car> list = new ArrayList<>();
        list.add(carJson(2,file));
        list.add(carJson(3,file));
        list.add(carJson(4,file));
        list.add(carJson(5,file));
        list.add(carJson(6,file));
        list.add(carJson(7,file));
        /*list.add(carJson(8,file));
        list.add(carJson(9,file));
        list.add(carJson(10,file));*/
        RushHourGame game = new RushHourGame(6, 6,
                new Position(redCar.getCurrentPosition().getRow(), 5), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();
      
    }

}
