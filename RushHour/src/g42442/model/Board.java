package g42442.model;

import java.util.List;

/**
 * The playing board
 *
 * @author Cordier Olivier
 */
public class Board {

    //instance attributes
    private Car[][] grid;
    private Position exit;

    //constructors
    /**
     * build a board with parameters
     *
     * @param row number of row
     * @param column number of column
     * @param exit the position of the exit
     * @throws IllegalArgumentException used when size parameters of the board
     * or a wrong position of the exit
     */
    public Board(int row, int column, Position exit) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException("\033[31m" + "board size settings "
                    + "are invalid! " + "\033[0m");
        }
        this.grid = new Car[row][column];

        if (exit.getColumn() != column - 1
                || exit.getRow() > row - 1 || exit.getRow() < 0) {
            throw new IllegalArgumentException("\033[34m" + "the exit position "
                    + "parameters are not valid" + "\033[0m");
        }
        this.exit = exit;
    }

    /**
     * build a board 6x6 without parameters
     */
    public Board() {
        this(6, 6, new Position(2, 5));
    }

    //getters
    /**
     *
     * @return exit position
     */
    public Position getExit() {
        return this.exit;
    }

    /**
     *
     * @return the height of the board
     */
    public int getHeight() {
        return this.grid.length;
    }

    /**
     * @return the width of the board
     */
    public int getWidth() {
        return this.grid[0].length;
    }

    //others methods
    /**
     * to get a car at a certain position
     *
     * @param pos the position where a car supposed to be
     * @return a car if found or null
     */
    public Car getCarAt(Position pos) {
        return grid[pos.getRow()][pos.getColumn()];
    }

    /**
     * to know if all the places of a car are on the board and free
     *
     * @param car the car checked to be put on the board
     * @return if a car can be put on a certain place or not
     */
    public boolean canPut(Car car) {
        List<Position> positionCar = car.getPositions();
        boolean isInBoard = true;
        boolean parkingFree = true;
        int i = 0;
        if (positionCar.size() > this.getWidth()) {
            isInBoard = false;
        }
        while (i < positionCar.size() && isInBoard) {

            if (positionCar.get(i).getRow() < 0 || positionCar.get(i).getColumn() < 0
                    || positionCar.get(i).getColumn() >= this.getWidth()
                    || positionCar.get(i).getRow() >= this.getHeight()) {

                isInBoard = false;
            }
            ++i;
        }
        i = 0;
        while (i < positionCar.size() && isInBoard && parkingFree) {
            parkingFree = this.isFree(positionCar.get(i));
            ++i;
        }
        return isInBoard && parkingFree;
    }

    /**
     * put a car at a position on the board
     *
     * @param car the car to put on the board
     */
    public void putCar(Car car) {
        List<Position> posCar = car.getPositions();
        int i = 0;
        while (i < posCar.size()) {
            this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] = car;
            ++i;
        }

    }

    /**
     * remove a car from a position of the board
     *
     * @param car the car to remove from the board
     */
    public void remove(Car car) {
        List<Position> posCar = car.getPositions();
        int i = 0;
        while (i < posCar.size()) {
            this.grid[posCar.get(i).getRow()][posCar.get(i).getColumn()] = null;
            ++i;
        }
    }

    /**
     * to find a car based on its identity
     *
     * @param id the identity of the car to get
     * @return the position of a certain car on the board or null if the car
     * is'nt found
     */
    public Car getCar(char id) {
        for (int i = 0; i < this.getHeight(); ++i) {
            for (int j = 0; j < this.getWidth(); ++j) {
                if (this.grid[i][j] != null && this.grid[i][j].getId() == id) {
                    return this.grid[i][j];
                }
            }
        }
        return null;
    }

    /**
     * checks if a car can move in a certain direction
     *
     * @param car the car checked to be moved
     * @param direction the direction in which the car should move
     * @return if the car can move in a certain direction or not
     */
    public boolean canMove(Car car, Direction direction) {
        List<Position> listePositions = car.getPositions();
        boolean canMove = false;
        Position positionExt;
        Position positionTest;
        if (car.isMovCoherent(direction)) {
            switch (direction) {
                case LEFT:
                case UP:
                    positionExt = listePositions.get(0);
                    positionTest = positionExt.getPosition(direction);
                    if (this.isOnTheBoard(positionTest)
                            && this.isFree(positionTest)) {
                        canMove = true;
                    }
                    break;
                case RIGHT:
                case DOWN:
                    positionExt = listePositions.get(listePositions.size() - 1);
                    positionTest = positionExt.getPosition(direction);
                    if (this.isOnTheBoard(positionTest)
                            && this.isFree(positionTest)) {
                        canMove = true;
                    }
                    break;
            }
        }
        return canMove;
    }

    /**
     * checks if a position is on the board
     *
     * @param position the position checked to know if it is on the board
     * @return if a certain position is on the board or not
     */
    public boolean isOnTheBoard(Position position) {
        return (position.getRow() >= 0 && position.getRow() < this.getHeight()
                && position.getColumn() >= 0
                && position.getColumn() < this.getWidth());
    }

    /**
     * to know if a position is free
     *
     * @param position the position checked to know if it is a free place
     * @return if a certain position is free or not
     */
    public boolean isFree(Position position) {
        return this.grid[position.getRow()][position.getColumn()] == null;
    }

    //Test d'une méthode howManyCanMove
    /**
     * to know how long the car can move
     *
     * @param car the car to move
     * @param direction the direction of the car
     * @return how long the car can move
     */
    public int howManyCanMove(Car car, Direction direction) {
        int count = 0;
        List<Position> listePositions = car.getPositions();
        boolean canMove = true;
        Position positionExt;
        Position positionTest;
        if (car.isMovCoherent(direction)) {
            switch (direction) {
                case LEFT:
                case UP:
                    positionExt = listePositions.get(0);
                    while (canMove == true) {
                        positionTest = positionExt.getPosition(direction);
                        if (!this.isOnTheBoard(positionTest)
                                || !this.isFree(positionTest)) {
                            canMove = false;
                        } else {
                            ++count;
                            positionExt = positionTest;
                        }
                    }
                    break;
                case RIGHT:
                case DOWN:
                    positionExt = listePositions.get(listePositions.size() - 1);
                    while (canMove == true) {
                        positionTest = positionExt.getPosition(direction);
                        if (!this.isOnTheBoard(positionTest)
                                || !this.isFree(positionTest)) {
                            canMove = false;
                        } else {
                            ++count;
                            positionExt = positionTest;
                        }
                    }
                    break;
            }
        }
        return count;
    }
}
