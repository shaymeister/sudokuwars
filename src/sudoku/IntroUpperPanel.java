/**
 * ---------------------------------------------------------------------------
 * File name: IntroUpperPanel.java
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * initialize and manage the upper panel of the intro panel
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class IntroUpperPanel extends JPanel
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = 31265932345835809L;

    /**
	 * arg constructor for the IntroUpperPanel class
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public IntroUpperPanel(Settings settings)
    {
        // make the panel transparent
        this.setOpaque(false);

        // add a border around the logi to improve visuals
        this.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));
        try // attempt to load SudokuWars logo
        {
            // load the logo
            final ImageIcon logo = new ImageIcon(settings.getPathLogoImage());
            
            // add the logo to the upper panel via JLabel
            this.add(new JLabel(logo));
        } // END: attempting to the load logo
        catch (Exception e) // catch any errors that may arise
        {
            // create a String object to message to return
            final String errorPrompt = "An unexpected error occurred while loading the SudokuWars logo.\n"
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
            this.add(new JLabel("SudokuWars"));
        } // END: error catching
    } // END: IntroUpperPanel() arg constructor
} // END: IntroUpperPanel class