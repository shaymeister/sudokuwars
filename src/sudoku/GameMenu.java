/**
 * ---------------------------------------------------------------------------
 * File name: GameMenu.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import javax.swing.JFrame;
import javax.swing.JMenu;

/**
 * represent and manage the 'game' menu within
 * the JMenuBar
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 */
public class GameMenu extends JMenu
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -6289431882773237625L;

    /**
     * arg constructor for the GameMenu class
     *
     * <hr>
     * Date created: April 20, 2020
     */
    public GameMenu(JFrame window, Settings settings)
    {
        // instantiate the game menu
        new JMenu();

        // set the title of the menu
        this.setText("Game");
    
        // add the new game menu item
        this.add(new NewGameMenuItem(window, settings));

        // add a separator
        this.addSeparator();

        // add the leaderboard menu item
        this.add(new LeaderboardMenuItem(window, settings));

        // add a separator
        this.addSeparator();

        // add the help menu item
        this.add(new HelpMenuItem(window, settings));
    } // END: GameMenu() arg-constructor
} // END: GameMenu class