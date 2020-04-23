/**
 * ---------------------------------------------------------------------------
 * File name: MenuBar.java
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

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * initialize and manage the game's menu bar
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class MenuBar extends JMenuBar
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -955443277560794332L;
    
    /**
     * create and manage the game's menu bar
     *
     * <hr>
     * Date created: April 13, 2020
     */
    public MenuBar(JFrame window, Settings settings, Sudoku game)
    {
        // initialize the menubar
        new JMenuBar();
        
        // add the game menu to the JMenuBar
        this.add(new GameMenu(window, settings, game));
    } // END: MenuBar() arg-constructor
} // END: MenuBar class