package model;

/**
 *
 * @author Cordier Olivier
 */
 public class Position {

    //Attributs
    private final int row;        // pas de restrictions sur cet attribut (peut être grand et même négatif)
    private final int column;     // pas de restrictions sur cet attribut (peut être grand et même négatif)

    //Constructeur
    /**
     * @param row
     * @param column
     */
    public Position(int row, int column) {  //construit une Position avec les numéros de ligne et de colonne en paramètre
        this.row = row;
        this.column = column;
    }

    //Accesseurs
    /**
     * @return the row number
     */
    public int getRow() {                   // retourne le numéro de ligne
        return this.row;
    }

    /**
     * @return the column number
     */
    public int getColumn() {                // retourne le numéro de colonne 
        return this.column;
    }

    //Autres méthodes
    /**
     * @return the display characteristics of the position
     */
    @Override
    public String toString() {
        return ("(" + this.row + " , " + this.column + ")");
    }

    /**
     * @param direction defines the direction in which the position will move
     * @return a new position representing the position adjacent to the current
     * position
     */
    public Position getPosition(Direction direction) {
        int tempRow = this.row;
        int tempColumn = this.column;

        switch (direction) {
            case LEFT:
                tempColumn -= 1;
                break;
            case RIGHT:
                tempColumn += 1;
                break;
            case UP:
                tempRow -= 1;
                break;
            case DOWN:
                tempRow += 1;
                break;
        }
        Position pos = new Position(tempRow, tempColumn);
        return pos;
    }

    /**
     * @param position
     * @return true if the parameters of the two positions are equal
     */
    public boolean equals(Position position) {
        boolean equal = false;
        if (this.getRow() == position.getRow() && this.getColumn() == position.getColumn()) {
            equal = true;
        }
        return equal;
    }

}
