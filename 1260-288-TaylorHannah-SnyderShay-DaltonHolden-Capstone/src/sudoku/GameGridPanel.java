/**
 * ---------------------------------------------------------------------------
 * File name: GameGridPanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *							 Holden Dalton, daltonh@etsu.edu
 *							 Hannah Taylor, taylorhm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * represent the whole 9x9 board with an array of GridElements
 * in a GridLayout
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class GameGridPanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 1527821772014553107L;

    /**
     * arg constructor for the GameGridPanel class
     *
     * <hr>
     * Date created: April 20, 2020
     */
    public GameGridPanel(Settings settings, Sudoku game, JFrame window)
    {
        // initialize the panel
        new JPanel();

        // set the layout to 9x9 grid
        this.setLayout(new GridLayout(9,9));

        // make the panel transparent
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(50, 75, 75, 75));

        // add every element of the board to the grid
        for (int i = 0; i < 81; i++)
        {
            // create the GameGridElement
            this.add(new GameGridElement(game, i, settings, window));
        } // END: building panel
    } // GameGridPanel() arg-constructor
} // END: GameGridPanel class