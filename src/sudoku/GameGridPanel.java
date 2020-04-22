/**
 * ---------------------------------------------------------------------------
 * File name: GameGridPanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
 */
public class GameGridPanel extends JPanel
{
    // global variables
    private Settings settings;
    private Sudoku game;
    private Board board;

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
    public GameGridPanel(Settings settings, Sudoku game)
    {
        // initialize the panel
        new JPanel();

        // set the layout to 9x9 grid
        this.setLayout(new GridLayout(9,9));

        // make the panel transparent
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(50, 75, 75, 75));

        // initialize the global variables
        this.settings = settings;
        this.game = game;

        // add every element of the board to the grid
        for (int i = 0; i < 81; i++)
        {
            this.add(new GameGridElement(game, i, settings));
        } // END: building panel
    } // GameGridPanel() arg-constructor
} // END: GameGridPanel class