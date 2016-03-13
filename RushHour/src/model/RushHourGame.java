package model;

import java.util.List;

/**
 *
 * @author Cordier Olivier
 */
public class RushHourGame {

    //Attributs
    private Board board;
    private Car redCar;

    //Constructeurs
    public RushHourGame(int height, int width, Position exit, List<Car> cars, Car redCar) {

        Board board = new Board(height, width, exit);
        this.redCar = redCar;
        board.putCar(redCar);

    }

}
