/**
 * ---------------------------------------------------------------------------
 * File name: Board.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Holden Dalton, daltonh@etsu.edu
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Creator's name and email: Hannah Taylor, hannahm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 13, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.util.Calendar;
import java.util.Random;

/**
 * Represent and control the sudoku playing surface
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class Board
{
    // global variables
    private Piece[][] board = new Piece[9][9];
    private Random rnd = new Random();
    private Calendar calendar;
    private Player player;
    private Difficulty difficulty;
    private String user;
    private boolean complete;
    private long startTime;
    private long endTime;
    private int numOfMoves;
    private int score;

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void importPreviousGame()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: importPreviousGame() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void importBoard(Difficulty difficulty)
    {
        // TODO FINISH IMPLEMENTATION
    } // END: importBoard() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public boolean isMoveAvailable(String move)
    {
        // TODO FINISH IMPLEMENTATION
        return false; // remove later
    } // END: isMoveAvailable() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void submitMove(String move)
    {
        // TODO FINISH IMPLEMENTATION
    } // END: submitMove() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String displayBoard(String move)
    {
        // TODO FINISH IMPLEMENTATION
        return ""; //! change later
    } // END: displayBoard() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int comparePlayer(Board otherBoard)
    {
        // TODO FINISH IMPLEMENTATION
        return 0; //! change later
    } // END: comparePlayer() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int compareDifficulty(Board otherBoard)
    {
        // TODO FINISH IMPLEMENTATION
        return 0; //! change later
    } // END: compareDifficulty() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int compareTime(Board otherBoard)
    {
        // TODO FINISH IMPLEMENTATION
        return 0; //! change later
    } // END: compareTime() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int compareScore(Board otherBoard)
    {
        // TODO FINISH IMPLEMENTATION
        return 0; //! change later
    } // END: compareScore() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int compareMoves(Board otherBoard)
    {
        // TODO FINISH IMPLEMENTATION
        return 0; //! change later
    } // END: compareMoves() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void calculateScore()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: calculateScore() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void submitScore()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: submitScore() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void startTime()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: startTime() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void calculatePlayTime()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: calculatePlayTime() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void setPausedTime()
    {

    } // END: setPausedTime()
} // END: Board class