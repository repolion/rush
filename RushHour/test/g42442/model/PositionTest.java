package g42442.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test G-unit ;)
 *
 * @author Cordier Olivier
 */
public class PositionTest {

    // test the getter of the row
    @Test
    public void testGetRow() {                              //vérifie que le numéro de ligne d'une position est bien 
        Position pos = new Position(1, 2);                  // récupéré par getRow()
        int row = 1;
        int attRow = pos.getRow();
        Assert.assertTrue(row == attRow);
    }

    // test the getter of the column
    @Test
    public void testGetColumn() {                           // vérifie que le numéro de colonne d'une position est bien                 
        Position pos = new Position(1, 2);                  // récupéré par getColumn()
        int column = 2;
        int attColumn = pos.getColumn();
        Assert.assertTrue(column == attColumn);
    }

    // test an allowed movement to the left
    @Test                                                   // Vérifie le bon fonctionnement de getPosition
    public void testGetPositionLeft() {                     // avec le paramètre d'entrée Direction.LEFT
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 1);
        Position pos2 = pos.getPosition(Direction.LEFT);
        Assert.assertTrue(pos2.equals(posAtt));
    }

    // test an allowed movement to the right
    @Test                                                   // Vérifie le bon fonctionnement de getPosition
    public void testGetPositionRight() {                    // avec le paramètre d'entrée Direction.RIGHT 
        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 3);
        Position pos2 = pos.getPosition(Direction.RIGHT);
        Assert.assertTrue(posAtt.equals(pos2));
    }

    // test an allowed movement up
    @Test                                                   // Vérifie le bon fonctionnement de getPosition
    public void testGetPositionUp() {                       // avec le paramètre d'entrée Direction.UP
        Position pos = new Position(1, 2);
        Position posAtt = new Position(0, 2);
        Position pos2 = pos.getPosition(Direction.UP);
        Assert.assertTrue(posAtt.equals(pos2));
    }

    // test an allowed movement down
    @Test                                                   // Vérifie le bon fonctionnement de getPosition
    public void testGetPositionDown() {                     // avec le paramètre d'entrée Direction.DOWN 
        Position pos = new Position(1, 2);
        Position posAtt = new Position(2, 2);
        Position pos2 = pos.getPosition(Direction.DOWN);
        Assert.assertTrue(pos2.equals(posAtt));
    }

}
