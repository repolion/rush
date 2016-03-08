package model;

/**
 *
 * @author Cordier Olivier
 */
public class Position {

    //Attributs
    private int row;        // pas de restrictions sur cet attribut (peut être grand et même négatif)
    private int column;     // pas de restrictions sur cet attribut (peut être grand et même négatif)

    //Constructeur
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //Accesseurs
    public void getRow() {

    }

    public void getColumn() {

    }

    //Autres méthodes
    @Override
    public String toString() {
        return ("(" + this.row + " , " + this.column + ")");
    }

}
