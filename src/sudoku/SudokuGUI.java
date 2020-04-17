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

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
    private static final long serialVersionUID = -2988809562466920476L; // Generated ID

    // global variables -------------------------------------------------------
    // Class Instantiation
    private Settings settings; // to hold the game's various settings

    // Menu Variables
    private JMenuBar menuBar; // to hold the frame's menuBar
    private JMenu gameMenu; // to hold the game menu
    private JMenu helpMenu; // to hold the help menu
    private JMenu leaderBoardMenu; // to hold the leaderboard menu

    // Misc Variables
    private ImageIcon background; // to hold the frame's background
    // END: Global Variables --------------------------------------------------
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
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(settings.getScreenWidth(), settings.getScreenHeight());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        implementBackgroundImage();
        implementIconImage();
        implementMenuBar();

        this.setVisible(true);
    } // END: Menu() no-arg constructor

    /**
	 * create and manage the game's menu bar
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementMenuBar()
    {
        // TODO Finish Implementation
        // instantiate the JMenuBar
        menuBar = new JMenuBar();

        // build the various menus
        buildGameMenu();
        buildLeaderBoardMenu();
        buildHelpMenu();

        this.setJMenuBar(menuBar);
        // add the items

    } // END: implementMenuBar()

    /**
	 * TODO Finish Documentation 
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void buildGameMenu()
    {
        // instantiate the game menu
        gameMenu = new JMenu("Game");

        // open the game menu when the user presses 'g'
        gameMenu.setMnemonic(KeyEvent.VK_G);

        // create the various menu options
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem continueGame = new JMenuItem("Continue Game");
        JMenuItem saveGame = new JMenuItem("Save Game");
        JMenuItem saveGameAs = new JMenuItem("Save Game As");
        JMenuItem settingsMenu = new JMenuItem("Settings");
        

    } // END: buildGameMenu() method

    /**
	 * TODO Finish Documentation 
     *
	 * <hr>
	 * Date created: April 16, 2020
	 */
    private void buildLeaderBoardMenu()
    {
        // TODO Finish Implementation
    } // END: buildLeaderBoardMenu() method

    /**
	 * TODO Finish Documentation 
     *
	 * <hr>
	 * Date created: April 16, 2020
	 */
    private void buildHelpMenu()
    {
        // TODO Finish Implementation
    } // END: buildLeaderBoardMenu() method

    /**
	 * add an Icon Image to the JFrame; this method 
     * will check for any errors that could arise
     * during the process; if any error arises, an
     * exception will be thrown
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementIconImage()
    {
        try // attempt to set ImageIcon
        {
            this.setIconImage(new ImageIcon(settings.getPathIconImage()).getImage());;
        } // END: attempting to set ImageIcon
        catch (Exception e) // catch any errors
        {
            System.out.println("The ImageIcon was unable to be added.");
        } // END: error catching
    } // END: implementIconImage()

    /**
	 * add a background image to the JFrame; this method 
     * will check for any errors that could arise
     * during the process; if any error arises, an
     * exception will be thrown
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementBackgroundImage()
    {
        // set the background image
        this.setContentPane(new JLabel(new ImageIcon(settings.getPathBackgroundImage())));
    } // END: implementBackgroundImage() method
} // END: Menu class