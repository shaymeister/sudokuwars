/**
 * ---------------------------------------------------------------------------
 * File name: HelpPanel.java
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

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * visualize data and information in a JPanel that informs the player
 * about Sudoku and how to play the game
 *
 * <hr>
 * Date created: April 20, 2020
 * Last modified: April 20, 2020
 * <hr>
 * @author Shay Snyder
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class HelpPanel extends JDialog
{
  /**
   * randomly generated
   */
  private static final long serialVersionUID = -1145161862803980909L;

  /**
   * arg constructor for the HelpPanel class
   *
   * <hr>
   * Date created: April 20, 2020
   */
    public HelpPanel(JFrame window, Settings settings)
    {
        // initialize the JDialog
        new JDialog();

        // set the dialogs title
        this.setTitle("Instructions");

        // this string will hold all instructions
        String instructions = "How to interact with SudokuWars:\n"
      + "1) Touch an empty slot... 2) Then touch a tile to place it on the slot\n"
      + "\nMore detailed instructions from:\n"
      + "Each row, column, and nonet can contain a number 1-9 exactly once.\n"
      + "The sum of all numbers in any nonet, row, or column must be equal to 45.\n"
      + "The goal of the game is fill all spaces while abiding by these rules.\n"
      + "\n'Good luck young padawan' - Master Yoda";
      
        // set the dialogs size
        this.setSize(500, 500);

        // create a text area to hold the instructions
        JTextArea help = new JTextArea(instructions, 50, 50);

        // don't allow editing on the text area
        help.setEditable(false);
        
        // add the text area
        this.add(help);

        // set the icon
        this.setIconImage(new ImageIcon(settings.getPathIconImage()).getImage());
        
        // center the dialog
        this.setLocationRelativeTo(window);

        // make it visible
        this.setVisible(true);
	} // END: HelpPanel() arg constructor
} // END: HelpPanel class