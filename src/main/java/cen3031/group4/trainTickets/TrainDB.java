package cen3031.group4.trainTickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainDB {
//private ArrayList <Train> trains = new ArrayList<Train>();
	
	public void storeTrains() throws Exception {
		SimpleDataSource.init();
		Connection conn = SimpleDataSource.getConnection();
		ArrayList<Train> trainList = TrainReadin.ReadIn();
		
		Statement stmt = conn.createStatement();
		String sqlInsert = "INSERT INTO Trains(trainID,starting, destination,express,distace,capacity,days,softSeat,hardSeat,softSleeper,hardSleeper,breakfast,lunch,dinner,price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		stmt.execute("DROP TABLE Trains");
		stmt.executeUpdate("CREATE TABLE Trains(trainID INTEGER,starting CHAR(50),destination CHAR(50),express INTEGER,distace INTEGER,capacity INTEGER,days INTEGER,softSeat INTEGER,hardSeat INTEGER,softSleeper INTEGER,hardSleeper INTEGER,breakfast INTEGER,lunch INTEGER,dinner INTEGER,price INTEGER)");

		
		try {
			System.out.println("Creating Trains Table... \n");
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			for(int i = 0; i < trainList.size(); ++i) {
					pstmt.setInt(1,trainList.get(i).getID());
					pstmt.setString(2, trainList.get(i).getFrom());
					pstmt.setString(3, trainList.get(i).getTo());
					pstmt.setInt(4, trainList.get(i).getIsExpress());
					pstmt.setInt(5, trainList.get(i).getDistance());
					pstmt.setInt(6, trainList.get(i).getCapacity());
					pstmt.setInt(7, trainList.get(i).getDays());
					pstmt.setInt(8, trainList.get(i).getSoftSeat());
					pstmt.setInt(9, trainList.get(i).getHardSeat());
					pstmt.setInt(10, trainList.get(i).getSoftSleeper());
					pstmt.setInt(11, trainList.get(i).getHardSleeper());
					pstmt.setInt(12, trainList.get(i).getBreakfast());
					pstmt.setInt(13, trainList.get(i).getLunch());
					pstmt.setInt(14, trainList.get(i).getDinner());
					pstmt.setDouble(15, 0.0);
					pstmt.executeUpdate();
			}
			
		}finally{
			conn.close();
		}
	}
	
//	public void processQuery(String sqlQuery) {
//		Connection conn;
//		try {
//			conn = SimpleDataSource.getConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet result = stmt.executeQuery(sqlQuery);
//			ResultSetMetaData rsm = result.getMetaData();
//			int cols = rsm.getColumnCount();
//			while (result.next()) {
//				for (int i = 1; i <= cols; i++) {
//					switch (i){
//						case 1:
//							System.out.print("Make: ");
//							break;
//						case 2:
//							System.out.print("Size: ");
//							break;
//						case 3:
//							System.out.print("Weight: ");
//							break;
//						case 4:
//							System.out.print("HorsePower: ");
//							break;
//					}
//		            System.out.print(result.getString(i) + " ");
//				}
//		        System.out.println("");
//			}
//			
//			System.out.println("======================================================================================================================================================");
//		} catch (SQLException e) {
//			System.out.println("Unable to query for such information.");
//		}
//		
//	}
}
