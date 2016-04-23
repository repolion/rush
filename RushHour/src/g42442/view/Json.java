package g42442.view;

import g42442.model.Car;
import g42442.model.Orientation;
import g42442.model.Position;
import java.io.FileReader;
import java.io.IOException;
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
     * to implement a Car read in a Json file
     *
     * @param number the id of the Car to be read in Json file
     * @param dice the Json file to be read
     * @return a Car read in a Json file
     */
    public static Car carJson(int number, int dice) {

        JSONParser parser = new JSONParser();
        Car car;
        try {
           
            Object obj = parser.parse(new FileReader(
                    "./resources/file" + dice + ".txt"));
       
           
            
            JSONObject jsonObject = (JSONObject) obj;
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

        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            car = null;
            System.exit(-1);
        }
        return car;
    }

    /**
     * to know how many cars (to put) are in a certain file
     *
     * @param dice random number that determines the file to open
     * @return cars number of cars have to be put int the board
     */
    public static int howManyCarsToPut(int dice) {

        JSONParser parser = new JSONParser();
        int cars = 0;
        try {

            Object obj = parser.parse(new FileReader(
                    "./resources/file" + dice + ".txt"));

            JSONObject jsonObject = (JSONObject) obj;
            String nbCars = (String) jsonObject.get("cars");
            cars = Integer.parseInt(nbCars);

        } catch (IOException | ParseException e) {
            System.out.println("the Json file can't be read!");
            System.exit(-1);
        }
        return cars;
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
}
