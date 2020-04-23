/**
 * ---------------------------------------------------------------------------
 * File name: NewGameMenuItem.java
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * create a JMenuItem that will allow the user to start
 * a new game from the game menu
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class NewGameMenuItem extends JMenuItem
{
	/**
     * randomly generated
     */
    private static final long serialVersionUID = 1L;

    // global variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's settings

    /**
	 * no-arg constructor for the NewGameMenuItem class
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public NewGameMenuItem(JFrame window, Settings settings)
    {
        // set the global variables from the argued values
        this.window = window;
        this.settings = settings;

        // instantiate the JMenuItem
        new JMenuItem();

        // set the text
        this.setText("New Game");

        // add the actionListener
        this.addActionListener(new NewGameListener());

        // attempt to set the icons
        try
        {
            this.setIcon(new ImageIcon(settings.getPathNewGameMenuIcon()));
        } // END: attempting to the set icons
        catch (Exception e) // do the following if an error occurs
        {
            // this is the message that will be displayed via JOptionPane and CMD line
            final String errorPrompt = "There was an error importing the icons for the new game menu icon.";
            
            // use the CMD line to show the error message
            System.out.println(errorPrompt);
            
            // use JOptionPane to show the error message
            JOptionPane.showMessageDialog(window,
                                          errorPrompt,
                                          this.settings.getTitle(),
                                          JOptionPane.WARNING_MESSAGE);
        } // END: error catching
    } // END: NewGameMenuItem() arg-constructor
    
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
            int result = JOptionPane.showConfirmDialog(window,
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
                new GamePanel(window, settings);
            } // END: if user selects yes
        } // END: actionPerformed() method
    } // END: IntroNewGameListener class
} // END: NewGameMenuItem class