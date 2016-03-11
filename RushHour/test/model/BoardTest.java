
package model;

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
        Car car=new Car('a',2,model.Orientation.VERTICAL,new Position(-1,2));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    public void testCanPut2(){
        Car car=new Car('a',2,model.Orientation.VERTICAL,new Position(1,-1));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut3(){
        Car car=new Car('a',2,model.Orientation.VERTICAL,new Position(5,0));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut4(){
        Car car=new Car('a',2,model.Orientation.VERTICAL,new Position(5,0));
        Board plateau=new Board(6,6,new Position(5,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut5(){
        Car car=new Car('a',2,model.Orientation.HORIZONTAL,new Position(0,5));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut6(){
        Car car=new Car('a',3,model.Orientation.HORIZONTAL,new Position(5,4));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertFalse(plateau.canPut(car));
    }
    @Test
    public void testCanPut7(){
        Car car=new Car('a',2,model.Orientation.HORIZONTAL,new Position(0,4));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    public void testCanPut8(){
        Car car=new Car('a',3,model.Orientation.HORIZONTAL,new Position(5,3));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    @Test
    public void testCanPut9(){
        Car car=new Car('a',2,model.Orientation.VERTICAL,new Position(4,0));
        Board plateau=new Board(6,6,new Position(3,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    @Test
    public void testCanPut10(){
        Car car=new Car('a',3,model.Orientation.VERTICAL,new Position(3,5));
        Board plateau=new Board(6,6,new Position(5,5));
        Assert.assertTrue(plateau.canPut(car));
    }
    
    //test methode getCarAt()
    
   /*
    @Test
    public void testGetCarAt(){
        
         Car car1=new Car('a',3,model.Orientation.VERTICAL,new Position(3,5));
         Board plateau=new Board(6,6,new Position(5,5));
         plateau.putCar(car1);
         Car car2=plateau.getCarAt(new Position(3,5));
         Assert.assertTrue(car1.equalsName(car2));
    }
    */
    
    
}
