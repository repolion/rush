package g42442.model;

import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class CarTest {

    // test of the exception if the size of the car = 0
    @Test(expected = IllegalArgumentException.class)           
    public void testSize1(){
        Car zeroCar = new Car('c', 0, Orientation.HORIZONTAL, new Position(1, 1));
    }

    //test of the exception if the size of the car < 0
    @Test(expected = IllegalArgumentException.class)        
    public void testSize2(){
        Car negCar = new Car('c', -1, Orientation.HORIZONTAL, new Position(1, 1));
    }

    //test a correct declaration
    @Test
    public void testSize(){
        Car okCar = new Car('c', 1, Orientation.HORIZONTAL, new Position(1, 1));
        
    }

    //test the moving method of the car (Up when car HORIZONTAL)
    @Test(expected = IllegalArgumentException.class)                   
    public void testMoveUpA(){
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.UP);
    }

    //test the moving method of the car (Up when car VERTICAL)
    @Test                                                               
    public void testMoveUpB(){
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.UP);
    }

    //test the moving method of the car (down when car HORIZONTAL)
    @Test(expected = IllegalArgumentException.class)                   
    public void testMoveDownA(){
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.DOWN);
    }

    //test the moving method of the car (down when car VERTICAL)
    @Test                                                                
    public void testMoveDownB() throws IllegalArgumentException {
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.DOWN);
    }

    //test the moving method of the car (left when car VERTICAL)
    @Test(expected = IllegalArgumentException.class)                   
    public void testMoveLeftA(){
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.LEFT);
    }

    //test the moving method of the car (left when car HORIZONTAL)
    @Test                                                               
    public void testMoveLeftB() throws IllegalArgumentException {
        Car C = new Car('c', 2, Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.LEFT);
    }

    //test the moving method of the car (right when car VERTICAL)
    @Test(expected = IllegalArgumentException.class)                    
    public void testMoveRightA(){
        Car C = new Car('c', 2, Orientation.VERTICAL, new Position(1, 1));
        C.move(Direction.RIGHT);
    }

    //test the moving method of the car (right when car HORIZONTAL)     
    @Test                                                          
    public void testMoveRightB(){
        Car C = new Car('c', 2,Orientation.HORIZONTAL, new Position(1, 1));
        C.move(Direction.RIGHT);
    }

}
