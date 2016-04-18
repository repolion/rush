package g42442.evaluation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cordier Olivier
 */
public class Path {

    private List<Position> positions;

    //constructor
    public Path() {
        this.positions = new ArrayList<>();
    }
//others methods

    /**
     * to add a new position in the list positions of path
     *
     * @param position new position to add in parameters of Path
     */
    public void add(Position position) {
        this.positions.add(position);
    }

    /**
     * to know how the number of position in the list positions of Path
     *
     * @return the number of positions in list positions
     */
    public int stepsNumber() {
        return this.positions.size();
    }

    /**
     * to know if the last fifteens minutes the positions in the list are the
     * same
     *
     * @return if the position in path list is stationary last fifteen times
     */
    public boolean isStationary() {
        int compteur = 1;
        if (stepsNumber() >= 14) {
            Position tempPosition = positions.get(positions.size() - 1);

            boolean areEquals = true;
            int i = positions.size() - 1;
            while (areEquals && compteur < 15 && i >= 0) {
                if (tempPosition.equals(positions.get(i))) {
                    compteur += 1;
                } else {
                    areEquals = false;
                }
                i -= 1;
            }
        }
        return compteur == 15;
    }

    /**
     * to know the maximum latitude in the list positions
     *
     * @return the latitude max in the position list
     * @throws PathException launched if no position in Path list
     */
    public double maxLatitude() throws PathException {

        if (positions.isEmpty()) {
            throw new PathException("there is no position in the list! ");
        }
        double maxLatitude = positions.get(0).getLatitude();
        for (int i = 1; i <= positions.size() - 1; ++i) {
            if (maxLatitude < positions.get(i).getLatitude()) {
                maxLatitude = positions.get(i).getLatitude();
            }
        }
        return maxLatitude;
    }

}
