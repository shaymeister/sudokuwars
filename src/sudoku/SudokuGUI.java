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
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * initialize the graphics for SudokuWars
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
	 * no-arg constructor for the SudokuGUI class
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

        // show the intro
        intro();
    } // END: Menu() no-arg constructor

    /**
     * introduce the user to the game and ask them if they would
     * like to start a new game or continue the previous game
     *
     * <hr>
     * Date created: April 18, 2020
     * Last modified: April 18, 2020
     * <hr>
     * @author Holden Dalton
     * @author Shay Snyder
     * @author Hannah Taylor
     */
    private void intro()
    {
        /*
         * Build the required panels to properly show the intro screen:
         * 'introPanel' will be used to contain the other two panels
         * 'introUpperPanel' will be used to hold the title of the game
         * 'introLowerPanel' will be used to hold the buttons
         */
        JPanel introPanel = new JPanel(new BorderLayout());
        JPanel introUpperPanel = new JPanel(new BorderLayout());
        JPanel introLowerPanel = new JPanel(new BorderLayout());

    } // END: intro() method
    /**
	 * create and manage the game's menu bar
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementMenuBar()
    {
        // instantiate the JMenuBar
        menuBar = new JMenuBar();

        // build the various menus
        buildGameMenu();
        buildLeaderBoardMenu();
        buildHelpMenu();

        // add the various menus
        menuBar.add(gameMenu);
        menuBar.add(leaderBoardMenu);
        menuBar.add(helpMenu);

        // add the game's menu bar
        this.setJMenuBar(menuBar);
    } // END: implementMenuBar()

    /**
	 * build the game menu in the menu bar
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

        try // attempt to set the icons
        {
            newGame.setIcon(new ImageIcon(settings.getPathNewGameMenuIcon()));
            continueGame.setIcon(new ImageIcon(settings.getPathContinueGameMenuIcon()));
            saveGame.setIcon(new ImageIcon(settings.getPathSaveGameMenuIcon()));
            saveGameAs.setIcon(new ImageIcon(settings.getPathSaveGameAsMenuIcon()));
            settingsMenu.setIcon(new ImageIcon(settings.getPathSettingsMenuIcon()));
        } // END: attempting to the set icons
        catch (Exception e) // do the following if an error occurs
        {
            // this is the message that will be displayed via JOptionPane and CMD line
            String errorPrompt = "There was an error importing the icons for the game menu.";

            // use the CMD line to show the error message
            System.out.println(errorPrompt);

            // use JOptionPane to show the error message
            JOptionPane.showMessageDialog(null,
                                          errorPrompt,
                                          settings.getTitle(),
                                          JOptionPane.WARNING_MESSAGE);
        } // END: error catching

        // add all of the menu items to the menu
        gameMenu.add(newGame);
        gameMenu.add(continueGame);
        gameMenu.addSeparator();
        gameMenu.add(saveGame);
        gameMenu.add(saveGameAs);
        gameMenu.addSeparator();
        gameMenu.add(settingsMenu);
    } // END: buildGameMenu() method

    /**
	 * build the leaderboard in the menu bar
     *
	 * <hr>
	 * Date created: April 16, 2020
	 */
    private void buildLeaderBoardMenu()
    {
        // TODO Finish Implementation
        this.leaderBoardMenu = new JMenu("Leaderboard");

    } // END: buildLeaderBoardMenu() method

    /**
	 * build the help menu in the menu bar
     *
	 * <hr>
	 * Date created: April 16, 2020
	 */
    private void buildHelpMenu()
    {
        // TODO Finish Implementation
        this.helpMenu = new JMenu("Help");
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