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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class SudokuGUI
{
    // global variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's various settings
    private JPanel introPanel; // to hold the game's intro panel
    private JPanel gamePanel; // to hold the game's game panel
    private Sudoku game; // to hold the game itself
    
    // Misc Variables
    //private ImageIcon background; // to hold the frame's background

    /**
	 * no-arg constructor for the SudokuGUI class
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public SudokuGUI()
    {
        // initialize the settings class to the default value
        settings = new Settings();

        // initialize the main window and set the frame's title
        window = new JFrame(settings.getTitle());

        // initialize the game
        game = new Sudoku();
        
        // close the game upon exit
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the JFrame to the value in settings
        this.window.setSize(settings.getScreenWidth(), settings.getScreenHeight());

        // disable resizing
        this.window.setResizable(false);

        // center the frame
        this.window.setLocationRelativeTo(null);

        // add the icon image
        implementIconImage();

        // show the main frame
        this.window.setVisible(true);

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
        // initialize the intro panel
        introPanel = new BgPanel();
        introPanel.setLayout(new BorderLayout());

        /*
         * Build the required panels to properly show the intro screen:
         * 'introUpperPanel' will be used to hold the title of the game
         * 'introLowerPanel' will be used to hold the buttons
         */
        JPanel introUpperPanel = new JPanel(new BorderLayout());
        JPanel introLowerPanel = new JPanel(new BorderLayout());

        // make the panels transparent
        introUpperPanel.setOpaque(false);
        introLowerPanel.setOpaque(false);

        // Elements for upper panel
        try // attempt to load SudokuWars logo
        {
            // load the logo
            ImageIcon logo = new ImageIcon(settings.getPathLogoImage());

            // add the logo to the upper panel via JLabel
            introUpperPanel.add(new JLabel(logo));
        } // END: attempting to the load logo
        catch (Exception e) // catch any errors that may arise
        {
            // create a String object to message to return
            String errorPrompt = "An unexpected error occurred while loading the SudokuWars logo.\n"
                               + "The game will function properly but make sure all files are\n"
                               + "properly installed";

            // display using JOptionPane
            JOptionPane.showMessageDialog(null,
                                          errorPrompt,
                                          settings.getTitle(),
                                          JOptionPane.WARNING_MESSAGE);

            // display using CMD line
            System.out.println(errorPrompt);

            /*
             * Since the game's logo was unable to be loaded, simply print
             * a String displaying the game's title
             */
            introUpperPanel.add(new JLabel("SudokuWars"));
        } // END: error catching

        // Elements for lower panel
        JButton newGame = new JButton("Start");

        // Add the action listeners
        newGame.addActionListener(new IntroStartGameListener());

        // add the buttons to the lower panel
        introLowerPanel.add(newGame, BorderLayout.NORTH);
        introLowerPanel.setBorder(BorderFactory.createEmptyBorder(0, 300, 150, 300));

        // show the intro screen
        this.introPanel.add(introUpperPanel, BorderLayout.CENTER);
        this.introPanel.add(introLowerPanel, BorderLayout.SOUTH);

        // add the intro panel to the main frame
        this.window.add(introPanel);

        this.window.revalidate();
        this.window.repaint();
    } // END: intro() method

    /**
	 * display and manage the game's functionality
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private void game()
    {
        // TODO Finish Implementation

        // ask the user what difficulty board they would like to play
        Difficulty difficulty = getDesiredDifficulty();

        // implement the game's menu bar
        implementMenuBar();

        /*
         * this panel will contain the user interface for the game;
         * also, the panel will implement our BgPanel class
         */
        JPanel gamePanel = new BgPanel();

        // set the panel's layout to BorderLayout
        gamePanel.setLayout(new BorderLayout());

        // create the two main panels of the game gui
        JPanel upperPanel = new SudokuGrid(difficulty); // will hold the board
        JPanel lowerPanel = new JPanel(new BorderLayout()); // will hold the possible moves

        

       
        
        // add the game panel to the main frame
        window.add(gamePanel);

        // revalidate the main frame
        window.validate();

        // repaint the main frame
        window.repaint();
        //updateMainWindow();
    } // END: game() method

    /**
	 * ask the user what difficulty board they would like to play
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private Difficulty getDesiredDifficulty()
    {
        /*
         * This array contains the various difficulty options for the user
         */
        String[] options = {"unbeatable", "expert", "hard", "medium", "easy"};

        /*
         * Use JOptionPane to ask the user what difficulty
         * board they would like to play
         */
        int choice = JOptionPane.showOptionDialog(
                        null, // no main component
                        "What difficulty board would you like to play?", // prompt
                        settings.getTitle(), // title
                        JOptionPane.YES_NO_OPTION, // option type
                        JOptionPane.QUESTION_MESSAGE, // message type
                        new ImageIcon(settings.getPathIconImage()), // icon
                        options, // user's options
                        "easy"); // default option

        /*
         * This switch is used to manage the various outputs from the
         * aforementioned JOptionPane showOptionDialog box.
         * 
         * 0 = the user selected 'expert'
         * 1 = the user selected 'hard'
         * 2 = the user selected 'medium'
         * 3 = the user selected 'easy'
         * Default: 'easy'
         */
        switch (choice)
        {
            // assuming user selects 'easy'
            case 0:
                return Difficulty.EASY;

            // assuming the user selects 'medium'
            case 1:
                return Difficulty.MEDIUM;

            // assuming the user selects 'hard'
            case 2:
                return Difficulty.HARD;

            // assuming the user selects 'expert'
            case 3:
                return Difficulty.EXPERT;

            // assuming the user selects 'unbeatable'
            case 4:
                return Difficulty.UNBEATABLE;

            // default
            default:
                return Difficulty.EASY;
        } // END: switching through user responses
    } // END: getDesiredDifficulty() method

    /**
     * create and manage the game's menu bar
     *
     * <hr>
     * Date created: April 13, 2020
     */
    private void implementMenuBar()
    {
        // instantiate the JMenuBar
        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("Game");
        
        // open the game menu when the user presses 'g'
        gameMenu.setMnemonic(KeyEvent.VK_G);
        
        // create the various menu options
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem leaderboard = new JMenuItem("LeaderBoard");
        JMenuItem help = new JMenuItem("Help");
        
        try // attempt to set the icons
        {
            newGame.setIcon(new ImageIcon(settings.getPathNewGameMenuIcon()));
            leaderboard.setIcon(new ImageIcon(settings.getPathLeaderboardMenuIcon()));
            help.setIcon(new ImageIcon(settings.getPathHelpMenuIcon()));
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
        gameMenu.addSeparator();
        gameMenu.add(leaderboard);
        gameMenu.addSeparator();
        gameMenu.add(help);

        // add listeners
        newGame.addActionListener(new NewGameListener());
        leaderboard.addActionListener(new LeaderboardActionListener());
        help.addActionListener(new HelpActionListener());
        
        // add the various menus
        menuBar.add(gameMenu);

        // add the game's menu bar
        this.window.setJMenuBar(menuBar);
    } // END: implementMenuBar()

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
            this.window.setIconImage(new ImageIcon(settings.getPathIconImage()).getImage());;
        } // END: attempting to set ImageIcon
        catch (Exception e) // catch any errors
        {
            System.out.println("The ImageIcon was unable to be added.");
        } // END: error catching
    } // END: implementIconImage()

    /**
	 * listen if the user clicks the 'Start Game' button on the
     * intro screen
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private class IntroStartGameListener implements ActionListener
    {
        /**
         * listen if the user click's the 'Start Game' button on the
         * intro screen
         *
	     * <hr>
	     * Date created: April 19, 2020
	     */
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            // remove the intro panel before starting the new game
            window.remove(introPanel);

            // start a new game
            game();
        } // END: actionPerformed() method
    } // END: StartGameListener class

    /**
	 * listen if the user clicks the 'new game' button in the
     * 'game' menu
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private class NewGameListener implements ActionListener
    {
        /**
         * listen if the user click's the 'new game' button in the 'game'
         * menu; of they click the button, use JOptionPane to confirm the
         * user's decision to start a new game; if they say 'yes', start
         * a new game; otherwise, do nothing
         *
	     * <hr>
	     * Date created: April 19, 2020
	     */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // make sure the user would like to start a new game
            int result = JOptionPane.showConfirmDialog(null,
                            "Are you sure you would like to start a new game?",
                            "SudokuWars",
                            JOptionPane.YES_NO_OPTION);

            /*
             * if the user selects yes, generate a new game;
             * otherwise, do nothing
             */
            if (result == JOptionPane.YES_OPTION)
            {
                // generate a new game
                game();
            } // END: if user selects yes
        } // END: actionPerformed() method
    } // END: IntroNewGameListener class

    /**
	 * listen if the user clicks the 'leaderboard' button in
     * the 'game' menu
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private class LeaderboardActionListener implements ActionListener
    {
        /**
         * listen if the user clicks the 'save game' button in
         * the 'game' menu; if they click the button, save the
         * game
         *
	     * <hr>
	     * Date created: April 19, 2020
	     */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // show the leaderboard pane
            accessLeaderboard();
        } // END: actionPerformed() method
    } // END: LeaderboardActionListener class

    /**
	 * listen if the user clicks the 'help' button in
     * the 'game' menu
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    private class HelpActionListener implements ActionListener
    {
        /**
         * listen if the user clicks the 'help' button in
         * the 'game' menu
         *
	     * <hr>
	     * Date created: April 19, 2020
	     */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Finish Implementation
            System.out.println("Should show help screen");
        } // END: actionPerformed() method
    } // END: HelpActionListener class

    /**
	 * continue the previous game
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    public void accessLeaderboard()
    {
        // TODO Finish Implementation
        System.out.println("Should show leaderboard panel");
    }
} // END: Menu class