//test for reading a file into an array

import java.io.*;
import java.util.Scanner;
public class FileTest
{
	public static void main(String[] args)
	{
		File myFile = new File("numbers.txt");
		Scanner inputFile = null;
		int[] iNumbers = new int[5];
		if(myFile.exists())
		{
			try
			{
				inputFile = new Scanner(myFile);
			}
			catch(FileNotFoundException e)
			{
				System.out.print("file does not exist");
			}
			while(inputFile.hasNext())
			{
				String str = inputFile.nextLine();
				String[] fields = str.split("\\|");
				try
				{
					for(int counter=0;counter<5;counter++)
					{
						if(Integer.parseInt(fields[counter])==1)
						{
							
						}
						else
						{
							iNumbers[counter] = Integer.parseInt(fields[counter]);
						}
					}
				}
				catch(Exception e)
				{
					System.out.print("\n\n\tCant do that stupid!!!");
				}
			}
			for(int counter=0;counter<iNumbers.length;counter++)
			{
				System.out.print(iNumbers[counter]);
			}
			
		}	
		else
		{
			System.out.print("file does not exist");
		}
		
		System.out.print("\n\n\n----------------------------------------------------------------------------------");
		String[] test = new String[5];
		for(int counter=0;counter<5;counter++)
		{
			System.out.print("\n\t"+test[counter]);
		}
		
		inputFile.close();
	}	
}