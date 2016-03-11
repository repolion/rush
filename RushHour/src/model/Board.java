/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Liongeek
 */
public class Board {

    //attributs
    private Car[][] grid;
    private Position exit;

    //constructeurs
    public Board(int row, int column, Position exit) {
        this.grid = new Car[row][column];
        this.exit = exit;
    }

    public Board() {
        this.grid = new Car[6][6];
        this.exit = new Position(2, 5);
    }
}
