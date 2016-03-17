package g42442.model;

import java.util.ArrayList;
import java.util.List;

/**
 * the car on the playing board
 *
 * @author Cordier Olivier
 */
public class Car {

    //Attributs
    private char id;
    private int size;
    private Orientation orientation;
    private Position currentPosition;

    //Constructeur
    /**
     * @param id the identity of the object Car
     * @param size the size of the car
     * @param orientation the orientation(HORIZONTAL-VERTICAL) of the car
     * @param position first box of the board where the car is located
     */
    public Car(char id, int size, Orientation orientation, Position position) {
        if (size <= 0) {
            throw new IllegalArgumentException("taille invalide! ");
        }
        this.id = id;
        this.size = size;
        this.orientation = orientation;
        this.currentPosition = position;
    }

    //Accesseurs
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

    //Autres méthodes
    /**
     * @return the display characteristics of the car (id, size, orientation,
     * position)
     */
    @Override
    public String toString() {
        return "la voiture " + this.id + " de taille " + this.size
                + " d'orientation " + this.orientation + " est en position" + this.currentPosition;
    }

    /**
     * Test the position of the car and if the mouvement is allowed, move it.
     *
     * @param direction of the movement car
     */
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                if (this.orientation != Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }

                break;
            case RIGHT:
                if (this.orientation != Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }
                break;
            case UP:
                if (this.orientation != Orientation.VERTICAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }
                break;
            case DOWN:
                if (this.orientation != Orientation.VERTICAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
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

}
