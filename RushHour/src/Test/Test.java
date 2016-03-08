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
    }

}
