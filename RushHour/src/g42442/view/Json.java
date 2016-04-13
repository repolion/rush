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
 * @author Cordier Olivier
 */
public class Json {

    public static Car carJson(int number, String file) {
        JSONParser parser = new JSONParser();
        Car car = new Car('0', 1, Orientation.HORIZONTAL, new Position(0, 0));
        try {

            Object obj = parser.parse(new FileReader(
                    file + ".txt"));

            JSONObject jsonObject = (JSONObject) obj;
                    String id1 = (String) jsonObject.get("id"+number);
                    String size1 = (String) jsonObject.get("size"+number);
                    String orientation1 = (String) jsonObject.get("orientation"+number);
                    String x1 = (String) jsonObject.get("x"+number);
                    String y1 = (String) jsonObject.get("y"+number);
                    char id1c = id1.charAt(0);
                    int size1c = Integer.parseInt(size1);
                    Orientation orientation1c = conv(orientation1);
                    int x1c = Integer.parseInt(x1);
                    int y1c = Integer.parseInt(y1);
                    car = new Car(id1c, size1c, orientation1c, new Position(x1c, y1c));
             
        } catch (IOException | ParseException e) {
            System.out.println("Le fichier ne peut être lu!");
            System.exit(-1);
        }
        return car;
    }

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

    public static int hasard() {
        int hasard = 1 + (int) (Math.random() * 3);
        return hasard;
    }

    public static String file(int de) {
        String file = "";
        switch (de) {
            case 1:
                file = "file1";

                break;
            case 2:
                file = "file2";
                break;
            case 3:
                file = "file3";
                break;
        }
        return file;
    }
}
