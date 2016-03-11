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
            if (this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] != null) {
                parkingFree = false;
            }
            ++i;
        }
        return parkingInBoard && parkingFree;
    }

    //A vérifier!!!!!
    public void putCar(Car car) {
        List<Position> posCar = car.getPositions();
        int i = 0;
        while (i < posCar.size()) {
            this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] = car;
         ++i;   
        }
        
    }

}
