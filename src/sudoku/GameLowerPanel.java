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

import javax.swing.JLabel;
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
    public GameLowerPanel(Settings settings, Sudoku game)
    {
        //! Temporary
        this.add(new JLabel("Lower Panel"));
	} // END: GameLowerPanel() arg constructor
} // END: GameLowerPanel class