package g42442.evaluation;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Test
    public void testMaxLatitude2() throws Exception {
        Path path = new Path();
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 30., 1200));
        path.add(new Position(10., 20., 1200));
        path.add(new Position(10., 40., 1200));
        double maxLatitude=path.maxLatitude();
        Assert.assertTrue(maxLatitude==40.);
    }

}
