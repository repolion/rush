package g42442.evaluation;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cordier Olivier
 */
public class PathTest {

    // case in which the last 15 positions are the same
    @Test
    public void testIsStationary() {
        Path path = new Path();
        for (int i = 0; i < 15; ++i) {
            path.add(new Position(10., 20., 1200));
        }
        Assert.assertTrue(path.isStationary());
    }

    // case in which the last 15 positions are not the same
    @Test
    public void testIsStationary2() {
        Path path = new Path();
        for (int i = 1; i < 15; ++i) {
            path.add(new Position(10., 20., 1200));
        }
        path.add(new Position(10., 30., 1200));
        Assert.assertFalse(path.isStationary());
    }

    // test the launch of PathException if no position in the list of Path
    @Test(expected = PathException.class)
    public void testMaxLatitude1() throws Exception {
        Path path = new Path();
        path.maxLatitude();
    }

    //check it the methods return 40. the maximum latitude
    @Test
    public void testMaxLatitude2() throws Exception {
        Path path = new Path();
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 30., 1200));
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 40., 1200));
        double maxLatitude = path.maxLatitude();
        Assert.assertTrue(maxLatitude == 40.);
    }

    //check it the methods return 120. the maximum latitude
    @Test
    public void testMaxLatitude3() throws Exception {
        Path path = new Path();
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 30., 1200));
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 120., 1200));
        double maxLatitude = path.maxLatitude();
        Assert.assertTrue(maxLatitude == 120.);
    }

    //check it the methods return 80. the maximum latitude
    @Test
    public void testMaxLatitude4() throws Exception {
        Path path = new Path();
        path.add(new Position(10., 80., 1200));
        path.add(new Position(10., 30., 1200));
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 40., 1200));
        double maxLatitude = path.maxLatitude();
        Assert.assertTrue(maxLatitude == 80.);
    }

}
