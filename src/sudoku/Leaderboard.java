/**
 * ---------------------------------------------------------------------------
 * File name: Leaderboard.java
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

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;


/**
 * Contain an manage all previous boards
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class Leaderboard
{
    // global variable
    private ArrayList<Board> leaderboard; // to hold all previous boards
    private String initialPath; // to hold the initial path of the leaderboard

    /**
	 * no-arg constructor for the Leaderboard class
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public Leaderboard()
    {
        this.leaderboard = new ArrayList<Board>();
		
		try 
		{
			File leaderText = new File("leaderboard.txt");
			Scanner input = null;
			
			if(leaderText.exists())
			{
				input = new Scanner(leaderText);
			}
			
			while(input.hasNext())
			{
				String strTextLine = input.nextLine();
				String[] fields = strTextLine.split("\\|");
				
				String strUser = fields[0];
				String strDifficulty = fields[1];
				String strTime = fields[2];
				String strMoves = fields[3];
				
				Difficulty diff = Difficulty.valueOf(strDifficulty);
				
				Board board = new Board(strUser,diff);
				this.leaderboard.add(board);
			}
			input.close();
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error from the leaderboard constructor","Sudoku",JOptionPane.ERROR_MESSAGE);
		}
		
    } // END: Leaderboard()

	public void addToList(Board board)
	{
		this.leaderboard.add(board);
	}


    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortByPlayer()
    {
        String user1;
		String user2;
		Board board1;
		Board board2;
		
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			for(int position=counter+1;position<leaderboard.size();position++)
			{
				board1 = leaderboard.get(counter);
				board2 = leaderboard.get(position);
				user1 = board1.getUser();
				user2 = board2.getUser();
				if(user1.compareTo(user2)>0)
				{
					leaderboard.set(counter, user2);
					leaderboard.set(position, user1);
				}
			}
		}
		
    } // END: sortByPlayer() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortByDifficulty()
    {
        Difficulty diff1;
		Difficulty diff2;
		String strDiff1;
		String strDiff2;
		Board board1;
		Board board2;
		
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			for(int position=counter+1;position<leaderboard.size();position++)
			{
				board1 = leaderboard.get(counter);
				board2 = leaderboard.get(position);
				diff1 = board1.getDifficulty();
				diff2 = board2.getDifficulty();
				
				strDiff1 = diff1.toString();
				strDiff2 = diff2.toString();
				
				if(strDiff1.compareTo(strDiff2)>0)
				{
					leaderboard.set(counter, board2);
					leaderboard.set(position, board1);
				}
			}
		}
    } // END: sortByDifficulty() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortByTime()
    {
        
    } // END: sortByTime() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void sortByMoves()
    {
        String moves1;
		String moves2;
		Board board1;
		Board board2;
		
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			for(int position=counter+1;position<leaderboard.size();position++)
			{
				board1 = leaderboard.get(counter);
				board2 = leaderboard.get(position);
				moves1 = board1.getNumOfMoves();
				moves2 = board2.getNumOfMoves();
				
				if(moves1.compareTo(moves2)>0)
				{
					leaderboard.set(counter, board2);
					leaderboard.set(position, board1);
				}
			}
		}
		
    } // END: sortByMoves() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public ArrayList<Board> searchByPlayer(String user)
    {
        ArrayList<Board> byPlayer = new ArrayList<Board>();
		Board board;
		String strUser;
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			board = leaderboard.get(counter);
			strUser = board.getUser();
			if(strUser.equals(user))
			{
				byPlayer.add(board);
			}
		}
		return byPlayer;
    } // END: searchByPlayer() method

    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public ArrayList<Board> searchByDifficulty(Difficulty diff)
    {
        ArrayList<Board> diffBoard;
		Difficulty difficult;
		Board board;
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			board = leaderboard.get(counter);
			difficult = board.getDifficulty();
			if(difficult.equals(diff))
			{
				diffBoard.add(board);
			}
		}
		return diffBoard;
    } // END: searchByDifficulty() method


    /**
	 * TODO FINISH DOCUMENTATION
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    private void export()
    {
        // TODO FINISH IMPLEMENTATION
    } // END: export() method
} // END: Leaderboard class