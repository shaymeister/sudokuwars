/**
 * ---------------------------------------------------------------------------
 * File name: HelpMenuItem.java
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
 * represent a JMenuItem in the game menu that allows the
 * user to learn about the game and how to play
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 */
public class HelpMenuItem extends JMenuItem
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 5162891534470149625L;

    // global variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's settings

    /**
	 * arg constructor for the HelpMenuItem class
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public HelpMenuItem(JFrame window, Settings settings)
    {
        // initialize the global variable
        this.window = window;
        this.settings = settings;

        // initialize the JMenuItem
        new JMenuItem();

        // set the title of the menu item
        this.setText("Help");

        // attempt to set the icon for the help menu
        try
        {
            this.setIcon(new ImageIcon(settings.getPathHelpMenuIcon()));
        } // END: attempting to the set icons
        catch (Exception e) // do the following if an error occurs
        {
            // this is the message that will be displayed via JOptionPane and CMD line
            final String errorPrompt = "There was an error importing the icons for the help menu item.";
            
            // use the CMD line to show the error message
            System.out.println(errorPrompt);
            
            // use JOptionPane to show the error message
            JOptionPane.showMessageDialog(null,
                            errorPrompt,
                            settings.getTitle(),
                            JOptionPane.WARNING_MESSAGE);
        } // END: error catching
        // attempt to set the icon

        // add the actionListener
        this.addActionListener(new HelpActionListener());
	} // END: HelpMenuItem() arg-constructor

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
            // show the leaderboard panel
            new HelpPanel(window, settings);   
        } // END: actionPerformed() method
    } // END: HelpActionListener class
} // END: HelpMenuItem class