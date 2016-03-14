
package g42442.model;


import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class BoardTest {
   
    //tests des paramètres d'entrées de la taille du board 
    @Test(expected = IllegalArgumentException.class)
    public void testBoard1() {
        Board plateau=new Board(1,1,new Position(1,1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBoard2() {
        Board plateau=new Board(0,0,new Position(0,0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBoard3() {
        Board plateau=new Board(-1,-1,new Position(0,0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBoard4() {
        Board plateau=new Board(0,2,new Position(0,0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBoard5() {
        Board plateau=new Board(2,0,new Position(0,0));
    }
    //test de valeurs acceptables pour la taille du board
    @Test
    public void testBoard6() {
        Board plateau=new Board(1,1,new Position(0,0));
    }
    @Test
    public void testBoard7() {
        Board plateau=new Board(6,6,new Position(5,5));
    }
    
    //tests des paramètres d'entrées de la position de la sortie
    //cas de positions limites qui doivent lancer une exceptions
    @Test(expected = IllegalArgumentException.class)
    public void testExit1() {
        Board plateau=new Board(6,6,new Position(0,4));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit2() {
        Board plateau=new Board(6,6,new Position(-1,5));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit3() {
        Board plateau=new Board(6,6,new Position(0,-1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit4() {
        Board plateau=new Board(6,6,new Position(6,5));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit5() {
        Board plateau=new Board(6,6,new Position(0,6));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit6() {
        Board plateau=new Board(6,6,new Position(5,6));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit7() {
        Board plateau=new Board(6,6,new Position(5,4));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExit8() {
        Board plateau=new Board(6,6,new Position(0,0));
    }
    //cas de positions acceptables 
    @Test
    public void testExit9() {
        Board plateau=new Board(6,6,new Position(0,5));
    }
    @Test
    public void testExit10() {
        Board plateau=new Board(6,6,new Position(5,5));
    }
    
    //test de la méthode canPut sur des positions hors board
    @Test
    public void testCanPut1(){
        Car car=new Car('a',2,g42442.model.Orientation.VERTICAL,new Position(-1,2));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    public void testCanPut2(){
        Car car=new Car('a',2,g42442.model.Orientation.VERTICAL,new Position(1,-1));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut3(){
        Car car=new Car('a',2,g42442.model.Orientation.VERTICAL,new Position(5,0));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut4(){
        Car car=new Car('a',2,g42442.model.Orientation.VERTICAL,new Position(5,0));
        Board plateau=new Board(6,6,new Position(5,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut5(){
        Car car=new Car('a',2,g42442.model.Orientation.HORIZONTAL,new Position(0,5));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut6(){
        Car car=new Car('a',3,g42442.model.Orientation.HORIZONTAL,new Position(5,4));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut7(){
        Car car=new Car('a',2,g42442.model.Orientation.HORIZONTAL,new Position(0,4));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    public void testCanPut8(){
        Car car=new Car('a',3,g42442.model.Orientation.HORIZONTAL,new Position(5,3));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    @Test
    public void testCanPut9(){
        Car car=new Car('a',2,g42442.model.Orientation.VERTICAL,new Position(4,0));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    @Test
    public void testCanPut10(){
        Car car=new Car('a',3,g42442.model.Orientation.VERTICAL,new Position(3,5));
        Board plateau=new Board(6,6,new Position(5,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    
    //test methode getCarAt()
    @Test
    public void testGetCarAt(){
        
         Car car1=new Car('a',3,g42442.model.Orientation.VERTICAL,new Position(3,5));
         Board plateau=new Board(6,6,new Position(5,5));
         plateau.putCar(car1);
         Car car2=plateau.getCarAt(new Position(3,5));
         Assert.assertTrue(car1.equalsName(car2));
    }
   
    @Test
    public void getCar1(){
      Car car1=new Car('1',3,g42442.model.Orientation.VERTICAL,new Position(3,5));
      Car car2;
        Board plateau=new Board(6,6,new Position(5,5));
        plateau.putCar(car1);
            car2=plateau.getCar('1');  
        Assert.assertTrue(car1.equalsName(car2));
        
    }
    @Test
    public void getCar2(){
        boolean estNull=false;
      Car car2;
        Board plateau=new Board(6,6,new Position(5,5));
            car2=plateau.getCar('1'); 
            if(car2 == null){
                estNull=true;
            } 
        Assert.assertTrue(estNull);
        
    }
    
    @Test
    public void canMove1(){
      Car car1=new Car('1',3,g42442.model.Orientation.HORIZONTAL,new Position(0,0));
      Car car2=new Car('2',2,g42442.model.Orientation.VERTICAL,new Position(0,3));
        Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        plateau.putCar(car2);
        Assert.assertFalse(plateau.canMove(car1,g42442.model.Direction.RIGHT));
        
    }
    
    @Test
    public void canMove2(){
      Car car1=new Car('1',3,g42442.model.Orientation.HORIZONTAL,new Position(0,0));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1,g42442.model.Direction.RIGHT));
    }
    @Test
    public void canMove3(){
      Car car1=new Car('1',3,g42442.model.Orientation.VERTICAL,new Position(0,0));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1,g42442.model.Direction.UP));
    }
    @Test
    public void canMove4(){
      Car car1=new Car('1',3,g42442.model.Orientation.VERTICAL,new Position(0,0));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1,g42442.model.Direction.DOWN));
    }
    @Test
    public void canMove5(){
      Car car1=new Car('1',2,g42442.model.Orientation.HORIZONTAL,new Position(0,4));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1,g42442.model.Direction.RIGHT));
    }
    @Test
    public void canMove6(){
      Car car1=new Car('1',2,g42442.model.Orientation.HORIZONTAL,new Position(0,4));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1,g42442.model.Direction.LEFT));
    }
    public void canMove7(){
      Car car1=new Car('1',2,g42442.model.Orientation.VERTICAL,new Position(2,3));
      Car car2=new Car('2',2,g42442.model.Orientation.HORIZONTAL,new Position(1,2));
      Car car3=new Car('3',2,g42442.model.Orientation.HORIZONTAL,new Position(4,2));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1,g42442.model.Direction.UP));
    }
    public void canMove8(){
      Car car1=new Car('1',2,g42442.model.Orientation.VERTICAL,new Position(2,3));
      Car car2=new Car('2',2,g42442.model.Orientation.HORIZONTAL,new Position(1,2));
      Car car3=new Car('3',2,g42442.model.Orientation.HORIZONTAL,new Position(4,2));
      Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertFalse(plateau.canMove(car1,g42442.model.Direction.DOWN));
    }
    public void canMove9(){
      Car car1=new Car('1',2,g42442.model.Orientation.VERTICAL,new Position(2,3));
        Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1,g42442.model.Direction.UP));
    }
    public void canMove10(){
      Car car1=new Car('1',2,g42442.model.Orientation.VERTICAL,new Position(2,3));
        Board plateau=new Board(6,6,new Position(2,5));
        plateau.putCar(car1);
        Assert.assertTrue(plateau.canMove(car1,g42442.model.Direction.DOWN));
    }
}
