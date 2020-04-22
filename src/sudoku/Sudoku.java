/**
 * ---------------------------------------------------------------------------
 * File name: Sudoku.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 13, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.util.Random;

/**
 * represent and control the actual game
 *
 * <hr>
 * Date created: April 13, 2020 Last modified: April 13, 2020
 * <hr>
 * 
 * @author Shay Snyder
 */
public class Sudoku
{
    // global variables
    private Board board; // to hold each game's playing surface
    private Leaderboard leaderboard; // to hold the game's leaderboard

    /**
	 * arg-constructor for the Sudoku class
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public Sudoku(Difficulty difficulty)
    {
        // create a board of the desired difficulty
        board = new Board(difficulty);
	} // END: Sudoku() arg constructor

	/**
	 * return a String visualization of the playing surface
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String showBoard()
    {
        // TODO Finish Implementation
        return null; //! change later
    } // END: showBoard() method

    /**
	 * return a String visualization of the leaderboard
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String showLeaderboard()
    {
        // todo finish implementation
        return null; //! change later
    } // END: showLeaderboard() method

    /**
	 * submit the index of the desired element to submit a value; 
     * a boolean attribute representing the success status of
     * said submission
     *
	 * <hr>
	 * Date created: April 22, 2020
	 */
    public boolean setDesiredElement(int index)
    {
        Random rnd = new Random();
        return rnd.nextBoolean();
    } // END: setDesiredMove() method

    /**
	 * submit a move to the board; a boolean attribute
     * representing the success status of said submission
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public boolean submitMove(char value)
    {
        // todo finish implementation
        Random rnd = new Random();
        return rnd.nextBoolean(); //! change later
    } // END: submitMove() method

    /**
	 * allow the user to choose how to sort the leaderboard
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortLeaderboard()
    {

    } // END: sortLeaderboard() method

    /**
	 * return the game's current board
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public Board getBoard()
    {
        // return the game's board
		return this.board;
	} // END: getBoard() method

    /**
	 * return the current value of the element at the argued index
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public char getElementValue(int index)
    {
        // return the current value of the element at the argued index
		return this.board.getElementValue(index);
	} // END: getElementValue() method
} // END: Sudoku class