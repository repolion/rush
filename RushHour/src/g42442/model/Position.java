package g42442.model;

/**
 * Position of the car on the board
 *
 * @author Cordier Olivier
 */
public class Position {

    //Attributes
    private int row;        // pas de restriction (peu être énorme ou même négatif, sera vérifié ailleurs
    private int column;     // idem

    //Constructeur
    /**
     * @param row line number of this position
     * @param column column number of this position
     */
    public Position(int row, int column) {              // construit une position avec comme paramètre le numéro de ligne 
        this.row = row;                                 // et de colonne
        this.column = column;
    }

    //Accesseurs
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

    //Autres méthodes
    /**
     * @return the display characteristics of the position
     */
    @Override
    public String toString() {
        return ("(" + this.row + " , " + this.column + ")");
    }

    /**
     * @param direction defines the direction in which the position will be
     * moved
     * @return a new position representing the position adjacent to the current
     * position
     */
    public Position getPosition(Direction direction) {      //retourne une nouvelle position à côté de l'objet 
        int tempRow = this.row;                             //lui même dans la direction donnée en paramètre
        int tempColumn = this.column;

        switch (direction) {
            case LEFT:
                tempColumn -= 1;                            // direction étant gauche, retire un au numéro de la colonne
                break;                                      // de l'objet => exemple: (2,1) devient (2,0)
            case RIGHT:
                tempColumn += 1;                            // exemple: (2,1) devient (2,2)
                break;
            case UP:                                        // exemple: (2,1) devient (3,1) 
                tempRow -= 1;
                break;
            case DOWN:                                      // exemple: (2,1) devient (3,1)
                tempRow += 1;
                break;
        }
        return new Position(tempRow, tempColumn);           // pos reçoit le numéro de ligne et de colonne de la nouvelle  
        // position
    }

    /**
     * @param o a Position
     * @return true if the parameters of the two positions are equal
     */
    @Override
    public boolean equals(Object o) {                       // méthodes boolean equals o(Object o) redéfinie
        if (!(o instanceof Position)) {                     // permet à ma classe Test de tester "l'égalité" des 
            return false;                                   // attributs de 2 Positions
        }
        Position position = (Position) o;
        return this.getRow() == position.getRow()
                && this.getColumn() == position.getColumn();
    }

    @Override
    public int hashCode() {                      //génère un hashcode identique pour 2 positions qui ont les mêmes attributs
        int hash = 7;
        hash = 59 * hash + this.row;
        hash = 59 * hash + this.column;
        return hash;
    }

}
