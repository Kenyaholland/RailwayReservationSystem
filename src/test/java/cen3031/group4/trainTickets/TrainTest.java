package cen3031.group4.trainTickets;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TrainTest {

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
	public void TrainSetSoftSleeper() {
		//Arrange
		Train testTrain = new Train();
		
		//Act
		testTrain.setSoftSleeper(1);
		
		//Assert
		Assert.assertEquals(testTrain.getSoftSleeper(), 1);
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

}
