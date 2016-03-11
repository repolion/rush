package model;

import java.util.ArrayList;
import java.util.List;

/**
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
     * @param id
     * @param size
     * @param orientation
     * @param position
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
     * @return a string corresponding to the car id
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
     * @return the car current position
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    //Autres méthodes
    /**
     *
     * @return the display characteristics of the car (id, size, orientation,
     * position)
     */
    @Override
    public String toString() {
        return "la voiture " + this.id + " de taille " + this.size + " d'orientation " + this.orientation + " est en position" + this.currentPosition;
    }

    /**
     * Test the position of the car and if the mouvement is allowed, move it.
     *
     * @param direction
     */
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                if (this.orientation != model.Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }

                break;
            case RIGHT:
                if (this.orientation != model.Orientation.HORIZONTAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }
                break;
            case UP:
                if (this.orientation != model.Orientation.VERTICAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }
                break;
            case DOWN:
                if (this.orientation != model.Orientation.VERTICAL) {
                    throw new IllegalArgumentException("Déplacement impossible! ");
                }
                break;
        }
        this.currentPosition = this.currentPosition.getPosition(direction);

    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        Position temp = this.currentPosition;
        if (this.orientation == model.Orientation.HORIZONTAL) {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(model.Direction.RIGHT);
            }
        } else {
            for (int i = 1; i <= size; ++i) {
                positions.add(temp);
                temp = temp.getPosition(model.Direction.DOWN);
            }

        }
        return positions;

    }
    public boolean equalsName(Car car) {
        boolean equal = false;
        if (this.getId() == car.getId()) {
            equal = true;
        }
        return equal;
    }
}
