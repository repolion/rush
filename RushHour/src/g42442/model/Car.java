package g42442.model;

import static g42442.model.Direction.*;
import static g42442.model.Orientation.*;
import static g42442.view.Color.toRed;
import java.util.ArrayList;
import java.util.List;

/**
 * the cars on the playing board
 *
 * @author Cordier Olivier
 */
public class Car {

    //instance attributes
    private char id;
    private int size;
    private Orientation orientation;
    private Position currentPosition;

    //constructor
    /**
     * @param id the identity of the object Car
     * @param size the size of the car
     * @param orientation the orientation(HORIZONTAL-VERTICAL) of the car
     * @param position first box of the board where the car is located
     * @throws IllegalArgumentException
     */
    public Car(char id, int size, Orientation orientation, Position position) {
        if (size <= 0) {
            throw new IllegalArgumentException("invalid size of the car! ");
        }
        this.id = id;
        this.size = size;
        this.orientation = orientation;
        this.currentPosition = position;
    }

    //getters
    /**
     * @return the car id
     */
    public char getId() {
        return this.id;
    }

    /**
     * @return the orientation of the car
     */
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * @return the current position of the car
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    //others methods
    /**
     * @return the display characteristics of the car (id, size, orientation,
     * position)
     */
    @Override
    public String toString() {
        return "the car " + this.id + " with size " + this.size
                + ", orientation " + this.orientation
                + " and position" + this.currentPosition;
    }

    /**
     * Test the position of the car and if the mouvement is allowed, move it.
     *
     * @param direction of the movement car
     * @throws IllegalArgumentException
     */
    public void move(Direction direction) {

        if ((direction == LEFT && this.orientation != HORIZONTAL)
                || (direction == RIGHT && this.orientation != HORIZONTAL)
                || (direction == UP && this.orientation != VERTICAL)
                || (direction == DOWN && this.orientation != VERTICAL)) {
            throw new IllegalArgumentException(toRed("car this movement"
                    + " is not allowed!!! "));
        } else {
            this.currentPosition = this.currentPosition.getPosition(direction);
        }

    }

    /**
     *
     * @return a List of Positions occupied by the car
     */
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        Position temp = this.currentPosition;
        if (this.orientation == HORIZONTAL) {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(RIGHT);
            }
        } else {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(DOWN);
            }
        }
        return positions;
    }

    //@pbt ces méthodes ne doivent pas être publiques
    
    /**
     * to know if two differents car has the same id
     *
     * @param car2 the car to be compared to the object Car
     * @return if the two cars has the same id
     */
    public boolean equalsName(Car car2) {
        return this.id == car2.getId();
    }

    /**
     * check if the orientation and the direction are compatible to move the car
     *
     * @param direction the direction in which the car should move
     * @return if the oriention of the car is compatible with the direction
     */
    public boolean isMovCoherent(Direction direction) {
        boolean coherent = true;

        if (direction == Direction.LEFT
                && this.orientation != HORIZONTAL
                || direction == Direction.RIGHT
                && this.orientation != HORIZONTAL
                || direction == Direction.UP
                && this.orientation != VERTICAL
                || direction == DOWN
                && this.orientation != VERTICAL) {
            coherent = false;

        }
        return coherent;
    }

}
