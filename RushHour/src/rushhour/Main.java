package rushhour;


import java.util.ArrayList;
import java.util.List;
import model.RushHourGame;

/**
 *
 * @author Cordier Olivier
 */
public class Main {
    public static void main(String[] args) {
        model.Car redCar=new model.Car('1',2,model.Orientation.HORIZONTAL,new model.Position(2,0));
        List<model.Car> list=new ArrayList<>();
        list.add(new model.Car('2',2,model.Orientation.HORIZONTAL,new model.Position(0,0)));
        list.add(new model.Car('3',3,model.Orientation.VERTICAL,new model.Position(3,3)));
        list.add(new model.Car('4',2,model.Orientation.VERTICAL,new model.Position(0,5)));
        
        model.RushHourGame game=new RushHourGame(6,6,new model.Position(2,5),list,redCar);
        
        view.RushHourView gameView=new view.RushHourView(game);
        gameView.play();
        
    }
    
}
