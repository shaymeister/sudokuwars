
import java.io.*;
import java.util.*;
public class TestBoardArray
{
	public static void main(String[] args)
	{
		//only test with the starter board in the text file, if answer board is in same file it will throw an error 
		
		
		int[][] iBoard = new int[9][9];			//initializes 2d array
		int row = 0;							//counter for the number of rows, reason not to do a for within a for is because it will throw an out of bounds
		File myFile = new File("medium1.txt");	//selects the file, can change the file name if you want to test just read the first comment 
		Scanner inputFile = null;				//set equal to null at first
		
		//the try and catch is required by the compiler 
		try
		{
			inputFile = new Scanner(myFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.print("\n\tInvalid file.");
		}
		
		//while loop goes through each line of the text file 
		//each line creates a single array of length 9 (reason for the for loop to capture those numbers in the 2d array) 
		while(inputFile.hasNextLine())
		{
			String strString = inputFile.nextLine();
			String[] field = strString.split("\\|");
			
			for(int column=0;column<field.length;column++)
			{
				iBoard[row][column] = Integer.parseInt(field[column]);
			}
			row++;
		}
	
		//this is just what I used to check my work to see if the 2d array is an exact copy of the text file
		for(int counter1=0;counter1<9;counter1++)
		{
			System.out.print("\n\t");
			for(int counter2=0;counter2<9;counter2++)
			{
				System.out.print(iBoard[counter1][counter2]+", ");
			}
		}
		
	}//end main(String[]) 
}//end TestBoardArray 