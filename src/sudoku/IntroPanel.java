/**
 * ---------------------------------------------------------------------------
 * File name: IntroPanel.java
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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * represent and manage the functions of the intro screen
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * 
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class IntroPanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 1918873770119528373L;

    // global variables
    private JFrame window; // to hold the game's main frame
    private Settings settings; // to hold the game's settings
    
    /**
	 * arg constructor for the IntroPanel class
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public IntroPanel(JFrame window, Settings settings)
    {
        // assign the argued objects to the class variables
        this.window = window;
        this.settings = settings;

        // implement the background image into the intro panel;
        new BgPanel();

        // implement a border layout in the intro pane
        this.setLayout(new BorderLayout());
                
        // add the upper and lower panels to the introPanel
        this.add(new IntroUpperPanel(this.window, this.settings), BorderLayout.CENTER);
        this.add(new IntroLowerPanel(this.window, this.settings), BorderLayout.SOUTH);
        
        // make this panel transparent
        this.setOpaque(false);

        // add the intro panel to the main frame
        this.window.add(this);
        
        // revalidate and repaint the main frame
        this.window.revalidate();
        this.window.repaint();
    } // END: IntroPanel() no-arg constructor
} // END: IntroPanel class