package g42442.model;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class BoardTest {

    /*test to check if an exception is launched caused by an illegal size of
     the board*/
    @Test
    public void testBoard1() throws RushHourException {
        Board plateau = new Board(1, 1, new Position(0, 0));
    }

    @Test(expected = RushHourException.class)
    public void testBoard2() throws RushHourException {
        Board plateau = new Board(0, 0, new Position(0, 0));
    }

    @Test(expected = RushHourException.class)
    public void testBoard3() throws RushHourException {
        Board plateau = new Board(-1, -1, new Position(0, 0));
    }

    @Test(expected = RushHourException.class)
    public void testBoard4() throws RushHourException {
        Board plateau = new Board(0, 2, new Position(0, 0));
    }

    @Test(expected = RushHourException.class)
    public void testBoard5() throws RushHourException {
        Board plateau = new Board(2, 0, new Position(0, 0));
    }

    //test if no exception launched with acceptables values for the board
    @Test
    public void testBoard6() throws RushHourException {
        Board plateau = new Board(1, 1, new Position(0, 0));
    }

    @Test
    public void testBoard7() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(5, 5));
    }

    /*test to check if an exception is launched caused by an illegal exit 
     position on the board*/
    @Test(expected = RushHourException.class)
    public void testExit1() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(0, 4));
    }

    @Test(expected = RushHourException.class)
    public void testExit2() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(-1, 5));
    }

    @Test(expected = RushHourException.class)
    public void testExit3() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(0, -1));
    }

    @Test(expected = RushHourException.class)
    public void testExit4() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(6, 5));
    }

    @Test(expected = RushHourException.class)
    public void testExit5() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(0, 6));
    }

    @Test(expected = RushHourException.class)
    public void testExit6() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(5, 6));
    }

    @Test(expected = RushHourException.class)
    public void testExit7() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(5, 4));
    }

    @Test(expected = RushHourException.class)
    public void testExit8() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(0, 0));
    }

    //test if no exception launched with acceptables values of the exit position
    @Test
    public void testExit9() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(0, 5));
    }

    @Test
    public void testExit10() throws RushHourException {
        Board plateau = new Board(6, 6, new Position(5, 5));
    }

    /*test to check if an exception is launched caused usinf the method
     canPut with positions out of the board*/
    @Test
    public void testCanPut1() throws RushHourException {
        Car car = new Car('a', 2, Orientation.VERTICAL, new Position(-1, 2));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    public void testCanPut2() throws RushHourException {
        Car car = new Car('a', 2, Orientation.VERTICAL, new Position(1, -1));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    @Test
    public void testCanPut3() throws RushHourException {
        Car car = new Car('a', 2, Orientation.VERTICAL, new Position(5, 0));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    @Test
    public void testCanPut4() throws RushHourException {
        Car car = new Car('a', 2, Orientation.VERTICAL, new Position(5, 0));
        Board plateau = new Board(6, 6, new Position(5, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    @Test
    public void testCanPut5() throws RushHourException {
        Car car = new Car('a', 2, Orientation.HORIZONTAL, new Position(0, 5));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    @Test
    public void testCanPut6() throws RushHourException {
        Car car = new Car('a', 3, Orientation.HORIZONTAL, new Position(5, 4));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(plateau.canPut(car));
    }

    @Test
    public void testCanPut7() throws RushHourException {
        Car car = new Car('a', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(plateau.canPut(car));
    }

    public void testCanPut8() throws RushHourException {
        Car car = new Car('a', 3, Orientation.HORIZONTAL, new Position(5, 3));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(plateau.canPut(car));
    }

    @Test
    public void testCanPut9() throws RushHourException {
        Car car = new Car('a', 2, Orientation.VERTICAL, new Position(4, 0));
        Board plateau = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(plateau.canPut(car));
    }

    @Test
    public void testCanPut10() throws RushHourException {
        Car car = new Car('a', 3, Orientation.VERTICAL, new Position(3, 5));
        Board plateau = new Board(6, 6, new Position(5, 5));
        Assert.assertTrue(plateau.canPut(car));
    }

    //test the method getCarAt()
    @Test
    public void testGetCarAt() throws RushHourException {

        Car car1 = new Car('a', 3, Orientation.VERTICAL, new Position(3, 5));
        Board plateau = new Board(6, 6, new Position(5, 5));
        plateau.putCar(car1);
        assertEquals(plateau.getCarAt(new Position(3, 5)), car1);
    }

    @Test
    public void getCar1() throws RushHourException {
        Car car1 = new Car('1', 3, Orientation.VERTICAL, new Position(3, 5));
        Car car2;
        Board plateau = new Board(6, 6, new Position(5, 5));
        plateau.putCar(car1);
        car2 = plateau.getCar('1');
        Assert.assertTrue(car1.equalsName(car2));

    }

    @Test
    public void getCar2() throws RushHourException {
        boolean estNull = false;
        Car car2;
        Board plateau = new Board(6, 6, new Position(5, 5));
        car2 = plateau.getCar('1');
        if (car2 == null) {
            estNull = true;
        }
        Assert.assertTrue(estNull);

    }

    //test the method canMove
    @Test
    public void canMove1() throws RushHourException {
        Car car1 = new Car('1', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Car car2 = new Car('2', 2, Orientation.VERTICAL, new Position(0, 3));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        plateau.putCar(car2);
        Assert.assertFalse(plateau.canMove(car1, g42442.model.Direction.RIGHT));

    }

    @Test
    public void canMove2() throws RushHourException {
        Car car1 = new Car('1', 3, Orientation.HORIZONTAL, new Position(0, 0));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1, g42442.model.Direction.RIGHT));
    }

    @Test
    public void canMove3() throws RushHourException {
        Car car1 = new Car('1', 3, Orientation.VERTICAL, new Position(0, 0));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1, g42442.model.Direction.UP));
    }

    @Test
    public void canMove4() throws RushHourException {
        Car car1 = new Car('1', 3, Orientation.VERTICAL, new Position(0, 0));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1, g42442.model.Direction.DOWN));
    }

    @Test
    public void canMove5() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1, g42442.model.Direction.RIGHT));
    }

    @Test
    public void canMove6() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.HORIZONTAL, new Position(0, 4));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1, g42442.model.Direction.LEFT));
    }

    public void canMove7() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.VERTICAL, new Position(2, 3));
        Car car2 = new Car('2', 2, Orientation.HORIZONTAL, new Position(1, 2));
        Car car3 = new Car('3', 2, Orientation.HORIZONTAL, new Position(4, 2));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1, g42442.model.Direction.UP));
    }

    public void canMove8() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.VERTICAL, new Position(2, 3));
        Car car2 = new Car('2', 2, Orientation.HORIZONTAL, new Position(1, 2));
        Car car3 = new Car('3', 2, Orientation.HORIZONTAL, new Position(4, 2));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1, g42442.model.Direction.DOWN));
    }

    public void canMove9() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.VERTICAL, new Position(2, 3));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1, g42442.model.Direction.UP));
    }

    public void canMove10() throws RushHourException {
        Car car1 = new Car('1', 2, Orientation.VERTICAL, new Position(2, 3));
        Board plateau = new Board(6, 6, new Position(2, 5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1, g42442.model.Direction.DOWN));
    }
}
