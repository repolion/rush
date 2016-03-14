package g42442.rushhour;

import java.util.ArrayList;
import java.util.List;
import g42442.model.RushHourGame;

/**
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) {
        g42442.model.Car redCar = new g42442.model.Car('1', 2, g42442.model.Orientation.HORIZONTAL, new g42442.model.Position(2, 0));
        List<g42442.model.Car> list = new ArrayList<>();
        list.add(new g42442.model.Car('2', 2, g42442.model.Orientation.HORIZONTAL, new g42442.model.Position(0, 0)));
        list.add(new g42442.model.Car('3', 3, g42442.model.Orientation.VERTICAL, new g42442.model.Position(3, 3)));
        list.add(new g42442.model.Car('4', 2, g42442.model.Orientation.VERTICAL, new g42442.model.Position(0, 5)));
        list.add(new g42442.model.Car('5', 3, g42442.model.Orientation.VERTICAL, new g42442.model.Position(1, 4)));
        list.add(new g42442.model.Car('6', 2, g42442.model.Orientation.HORIZONTAL, new g42442.model.Position(4, 4)));
        list.add(new g42442.model.Car('7', 2, g42442.model.Orientation.VERTICAL, new g42442.model.Position(3, 1)));
        g42442.model.RushHourGame game = new RushHourGame(6, 6, new g42442.model.Position(2, 5), list, redCar);

        g42442.view.RushHourView gameView = new g42442.view.RushHourView(game);
        gameView.play();

    }

}
