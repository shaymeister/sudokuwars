/**
 * ---------------------------------------------------------------------------
 * File name: LeaderboardPanel.java
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.DimensionUIResource;

/**
 * create a JPanel that will be used to visualize
 * the SudokuWars leaderboard
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class LeaderboardPanel
{
    // global variables
    private JFrame window;
    private Settings settings;
    private Sudoku game;

    /**
	 * arg constructor for the LeaderboardPanel() arg constructor
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public LeaderboardPanel(JFrame window, Settings settings, Sudoku game)
    {
        // initialize the global variables
        this.window = window;
        this.settings = settings;
        this.game = game;

        // show the leaderboard
        showLeaderBoard();
    } // END: LeaderboardPanel() arg constructor
    
    /**
	 * show the game's leaderboard
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    private void showLeaderBoard()
    {
        // options to manipulate the leaderboard
        final String[] options = {"Sort: Difficulty", "Sort: Player", "Sort: Time"};

        /*
         * create a JTextArea that will allow us to create a text area with
         * a scroll bar so the user can view all of their cards
         */
        JTextArea textArea = new JTextArea(game.showLeaderboard(), 30, 50);

        // make the text area not editable
        textArea.setEditable(false);

        // create a scroll pane with our text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setMaximumSize(new DimensionUIResource(300, 300));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        // show the leaderboard
        int result = JOptionPane.showOptionDialog(this.window,
                                                  scrollPane,
                                                  "SudokuWars: Leaderboard",
                                                  JOptionPane.YES_NO_OPTION,
                                                  JOptionPane.INFORMATION_MESSAGE,
                                                  new ImageIcon(settings.getPathIconImage()),
                                                  options, "Sort: Difficulty");

        // make sure the user didn't close the window
        if (result != -1)
        {
            // sort the leaderboard
            game.sortLeaderboard(result);

            // show the sorted leaderboard
            showLeaderBoard();
        }
        else
        {
            // make sure the player wants to exit the leaderboard
            confirmExit();
        }
    } // END: showLeaderboard() method

    /**
	 * make sure the user wants to exit the leaderboard
     *
	 * <hr>
	 * Date created: April 23, 2020
	 */
    private void confirmExit()
    {
        // make sure the user wants to exit the leaderboard
        int result = JOptionPane.showConfirmDialog(this.window,
                                        "Are you sure you would like to exit the leaderboard?",
                                        "SudokuWars",
                                        JOptionPane.YES_NO_OPTION);

        // account for answer variation
        if (result != JOptionPane.YES_OPTION)
        {
            // show the leaderboard
            showLeaderBoard();
        }
    } // END: confirmExit() method
} // END: LeaderboardPanel class
