package g42442.evaluation;

//@pbt s/mainTest/MainTest

/**
 *
 * @author Cordier Olivier
 */
public class mainTest {

    public static void main(String[] args) throws PathException {

        Path path = new Path();
        for (int i = 1; i < 4; ++i) {
            path.add(new Position(10., 20., 1200));
        }
        for (int i = 1; i < 5; ++i) {
            path.add(new Position(10., 30., 1400));
        }
        for (int i = 1; i < 10; ++i) {
            path.add(new Position(10., 35., 1800));
        }
        System.out.println("Le nombre d'étapes est de : " + path.stepsNumber());
        System.out.println("La latitude la plus au nord est : " + path.maxLatitude());
    }
}
