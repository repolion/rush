package g42442.model;

import static g42442.model.Direction.*;
import static g42442.model.Orientation.*;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class BoardTest {

    //test if an exception is launched caused by an illegal size ofthe board
    @Test
    public void testBoard1() throws IllegalArgumentException {
        Board board = new Board(1, 1, new Position(0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoard2() throws IllegalArgumentException {
        Board board = new Board(0, 0, new Position(0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoard3() throws IllegalArgumentException {
        Board board = new Board(-1, -1, new Position(0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoard4() throws IllegalArgumentException {
        Board board = new Board(0, 2, new Position(0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoard5() throws IllegalArgumentException {
        Board board = new Board(2, 0, new Position(0, 0));
    }

    //test if no exception launched with acceptables values for the board
    @Test
    public void testBoard6() throws IllegalArgumentException {
        Board board = new Board(1, 1, new Position(0, 0));
    }

    @Test
    public void testBoard7() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(5, 5));
    }

    /*test if an exception is launched caused by an illegal exit 
     position on the board*/
    @Test(expected = IllegalArgumentException.class)
    public void testExit1() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(0, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit2() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(-1, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit3() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(0, -1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit4() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(6, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit5() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(0, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit6() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit7() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(5, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExit8() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(0, 0));
    }

    //test if no exception launched with acceptables values of the exit position
    @Test
    public void testExit9() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(0, 5));
    }

    @Test
    public void testExit10() throws IllegalArgumentException {
        Board board = new Board(6, 6, new Position(5, 5));
    }

    /*test if an exception is launched caused by using the method
     canPut with positions out of the board*/
    @Test
    public void testCanPut1() throws IllegalArgumentException {
        Car car = new Car('a', 2, VERTICAL, new Position(-1, 2));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(board.canPut(car));
    }

    public void testCanPut2() throws IllegalArgumentException {
        Car car = new Car('a', 2, VERTICAL, new Position(1, -1));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(board.canPut(car));
    }

    @Test
    public void testCanPut3() throws IllegalArgumentException {
        Car car = new Car('a', 2, VERTICAL, new Position(5, 0));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(board.canPut(car));
    }

    @Test
    public void testCanPut4() throws IllegalArgumentException {
        Car car = new Car('a', 2, VERTICAL, new Position(5, 0));
        Board board = new Board(6, 6, new Position(5, 5));
        Assert.assertFalse(board.canPut(car));
    }

    @Test
    public void testCanPut5() throws IllegalArgumentException {
        Car car = new Car('a', 2, HORIZONTAL, new Position(0, 5));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(board.canPut(car));
    }

    @Test
    public void testCanPut6() throws IllegalArgumentException {
        Car car = new Car('a', 3, HORIZONTAL, new Position(5, 4));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertFalse(board.canPut(car));
    }

    @Test
    public void testCanPut7() throws IllegalArgumentException {
        Car car = new Car('a', 2, HORIZONTAL, new Position(0, 4));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(board.canPut(car));
    }

    public void testCanPut8() throws IllegalArgumentException {
        Car car = new Car('a', 3, HORIZONTAL, new Position(5, 3));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(board.canPut(car));
    }

    @Test
    public void testCanPut9() throws IllegalArgumentException {
        Car car = new Car('a', 2, VERTICAL, new Position(4, 0));
        Board board = new Board(6, 6, new Position(3, 5));
        Assert.assertTrue(board.canPut(car));
    }

    @Test
    public void testCanPut10() throws IllegalArgumentException {
        Car car = new Car('a', 3, VERTICAL, new Position(3, 5));
        Board board = new Board(6, 6, new Position(5, 5));
        Assert.assertTrue(board.canPut(car));
    }

    //test the method getCarAt()
    @Test
    public void testGetCarAt() throws IllegalArgumentException {

        Car car1 = new Car('a', 3, VERTICAL, new Position(3, 5));
        Board board = new Board(6, 6, new Position(5, 5));
        board.putCar(car1);
        assertEquals(board.getCarAt(new Position(3, 5)), car1);
    }

    @Test
    public void getCar1() throws IllegalArgumentException {
        Car car1 = new Car('1', 3, VERTICAL, new Position(3, 5));
        Car car2;
        Board board = new Board(6, 6, new Position(5, 5));
        board.putCar(car1);
        car2 = board.getCar('1');
        Assert.assertTrue(car1.equalsName(car2));

    }

    @Test
    public void getCar2() throws IllegalArgumentException {
        boolean estNull = false;
        Car car2;
        Board board = new Board(6, 6, new Position(5, 5));
        car2 = board.getCar('1');
        if (car2 == null) {
            estNull = true;
        }
        Assert.assertTrue(estNull);

    }

    //test the method canMove
    @Test
    public void canMove1() throws IllegalArgumentException {
        Car car1 = new Car('1', 3, HORIZONTAL, new Position(0, 0));
        Car car2 = new Car('2', 2, VERTICAL, new Position(0, 3));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        board.putCar(car2);
        Assert.assertFalse(board.canMove(car1, RIGHT));

    }

    @Test
    public void canMove2() throws IllegalArgumentException {
        Car car1 = new Car('1', 3, HORIZONTAL, new Position(0, 0));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertTrue(board.canMove(car1, RIGHT));
    }

    @Test
    public void canMove3() throws IllegalArgumentException {
        Car car1 = new Car('1', 3, VERTICAL, new Position(0, 0));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertFalse(board.canMove(car1, UP));
    }

    @Test
    public void canMove4() throws IllegalArgumentException {
        Car car1 = new Car('1', 3, VERTICAL, new Position(0, 0));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertTrue(board.canMove(car1, DOWN));
    }

    @Test
    public void canMove5() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, HORIZONTAL, new Position(0, 4));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertFalse(board.canMove(car1, RIGHT));
    }

    @Test
    public void canMove6() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, HORIZONTAL, new Position(0, 4));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertTrue(board.canMove(car1, LEFT));
    }

    public void canMove7() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, VERTICAL, new Position(2, 3));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertFalse(board.canMove(car1, g42442.model.Direction.UP));
    }

    public void canMove8() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, Orientation.VERTICAL, new Position(2, 3));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertFalse(board.canMove(car1, DOWN));
    }

    public void canMove9() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, VERTICAL, new Position(2, 3));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertTrue(board.canMove(car1, UP));
    }

    public void canMove10() throws IllegalArgumentException {
        Car car1 = new Car('1', 2, VERTICAL, new Position(2, 3));
        Board board = new Board(6, 6, new Position(2, 5));
        board.putCar(car1);
        Assert.assertTrue(board.canMove(car1, DOWN));
    }
}
