package g42442.model;

import java.util.List;

/**
 * A game
 *
 * @author Cordier Olivier
 */
public class RushHourGame {

    //instance attributes
    private Board board;
    private Car redCar;

    //constructor
    /**
     * Build a playing board with parameters
     *
     * @param height the height of the board
     * @param width the width of the board
     * @param exit the position of the exit on the board
     * @param carsList a list of cars to be put on the board
     * @param redCar the player's car to put on the board or if the exit
     * position is not allowed
     * @throws RushHourException if the exit position is not acceptable
     */
    public RushHourGame(int height, int width, Position exit,
            List<Car> carsList, Car redCar) throws RushHourException {
        this.board = new Board(height, width, exit);
        this.redCar = redCar;
        if (redCar.getCurrentPosition().getRow() != exit.getRow()) {
            throw new RushHourException("\033[31m"
                    + "the exit position is not acceptable!!!" + "\033[0m");
        }
        if (this.board.canPut(redCar)) {
            this.board.putCar(redCar);
        }

        int i = 0;
        while (i < carsList.size()) {
            if (this.board.canPut(carsList.get(i))) {
                this.board.putCar(carsList.get(i));
            }
            ++i;

        }

    }

    //getter
    /**
     *
     * @return the playing board
     */
    public Board getBoard() {
        return this.board;
    }

    //other method
    /**
     * to move a car in a certain direction
     *
     * @param id the identity of the car to move
     * @param direction the direction in which the car should move
     * @throws RushHourException launched if no car found with an id or if a car
     * can't move in a certain direction
     */
    public void move(char id, Direction direction) throws RushHourException {
        Car carToMove = board.getCar(id);
        if (carToMove == null) {
            throw new RushHourException("\033[31m" + "this identity "
                    + "does not match with a car!!!" + "\033[0m");
        } else if (!board.canMove(carToMove, direction)) {
            throw new RushHourException("\033[31m"
                    + "this movement is not allowed!!!" + "\033[0m");
        } else {
            board.remove(carToMove);
            carToMove.move(direction);
            board.putCar(carToMove);

        }
    }

    /**
     * to know if the game is over
     *
     * @return if the game is over or not
     */
    public boolean isOver() {
        return board.getCarAt(board.getExit()) == redCar;
    }
}
