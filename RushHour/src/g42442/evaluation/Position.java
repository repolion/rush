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
    public Position(double longitude, double latitude, int elevation) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.elevation = elevation;
        if (elevation < 0) {
            throw new IllegalArgumentException("the elevation can't be negative! ");
        }
    }

    //getters
    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getElevation() {
        return this.elevation;
    }

    //others methods
    @Override
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
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude)
                ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude)
                ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + this.elevation;
        return hash;
    }

    @Override
    public String toString() {
        return ("longitude: " + this.longitude + " latitude: "
                + this.latitude + " elevation " + this.elevation + ")");
    }

}
