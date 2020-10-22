package cen3031.group4.trainTickets;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
			
			TrainReadin.ReadIn();
			
			TrainDB db = new TrainDB();
			db.storeTrains();
			
//			String trainArray[][] = new String[14][numLines];
//			//ArrayList<List<String>> trainList;
//			
//			
//			
//			for(int i=0;i<13;i++)
//			{
//				for(int j=0;j<numLines;j++)
//				{
//					trainArray[i][j]= input.next();
//				}
//			}
//			
//			ArrayList<ArrayList<String>> trainList = new ArrayList<ArrayList<String>>();
//
//			for(int i = 0; i < numLines; ++i) {
//				trainList.add(new ArrayList<String>()); 
//			}
//			
//			
//			
//			for(int i=0;i<13;i++)
//			{
//				for(int j=0;j<numLines;j++)
//				{
//					trainList.get(i).add(j, trainArray[i][j]);
//				}
//			}
//			
//			System.out.println(trainList);
//			
			
//			do
//			{
//				
//				for(int i=0;i<13;i++)
//				{
//					for(int j=0;j<numLines;j++)
//					{
//						
//						System.out.print(trainArray[i][j] +" ");
//					}
//				}
//				
//			route = infoIn.nextInt();
//			if(!(route>=101&& route<=(100+numLines)))
//			{
//				System.out.println("Invalid choice! Please select a valid Train ID!");
//			}
//			
//			}while(!(route>=101&& route<=(100+numLines)));
			
			
//			String menuArray[][] = new String[7][numLines];
//			String backendArray[][] = new String[7][numLines];
//			
//			
//			for(int j = 0; j < numLines; ++j) {
//				for(int i = 0; i < 6; ++i) {
//					menuArray[i][j] = trainArray[i][j];
//				}
//			}
			
//			for(int i = 0; i < 6;  ++i){
//				for(int j = 0; j < numLines; ++j)
//				{
//					menuArray[i][j] = trainArray[i][j];
//				}
//			}
//
//			int z = 0;
//			
//			for(int i = 7; i < 13; ++i){
//				z++;
//				for(int j = 0; j < numLines; ++j){
//					backendArray[z][j] = trainArray[i][j];
//				}
//				
//			}
//			
//			
//			for(int i=0;i < 7 ;i++)
//			{
//				for(int j=0;j<numLines;j++)
//				{
//					
//					System.out.print(backendArray[i][j] +" ");
//				}
//			}

			
			
			
			
			
			
			
			
			
			
			
			FileOutputStream fileOut = new FileOutputStream("src/main/java/cen3031/group4/trainTickets/TrainTickets.txt");
			PrintWriter printOut = new PrintWriter(fileOut);
			
			
	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
}