package g42442.model;

/**
 * Position of the car on the board
 *
 * @author Cordier Olivier
 */
public class Position {

    //instance attributes
    private int row;        // no restrictions (will be verified elsewhere)
    private int column;     // idem

    //constructor
    /**
     * @param row line number of this position
     * @param column column number of this position
     */
    // built a position with parameters: the line and column number
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //getters
    /**
     * @return the line number of this position
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return the column number of this position
     */
    public int getColumn() {
        return this.column;
    }

    //others methods
    /**
     * @return the display characteristics of the position
     */
    @Override
    public String toString() {
        return ("(" + this.row + " , " + this.column + ")");
    }

    /**
     * to know the position next to the car
     *
     * @param direction defines the direction in which the position will be
     * moved
     * @return a new position representing the position adjacent to the current
     * position
     */
    public Position getPosition(Direction direction) {
        int tempRow = this.row;
        int tempColumn = this.column;
        // modification ot the coordinates of the direction
        switch (direction) {
            case LEFT:
                tempColumn -= 1;    // example: (2,1) become (2,0)
                break;
            case RIGHT:
                tempColumn += 1;    // example: (2,1) become (2,2)
                break;
            case UP:
                tempRow -= 1;       // example: (2,1) become (3,1) 
                break;
            case DOWN:
                tempRow += 1;       // example: (2,1) become (3,1)
                break;
        }
        return new Position(tempRow, tempColumn);
        // pos receives the line and column number of the new position
    }

    /**
     * method boolean equals o(Object o) redefined allows my class Test to test
     * "the egality"of 2 positions attributes
     *
     * @param o a Position
     * @return true if the parameters of the two positions are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return this.getRow() == position.getRow()
                && this.getColumn() == position.getColumn();
    }

    @Override
    //generate same hash code for two positions that have the same attributes
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.row;
        hash = 59 * hash + this.column;
        return hash;
    }

}
