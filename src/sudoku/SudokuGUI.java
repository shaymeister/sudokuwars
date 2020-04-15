/**
 * ---------------------------------------------------------------------------
 * File name: SudokuGUI.java
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * TODO Finish Documentation
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class SudokuGUI extends JFrame
{
    // global variables
    private Settings settings; // to hold the game's various settings

    /**
	 * TODO Finish Documentation
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public SudokuGUI()
    {
        // TODO Finish Implementation

        // initialize the settings class to the default value
        settings = new Settings();


        this.setTitle(settings.getTitle());
        this.setIconImage(new ImageIcon(settings.getPathIconImage()).getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    } // END: Menu() no-arg constructor
} // END: Menu class