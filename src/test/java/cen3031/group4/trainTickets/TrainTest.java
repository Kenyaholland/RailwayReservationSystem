package cen3031.group4.trainTickets;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import javafx.stage.Stage;

public class TrainTest {

	
	@Test
	public void TrainSetBreakfast() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setBreakfast(1);
		
		//Assert
		Assert.assertEquals(testTrain.getBreakfast(), 1);
	}
	
	@Test
	public void TrainSetLunch() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setLunch(1);
		
		//Assert
		Assert.assertEquals(testTrain.getLunch(), 1);
	}
	
	@Test
	public void TrainSetDinner() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setDinner(1);
		
		//Assert
		Assert.assertEquals(testTrain.getDinner(), 1);
	}
	
	@Test
	public void TrainSetSoftSleeper() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setSoftSleeper(1);
		
		//Assert
		Assert.assertEquals(testTrain.getSoftSleeper(), 1);
	}
	
	@Test
	public void TrainSetHardSleeper() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setHardSleeper(1);
		
		//Assert
		Assert.assertEquals(testTrain.getHardSleeper(), 1);
	}
	
	@Test
	public void TrainSetSoftSeat() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setSoftSeat(1);
		
		//Assert
		Assert.assertEquals(testTrain.getSoftSeat(), 1);
	}
	
	@Test
	public void TrainSetHardSeat() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setHardSeat(1);
		
		//Assert
		Assert.assertEquals(testTrain.getHardSeat(), 1);
	}
	
	@Test
	public void TrainSetTo() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setTo("Wagsville");
		
		//Assert
		Assert.assertEquals(testTrain.getTo(), "Wagsville");
	}
	
	@Test
	public void TrainSetFrom() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setFrom("Billington");
		
		//Assert
		Assert.assertEquals(testTrain.getFrom(), "Billington");
	}
	
	@Test
	public void TrainSetIsExpress() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setIsExpress(1);
		
		//Assert
		Assert.assertEquals(testTrain.getIsExpress(), 1);
	}
	
	@Test
	public void TrainSetDistance() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setDistance(350);
		
		//Assert
		Assert.assertEquals(testTrain.getDistance(), 350);
	}
	
	@Test
	public void TrainSetID() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setID(601);
		
		//Assert
		Assert.assertEquals(testTrain.getID(), 601);
	}
	
	@Test
	public void TrainSetCapacity() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setCapacity(500);
		
		//Assert
		Assert.assertEquals(testTrain.getCapacity(), 500);
	}
	
	@Test
	public void TrainSetDays() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setDays(9);
		
		//Assert
		Assert.assertEquals(testTrain.getDays(), 9);
	}
	
	@Test
	public void TrainSetPrice() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setPrice(450.97);
		
		//Assert
		Assert.assertEquals(testTrain.getPrice(), 450.97, 0.00001);
	}
	
//	@Test
//	public void Login() {
//		Stage screen;
//		//Arrange
//		BackOffice testBackOffice = new BackOffice(null, null, null, null, null, null, null, "1", "1", null, null);
//		
//		//Act
//		testBackOffice.loginEvent();
//		
//		//Assert
//		Assert.assertNotNull(screen.setScene(null));
//	}

}
