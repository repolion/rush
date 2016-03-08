package Test;

import model.Direction;
import model.Position;

/**
 *
 * @author Cordier Olivier
 */
public class Test {

    public static void main(String[] args) {
        
        Position pos = new Position(1, 2);
        System.out.println(pos.toString());
        
        Position pos2=pos.getPosition(Direction.LEFT);
        System.out.println(pos2.toString());
        
        Position pos3=pos2.getPosition(Direction.DOWN);
        System.out.println(pos3.toString());
        
        Position pos4=pos3.getPosition(Direction.RIGHT);
        System.out.println(pos4.toString());
        
        Position pos5=pos4.getPosition(Direction.UP);
        System.out.println(pos5.toString());
        
    }

}
