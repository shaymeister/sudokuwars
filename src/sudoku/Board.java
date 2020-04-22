/**
 * ---------------------------------------------------------------------------
 * File name: Board.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 13, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Represent and control the sudoku playing surface
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Board
{
    // global variables
    private Date startDate;
    private Date endDate;
    private Difficulty difficulty;
    private Element[] board;
    private Random rnd;
    private String user;
    private boolean complete;
    private int numOfMoves;
    private int score;
	private long minutes;
	private long seconds;

    /**
	 * arg constructor for the Board class
     *
	 * <hr>
	 * Date created: April 20, 2020
     * 
     * <hr>
     * @param difficulty the desired difficulty of the board
	 */
    public Board(Difficulty difficulty)
    {
        // initialize the global variables
        this.startDate = Calendar.getInstance().getTime();
        this.endDate = null;
        this.difficulty = difficulty;
        this.rnd = new Random();
        board = new Element[81];
        this.user = null;
        this.complete = false;
        this.numOfMoves = 0;
        this.score = 0;

        // build the board
        buildBoard();
	} // END: Board() arg constructor
	
	public Board(String strUser,Difficulty diff,long mins,long sec,int moves)
	{
		this.user = user;
		this.difficulty = diff;
		this.minutes = mins;
		this.seconds = sec;
		this.numOfMoves = moves;
	}
	
	/**
	* @return difficulty 
	*/
	public Difficulty getDifficulty()
	{
		return this.difficulty;
	}
	
	/**
	* @return minutes 
	*/
	public long getMinutes()
	{
		return this.minutes;
	}
	
	/**
	* @return seconds
	*/
	public long getSeconds()
	{
		return this.seconds;
	}
	
	/**
	* @return user String
	*/
	public String getUser()
	{
		return this.user;
	}
	
	/**
	* @return numOfMoves
	*/
	public int getMoves();
	{
		return this.numOfMoves;
	}

    /**
	 * construct the Element[] that will be used
     * to represent the 81 individual elements of
     * a standard Sudoku board. This array could
     * be implemented with two dimensions but
     * that would complicate our code when we
     * visualize the board in JFrame on a
     * grid layout.
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    private void buildBoard()
    {
        /*
         * generate a number 1 - 10 that will be used to
         * determine which board to import
         */
        int index = (this.difficulty.equals(Difficulty.UNBEATABLE)) ? 1 : rnd.nextInt(10) + 1;
        
        // import the empty board (aka board to be solved)
        char[] emptyBoard = new char[81];
        importBoard(emptyBoard, index, false);

        // import the answer to the empty board
        char[] answerBoard = new char[81];
        importBoard(answerBoard, index, true);

        /*
         * loop through all 81 characters; creating each element and adding it
         * to the Element[] board
         */ 
        for(int i = 0; i < 81; i++)
        {
            // create each element of the board
            this.board[i] = new Element(emptyBoard[i], answerBoard[i]);
        } // END: looping through all elements
    } // END: buildBoard() method

    /**
     * import a the board to solve
     *
     * <hr>
     * Date created: April 13, 2020
     * 
     * <hr>
     * @param index specify which specific board to import, 1 through 10
     * @param answer specifies whether to import the answer board
     */
    private char[] importBoard(char[] tmp, int index, boolean answer)
    {
        /*
         * 'type' will be used to differentiate between the solution and
         * the normal board; if 'answer' = true, type = "answer";
         * otherwise it will be an empty string
         */
        String type = (answer == true) ? "answer" : "";
        
        /*
         * this String specifies the difficulty of the board
         * to import; the difficultyToString() method will
         * be used to convert the difficulty into the
         * appropriate string
         */
        String diff = difficultyToString(difficulty);
        
        /*
         * this String specifies the directory where the txt files
         * containing the board information is held
         */
        String dir = "boards/";
        
        // create the path to the txt file
        String path = dir + diff + index + type + ".txt";

        /*
         * attempt to import the desired board
         */
        try
        {
            // create a new File object from our path
            File file = new File(path);

            // create a Scanner object for our path
            Scanner fileReader = new Scanner(file);

            int i = 0; // iterator to keep track of the index in tmp array

            // loop until all information has been read
            while (fileReader.hasNextLine())
            {
                /*
                 * get the data from a given line in the file
                 */
                String[] data = fileReader.nextLine().split("\\|");

                /*
                 * loop through every piece of data in the data
                 * array so we can convert it to a char and add
                 * it to the temporary array
                 */
                for (String n : data)
                {
                    // add the element to the tmp array
                    tmp[i] = n.charAt(0);

                    // iterate the counter
                    i++;
                } // END: looping through all data in a given line
            } // END: reading from file
          
            // close the Scanner object
            fileReader.close();

            // return the array
            return tmp;
        } // END: try
        catch (FileNotFoundException e)
        {
            // display an error prompt to the CMD line
            System.out.println("An unexpected error occurred while importing\n"
                             + "the Sudoku board. Make sure SudokuWars\n"
                             + "doesn't have any missing files.");
            
            // output the stack trace as well
            e.printStackTrace();

            // terminate the program
            System.exit(0);
        } // END: catch

        // return the array
        return tmp;
    } // END: importBoard() method

    /**
     * convert the argued difficulty to a String that
     * can be used to import a file
     *
     * <hr>
     * Date created: April 20, 2020
     */
    private String difficultyToString(Difficulty difficulty)
    {
        /*
         * use an if-statement to account for difficulty variation
         */ 
        // assuming the desired difficulty = easy
        if (this.difficulty.equals(Difficulty.EASY))
        {
            // return the appropriate String to access the file
            return "easy";
        } // END: easy

        // assuming the desired difficulty = medium
        else if (this.difficulty.equals(Difficulty.MEDIUM))
        {
            // return the appropriate String to access the file
            return "medium";
        } // END: medium

        // assuming the desired difficulty = hard
        else if (this.difficulty.equals(Difficulty.HARD))
        {
            // return the appropriate String to access the file
            return "hard";
        } // END: hard

        // assuming the desired difficulty = expert
        else if (this.difficulty.equals(Difficulty.EXPERT))
        {
            // return the appropriate String to access the file
            return "extreme";
        } // END: expert

        // assuming the desired difficulty = unbeatable
        else if (this.difficulty.equals(Difficulty.UNBEATABLE))
        {
            // return the appropriate String to access the file
            return "unbeatable";
        } // END: unbeatable

        // default
        else
        {
            // prompt the user of the error
            System.out.println("An unexpected error has occurred");

            // terminate the program
            System.exit(0);

            return null; // added to remove errors from compiler
        } // END: default
    } // END: difficultyToString() method

    /**
	 * return a boolean attribute that specifies if a
     * given move is possible
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
	 * return the current value of the element at the
     * argued index
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public char getElementValue(int index) 
    {
        // return the value of the element at the argued index
		return board[index].getValue();
	} // END: getElementValue() method
} // END: Board class