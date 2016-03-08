package model;

/**
 *
 * @author Cordier Olivier
 */
class Car  {

    //Attributs
    private char id;
    private int size;
    private Orientation orientation;
    private Position currentPosition;

    //Constructeur
    /**
     *
     * @param id
     * @param size
     * @param orientation
     * @param currentPosition
     */
    public Car(char id, int size, Orientation orientation, Position position) {
        
        if (size < 0) {
            throw new IllegalArgumentException("taille invalide! ");
        }

        this.id = id;
        this.size = size;
        this.orientation = orientation;

    }

    //Accesseurs
    /**
     * @return a string corresponding to the car id
     */
    public char id() {
        return this.id;
    }

    /**
     * @return the orientation of the car
     */
    public Orientation orientation() {
        return this.orientation;
    }

    /**
     * @return the car current position
     */
    public Position currentPosition() {
        return this.currentPosition;
    }

    //Setters

    /**
     * Change the param currentPosition of the car by a new one
     *
     * @param position
     */
    public void currentPosition(Position position) {
        this.currentPosition = position;
    }

    //Autres méthodes
    /**
     *
     * @return the display characteristics of the car (id, size, orientation,
     * position)
     */
    @Override
    public String toString() {
        return ("La voiture " + this.id + " de taille " + this.size + " ayant une orientation " + this.orientation + " se trouve à la position (" + this.currentPosition.getRow() + " , " + this.currentPosition.getColumn() + ")");
    }

    public void move(Direction direction) {

        switch (direction) {
            case LEFT:
                currentPosition(this.getPosition(Direction.LEFT));
                break;
            case RIGHT:
                this.getPosition(Direction.RIGHT);
                ;
                break;
            case UP:
                this.getPosition(Direction.UP);
                ;
                break;
            case DOWN:
                this.getPosition(Direction.DOWN);
                ;
                break;
        }
    }

}
