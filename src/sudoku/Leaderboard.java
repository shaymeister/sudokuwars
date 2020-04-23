/**
 * ---------------------------------------------------------------------------
 * File name: Leaderboard.java
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

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;


/**
 * Contain an manage all previous boards
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 22, 2020
 * <hr>
 * @author Shay Snyder 
 * @author Holden Dalton 
 * @author Hannah Taylor 
 */
public class Leaderboard
{
    // global variable
    private ArrayList<Board> leaderboard; // to hold all previous boards

    /**
	*Purpose: constructor for the leaderboard 
	*
	*Date created: 04/22/2020
	*
	*@param none 
	*@return none 
	*/
    public Leaderboard()
    {
        this.leaderboard = new ArrayList<Board>();
		
		try 
		{
			File leaderText = new File("boards/leaderboard.txt");
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
				String strMinutes = fields[2];
				String strSeconds = fields[3];
				String strMoves = fields[4];
				
				Difficulty diff = Difficulty.valueOf(strDifficulty);
				long LMins = Long.parseLong(strMinutes);
				long LSecs = Long.parseLong(strSeconds);
				int iMoves = Integer.parseInt(strMoves);
				
				Board board = new Board(strUser,diff,LMins,LSecs,iMoves);
				this.leaderboard.add(board);
			}
			input.close();
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error from the leaderboard constructor","Sudoku",JOptionPane.ERROR_MESSAGE);
		}
		
    } // END: Leaderboard()

	/**
	*Purpose: add a board to the list when the player has completed a board 
	*
	*Date created: 04/22/2020
	*
	*@param board - board that the player completed 
	*@return none 
	*/
	public void addToList(Board board)
	{
		this.leaderboard.add(board);
		export();
	}


    /**
	*Purpose: sort boards by player 
	*
	*Date created: 04/22/2020
	*
	*@param none 
	*@return none 
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
					leaderboard.set(counter, board2);
					leaderboard.set(position, board1);
				}
			}
		}
		
    } // END: sortByPlayer() method

   /**
	*Purpose: sorts the boards by difficulty 
	*
	*Date created: 04/22/2020
	*
	*@param none 
	*@return none 
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
	*Purpose: sort the boards by time
	*
	*Date created: 04/22/2020
	*
	*@param none 
	*@return none 
	*/
    public void sortByTime()
    {
        long totalTimeSec1;
		long totalTimeSec2;
		long LMinutes1;
		long LMinutes2;
		long LSeconds1;
		long LSeconds2;
		Board board1;
		Board board2;
		
		for(int counter=0;counter<leaderboard.size();counter++)
		{
			for(int position=counter+1;position<leaderboard.size();position++)
			{
				board1 = leaderboard.get(counter);
				board2 = leaderboard.get(position);
				LMinutes1 = board1.getMinutes();
				LMinutes2 = board2.getMinutes();
				LSeconds1 = board1.getSeconds();
				LSeconds2 = board2.getSeconds();
				
				totalTimeSec1 = (LMinutes1*60)+LSeconds1;
				totalTimeSec2 = (LMinutes2*60)+LSeconds2;
				
				if(totalTimeSec1<totalTimeSec2)
				{
					leaderboard.set(counter, board2);
					leaderboard.set(position, board1);
				}
			}
		}
    } // END: sortByTime() method

    /**
	*Purpose: get all boards by player name 
	*
	*Date created: 04/22/2020
	*
	*@param user- player name being searched 
	*@return byPlayer-list of boards by that player 
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
	*Purpose: get list of boards by difficulty
	*
	*Date created: 04/22/2020
	*
	*@param diff-difficulty being searched 
	*@return diffBoard-list of the searched difficulty 
	*/
    public ArrayList<Board> searchByDifficulty(Difficulty diff)
    {
        ArrayList<Board> diffBoard = new ArrayList<Board>();
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
	*Purpose: save the list in a text file 
	*
	*Date created: 04/22/2020
	*
	*@param none 
	*@return none 
	*/
    private void export()
    {
       PrintWriter printWriter = null;
	   String strUser = null;
	   String strDiff = null;
	   String strMins = null;
	   String strSecs = null;
	   String strMoves = null;
	   Difficulty diff;
	   long minutes;
	   long seconds;
	   int moves;
	   
	   
	   try 
	   {
		   printWriter = new PrintWriter("boards/leaderboard.txt");
		   for(int counter=0;counter<leaderboard.size();counter++)
		   {
			   Board board = leaderboard.get(counter);
			   strUser = board.getUser();
			   diff = board.getDifficulty();
			   minutes = board.getMinutes();
			   seconds = board.getSeconds();
			   moves = board.getMoves();
			   
			   strDiff = diff.toString();
			   strMins = Long.toString(minutes);
			   strSecs = Long.toString(seconds);
			   strMoves = Integer.toString(moves);
			   
			   printWriter.println(strUser+"|"+strDiff+"|"+strMins+"|"+strSecs+"|"+strMoves);
			   
		   }
		   printWriter.close();
	    }
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error in saving the leaderboard","Sudoku",JOptionPane.ERROR_MESSAGE);
		}
	} // END: export() method
	
	/**
	*Purpose: convert to string method 
	*
	*Date created: 04/23/2020
	*
	*@param none 
	*@return string.toString() 
	*/
	public String toString()
	{
		// will hold all leaderboard information
		StringBuilder string = new StringBuilder();

		for(int i = 0; i < leaderboard.size(); i++)
		{
			string.append("-------------------------------------------------------------------------\n"
						+ "Game at index : " + i + "\n"
						+ "Player: " + leaderboard.get(i).getUser() + "\n"
						+ "Difficulty: " + leaderboard.get(i).getDifficulty() + "\n"
						+ "Total Time (Min): " + leaderboard.get(i).getMinutes() + "\n"
						+ "Total Time (Sec): " + leaderboard.get(i).getSeconds() + "\n"
						+ "Num of Moves: " + leaderboard.get(i).getMoves() + "\n"
						+ "-------------------------------------------------------------------------\n");
		}

		return string.toString();
	}

	/**
	*Purpose: to string method 
	*
	*Date created: 04/23/2020
	*
	*@param boards - array list of game boards 
	*@return string.toString() 
	*/
	public String toString(ArrayList<Board> boards)
	{
		// will hold all leaderboard information
		StringBuilder string = new StringBuilder();

		for(int i = 0; i < boards.size(); i++)
		{
			string.append("-------------------------------------------------------------------------\n"
						+ "Game at index : " + i + "\n"
						+ "Player: " + boards.get(i).getUser() + "\n"
						+ "Difficulty: " + boards.get(i).getDifficulty() + "\n"
						+ "Total Time (Min): " + boards.get(i).getMinutes() + "\n"
						+ "Total Time (Sec): " + boards.get(i).getSeconds() + "\n"
						+ "Num of Moves: " + boards.get(i).getMoves() + "\n"
						+ "-------------------------------------------------------------------------\n");
		}

		return string.toString();
	}
} // END: Leaderboard class