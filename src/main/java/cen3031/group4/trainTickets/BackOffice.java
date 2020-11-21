package cen3031.group4.trainTickets;

import java.util.ArrayList;


import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class BackOffice {

	GridPane backPane;
	Stage screen;
	GridPane TrainInfoPane;
	String id;
	String cancel;
	Scene trainInfoScene, backOfficeScene ,mainScene;
	Button Login;
	String checkUser, checkPw;
	final TextField txtUserName;
	final PasswordField pf;
	final Label Message;
	String username;
	String password;
	TextArea outputarea;
	Button returnToMainButton3;
	ArrayList<Train> destinationTrains;
	ArrayList<Button> goToTrain;
	VBox vboxForButtons;
	
	
	;
	
	
	BackOffice(Scene backOfficeScene, Stage screen, Button Login, String checkUser, String checkPw, final TextField txtUserName, 
			final PasswordField pf, String username, String password, final Label Message, Scene mainScene) {
		//this.backPane = backPane;
		this.screen = screen;
		this.backOfficeScene = backOfficeScene;
		this.Login = Login;
		this.checkPw = checkPw;
		this.checkUser = checkUser;
		this.txtUserName = txtUserName;
		this.pf = pf;
		this.username = username;
		this.password = password;
		this.Message = Message;
		this.mainScene = mainScene;
		//this.TrainInfoPane = TrainInfoPane;
	}

	public void createBackOffice() {
		backPane = new GridPane();
    	backPane.setId("backpane");
    	backPane.setPadding(new Insets(5,5,5,5));
    	backPane.setVgap(20);
    	backPane.setHgap(20);
    	backPane.setAlignment(Pos.CENTER);

        TrainInfoPane = new GridPane();
        TrainInfoPane.setId("trainpane");
        TrainInfoPane.setPadding(new Insets(5,5,5,5));
        TrainInfoPane.setVgap(20);
        TrainInfoPane.setHgap(20);
        TrainInfoPane.setAlignment(Pos.CENTER);
        
       // backOffice = new BackOffice(backPane,screen,TrainInfoPane);
        //backOffice.createBackOffice();
        
        //backOfficeScene = new Scene(backPane,1366, 845);
        //this.backOfficeScene = new Scene(backPane,1366, 845);
        //backOfficeScene.getStylesheets().addAll(this.getClass().getResource("adminpage.css").toExternalForm());
        
		createTrainDisplay();
		loginEvent();
		//screen.setScene(trainInfoScene);
		
	}
	
	@SuppressWarnings("unchecked")
	public void loginEvent() {
		
		backOfficeScene = new Scene(backPane,1366, 845);
	    //backOfficeScene.getStylesheets().addAll(this.getClass().getResource("adminpage.css").toExternalForm());
	     
		Login.setOnAction(new EventHandler() {

			@Override
			public void handle(Event event) {
				checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
             if(checkUser.equals(username) && checkPw.equals(password)){
            	 //makeBackOfficePage(back);
              screen.setScene(backOfficeScene);
              backOfficeScene.getStylesheets().addAll(this.getClass().getResource("adminpage.css").toExternalForm());
             }
             else{
              Message.setText("Either your password or username is wrong");
              Message.setTextFill(Color.RED);
             }
             txtUserName.setText("");
             pf.setText("");
				
			}
            });
		
		 
	        
	}
	
	public void createTrainDisplay() {
		outputarea = new TextArea();
	     
        returnToMainButton3 = new Button("Go back to main screen");
        
        destinationTrains = Pages.db.selectQuery("SELECT * FROM Trains"); 
        
        vboxForButtons = new VBox();
        
        vboxForButtons.setAlignment(Pos.CENTER_RIGHT);
        outputarea.setEditable(false);
        
        goToTrain = new ArrayList<>();
        
        //outputarea.appendText("its working yayyy");
        
        for(int i=0;i<destinationTrains.size();i++)
        {
  
       	 
       	 outputarea.appendText("Train ID: "+Integer.toString(destinationTrains.get(i).getID())+"\n--------------\n");
       	 goToTrain.add(new Button("Edit Train "+ String.valueOf(101+i)));
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
        
        //Add more here
        backPane.add(outputarea, 0, 1);
        backPane.add(vboxForButtons, 1, 1);
        backPane.add(returnToMainButton3, 0, 2);
        
        
        
        //TODO: add whatever is supposed to go on the back office page with backPane.add()
	}
	
	public void switchStmt(String id,Scene trainInfoScene,GridPane TrainInfoPane, int trainId,Stage screen)
    {
    	switch(id)
		 {
		 case "101":
			 trainId=0;
			break;
		 case "102":
			 trainId=1;
			break;
		 case "103":
			 trainId=2;
			break;
		 case "104":
			 trainId=3;
			break;
		 case "105":
			 trainId=4;
			break;
		 case "106":
			 trainId=5;
			break;
		 case "107":
			 trainId=6;
			break;
		 case "108":
			 trainId=7;
			break;
		 case "109":
			 trainId=8;
			break;
		 case "110":
			 trainId=9;
			break;
		 case "111":
			 trainId=10;
			break;
		 case "112":
			 trainId=11;
			break;
		 case "113":
			 trainId=12;
			break;
		 case "114":
			 trainId=13;
			break;
		 case "115":
			 trainId=14;
			break;
		 case "116":
			 trainId=15;
			break;
		 }
		 trainInfoScene=new Scene(TrainInfoPane,1365, 845);
         trainInfoScene(TrainInfoPane,screen,trainId);
		screen.setScene(trainInfoScene);
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
    	
    	returnToMainButton3.setOnAction(e->{
    		screen.setScene(mainScene);
        });
    	
    	
    }
}
