/**
 * ---------------------------------------------------------------------------
 * File name: SudokuGUI.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *							 Holden Dalton, daltonh@etsu.edu
 *							 Hannah Taylor, taylorhm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 13, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * initialize the graphics for SudokuWars
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class SudokuGUI extends JFrame
{
    /**
     * randomly generated
     */
    private static final long serialVersionUID = -87287031534880725L;

    // global variables
    private Settings settings; // to hold the game's various settings

    /**
	 * no-arg constructor for the SudokuGUI class
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public SudokuGUI()
    {
        // initialize the settings class to the default value
        this.settings = new Settings();

        // initialize the main window and set the frame's title
        this.setContentPane(new BgPanel());

        // set the frame's title
        this.setTitle(settings.getTitle());

        // set the frame's layout
        this.setLayout(new BorderLayout());
        
        // close the game upon exit
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // add the window listener
        this.addWindowListener(new WindowListener());

        // set the size of the JFrame to the value in settings
        this.setSize(settings.getScreenWidth(), settings.getScreenHeight());

        // disable resizing
        this.setResizable(false);

        // center the frame
        this.setLocationRelativeTo(null);

        // add the icon image
        try // attempt to set ImageIcon
        {
            this.setIconImage(new ImageIcon(settings.getPathIconImage()).getImage());;
        } // END: attempting to set ImageIcon
        catch (Exception e) // catch any errors
        {
            System.out.println("The ImageIcon was unable to be added.");
        } // END: error catching

        // show the main frame
        this.setVisible(true);

        // show the intro
        new IntroPanel(this, this.settings);
    } // END: SudokuGUI() no-arg constructor

    /**
	 * use JOptionPane to confirm if the user
     * wants to exit the program
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public void confirmExit()
    {
        /*
         * use JOptionPane to confirm if the user
         * wants to exit the program
         */
        int choice = JOptionPane.showConfirmDialog(
                                    this,
                                    "Are you sure you would like to exit?",
                                    settings.getTitle(),
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE);

        /*
         * if the user selects 'yes', roll the outro;
         * otherwise, do nothing
         */
        if (choice == JOptionPane.YES_OPTION) outro();
    } // END: confirmExit() method

    /**
	 * use JOptionPane to thank the user for
     * playing SudokuWars
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    public void outro()
    {
        // Thank the user
        JOptionPane.showMessageDialog(
                        null,
                        "Thank you for playing SudokuWars!",
                        settings.getTitle(),
                        JOptionPane.INFORMATION_MESSAGE);

        // terminate the program
        System.exit(0);
    } // END: outro() method

    /**
     * listen for the user to close the window; then make sure they
     * want to exit the program
     *
     * <hr>
     * Date created: April 20, 2020
     * Last modified: April 20, 2020
     * <hr>
     * @author Holden Dalton
     * @author Shay Snyder
     * @author Hannah Taylor
     */
    private class WindowListener extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            // confirm if the user wants to exit the program
            confirmExit();
        } // END: windowClosing() method
    } // END: WindowListener class
} // END: SudokuGUI class