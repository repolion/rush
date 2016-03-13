package model;

import java.util.List;

/**
 *
 * @author Cordier Olivier
 */
public class Board {

    //attributs
    private Car[][] grid;
    private Position exit;

    //constructeurs
    public Board(int row, int column, Position exit) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException("Les paramètres de taille du plateau ne sont pas valides! ");
        }
        this.grid = new Car[row][column];

        if (exit.getColumn() != column - 1 || exit.getRow() > row - 1 || exit.getRow() < 0) {
            throw new IllegalArgumentException("Les paramètres de position de la sortie ne sont pas acceptables");
        }
        this.exit = exit;
    }

    public Board() {
        this.grid = new Car[6][6];
        this.exit = new Position(2, 5);
    }

    //accesseurs
    public Position getExit() {
        return this.exit;
    }

    public int getHeight() {
        return this.grid.length;
    }

    public int getWidth() {
        return this.grid[0].length;
    }

    //Autres méthodes
    public Car getCarAt(Position pos) {
        return grid[pos.getRow()][pos.getColumn()];
    }

    //retourne vrai si toutes les palces de car sont sur le board et sont libres
    public boolean canPut(Car car) {
        List<Position> posCar = car.getPositions(); // posCar est une liste des positions d'un car
        boolean parkingInBoard = true;
        boolean parkingFree = true;
        int i = 0;
        while (i < posCar.size() && parkingInBoard == true) {

            if (posCar.get(i).getRow() < 0 || posCar.get(i).getColumn() < 0
                    || posCar.get(i).getColumn() >= this.getWidth()
                    || posCar.get(i).getRow() >= this.getHeight()) {

                parkingInBoard = false;
            }
            ++i;
        }
        i = 0;
        while (i < posCar.size() && parkingInBoard == true && parkingFree) {
            parkingFree = this.isFree(posCar.get(i));
            ++i;
        }
        return parkingInBoard && parkingFree;
    }

    // place un objet de type Car sur le plateau
    public void putCar(Car car) {
        List<Position> posCar = car.getPositions();
        int i = 0;
        while (i < posCar.size()) {
            this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] = car;
            ++i;
        }

    }

    //méthode qui retire une voiture du plateau de jeu
    public void remove(Car car) {
        List<Position> posCar = car.getPositions();
        int i = 0;
        while (i < posCar.size()) {
            this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] = null;
            ++i;
        }
    }

    /*méthode qui recherche sur le plateau une voiture et retourne une voiture 
     en fontion de son id ou null si elle n'est pas trouvée */
    public Car getCar(char id) {
        int i = 0;
        int j = 0;
        while (i < this.getHeight()) {
            while (j < this.getWidth()) {
                if (this.grid[i][j] != null) {
                    if (this.grid[i][j].getId() == id) {
                        return this.grid[i][j];
                    }
                }
                ++j;
            }
            j = 0;
            ++i;
        }
        return null;
    }

    public boolean canMove(Car car, Direction direction) {
        List<Position> listePositions = car.getPositions();
        boolean peutBouger = false;
        Position positionExt;
        Position positionTest;

        switch (direction) {                    //isOnTheBoard(Position position, Board board)
            case LEFT:                          //isFree(position)
            case UP:
                positionExt = listePositions.get(0);
                positionTest = positionExt.getPosition(direction);
                if (this.isOnTheBoard(positionTest) == true && this.isFree(positionTest)) {
                    peutBouger = true;
                }
                break;

            case RIGHT:
            case DOWN:
                positionExt = listePositions.get(listePositions.size() - 1);
                positionTest = positionExt.getPosition(direction);
                if (this.isOnTheBoard(positionTest) == true && this.isFree(positionTest)) {
                    peutBouger = true;
                }
                break;

        }
        return peutBouger;
    }

    public boolean isOnTheBoard(Position position) {
        boolean isOnTheBoard = false;
        if (position.getRow() >= 0 && position.getRow() < this.getHeight()) {
            if (position.getColumn() >= 0 && position.getColumn() < this.getWidth()) {
                isOnTheBoard = true;
            }

        }
        return isOnTheBoard;
    }

    public boolean isFree(Position position) {
        boolean parkingFree = false;
        if (this.grid[position.getRow()][position.getColumn()] == null) {
            parkingFree = true;
        }
        return parkingFree;
    }
}
