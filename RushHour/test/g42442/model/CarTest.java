package g42442.model;

import g42442.model.Car;
import g42442.model.Position;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class CarTest {

    //Décalarations et assignations de positions et Orientations pour Tests
    Position positionOk = new Position(1, 1);
    Car horOk = new Car('a', 1, g42442.model.Orientation.HORIZONTAL, positionOk);
    Car verOk = new Car('b', 1, g42442.model.Orientation.VERTICAL, positionOk);

    /**
     * Test the getters, of class Car.
     */
    //test l'accesseur de l'attribut id
    @Test
    public void testGetId() {
        horOk.getId();
    }

    //test l'accesseur de l'attribut orientation
    @Test
    public void getOrientation() {
        verOk.getOrientation();
    }

    //test l'accesseur de l'attribut currentPosition
    @Test
    public void getCurrentPosition() {
        horOk.getCurrentPosition();
    }

    /**
     * Test of size method, of class Car.
     */
    //test le déclenchement de l'exception si la taille = 0
    @Test(expected = IllegalArgumentException.class)
    public void testSize1() {
        Car zeroCar = new Car('c', 0, g42442.model.Orientation.HORIZONTAL, positionOk);
        zeroCar.move(g42442.model.Direction.LEFT);
    }

    //test le déclenchement de l'exception lorsque la taille est négative
    @Test(expected = IllegalArgumentException.class)
    public void testSize2() {
        Car negCar = new Car('c', -1, g42442.model.Orientation.HORIZONTAL, positionOk);
        negCar.move(g42442.model.Direction.RIGHT);
    }

    //test de l'assignation de car quand la taille est strictement supérieur à 0
    @Test
    public void testSize3() {
        horOk.move(g42442.model.Direction.LEFT);
    }

    @Test
    public void testToString() {
        verOk.toString();
    }

    /**
     * Test of move methods for class Car.
     */
    //test aller vers le haut, quand car=horizontal
    @Test(expected = IllegalArgumentException.class)
    public void testMoveUpA() {
        Car C = new Car('c', 2, g42442.model.Orientation.HORIZONTAL, positionOk);
        C.move(g42442.model.Direction.UP);
    }

    //test aller vers le bas quand car=horizontal
    @Test(expected = IllegalArgumentException.class)
    public void testMoveDownA() {
        Car C = new Car('c', 2, g42442.model.Orientation.HORIZONTAL, positionOk);
        C.move(g42442.model.Direction.DOWN);
    }

    //test aller vers le haut quand car=vertical
    @Test
    public void testMoveUpB() {
        Car C = new Car('c', 2, g42442.model.Orientation.VERTICAL, positionOk);
        C.move(g42442.model.Direction.UP);
    }

    //test aller vers le bas quand car=vertical
    @Test
    public void testMoveDownB() {
        Car C = new Car('c', 2, g42442.model.Orientation.VERTICAL, positionOk);
        C.move(g42442.model.Direction.DOWN);
    }

    //test aller vers la gauche quand car=vertical
    @Test(expected = IllegalArgumentException.class)
    public void testMoveLeftA() {
        Car C = new Car('c', 2, g42442.model.Orientation.VERTICAL, positionOk);
        C.move(g42442.model.Direction.LEFT);
    }

    //test aller vers la droite quand car=vertical
    @Test(expected = IllegalArgumentException.class)
    public void testMoveRightA() {
        Car C = new Car('c', 2, g42442.model.Orientation.VERTICAL, positionOk);
        C.move(g42442.model.Direction.RIGHT);
    }

    //test aller vers la gauche quand car=horizontal
    @Test
    public void testMoveLeftB() {
        Car C = new Car('c', 2, g42442.model.Orientation.HORIZONTAL, positionOk);
        C.move(g42442.model.Direction.LEFT);
    }

    //test aller vers la droite quand car=horizontal
    @Test
    public void testMoveRightB() {
        Car C = new Car('c', 2, g42442.model.Orientation.HORIZONTAL, positionOk);
        C.move(g42442.model.Direction.RIGHT);
    }
    /**
     * Test of List<Position> getPositions() methods, of class Car.
     */

    /* @Test
     public void testListPositions() {
        
     }
     */
}
