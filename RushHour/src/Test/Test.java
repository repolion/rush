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
        Position posAtt=new Position(1,1);
        Position pos2=pos.getPosition(Direction.LEFT);
        
        System.out.println(posAtt);
        System.out.println(pos2);
        System.out.println("test");
    }

}
