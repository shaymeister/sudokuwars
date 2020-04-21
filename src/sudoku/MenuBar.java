/**
 * ---------------------------------------------------------------------------
 * File name: MenuBar.java
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

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * initialize and manage the game's menu bar
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class MenuBar extends JMenuBar
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -955443277560794332L;

    // Global Variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's settings
    
    /**
     * create and manage the game's menu bar
     *
     * <hr>
     * Date created: April 13, 2020
     */
    public MenuBar(JFrame window, Settings settings)
    {
        // initialize the menubar
        new JMenuBar();
        
        // add the game menu to the JMenuBar
        this.add(new GameMenu(this.window, this.settings));
    } // END: MenuBar() arg-constructor
} // END: MenuBar class