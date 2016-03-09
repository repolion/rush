/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.Orientation.HORIZONTAL;

/**
 *
 * @author Liongeek
 */
public class NewMain {

    public static void main(String[] args) {

        Position pos = new Position(1, 2);
        Position posAtt = new Position(1, 1);
        Position pos2 = pos.getPosition(Direction.LEFT);

        System.out.println(posAtt);
        System.out.println(pos2);
        
          Car car = new Car('d', 1, HORIZONTAL,pos2);
        
      
    }
}
