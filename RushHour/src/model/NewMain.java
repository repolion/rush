/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


/**
 *
 * @author Liongeek
 */
public class NewMain {

    public static void main(String[] args) {
        Position pos=new Position(1,2);
        Car car=new Car('d',2,model.Orientation.VERTICAL,pos);
        System.out.println(car.getPositions());
    }
}
