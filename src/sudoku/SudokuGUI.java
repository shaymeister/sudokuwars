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

import java.io.File;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

/**
 * TODO Finish Documentation
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class SudokuGUI extends JFrame
{
    // global variables
    private Settings settings; // to hold the game's various settings
    private ImageIcon background; // to hold the frame's backgroung
    private JMenuBar menuBar; // to hold the frame's menuBar

    /**
	 * TODO Finish Documentation
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public SudokuGUI()
    {
        // TODO Finish Implementation

        // initialize the settings class to the default value
        settings = new Settings();
        
        this.setTitle(settings.getTitle());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(settings.getScreenWidth(), settings.getScreenHeight());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        implementIconImage();
        implementMenuBar();

        this.setVisible(true);
    } // END: Menu() no-arg constructor

    /**
	 * TODO Finish Documentation
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementMenuBar()
    {
        // TODO Finish Implementation
       menuBar = new JMenuBar();
    } // END: implementMenuBar()

    /**
	 * add an Icon Image to the JFrame; this method 
     * will check for any errors that could arise
     * during the process; if any error arises, an
     * exception will be thrown
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void implementIconImage()
    {
        try // attempt to set ImageIcon
        {
            this.setContentPane(new JLabel(new ImageIcon(settings.getPathBackgroundImage())));
        } // END: attempting to set ImageIcon
        catch (Exception e) // catch any errors
        {
            System.out.println("The ImageIcom was unable to be added.");
        } // END: error catching
    } // END: implementIconImage()
} // END: Menu class