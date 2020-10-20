package cen3031.group4.trainTickets;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int route;
		int numLines=0;
		String fileDir="src/main/java/cen3031/group4/trainTickets/Inventory.csv";
		
		@SuppressWarnings("resource")
		Scanner infoIn = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner userIn = new Scanner(System.in);
		
		
		try
		{
			
			
			FileInputStream fileIn = new FileInputStream(fileDir);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(fileIn);
			input.useDelimiter(",");
			
			LineNumberReader lines= new LineNumberReader(new FileReader(fileDir));
			while(lines.readLine() != null)
			{
				numLines = lines.getLineNumber();
			}
			
			
			String trainArray[][] = new String[14][numLines];
			
			
			for(int i=0;i<13;i++)
			{
				for(int j=0;j<numLines;j++)
				{
					trainArray[i][j]= input.next();
				}
			}
			
			
			do
			{
				
				for(int i=0;i<13;i++)
				{
					for(int j=0;j<numLines;j++)
					{
						
						System.out.print(trainArray[i][j] +" ");
					}
				}
				
			route = infoIn.nextInt();
			if(!(route>=101&& route<=(100+numLines)))
			{
				System.out.println("Invalid choice! Please select a valid Train ID!");
			}
			
			}while(!(route>=101&& route<=(100+numLines)));
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			FileOutputStream fileOut = new FileOutputStream("src/main/java/cen3031/group4/trainTickets/TrainTickets.txt");
			PrintWriter printOut = new PrintWriter(fileOut);
			
			
	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
}