package g42442.model;

import static g42442.model.Direction.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test JUnit ;)
 *
 * @author Cordier Olivier
 */
public class PositionTest {

    // test the getter of the row
    @Test
    public void testGetRow() {
        Position pos = new Position(1, 2);
        int row = 1;
        int attRow = pos.getRow();
        Assert.assertTrue(row == attRow);
    }

    // test the getter of the column
    @Test
    public void testGetColumn() {
        Position pos = new Position(1, 2);
        int column = 2;
        int attColumn = pos.getColumn();
        Assert.assertTrue(column == attColumn);
    }

    // test an allowed movement to the left
    @Test
    public void testGetPositionLeft() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 1);
        Position pos2 = pos.getPosition(LEFT);
        Assert.assertTrue(pos2.equals(posAtt));
    }

    // test an allowed movement to the right
    @Test
    public void testGetPositionRight() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 3);
        Position pos2 = pos.getPosition(RIGHT);
        Assert.assertTrue(posAtt.equals(pos2));
    }

    // test an allowed movement up
    @Test
    public void testGetPositionUp() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(0, 2);
        Position pos2 = pos.getPosition(Direction.UP);
        Assert.assertTrue(posAtt.equals(pos2));
    }

    // test an allowed movement down
    @Test
    public void testGetPositionDown() {
        Position pos = new Position(1, 2);
        Position posAtt = new Position(2, 2);
        Position pos2 = pos.getPosition(Direction.DOWN);
        Assert.assertTrue(pos2.equals(posAtt));
    }

}
