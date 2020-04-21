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
import java.io.*;
import java.util.*;

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
    private Difficulty difficulty;
    private String user;
    private boolean complete;
    private long startTime;
    private long endTime;
    private int numOfMoves;
    private int score;
	private String boardFilePath;

	
	
    /**
	 * import the board file into the array for manipulation
	 * to play the game
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void importBoard()
    {
		File inputFile = new File(boardFilePath);
		Scanner inputRead = null;
		try
		{
			inputRead = new Scanner(inputFile);
		}
		catch(Exception e)
		{
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		while(inputRead.hasNext())
		{
			//hold current line
			String str = inputRead.nextLine();
			String[] fields = str.split("\\|"); //split line into fields
			int p;
			
			//initialize the Piece[][]
			for (int r=0; r < 9; r++)
			{
				for (int c=0; c < 9; c++)
				{
					p = Integer.parseInt(fields[c]);
					
					//set the enum based on the int in the field
					if(p == 0)
						this.board[r][c] = Piece.EMPTY;
					else if(p == 1)
						this.board[r][c] = Piece.ONE;
					else if(p == 2)
						this.board[r][c] = Piece.TWO;
					else if(p == 3)
						this.board[r][c] = Piece.THREE;
					else if(p == 4)
						this.board[r][c] = Piece.FOUR;
					else if(p == 5)
						this.board[r][c] = Piece.FIVE;
					else if(p == 6)
						this.board[r][c] = Piece.SIX;
					else if(p == 7)
						this.board[r][c] = Piece.SEVEN;
					else if(p == 8)
						this.board[r][c] = Piece.EIGHT;
					else if(p == 9)
						this.board[r][c] = Piece.NINE;
				}
				
			}
		}
        
		
    } // END: importBoard() method
	
	/**
	* determine the board to import and set the path
	* 
	* <hr>
	* Date created: April 21, 2020
	*
	* @param difficulty
	*/
	public void getBoardToUse(Difficulty difficulty)
	{
		// based on the difficulty chosen, get a random board of that level
		//and initialize it to board[][]
		int rand = rnd.nextInt(10);
		switch (difficulty)
		{
			case EASY:
			{
				switch(rand)
				{
					case 0:
						boardFilePath = "easy1.txt";
						break;
					case 1:
						boardFilePath = "easy2.txt";
						break;
					case 2:
						boardFilePath = "easy3.txt";
						break;
					case 3:
						boardFilePath = "easy4.txt";
						break;
					case 4:
						boardFilePath = "easy5.txt";
						break;
					case 5:
						boardFilePath = "easy6.txt";
						break;
					case 6:
						boardFilePath = "easy7.txt";
						break;
					case 7:
						boardFilePath = "easy8.txt";
						break;
					case 8:
						boardFilePath = "easy9.txt";
						break;
					case 9:
						boardFilePath = "easy10.txt";
						break;
				}
				break;
			}
			case MEDIUM:
			{
				switch(rand)
				{
					case 0:
						boardFilePath = "medium1.txt";
						break;
					case 1:
						boardFilePath = "medium2.txt";
						break;
					case 2:
						boardFilePath = "medium3.txt";
						break;
					case 3:
						boardFilePath = "medium4.txt";
						break;
					case 4:
						boardFilePath = "medium5.txt";
						break;
					case 5:
						boardFilePath = "medium6.txt";
						break;
					case 6:
						boardFilePath = "medium7.txt";
						break;
					case 7:
						boardFilePath = "medium8.txt";
						break;
					case 8:
						boardFilePath = "medium9.txt";
						break;
					case 9:
						boardFilePath = "medium10.txt";
						break;
				}
				break;
			}
			case HARD:
			{
				switch(rand)
				{
					case 0:
						boardFilePath = "hard1.txt";
						break;
					case 1:
						boardFilePath = "hard2.txt";
						break;
					case 2:
						boardFilePath = "hard3.txt";
						break;
					case 3:
						boardFilePath = "hard4.txt";
						break;
					case 4:
						boardFilePath = "hard5.txt";
						break;
					case 5:
						boardFilePath = "hard6.txt";
						break;
					case 6:
						boardFilePath = "hard7.txt";
						break;
					case 7:
						boardFilePath = "hard8.txt";
						break;
					case 8:
						boardFilePath = "hard9.txt";
						break;
					case 9:
						boardFilePath = "hard10.txt";
						break;
				}
				break;
			}
			case EXTREME:
			{
				switch(rand)
				{
					case 0:
						boardFilePath = "extreme1.txt";
						break;
					case 1:
						boardFilePath = "extreme2.txt";
						break;
					case 2:
						boardFilePath = "extreme3.txt";
						break;
					case 3:
						boardFilePath = "extreme4.txt";
						break;
					case 4:
						boardFilePath = "extreme5.txt";
						break;
					case 5:
						boardFilePath = "extreme6.txt";
						break;
					case 6:
						boardFilePath = "extreme7.txt";
						break;
					case 7:
						boardFilePath = "extreme8.txt";
						break;
					case 8:
						boardFilePath = "extreme9.txt";
						break;
					case 9:
						boardFilePath = "extreme10.txt";
						break;
				}
				break;
			}
			case UNBEATABLE:
				boardFilePath = "imossibleBoard.txt";
				break;
			
			
			
		}
		
	}// end getBoardToUse()
	
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