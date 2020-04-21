/**
 * ---------------------------------------------------------------------------
 * File name: IntroPanel.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Holden Dalton, daltonh@etsu.edu
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Creator's name and email: Hannah Taylor, hannahm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 20, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * initialize and manage the lower panel on the intro screen
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class IntroLowerPanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -5254589524802629851L;

    // global variables
    private JFrame window; // to hold the main frame
    private Settings settings; // to hold the game's settings

    /**
     * build the lower panel of the intro panel
     *
     * <hr>
     * Date created: April 20, 2020
     */
    public IntroLowerPanel(JFrame window, Settings settings)
    {
        // set the global variables
        this.window = window;
        this.settings = settings;

        // make the panel transparent
        this.setOpaque(false);

        // Elements for lower panel
        JButton newGame = new JButton("Start");
        
        // Add the action listeners
        newGame.addActionListener(new IntroStartGameListener());
        
        // add the buttons to the lower panel
        this.add(newGame);

        // add a border around the buttons to improve visuals
        this.setBorder(BorderFactory.createEmptyBorder(0, 300, 120, 300));
    } // END: implementLowerPanel() arg constructor

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
            // add the menubar to the main frame
            window.add(new MenuBar(window, settings));

            // start a new game
            new GamePanel(window, settings);
        } // END: actionPerformed() method
    } // END: StartGameListener class
} // END: IntroLowerPanel class