package g42442.model;

import static g42442.view.Color.toRed;
import java.util.ArrayList;
import java.util.List;

/**
 * the car on the playing board
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
            throw new IllegalArgumentException("invalid size! ");
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
        return "la voiture " + this.id + " de taille " + this.size
                + " d'orientation " + this.orientation
                + " est en position" + this.currentPosition;
    }

    /**
     * Test the position of the car and if the mouvement is allowed, move it.
     *
     * @param direction of the movement car
     * @throws IllegalArgumentException
     */
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                if (this.orientation != Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException(toRed("this movement"
                            + " is not allowed!!! "));
                }

                break;
            case RIGHT:
                if (this.orientation != Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException(toRed("this movement"
                            + " is not allowed!!! "));
                }
                break;
            case UP:
                if (this.orientation != Orientation.VERTICAL) {
                    throw new IllegalArgumentException(toRed("this movement"
                            + " is not allowed!!! "));
                }
                break;
            case DOWN:
                if (this.orientation != Orientation.VERTICAL) {
                    throw new IllegalArgumentException(toRed("this movement"
                            + " is not allowed!!! "));
                }
                break;
        }
        this.currentPosition = this.currentPosition.getPosition(direction);

    }

    /**
     *
     * @return a List of Positions occupied by the car
     */
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        Position temp = this.currentPosition;
        if (this.orientation == Orientation.HORIZONTAL) {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(Direction.RIGHT);
            }
        } else {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(Direction.DOWN);
            }
        }
        return positions;
    }

    /**
     * to know if two differents car has the same id
     *
     * @param car2 the car to be compared to the object Car
     * @return if the two cars has the same id
     */
    public boolean equalsName(Car car2) {
        return this.id == car2.getId();
    }

}
