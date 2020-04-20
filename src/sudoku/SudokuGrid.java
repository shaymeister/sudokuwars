package sudoku;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class SudokuGrid extends JPanel
{
    private JPanel grid;

    public SudokuGrid(Difficulty difficulty)
    {
        /*
         * if the user wants to play a difficult board,
         * use a 15x15 grid layout; otherwise, use a
         * 9x9 layout
         */
        if (difficulty.equals(Difficulty.UNBEATABLE))
        {
            grid = new JPanel(new GridLayout(15,15));
        }
        else
        {
            grid = new JPanel(new GridLayout(9,9));
        }
    } // END: SudokuGrid() arg-constructor

} // END: SudokuGrid class