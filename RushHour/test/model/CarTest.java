/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Liongeek
 */
public class CarTest {

    Position pos = new Position(1, 1);
    Car A = new Car('a', 1, model.Orientation.HORIZONTAL, pos);

    /**
     * Test the getters, of class Car.
     */
    //test l'accesseur de l'attribut id
    @Test
    public void testGetId() {
        A.getId();
    }

    //test l'accesseur de l'attribut orientation
    @Test
    public void getOrientation() {
        A.getOrientation();
    }

    //test l'accesseur de l'attribut currentPosition
    @Test
    public void getCurrentPosition() {
        A.getCurrentPosition();
    }

    /**
     * Test of size method, of class Car.
     */
    //test le déclenchement de l'exception si la taille = 0
    @Test(expected = IllegalArgumentException.class)
    public void testSize1() {
        Car C = new Car('c', 0, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.LEFT);
    }

    //test le déclenchement de l'exception lorsque la taille est négative

    @Test(expected = IllegalArgumentException.class)
    public void testSize2() {
        Car C = new Car('c', -1, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.RIGHT);
    }

    //test de l'assignation de car quand la taille est strictement supérieur à 0

    @Test
    public void testSize3() {
        Car C = new Car('c', 1, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.LEFT);
    }

    @Test
    public void testToString() {
        System.out.println(pos.toString());
        Car car = new Car('d', 1, model.Orientation.HORIZONTAL, pos);
        car.toString();
    }

    /**
     * Test of move methods for class Car.
     */
    //test aller vers le haut, quand car=horizontal
    @Test(expected = IllegalArgumentException.class)
    public void testMoveUpA() {
        Car C = new Car('c', 2, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.UP);
    }

    //test aller vers le bas quand car=horizontal
    @Test(expected = IllegalArgumentException.class)
    public void testMoveDownA() {
        Car C = new Car('c', 2, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.DOWN);
    }

    //test aller vers le haut quand car=vertical
    @Test
    public void testMoveUpB() {
        Car C = new Car('c', 2, model.Orientation.VERTICAL, pos);
        C.move(model.Direction.UP);
    }

    //test aller vers le bas quand car=vertical
    @Test
    public void testMoveDownB() {
        Car C = new Car('c', 2, model.Orientation.VERTICAL, pos);
        C.move(model.Direction.DOWN);
    }

    //test aller vers la gauche quand car=vertical
    @Test(expected = IllegalArgumentException.class)
    public void testMoveLeftA() {
        Car C = new Car('c', 2, model.Orientation.VERTICAL, pos);
        C.move(model.Direction.LEFT);
    }

    //test aller vers la droite quand car=vertical
    @Test(expected = IllegalArgumentException.class)
    public void testMoveRightA() {
        Car C = new Car('c', 2, model.Orientation.VERTICAL, pos);
        C.move(model.Direction.RIGHT);
    }

    //test aller vers la gauche quand car=horizontal
    @Test
    public void testMoveLeftB() {
        Car C = new Car('c', 2, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.LEFT);
    }

    //test aller vers la droite quand car=horizontal
    @Test
    public void testMoveRightB() {
        Car C = new Car('c', 2, model.Orientation.HORIZONTAL, pos);
        C.move(model.Direction.RIGHT);
    }

}
