package g42442.view;

import java.util.Scanner;
import g42442.model.RushHourGame;

/**
 *
 * @author Cordier Olivier
 */
public class RushHourView {
    
    //Attribut
    private RushHourGame game;
    
    //constructeur
    public RushHourView(RushHourGame game){
        this.game=game;
    }
    
    //Méthode
    public void play(){
        Scanner in =new Scanner(System.in);
        boolean isOver=false;
        char carId;
        char direction;
        g42442.view.Display.displayBoard(game.getBoard());
        while(isOver==false){
            System.out.println("Enter the id of the car to be moved");
            carId=in.next().charAt(0);
            System.out.println("Enter the direction: l(Left),u(UP), d(DOWN), r(RIGHT)" );
            direction=in.next().charAt(0);
            game.move(carId, convert(direction));
     
            g42442.view.Display.displayBoard(game.getBoard());
            isOver=game.isOver();
        }
        System.out.println("Well done!!!  ");
        System.out.println("Game Over!!!  ");
    }
    public g42442.model.Direction convert(char direction){
        g42442.model.Direction dir = null;
        
        switch (direction) {
            case 'l':
                dir=g42442.model.Direction.LEFT;
                
                break;
            case 'r':
                dir=g42442.model.Direction.RIGHT;
                break;
            case 'u':
               dir=g42442.model.Direction.UP;
                break;
            case 'd':
               dir=g42442.model.Direction.DOWN;
                break;
            default: System.out.println("This is not a valid direction ");
        }
        return dir;
    }
    
}
