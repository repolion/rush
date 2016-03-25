package g42442.model;

import static g42442.view.Color.toRed;
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
    public RushHourGame(int height, int width, Position exit, List<Car> carsList, Car redCar) {

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

    //Accesseur
    public Board getBoard() {
        return this.board;
    }

    //Autres méthodes
    public void move(char id, Direction direction) {
        Car carToMove = board.getCar(id);
        if (carToMove != null && board.canMove(carToMove, direction)) {
            board.remove(carToMove);
            try{
            carToMove.move(direction);}
            catch(IllegalArgumentException e){
                System.out.println(toRed("This move is not allowed"));}
            board.putCar(carToMove);
        }
        else{
            System.out.println(toRed("This move is not allowed"));
        
    }

    }

    public boolean isOver() {
        boolean isOver = false;
        if (board.getCarAt(board.getExit()) == redCar) {
            isOver = true;
        }
        return isOver;
    }
}
