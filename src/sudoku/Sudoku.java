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
        this.board = new Board(difficulty);
        this.leaderboard = new Leaderboard();

	} // END: Sudoku() arg constructor

    /**
	 * return a String visualization of the leaderboard
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String showLeaderboard()
    {
        // return the string representation of the leaderboard
        return this.leaderboard.toString();
    } // END: showLeaderboard() method

    /**
	 * allow the user to choose how to sort the leaderboard
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortLeaderboard(int i)
    {
        /*
         * i = 0 : sort by difficulty
         * i = 1 : sort by player
         * i = 2 : sort by time
         */
        switch (i)
        {
            // sort by difficulty
            case 0:
                this.leaderboard.sortByDifficulty();
                break;

            // sort by player
            case 1:
                this.leaderboard.sortByPlayer();
                break;

            // sort by time
            case 2:
                this.leaderboard.sortByTime();
                break;
        } // END: switch
    } // END: sortLeaderboard() method

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
        return this.board.setDesiredElement(index);
    } // END: setDesiredMove() method

    /**
	 * submit a move to the board; a boolean attribute
     * representing the success status of said submission
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public boolean setDesiredValue(char value)
    {
        /*
         * return the boolean attribute that represents the
         * status of setting the desired value method
         */
        return this.board.setDesiredValue(value);
    } // END: submitMove() method

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
    
    /**
	 * return the a boolean attribute that specifies the
     * completion status of the game
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public boolean isGameOver()
    {
        // return the completion status
        return this.board.isGameOver();
    } // END: isGameOver() method

    /**
	 * set the player's name to the argued value
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public void setName(String name)
    {
        // set the player's name to the argued value
        this.board.setName(name);
    } // END: setName() method

    /**
	 * add the board to the leaderboard
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public void addToLeaderboard()
    {
        // add the board to the leaderboard
        this.leaderboard.addToList(this.board);
    } // END: addToLeaderboard() method
} // END: Sudoku class