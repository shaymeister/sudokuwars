/**
 * ---------------------------------------------------------------------------
 * File name: Board.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *							 Holden Dalton, daltonh@etsu.edu
 *							 Hannah Taylor, taylorhm1@mail.etsu.edu
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
 * @author Holden Dalton
 * @author Hannah Taylor 
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
    private int numOfMoves;
    private int desiredElement;
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
        this.numOfMoves = 0;

        // build the board
        buildBoard();
	} // END: Board() arg constructor
	
	public Board(String strUser,Difficulty diff,long mins,long sec,int moves)
	{
		this.startDate = Calendar.getInstance().getTime();
		this.user = strUser;
		this.difficulty = diff;
		this.minutes = mins;
		this.seconds = sec;
		this.numOfMoves = moves;
	}
	
	public Board(String strUser, Difficulty diff) {
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
	public int getMoves()
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
	 * compare player names
     *
	 * <hr>
	 * Date created: April 13, 2020
	 *
	 * @return int
	 */
    public int comparePlayer(Board otherBoard)
    {
        // compare String user with compareTo method
        return user.compareTo(otherBoard.getUser());
    } // END: comparePlayer() method

    /**
	 * compare difficulty levels
     *
	 * <hr>
	 * Date created: April 13, 2020
	 *
	 * @return int
	 */
    public int compareDifficulty(Board otherBoard)
    {
        // compare two difficulty objects
        return difficulty.compareTo(otherBoard.getDifficulty());
    } // END: compareDifficulty() method

    /**
	 * compare times took to complete
     *
	 * <hr>
	 * Date created: April 13, 2020
	 *
	 * @return r
	 */
    public int compareTime(Board otherBoard)
    {
        /* since the smaller number for times means 
		*  a better time, the output for comparison will be positive
		*  if the first time is less than the second*/
		int r = 0;
		if(minutes < otherBoard.getMinutes())
			r = 1;
		else if (minutes == otherBoard.getMinutes())
		{
			if(seconds < otherBoard.getSeconds())
				r = 1;
			else if(seconds == otherBoard.getSeconds())
				r = 0;
			else
				r = -1;
		}
		else
			r = -1;
		
        return r; 
    } // END: compareTime() method

    

    /**
	 * compare the number of moves took to complete puzzle
     *
	 * <hr>
	 * Date created: April 13, 2020
	 *
	 * @return n
	 */
    public int compareMoves(Board otherBoard)
    {
        // compare the numOfMoves value
		//initially equal 
		int n = 0;
		if (numOfMoves < otherBoard.getMoves())
			n = -1;
		else if (numOfMoves > otherBoard.getMoves())
			n = 1;
		
        return n;
    } // END: compareMoves() method

    

    /**
	 * since startDate is initialized in the constructors
	 * need to set the endTime
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void endTime()
    {
        //set the end time
		this.endDate = Calendar.getInstance().getTime();
		
    } // END: startTime() method

    /**
	 * calculate the total amount of play time
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void calculatePlayTime()
    {
        // subtract times from dates
		long diff = endDate.getTime() - startDate.getTime();
		
		this.minutes = diff / (60*1000) % 60;
		this.seconds = diff / 1000%60;
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

    /**
	 * return the boolean attribute that specifies if the 
     * desired value was valid
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public boolean setDesiredValue(char value)
    {
        // if the user has selected an element, submit the value
        if (this.desiredElement != -1)
        {
            // copy the desired element to a temp variable
            int tmpDesiredElement = desiredElement;

            // clear the stored value
            this.desiredElement = -1;
            
            // return the status of the move submission
            return board[tmpDesiredElement].submitValue(value);
        } // END: submission
        else
        {
            // default to return false
            return false;
        }
    } // END: setDesiredValue() method
    
    /**
	 * return the boolean attribute that specifies if the 
     * desired element is available
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public boolean setDesiredElement(int index)
    {
        // check if the desired element is already correct
        if (!this.board[index].isCorrect())
        {
            // set the desired element
            this.desiredElement = index;
            
            // return true
            return true;
        }
        else
        {
            // return false
            return false;
        }
    } // END: setDesiredElement() method

    /**
	 * return the boolean attribute that specifies if given
     * board is complete
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public boolean isGameOver()
    {
        boolean flag = true;

        // loop through every element and see if it is complete
        for (int i = 0; i < 81; i++)
        {
            
            // if any element is incorrect, the board isn't complete
            if (!board[i].isCorrect()) flag = false;
        }

        /*
         * if the game is over, calculate the play time
         */
        if (flag == true)
        {
            endTime();
            calculatePlayTime();
        }
        
        // return the flag
		return flag;
    } // END: isGameOver() method
    
    /**
	 * set the user's name to the argued value
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public void setName (String name)
    {
        // set the user's name to the argued value
        this.user = name;
    } // END: setName() method
} // END: Board class