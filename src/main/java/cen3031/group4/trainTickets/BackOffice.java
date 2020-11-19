package cen3031.group4.trainTickets;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BackOffice {

	GridPane backPane;
	Stage screen;
	GridPane TrainInfoPane;
	String id;
	String cancel;
	Scene trainInfoScene, backOfficeScene;
	
	BackOffice(GridPane backPane, Stage screen, GridPane TrainInfoPane) {
		this.backPane = backPane;
		this.screen = screen;
		this.TrainInfoPane = TrainInfoPane;
	}

	public void createBackOffice() {
		// TODO Auto-generated method stub
		createTrainDisplay();
		screen.setScene(trainInfoScene);
		
	}
	
	public void createTrainDisplay() {
		TextArea outputarea= new TextArea();
	     
        Button returnToMainButton3 = new Button("Go back to main screen");
        
        ArrayList<Train> destinationTrains = Pages.db.selectQuery("SELECT * FROM Trains"); 
        
        VBox vboxForButtons = new VBox();
        
        vboxForButtons.setAlignment(Pos.BASELINE_RIGHT);
        outputarea.setEditable(false);
        
        ArrayList<Button> goToTrain = new ArrayList<>();
        
        
        for(int i=0;i<destinationTrains.size();i++)
        {
  
       	 
       	 outputarea.appendText("Train ID: "+Integer.toString(destinationTrains.get(i).getID())+"\n--------------\n");
       	 goToTrain.add(new Button("Edit Train "+String.valueOf(101+i)));
       	 goToTrain.get(i).setId(Integer.toString(destinationTrains.get(i).getID()));
       	 vboxForButtons.getChildren().addAll(goToTrain.get(i));
       	 outputarea.appendText("Starting: "+ destinationTrains.get(i).getFrom()+"\n");
       	 outputarea.appendText("Destination: "+destinationTrains.get(i).getTo()+"\n");
        
       	 if(destinationTrains.get(i).getIsExpress()==1)
       	 {
       		 outputarea.appendText("Is Express: True\n");
       	 }
       	 else
       	 {
       		 outputarea.appendText("Is Express: False\n");
       	 }
       
       	 outputarea.appendText("Distance: "+destinationTrains.get(i).getDistance()+" km\n");
       	 outputarea.appendText("Capacity: "+destinationTrains.get(i).getCapacity()+"\n");
       	 outputarea.appendText("Number of Days: "+destinationTrains.get(i).getDays()+"\n========================================\n");
        
       	 
       	 goToTrain.get(i).setOnAction(e ->{
       		 id =((Node) e.getSource()).getId();
       		 int trainId = 0;
       		 cancel=id;
       		 switchStmt(id,trainInfoScene,TrainInfoPane,trainId,screen);
       	 });

       
        }
	}
	
	public void switchStmt(String id,Scene trainInfoScene,GridPane TrainInfoPane, int trainId,Stage screen)
    {
    	switch(id)
		 {
		 case "101":
			 trainId=0;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "102":
			 trainId=1;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "103":
			 trainId=2;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "104":
			 trainId=3;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "105":
			 trainId=4;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "106":
			 trainId=5;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "107":
			 trainId=6;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "108":
			 trainId=7;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "109":
			 trainId=8;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "110":
			 trainId=9;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "111":
			 trainId=10;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "112":
			 trainId=11;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "113":
			 trainId=12;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "114":
			 trainId=13;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "115":
			 trainId=14;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 case "116":
			 trainId=15;
			 trainInfoScene=new Scene(TrainInfoPane,900,500);
	         trainInfoScene(TrainInfoPane,screen,trainId);
			screen.setScene(trainInfoScene);
			break;
		 }
    }
	
	public void trainInfoScene(GridPane TrainInfoPane, Stage screen,int trainId)
    {
    	

    	
    	
    	ArrayList<Train> destinationTrains = Pages.db.selectQuery("SELECT * FROM Trains");
    	
    	Button returnToAdminPage = new Button("Go back to Train Selection");
    	 
    	 
    	Button submitChanges = new Button("Submit Changes");
    	
    	Button cancelChanges = new Button("Cancel Changes");
    	 
    	 
    	 ArrayList<TextField> trainInfo = new ArrayList<TextField>();
         
    	 ArrayList<Label> trainLabels= new ArrayList<Label>();
    	
    
    	trainLabels.add(new Label("Train ID: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getID())));
    	
    	trainLabels.add(new Label("Starting: "));
    	trainInfo.add(new TextField(destinationTrains.get(trainId).getFrom()));
    	
    	trainLabels.add(new Label("Destination: "));
    	trainInfo.add(new TextField(destinationTrains.get(trainId).getTo()));
    	
    	trainLabels.add(new Label("Distance: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getDistance())));
    	
    	trainLabels.add(new Label("Capacity: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getCapacity())));
    	
    	trainLabels.add(new Label("Number of Days: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getDays())));
    	
    	trainLabels.add(new Label("Number of Hard Seats: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getHardSeat())));
    	
    	trainLabels.add(new Label("Number of Soft Seats: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getSoftSeat())));
    	
    	trainLabels.add(new Label("Number of Hard Sleepers: "));
    	trainInfo.add(new TextField(Integer.toString(destinationTrains.get(trainId).getHardSleeper())));
    
    	
    		

    	for(int i=0;i<trainInfo.size();i++)
    	{
    		TrainInfoPane.add(trainLabels.get(i), 1, i);
    		TrainInfoPane.add(trainInfo.get(i), 2, i);
    	}
    	
    	
    	
    	TrainInfoPane.add(submitChanges, 2, 9);
    	TrainInfoPane.add(cancelChanges, 1, 9);
    	
    	
    	
    	submitChanges.setOnAction(e->{
    		for(int i=0;i<trainInfo.size();i++)
    		{
    		System.out.println(trainInfo.get(i).getText());
    		
    		}
    		
    	});
    	
    	cancelChanges.setOnAction( e->{
    		System.out.println("Reset the scene");
    		Parent root = TrainInfoPane.getScene().getRoot();
    		TrainInfoPane.getScene().setRoot(new Region());
    		screen.setScene(backOfficeScene);
    		switchStmt(cancel,trainInfoScene,TrainInfoPane,trainId,screen);
    		
    	});
    	
    	
    	

    	TrainInfoPane.add(returnToAdminPage, 3, 9);
    	returnToAdminPage.setOnAction(e -> {
    		Parent root = TrainInfoPane.getScene().getRoot();
    		TrainInfoPane.getScene().setRoot(new Region());
    		screen.setScene(backOfficeScene);
    	});
    	
    	
    	
    	
    }
}
