package g42442.rushhour;

import g42442.model.RushHourException;
import g42442.model.RushHourGame;
import static g42442.rushhour.json.JsonReader.newGame;
import static g42442.view.Display.*;
import g42442.view.RushHourView;

/**
 * the main class to play the game
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {

        rushHour();
        instructions();
        RushHourGame game = newGame();
        RushHourView gameView = new RushHourView(game);
        gameView.play();

    }

}
