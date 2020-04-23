/**
 * ---------------------------------------------------------------------------
 * File name: Element.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 21, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

/**
 * Represent and manage the functionality of each individual element
 * of the board
 *
 * <hr>
 * Date created: April 21, 2020
 * Last modified: April 21, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Element
{
    // global variables
    private char currentValue; // to hold the current value of the element
    private char correctValue; // to hold the correct value of the element

    /**
	 * arg constructor for the Element class
     *
	 * <hr>
	 * Date created: April 21, 2020
     * 
     * <hr>
     * @param currentValue the current value of the element
     * @param correctValue the correct value of the element
	 */
    public Element(char currentValue, char correctValue)
    {
        // set the global values
        this.currentValue = currentValue;
        this.correctValue = correctValue;
    } // END: Element() arg constructor

    /**
	 * return the element's current value
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public char getValue()
    {
        // return the element's current value
        return this.currentValue;
    } // END: getValue() method

    /**
	 * return the boolean attribute specifying whether the argued move
     * is correct
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public boolean submitValue(char value)
    {
        // check if the argued value is correct
        if(this.correctValue == value)
        {
            // set the element's current value
            this.currentValue = value;

            return true;
        } // END: if value is correct
        else
        {
            // otherwise return false
            return false;
        }
    } // END: submitValue() method

    /**
	 * return the boolean attribute specifying whether the element
     * is already correct
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    public boolean isCorrect()
    {
        // check if the element is correct
        if (this.correctValue == this.currentValue)
        {
            return true; // the element is correct
        }
        else
        {
            return false; // the element is incorrect
        }
    } // END: isCorrect() method
} // END: Element class
