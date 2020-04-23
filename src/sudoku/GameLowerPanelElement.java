/**
 * ---------------------------------------------------------------------------
 * File name: GameLowerPanelElement.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 22, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * create a JButton class that will represent each
 * of the 9 sections of numbers the user can
 * choose from when submitting a move
 *
 * <hr>
 * Date created: April 22, 2020
 * Last modified: April 22, 2020
 * 
 * <hr>
 * @author Shay Snyder
 */
public class GameLowerPanelElement extends GamePanelElement
{
    /**
     * randomly generated by compiler
     */
    private static final long serialVersionUID = -8588366620257020431L;
    
    /**
	 * arg constructor for the GridElement class
     *
	 * <hr>
	 * Date created: April 22, 2020
	 */
    public GameLowerPanelElement(Sudoku game, Settings settings, char value, JFrame window)
    {
        // call the super constructor
        super(game, settings, value, window);

        // add the listener
        this.addActionListener(new ButtonActionListener());
    } // END: GameLowerPanelElement() arg constructor

    /**
     * listen if the user clicks the button
     *
     * <hr>
     * Date created: April 22, 2020
     * Last modified: April 22, 2020
     * <hr>
     * @author Shay Snyder
     */
    private class ButtonActionListener implements ActionListener
    {
        /**
	     * listen if the user clicks the button
         *
	     * <hr>
	     * Date created: April 22, 2020
	     */
        public void actionPerformed(ActionEvent e)
        {
            // submit the desired value to the game
            if(game.setDesiredValue(value))
            {
                // Use JOptionPane to display the move's unsuccessful submission
                JOptionPane.showMessageDialog(window,
                                              "Your move was successful!",
                                              "SudokuWars",
                                              JOptionPane.INFORMATION_MESSAGE);

                // determine if the game is over
                isGameOver();

                // regenerate the main screen with the updated data
                window.add(new GamePanel(window, settings, game));
            } // END: move valid
            else
            {
                // Use JOptionPane to display the move's unsuccessful submission
                JOptionPane.showMessageDialog(window,
                                              "Your move was invalid. Please try again.",
                                              "SudokuWars",
                                              JOptionPane.WARNING_MESSAGE);
            } // END: move invalid
        } // END: actionPerformed()
    } // END: ButtonActionListener class

    /**
     * determine if the game is over
     *
     * <hr>
     * Date created: April 23, 2020
     * Last modified: April 23, 2020
     * <hr>
     * @author Shay Snyder
     */
    private void isGameOver()
    {
        if (game.isGameOver())
        {
            int result = JOptionPane.showConfirmDialog(
                            window,
                            "Congratulations, you have completed the board!\n"
                           +"Would you like to add this board to the\n"
                           +"leaderboard?",
                           "SudokuWars",
                           JOptionPane.YES_NO_OPTION);

            // if the user selects 'yes'
            if (result == JOptionPane.YES_OPTION)
            {
                // call add to leaderboard
                addToLeaderBoard();
            }
            else // user selects anything else
            {
                // ask them if they would like to play again
                playAgain();
            } // END: if
        } // END: if
    } // END: isGameOver() method

    /**
	 * use JOptionPane to thank the user for
     * playing SudokuWars
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    private void outro()
    {
        // Thank the user
        JOptionPane.showMessageDialog(
                        window,
                        "Thank you for playing SudokuWars!",
                        settings.getTitle(),
                        JOptionPane.INFORMATION_MESSAGE);

        // terminate the program
        System.exit(0);
    } // END: outro() method

    /**
	 * use JOptionPane to all the user to enter their name to the board
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    private void addToLeaderBoard()
    {
        String name = JOptionPane.showInputDialog(window,
                            "What is your name?",
                            "SudokuWars",
                            JOptionPane.QUESTION_MESSAGE);

        // catch any errors that may arise
        if (name != null)
        {
            // set the player's name
            game.setName(name);
        } // END: if name != null
        else
        {
            // set the player's name
            game.setName("Jane Doe");
        } // END: if name == null

        // add the game to the leaderboard
        game.addToLeaderboard();

        playAgain();
    } // END: addToLeaderBoard

    /**
	 * use JOptionPane to ask the user if they would like to play again
     *
	 * <hr>
	 * Date created: April 20, 2020
	 */
    private void playAgain()
    {
        // ask the user if they would like to play again
        int result = JOptionPane.showConfirmDialog(
                            window,
                            "Would you like to play another game?",
                            "SudokuWars",
                            JOptionPane.YES_NO_OPTION);

            // if the user selects 'yes'
            if (result == JOptionPane.YES_OPTION)
            {
                // start a new game
                new GamePanel(window, settings);
            }
            else // user selects anything else
            {
                // roll the outro
                outro();
            } // END: if
    }
} // END: GameLowerPanelElement class