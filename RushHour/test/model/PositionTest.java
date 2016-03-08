package model;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Liongeek
 */
public class PositionTest {

    /**
     * Test of getRow method, of class Position.
     */
    @Test
    public void testGetRow() {
        Position pos = new Position(1, 2);
        int row = 1;
        int attRow = pos.getRow();
        Assert.assertTrue(row == attRow);
    }

    /**
     * Test of getColumn method, of class Position.
     */
    @Test
    public void testGetColumn() {
        Position pos = new Position(1, 2);
        int column = 2;
        int attColumn = pos.getColumn();
        Assert.assertTrue(column == attColumn);
    }

    /**
     * Test of getPosition methods, of class Position.
     */
    @Test
    public void testGetPositionLeft() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 1);
        Position pos2 = pos.getPosition(Direction.LEFT);
        Assert.assertTrue(pos2.equals(posAtt));
    }

    @Test
    public void testGetPositionDown() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(2, 2);
        Position pos2 = pos.getPosition(Direction.DOWN);
        Assert.assertTrue(pos2.equals(posAtt));
    }

    @Test
    public void testGetPositionRight() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 3);
        Position pos2 = pos.getPosition(Direction.RIGHT);
        Assert.assertTrue(posAtt.equals(pos2));
    }

    @Test
    public void testGetPositionUp() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(0, 2);
        Position pos2 = pos.getPosition(Direction.UP);
        Assert.assertTrue(posAtt.equals(pos2));
    }
}
