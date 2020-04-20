/**
 * ---------------------------------------------------------------------------
 * File name: BgPanel.java
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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

/**
 * create a JPanel that will be used as the content panel;
 * aka the base of all other panes
 *
 * <hr>
 * Date created: April 19, 2020
 * Last modified: April 19, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class BgPanel extends JPanel
{
    // instantiate the settings class
    private Settings settings = new Settings();
    
    // import the desired background image
    Image bg = new ImageIcon(settings.getPathBackgroundImage()).getImage();

    public void paintComponent(Graphics g)
    {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    } // END: paintComponent() method
} // END: BgPanel class