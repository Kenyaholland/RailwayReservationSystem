package cen3031.group4.trainTickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainDB {
private ArrayList <Train> trains = new ArrayList<Train>();
	
	public TrainDB(int n) {
		for(int i = 0; i < n; ++i) {
			//trains.add(CarFactory.createRandomCar());
		}
	}
	
	public TrainDB() {
		for(int i = 0; i < 10; ++i) {
			//trains.add(CarFactory.createRandomCar());
		}
	}
	
	public void storeTrains() throws Exception {
		SimpleDataSource.init();
		Connection conn = SimpleDataSource.getConnection();
		
		Statement stmt = conn.createStatement();
		String sqlInsert = "INSERT INTO Cars(horsePower,size,weight,make) VALUES(?,?,?,?)";
		stmt.execute("DROP TABLE Cars");
		//stmt.executeUpdate("Create Table Cars (horsePower INTEGER,size CHAR(50),weight INTEGER,make CHAR(50))");
		stmt.executeUpdate("Create Table Cars (make CHAR(50), size CHAR(50), weight INTEGER, horsePower INTEGER)");
		
		try {
			System.out.println("Creating Trains Table... \n");
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
//			for(int i = 0; i < trains.size(); ++i) {
//					pstmt.setInt(1,trains.get(i).getHorsePower());
//					pstmt.setString(2, trains.get(i).getSize());
//					pstmt.setInt(3, trains.get(i).getWeight());
//					pstmt.setString(4, trains.get(i).getMake());
//					pstmt.executeUpdate();
//			}
			
		}finally{
			conn.close();
		}
	}
	
	public void processQuery(String sqlQuery) {
		Connection conn;
		try {
			conn = SimpleDataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sqlQuery);
			ResultSetMetaData rsm = result.getMetaData();
			int cols = rsm.getColumnCount();
			while (result.next()) {
				for (int i = 1; i <= cols; i++) {
					switch (i){
						case 1:
							System.out.print("Make: ");
							break;
						case 2:
							System.out.print("Size: ");
							break;
						case 3:
							System.out.print("Weight: ");
							break;
						case 4:
							System.out.print("HorsePower: ");
							break;
					}
		            System.out.print(result.getString(i) + " ");
				}
		        System.out.println("");
			}
			
			System.out.println("======================================================================================================================================================");
		} catch (SQLException e) {
			System.out.println("Unable to query for such information.");
		}
		
	}
}
