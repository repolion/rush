package g42442.model;

import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class CarTest {

    // test of the exception if the size = 0
    @Test(expected = IllegalArgumentException.class)            //test le déclenchement de l'exception si la taille = 0
    public void testSize1() {
        Car zeroCar = new Car('c', 0, Orientation.HORIZONTAL, new Position(1, 1));
    }

    //test of the exception if the size < 0
    @Test(expected = IllegalArgumentException.class)        //test le déclenchement de l'exception lorsque la taille est négative
    public void testSize2() {
        Car negCar = new Car('c', -1, Orientation.HORIZONTAL, new Position(1, 1));
    }

    //test a correct declaration
    @Test
    public void testSize() {
        Car okCar = new Car('c', 1, Orientation.HORIZONTAL, new Position(1, 1));
    }

    //test the moving method of the car (Up when car HORIZONTAL)
    @Test(expected = IllegalArgumentException.class)                     //test aller vers le haut, quand car=horizontal
    public void testMoveUpA() {
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.UP);
    }

    //test the moving method of the car (Up when car VERTICAL)
    @Test                                                               //test aller vers le haut quand car=vertical
    public void testMoveUpB() {
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.UP);
    }

    //test the moving method of the car (down when car HORIZONTAL)
    @Test(expected = IllegalArgumentException.class)                    //test aller vers le bas quand car=horizontal
    public void testMoveDownA() {
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.DOWN);
    }

    //test the moving method of the car (down when car VERTICAL)
    @Test                                                                //test aller vers le bas quand car=vertical
    public void testMoveDownB() {
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.DOWN);
    }

    //test the moving method of the car (left when car VERTICAL)
    @Test(expected = IllegalArgumentException.class)                    //test aller vers la gauche quand car=vertical
    public void testMoveLeftA() {
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.LEFT);
    }

    //test the moving method of the car (left when car HORIZONTAL)
    @Test                                                               //test aller vers la gauche quand car=horizontal
    public void testMoveLeftB() {
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.LEFT);
    }

    //test the moving method of the car (right when car VERTICAL)
    @Test(expected = IllegalArgumentException.class)                    //test aller vers la droite quand car=vertical
    public void testMoveRightA() {
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.RIGHT);
    }

    //test the moving method of the car (right when car HORIZONTAL)     
    @Test                                                               //test aller vers la droite quand car=horizontal
    public void testMoveRightB() {
        Car C = new Car('c', 2,Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.RIGHT);
    }

}
