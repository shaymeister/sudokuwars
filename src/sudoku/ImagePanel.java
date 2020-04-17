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

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Image;

/**
 * manage and set the frame's background
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class ImagePanel extends JComponent
{
    // global variables
    private Image image; // to hold the frame's background
    
    /**
	 * arg constructor for the ImagePanel class; this constructor
     * will set the class' Image attribute to the argued Image
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public ImagePanel(Image image)
    {
        // set the global Image attribute to the argumented value
        this.image = image;
    } // END: ImagePanel(arg-constructor)

    /**
	 * override the parent's 'paintComponent' method
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    protected void paintComponent(Graphics g)
    {
        // call the super's 'paintComponent' method
        super.paintComponent(g);

        // draw the background image
        g.drawImage(this.image, 0, 0, this);
    } // END: paintComponent() method
} // END: ImagePanel class