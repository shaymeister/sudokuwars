/**
 * ---------------------------------------------------------------------------
 * File name: GamePanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * initialize and manage a JPanel that will be used
 * to represent the playing surface of SudokuWars
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 */
public class GamePanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 7336695822631652687L;
    
    // Global Variables
    private JFrame window; // to hold the game's main window
    private Settings settings; // to hold the game's settings
    private Sudoku game; // to hold the Sudoku game

    /**
	 * initialize and manage the game panel
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    public GamePanel(JFrame window, Settings settings)
    {
        // initialize global variables
        this.window = window; // to hold the game's main frame
        this.settings = settings; // to hold the game's settings

        // clear the main frame but add the background
        this.window.getContentPane().removeAll();
        this.window.setContentPane(new BgPanel());

        // add the menubar to the game frame
        this.window.setJMenuBar(new MenuBar(this.window, this.settings));

        // ask the user what difficulty board they would like to play
        Difficulty difficulty = getDesiredDifficulty();

        // start the SudokuGame with the argued difficulty
        this.game = new Sudoku(difficulty); // start the sudoku game

        // make this panel transparent
        this.setOpaque(false);

        // set the panel's layout to BorderLayout
        this.setLayout(new BorderLayout());

        // add the grid and lower panels to the game panel
        this.add(new GameGridPanel(this.settings, this.game, this.window), BorderLayout.CENTER);
        this.add(new GameLowerPanel(this.settings, this.game, this.window), BorderLayout.SOUTH);

        // set the layout
        window.setLayout(new BorderLayout());

        // add the game panel to the main frame
        window.add(this, BorderLayout.CENTER);

        // revalidate the main frame
        window.validate();

        // repaint the main frame
        window.repaint();
    } // END: game() method

    public GamePanel(JFrame window, Settings settings, Sudoku game)
    {
        // initialize global variables
        this.window = window; // to hold the game's main frame
        this.settings = settings;
        this.game = game;
        
        // clear the main frame but add the background
        this.window.getContentPane().removeAll();
        this.window.setContentPane(new BgPanel());
        
        // add the menubar to the game frame
        this.window.setJMenuBar(new MenuBar(this.window, this.settings));
        
        // make this panel transparent
        this.setOpaque(false);
        
        // set the panel's layout to BorderLayout
        this.setLayout(new BorderLayout());
        
        // add the grid and lower panels to the game panel
        this.add(new GameGridPanel(this.settings, this.game, this.window), BorderLayout.CENTER);
        this.add(new GameLowerPanel(this.settings, this.game, this.window), BorderLayout.SOUTH);
        
        // set the layout
        window.setLayout(new BorderLayout());
        
        // add the game panel to the main frame
        window.add(this, BorderLayout.CENTER);
        
        // revalidate the main frame
        window.validate();
        
        // repaint the main frame
        window.repaint();
    }


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
        String[] options = {"easy", "medium", "hard", "extreme", "unbeatable"};

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
                        
        /* This switch is used to manage the various outputs from the
        * aforementioned JOptionPane showOptionDialog box.
        * 
        * 0 = the user selected 'easy'
        * 1 = the user selected 'medium'
        * 2 = the user selected 'hard'
        * 3 = the user selected 'extreme'
        * 4 = the user selected 'unbeatable'
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

            // assuming the user selects 'extreme'
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
} // END: GamePanel class