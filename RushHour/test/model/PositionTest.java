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
        
    }

    /**
     * Test of getColumn method, of class Position.
     */
    @Test
    public void testGetColumn() {
    }

    /**
     * Test of toString method, of class Position.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of getPosition method, of class Position.
     */
    @Test
    public void testGetPositionLeft() {
        Position pos = new Position(1, 2);
        Position posAtt=new Position(1,1);
        Position pos2=pos.getPosition(Direction.LEFT);
        Assert.assertFalse(pos2.equals(posAtt));
    }
    @Test
    public void testGetPositionDown() {
        Position pos = new Position(1, 2);
        Position posAtt=new Position(2,2);
        Position pos2=pos.getPosition(Direction.DOWN);
        Assert.assertFalse(pos2.equals(posAtt));
    }
    @Test
    public void testGetPositionRight() {
        Position pos = new Position(1, 2);
        Position posAtt=new Position(1,3);
        Position pos2=pos.getPosition(Direction.RIGHT);
        Assert.assertFalse(pos2.equals(posAtt));
    }
    @Test
    public void testGetPositionUp() {
        Position pos = new Position(1, 2);
        Position posAtt=new Position(0,2);
        Position pos2=pos.getPosition(Direction.UP);
        Assert.assertFalse(pos2.equals(posAtt));
    }
    
}
/*
@Test(expected = IllegalArgumentException.class)
    public void test1(){
        Moment var = new Moment(-1, 22, 2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test2(){
        Moment var = new Moment(22, 78, 2);
    }
    
    @Test
    public void test3(){
        Moment var = new Moment(0, 22, 2);
        Moment var2 = new Moment(0, 22, 1);
        Assert.assertFalse(var.equals(var2));

*/