package g42442.rushhour;


import g42442.model.Car;
import g42442.model.Orientation;
import g42442.model.Position;
import java.util.ArrayList;
import java.util.List;
import g42442.model.RushHourGame;
import g42442.view.RushHourView;

/**
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) {
        Car redCar = new Car('1', 2,Orientation.HORIZONTAL, new Position(2, 0));
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, Orientation.HORIZONTAL, new Position(0, 0)));
        list.add(new Car('3', 3, Orientation.VERTICAL, new Position(3, 3)));
        list.add(new Car('4', 2, Orientation.VERTICAL, new Position(0, 5)));
        list.add(new Car('5', 3, Orientation.VERTICAL, new Position(1, 4)));
        list.add(new Car('6', 2, Orientation.HORIZONTAL, new Position(4, 4)));
        list.add(new Car('7', 2, Orientation.VERTICAL, new Position(3, 1)));
        RushHourGame game = new RushHourGame(6, 6, new Position(redCar.getCurrentPosition().getRow(),5), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();
        

    }

}
