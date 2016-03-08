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
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //Accesseurs
    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    //Autres méthodes
    @Override
    public String toString() {
        return ("(" + this.row + " , " + this.column + ")");
    }

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
            default:
                break;
        }
        Position pos = new Position(tempRow, tempColumn);
        return pos;
    }

}
