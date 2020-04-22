/**
 * ---------------------------------------------------------------------------
 * File name: GameLowerPanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 21, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * initialize and manage a JPanel that will be used
 * to represent the lower panel of the game panel
 *
 * <hr>
 * Date created: April 21, 2020
 * Last modified: April 21, 2020
 * <hr>
 * @author Shay Snyder
 */
public class GameLowerPanel extends JPanel
{
	/**
     * randomly generated
     */
    private static final long serialVersionUID = 4519592670697042473L;

    /**
	 * initialize and manage the game lower panel
     *
	 * <hr>
	 * Date created: April 21, 2020
	 */
    public GameLowerPanel(Settings settings, Sudoku game, JFrame window)
    {
        this.setLayout(new GridLayout(1,9));

        this.setOpaque(false);

        this.setPreferredSize(new Dimension(600, 67));

        char[] values = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        // loop 1-9 to add all digits to 
        for (int i = 0; i < 9; i++)
        {
            // add the given element
            this.add(new GameLowerPanelElement(game, settings, values[i] , window));
        } // END: looping through all digits
	} // END: GameLowerPanel() arg constructor
} // END: GameLowerPanel class