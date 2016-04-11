package g42442.model;

import java.util.List;

/**
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
     * @param redCar the player's car to put on the board
     * @throws RushHourException used if the size of the board is not accepted
     * or if the exit position is not allowed
     */
    public RushHourGame(int height, int width, Position exit,
            List<Car> carsList, Car redCar) throws RushHourException {

        this.board = new Board(height, width, exit);
        this.redCar = redCar;
        this.board.putCar(redCar);
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
     * @return
     */
    public Board getBoard() {
        return this.board;
    }

    //other method
    /**
     *
     * @param id the identity of the car to move
     * @param direction the direction in which the car should move
     */
    public void move(char id, Direction direction) {
        Car carToMove = board.getCar(id);
        if (carToMove != null && board.canMove(carToMove, direction)) {
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
        boolean isOver = false;
        if (board.getCarAt(board.getExit()) == redCar) {
            isOver = true;
        }
        return isOver;
    }
}
