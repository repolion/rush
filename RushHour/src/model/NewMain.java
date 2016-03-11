package model;

import java.util.List;


/**
 *
 * @author Cordier Olivier
 */
public class NewMain {

    public static void main(String[] args) {
        Position pos=new Position(1,2);
        Car car=new Car('d',2,model.Orientation.VERTICAL,pos);
        System.out.println(car.getPositions());
        
        Board plateau=new Board(3,3,new Position(1,2));
        System.out.println(plateau.getExit());
        System.out.println(plateau.getHeight());
        System.out.println(plateau.getWidth());
   
        
        
        System.out.println(plateau.getCarAt(pos));
        
    }
}
