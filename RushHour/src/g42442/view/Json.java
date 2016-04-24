
package g42442.view;

import g42442.model.Car;
import g42442.model.Orientation;
import g42442.model.Position;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * to read cars informations in a JSON file
 *
 * @author Cordier Olivier
 */
public class Json {

    /**
     * to create a list of Car read in Json file
     *
     * @param dice random parameter to know which file to read
     * @return a list of car
     */
    public static List<Car> listCars(int dice) {

        JSONParser parser = new JSONParser();
        Car car;
        List<Car> list = new ArrayList<>();
        try {

            Object obj = parser.parse(new FileReader("./file" + dice + ".json"));

            JSONObject jsonObject = (JSONObject) obj;
            String carsNumber = (String) jsonObject.get("cars");
            int carsNumberc = Integer.parseInt(carsNumber);

            for (int number = 2; number <= carsNumberc; ++number) {
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
                car = new Car(idc, sizec, orientationc, new Position(xc, yc));
                list.add(car);
            }

        } catch (FileNotFoundException e) {
            System.out.println("the Json file is not found!");
            System.exit(-1);
        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            System.exit(-1);
        }
        return list;
    }

    /**
     * to implement the redCar read in a Json file
     *
     * @param dice the Json file to be read
     * @return a Car read in a Json file
     */
    public static Car redCar(int dice) {

        JSONParser parser = new JSONParser();
        Car car;
        try {

            Object obj = parser.parse(new FileReader(
                    "./file" + dice + ".json"));
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("id1");
            String size = (String) jsonObject.get("size1");
            String orientation = (String) jsonObject.get("orientation1");
            String x = (String) jsonObject.get("x1");
            String y = (String) jsonObject.get("y1");
            char idc = id.charAt(0);
            int sizec = Integer.parseInt(size);
            Orientation orientationc = conv(orientation);
            int xc = Integer.parseInt(x);
            int yc = Integer.parseInt(y);
            car = new Car(idc, sizec, orientationc, new Position(xc, yc));

        } catch (FileNotFoundException e) {
            System.out.println("the Json file is not found!");
            car = null;
            System.exit(-1);
        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            car = null;
            System.exit(-1);
        }
        return car;
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
    /**
     * to know the size of the board
     *
     * @param dice random number that determines the file to open
     * @return the size of the board
     */
    public static int boardSize(int dice) {

        JSONParser parser = new JSONParser();
        int board = 0;
        try {

            Object obj = parser.parse(new FileReader(
                    "./file" + dice + ".json"));

            JSONObject jsonObject = (JSONObject) obj;
            String nbCars = (String) jsonObject.get("board");
            board = Integer.parseInt(nbCars);

        } catch (FileNotFoundException e) {
            System.out.println("the Json file is not found!");
            System.exit(-1);
        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            System.exit(-1);
        }
        return board;
    }
}
