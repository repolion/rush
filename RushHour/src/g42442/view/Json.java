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
            switch (number) {
                case 1:
                    String id1 = (String) jsonObject.get("id1");
                    String size1 = (String) jsonObject.get("size1");
                    String orientation1 = (String) jsonObject.get("orientation1");
                    String x1 = (String) jsonObject.get("x1");
                    String y1 = (String) jsonObject.get("y1");
                    char id1c = id1.charAt(0);
                    int size1c = Integer.parseInt(size1);
                    Orientation orientation1c = conv(orientation1);
                    int x1c = Integer.parseInt(x1);
                    int y1c = Integer.parseInt(y1);
                    car = new Car(id1c, size1c, orientation1c, new Position(x1c, y1c));
                    break;
                case 2:
                    String id2 = (String) jsonObject.get("id2");
                    String size2 = (String) jsonObject.get("size2");
                    String orientation2 = (String) jsonObject.get("orientation2");
                    String x2 = (String) jsonObject.get("x2");
                    String y2 = (String) jsonObject.get("y2");
                    char id2c = id2.charAt(0);
                    int size2c = Integer.parseInt(size2);
                    Orientation orientation2c = conv(orientation2);
                    int x2c = Integer.parseInt(x2);
                    int y2c = Integer.parseInt(y2);
                    car = new Car(id2c, size2c, orientation2c, new Position(x2c, y2c));
                    break;
                case 3:
                    String id3 = (String) jsonObject.get("id3");
                    String size3 = (String) jsonObject.get("size3");
                    String orientation3 = (String) jsonObject.get("orientation3");
                    String x3 = (String) jsonObject.get("x3");
                    String y3 = (String) jsonObject.get("y3");
                    char id3c = id3.charAt(0);
                    int size3c = Integer.parseInt(size3);
                    Orientation orientation3c = conv(orientation3);
                    int x3c = Integer.parseInt(x3);
                    int y3c = Integer.parseInt(y3);
                    car = new Car(id3c, size3c, orientation3c, new Position(x3c, y3c));
                    break;
                case 4:
                    String id4 = (String) jsonObject.get("id4");
                    String size4 = (String) jsonObject.get("size4");
                    String orientation4 = (String) jsonObject.get("orientation4");
                    String x4 = (String) jsonObject.get("x4");
                    String y4 = (String) jsonObject.get("y4");
                    char id4c = id4.charAt(0);
                    int size4c = Integer.parseInt(size4);
                    Orientation orientation4c = conv(orientation4);
                    int x4c = Integer.parseInt(x4);
                    int y4c = Integer.parseInt(y4);
                    car = new Car(id4c, size4c, orientation4c, new Position(x4c, y4c));
                    break;
                case 5:
                    String id5 = (String) jsonObject.get("id5");
                    String size5 = (String) jsonObject.get("size5");
                    String orientation5 = (String) jsonObject.get("orientation5");
                    String x5 = (String) jsonObject.get("x5");
                    String y5 = (String) jsonObject.get("y5");
                    char id5c = id5.charAt(0);
                    int size5c = Integer.parseInt(size5);
                    Orientation orientation5c = conv(orientation5);
                    int x5c = Integer.parseInt(x5);
                    int y5c = Integer.parseInt(y5);
                    car = new Car(id5c, size5c, orientation5c, new Position(x5c, y5c));
                    break;
                case 6:
                    String id6 = (String) jsonObject.get("id6");
                    String size6 = (String) jsonObject.get("size6");
                    String orientation6 = (String) jsonObject.get("orientation6");
                    String x6 = (String) jsonObject.get("x6");
                    String y6 = (String) jsonObject.get("y6");
                    char id6c = id6.charAt(0);
                    int size6c = Integer.parseInt(size6);
                    Orientation orientation6c = conv(orientation6);
                    int x6c = Integer.parseInt(x6);
                    int y6c = Integer.parseInt(y6);
                    car = new Car(id6c, size6c, orientation6c, new Position(x6c, y6c));
                    break;
                case 7:
                    String id7 = (String) jsonObject.get("id7");
                    String size7 = (String) jsonObject.get("size7");
                    String orientation7 = (String) jsonObject.get("orientation7");
                    String x7 = (String) jsonObject.get("x7");
                    String y7 = (String) jsonObject.get("y7");
                    char id7c = id7.charAt(0);
                    int size7c = Integer.parseInt(size7);
                    Orientation orientation7c = conv(orientation7);
                    int x7c = Integer.parseInt(x7);
                    int y7c = Integer.parseInt(y7);
                    car = new Car(id7c, size7c, orientation7c, new Position(x7c, y7c));
                    break;
               /* case 8:
                    String id8 = (String) jsonObject.get("id8");
                    String size8 = (String) jsonObject.get("size8");
                    String orientation8 = (String) jsonObject.get("orientation8");
                    String x8 = (String) jsonObject.get("x8");
                    String y8 = (String) jsonObject.get("y8");
                    char id8c = id8.charAt(0);
                    int size8c = Integer.parseInt(size8);
                    Orientation orientation8c = conv(orientation8);
                    int x8c = Integer.parseInt(x8);
                    int y8c = Integer.parseInt(y8);
                    car = new Car(id8c, size8c, orientation8c, new Position(x8c, y8c));
                    break;
                case 9:
                    String id9 = (String) jsonObject.get("id9");
                    String size9 = (String) jsonObject.get("size9");
                    String orientation9 = (String) jsonObject.get("orientation9");
                    String x9 = (String) jsonObject.get("x9");
                    String y9 = (String) jsonObject.get("y9");
                    char id9c = id9.charAt(0);
                    int size9c = Integer.parseInt(size9);
                    Orientation orientation9c = conv(orientation9);
                    int x9c = Integer.parseInt(x9);
                    int y9c = Integer.parseInt(y9);
                    car = new Car(id9c, size9c, orientation9c, new Position(x9c, y9c));
                    break;
                case 10:
                    String id10 = (String) jsonObject.get("id10");
                    String size10 = (String) jsonObject.get("size10");
                    String orientation10 = (String) jsonObject.get("orientation10");
                    String x10 = (String) jsonObject.get("x10");
                    String y10 = (String) jsonObject.get("y10");
                    char id10c = id10.charAt(0);
                    int size10c = Integer.parseInt(size10);
                    Orientation orientation10c = conv(orientation10);
                    int x10c = Integer.parseInt(x10);
                    int y10c = Integer.parseInt(y10);
                    car = new Car(id10c, size10c, orientation10c, new Position(x10c, y10c));
                    break;*/

            }

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
