package cen3031.group4.trainTickets;


import java.io.FileInputStream;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String fileDir="src/main/java/cen3031/group4/trainTickets/Inventory.csv";
		
		Scanner infoIn = new Scanner(System.in);
		Scanner userIn = new Scanner(System.in);
		
		
		try
		{
			FileInputStream fileIn = new FileInputStream(fileDir);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(fileIn);
			input.useDelimiter(",");
			
			
			
			
			FileInputStream clean = new FileInputStream(fileDir);
			@SuppressWarnings("resource")
			Scanner cleanCopy = new Scanner(clean);
			cleanCopy.useDelimiter(",");
			
			String[][] trainArray = new String[14][17];
			
			
			for(int i=0;i<14;i++)
			{
				for(int j=0;j<17;j++)
				{
					while(input.hasNext())
					{
					trainArray[i][j]= input.next();
					System.out.print(trainArray[i][j]+ " ");
					}
				
				}
			}
	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
}