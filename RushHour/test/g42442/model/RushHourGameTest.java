package g42442.model;

import static g42442.model.Direction.*;
import static g42442.model.Orientation.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class RushHourGameTest {

    /*test if an exception is launched when the exit is not on the 
     same row as the redCar*/
    @Test(expected = RushHourException.class)
    public void constructorRushHourGame1() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(2, 0));
        RushHourGame game = new RushHourGame(6, 6,
                new Position(1, 5), list, redCar);
    }

    //test if an exception is launched when we try to move an horizontal car up
    @Test(expected = RushHourException.class)
    public void testMove1() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('1', UP);

    }

    //test if an exception is launched when we try to move an horizontal car down

    @Test(expected = RushHourException.class)
    public void testMove2() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('1', DOWN);

    }

    //test if an exception is launched when we try to move a vertical car left

    @Test(expected = RushHourException.class)
    public void testMove3() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, VERTICAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('1', LEFT);

    }

    //test if an exception is launched when we try to move a vertical car right

    @Test(expected = RushHourException.class)
    public void testMove4() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, VERTICAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('1', RIGHT);

    }

    //test if an exception is launched when the id of the car to move is not found

    @Test(expected = RushHourException.class)
    public void testMove5() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('3', UP);

    }

    //test the position of a car that have been moved right

    @Test
    public void testMove6() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(2, 3)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(0, 5), list, redCar);
        game.move('1', RIGHT);
        Car carTest = new Car('3', 2, HORIZONTAL, new Position(0, 3));
        Assert.assertTrue(game.getBoard().getCar('1').getCurrentPosition().equals(carTest.getCurrentPosition()));
    }

    //test the position of a car that have been moved left

    @Test
    public void testMove7() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(1, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(1, 5), list, redCar);
        game.move('1', LEFT);
        Car carTest = new Car('3', 2, HORIZONTAL, new Position(1, 1));
        Assert.assertTrue(game.getBoard().getCar('1').getCurrentPosition().equals(carTest.getCurrentPosition()));
    }

    //test the position of a car that have been moved up

    @Test
    public void testMove8() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, VERTICAL, new Position(3, 3)));
        Car redCar = new Car('1', 2, VERTICAL, new Position(0, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(0, 5), list, redCar);
        game.move('2', UP);
        Car carTest = new Car('3', 2, VERTICAL, new Position(2, 3));
        Assert.assertTrue(game.getBoard().getCar('2').getCurrentPosition().equals(carTest.getCurrentPosition()));
    }

    //test the position of a car that have been moved down

    @Test
    public void testMove9() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, VERTICAL, new Position(3, 3)));
        Car redCar = new Car('1', 2, VERTICAL, new Position(2, 2));
        RushHourGame game = new RushHourGame(6, 6, new Position(2, 5), list, redCar);
        game.move('2', DOWN);
        Car carTest = new Car('3', 2, VERTICAL, new Position(4, 3));
        Assert.assertTrue(game.getBoard().getCar('2').getCurrentPosition().equals(carTest.getCurrentPosition()));
    }

    //test that method isOver() return true when the redCar arrive on the exit position

    @Test
    public void testIsOver() throws RushHourException {
        List<Car> list = new ArrayList<>();
        list.add(new Car('2', 2, HORIZONTAL, new Position(0, 0)));
        Car redCar = new Car('1', 2, HORIZONTAL, new Position(3, 3));
        RushHourGame game = new RushHourGame(6, 6, new Position(3, 5), list, redCar);
        game.move('1', RIGHT);
        Assert.assertTrue(game.isOver());
    }

}
