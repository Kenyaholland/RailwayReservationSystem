package cen3031.group4.trainTickets;

import java.util.Scanner;

public class Main
{
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner infoIn = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner userIn = new Scanner(System.in);
		
		try{
			
			TrainReadin.ReadIn();
			
			TrainDB db = new TrainDB();
			db.storeTrains();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}