package cen3031.group4.trainTickets;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int route;
		
		@SuppressWarnings("unused")
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
					//System.out.print(trainArray[i][j]+ " ");
					}
				
				}
			}
			do
			{
			System.out.println("Please choose a route:\n"+
							   "1:  Wagsville to Gujranwala\n"+
							   "2:  Wagsville to Bread Ponds City\n\n"+
							   "3:  Gujranwala to Wagsville\n"+
							   "4:  Gujranwala to Flipperton\n"+
							   "5:  Gujranwala New Wingsford\n\n"+
							   "6:  Flipperton to Gujranwala\n"+
							   "7:  Flipperton to Chesterdale\n\n"+
							   "8:  Chesterdale to Flipperton\n"+
							   "9:  Chesterdale to New Wingsford\n"+
							   "10: Chesterdale to Waddlesborough\n\n"+
							   "11: New Wingsford to Chesterdale\n"+
							   "12: New Wingsford to Gujranwala\n\n"+
							   "13: Waddlesborough to Chesterdale\n"+
							   "14: Waddlesborough to Bread Ponds City\n\n"+
							   "15: Bread Ponds City to Wagsville\n"+
							   "16: Bread Ponds City to Waddlesborough\n"+
							   "17: Bread Ponds City to Billington\n\n"+
							   "18: Billington to Bread Ponds City\n"+
							   "------------------------------------\n"+
							   "Your choice: ");
			route = infoIn.nextInt();
			if(route>=19||route<=0)
			{
				System.out.println("Invalid choice! Please select a route 1-18");
			}
			
			}while(route>=19||route<=0);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			FileOutputStream fileOut = new FileOutputStream("src/main/java/cen3031/group4/trainTickets/TrainTickets.txt");
			PrintWriter printOut = new PrintWriter(fileOut);
			
			
	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
}