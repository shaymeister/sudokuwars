/**
 * ---------------------------------------------------------------------------
 * File name: GridPanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Holden Dalton, daltonh@etsu.edu
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Creator's name and email: Hannah Taylor, hannahm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * represent the whole 9x9 board with an array of GridElements
 * in a GridLayout
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class GridPanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 1527821772014553107L;

    /**
     * arg constructor for the GridPanel class
     *
     * <hr>
     * Date created: April 13, 2020
     */
    public GridPanel(Difficulty difficulty)
    {
        // initialize the panel with a 9x9 grid
        new JPanel(new GridLayout(9,9));
    } // GridPanel() arg-constructor
} // END: GridPanel class