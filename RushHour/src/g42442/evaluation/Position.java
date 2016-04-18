package g42442.evaluation;

/**
 *
 * @author Cordier OLIVIER
 */
public class Position {

    //instance attributes
    private double longitude;
    private double latitude;
    private int elevation;

    //constructor
    /**
     *
     * @param longitude
     * @param latitude
     * @param elevation
     */
    public Position(double longitude, double latitude, int elevation) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        if (elevation < 0) {
            throw new IllegalArgumentException("the elevation can't be negative! ");
        }
    }

    //getters
    /**
     * getter of longitude attribute
     *
     * @return the longitude of the position
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * getter of latitude attribute
     *
     * @return the latitude of the position
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * getter of elevation attribute
     *
     * @return the elevation of the position
     */
    public int getElevation() {
        return this.elevation;
    }

    //others methods
    @Override
    /**
     * redefinition of equals methods test the equality (3 attributes) of two
     * object position
     *
     * @param o a Position
     * @return true if parameters of two positions are equal
     */
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return this.getLongitude() == position.getLongitude()
                && this.getLatitude() == position.getLatitude()
                && this.getElevation() == position.getElevation();
    }

    @Override
    /**
     * generate the same hash code for the two positions that have same
     * attributes
     */
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude)
                ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude)
                ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + this.elevation;
        return hash;
    }

    /**
     *
     * @return a text characteristics of the position
     */
    @Override
    public String toString() {
        return ("longitude: " + this.longitude + " latitude: "
                + this.latitude + " elevation " + this.elevation + ")");
    }

}
