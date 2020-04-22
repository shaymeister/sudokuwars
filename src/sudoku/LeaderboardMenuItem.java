/**
 * ---------------------------------------------------------------------------
 * File name: LeaderboardMenuItem.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * create a JMenuItem that allows the user to access the game's
 * leaderboard via the 'game' menu
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 */
public class LeaderboardMenuItem extends JMenuItem
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -3213950642371308692L;

    // global variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's settings

    /**
	 * arg constructor for the LeaderboardMenuItem class
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public LeaderboardMenuItem(JFrame window, Settings settings)
    {
        // set the global variables from the argued values
        this.window = window;
        this.settings = settings;
            
        // initialize the JMenuItem
        new JMenuItem();

        // set the title
        this.setText("Leaderboard");

        // add the action listener
        this.addActionListener(new LeaderboardActionListener());

        // attempt to set the icon
        try
        {
            this.setIcon(new ImageIcon(settings.getPathLeaderboardMenuIcon()));
        } // END: attempting to the set icons
        catch (Exception e) // do the following if an error occurs
        {
            // this is the message that will be displayed via JOptionPane and CMD line
            final String errorPrompt = "There was an error importing the icons for the leaderboard menu item.";
            
            // use the CMD line to show the error message
            System.out.println(errorPrompt);
            
            // use JOptionPane to show the error message
            JOptionPane.showMessageDialog(null,
                            errorPrompt,
                            settings.getTitle(),
                            JOptionPane.WARNING_MESSAGE);
        } // END: error catching
	} // END: LeaderboardMenuItem() arg-constructor

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
            new LeaderboardPanel(window, settings);
        } // END: actionPerformed() method
    } // END: LeaderboardActionListener class
} // END: LeaderboardMenuItem class
