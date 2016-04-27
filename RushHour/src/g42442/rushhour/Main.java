package g42442.rushhour;

import g42442.model.Car;
import g42442.model.Orientation;
import g42442.model.Position;
import g42442.model.RushHourException;
import java.util.List;
import g42442.model.RushHourGame;
import static g42442.view.Display.*;
import g42442.view.RushHourView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * the main class to play the game
 *
 * @author Cordier Olivier
 */
public class Main {

    public static void main(String[] args) throws RushHourException {
        JSONParser parser = new JSONParser();
        Car car;
        List<Car> list = new ArrayList<>();
        int sizeBoard = 0;
        Car redCar = new Car('1', 2, Orientation.HORIZONTAL, new Position(2, 0));

        int dice = hasard(7);
        try (InputStream in = Main.class.getResourceAsStream("json/file" + dice + ".json")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            String board = (String) jsonObject.get("board");
            sizeBoard = Integer.parseInt(board);

            String carsNumber = (String) jsonObject.get("cars");
            int carsNumberc = Integer.parseInt(carsNumber);

            for (int number = 1; number <= carsNumberc; ++number) {
                String id = (String) jsonObject.get("id" + number);
                String size = (String) jsonObject.get("size" + number);
                String orientation = (String) jsonObject.get("orientation" + number);
                String x = (String) jsonObject.get("x" + number);
                String y = (String) jsonObject.get("y" + number);
                char idc = id.charAt(0);
                int sizec = Integer.parseInt(size);
                Orientation orientationc = conv(orientation);
                int xc = Integer.parseInt(x);
                int yc = Integer.parseInt(y);
                if (idc == '1') {
                    redCar = new Car(idc, sizec, orientationc, new Position(xc, yc));
                } else {
                    car = new Car(idc, sizec, orientationc, new Position(xc, yc));
                    list.add(car);
                }
            }

        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            System.exit(-1);
        }
        rushHour();
        instructions();
        RushHourGame game = new RushHourGame(sizeBoard, sizeBoard,
                new Position(redCar.getCurrentPosition().getRow(), sizeBoard - 1), list, redCar);
        RushHourView gameView = new RushHourView(game);
        gameView.play();

    }

    /**
     * to convert a String in an Orientation
     *
     * @param orientation to be converted in type Orientation
     * @return an orientation
     */
    public static Orientation conv(String orientation) {
        Orientation ori = null;

        switch (orientation) {
            case "h":
                ori = Orientation.HORIZONTAL;

                break;
            case "v":
                ori = Orientation.VERTICAL;
                break;
            case "m":
                ori = Orientation.MULTI;
                break;
        }
        return ori;
    }

    /**
     * to generate a random number between 1 and a parameter (int it)
     *
     * @param i the maximum limit of the random number
     * @return a random number bewteen 1 and i
     */
    public static int hasard(int i) {
        int hasard = 1 + (int) (Math.random() * i);
        return hasard;
    }

}
