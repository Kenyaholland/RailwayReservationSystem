package cen3031.group4.trainTickets;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



/**
 * JavaFX App
 */
public class App extends Application {

	Stage window;
	Scene mainScene, ticketScene, adminScene, ticketConfirmationScene;
	static TrainDB db = new TrainDB();
	Train selectedTrain;
	ArrayList<String> destinationPoints = new ArrayList<String>();
	ArrayList<String> seatOptions = new ArrayList<String>();
	

    public static void main(String[] args) {
        
		try{
			db.createTables();
			db.printTable();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		launch(args);
    }
    
    @Override
    public void start(Stage screen) throws Exception {
        
        window = screen;

        screen.setTitle("Railway Reservation");
        
        /* ------------- main page ------------- */
        var welcomeLabel = new Label("Welcome to Railway Reservation:");
        var welcomeLabel2 = new Label("A Train Ticketing System");
        
        //main screen buttons
        Button bookTicketButton = new Button("Book a Ticket Now");
        bookTicketButton.setOnAction(e -> screen.setScene(ticketScene));
        
        Button adminButton = new Button("Sign in as an Administrator");
        adminButton.setOnAction(e -> screen.setScene(adminScene)); //for now
        
        Button exitButton = new Button("Exit Program");
        exitButton.setOnAction(e -> window.close());
        
        //main screen layout
        VBox layoutMain = new VBox(10);
        layoutMain.setId("mainPane");
        layoutMain.getChildren()
            .addAll(welcomeLabel, welcomeLabel2, bookTicketButton, adminButton, exitButton);
        layoutMain.setAlignment(Pos.CENTER);
        
        //set main scene layout, size, and css style
        mainScene = new Scene(layoutMain, 1365, 845);
        mainScene.getStylesheets().addAll(this.getClass().getResource("mainmenu.css").toExternalForm());
        
        
        /* ------------- ticket page ------------- */
        GridPane layoutTicket = new GridPane();
        layoutTicket.setId("ticketpane");
        layoutTicket.setPadding(new Insets(5, 5, 5, 5));
        layoutTicket.setVgap(20);
        layoutTicket.setHgap(20);
        layoutTicket.setAlignment(Pos.CENTER);
        
        ticketPage(layoutTicket, screen);
        
        ticketScene = new Scene(layoutTicket, 1366, 845);
        ticketScene.getStylesheets().addAll(this.getClass().getResource("ticketpage.css").toExternalForm());
        
        
        /* ------------- admin page ------------- */
        var adminLabel = new Label("Welcome to Administration page");
        
        Button returnToMainButton2 = new Button("Go back to main screen");
        returnToMainButton2.setOnAction(e -> screen.setScene(mainScene));
        
        VBox layoutAdmin = new VBox(20);
        layoutAdmin.getChildren().addAll(adminLabel, returnToMainButton2);
        layoutAdmin.setAlignment(Pos.CENTER);
        adminScene = new Scene(layoutAdmin, 900, 500);
        //adminScene.getStylesheets().addAll(this.getClass().getResource("adminmenu.css").toExternalForm());
        
        /* ------------- display main scene ------------- */
        window.setScene(mainScene);
        window.show();
    }
    public void updateDropDown(ComboBox<String> destinationPointDropDown) {
    	destinationPointDropDown.setItems(FXCollections.observableArrayList(destinationPoints));
    }
    

    public void updateSeatOptions(ComboBox<String> seatDropDown, ArrayList<String> seatOptions) {
    	seatDropDown.setItems(FXCollections.observableArrayList(seatOptions));
    }

    @SuppressWarnings("unchecked")
	public void ticketPage(GridPane layoutTicket, Stage screen) {
        //title

       var ticketLabel = new Label("Welcome to Ticket Booking");
       ticketLabel.setId("title");
       ticketLabel.setAlignment(Pos.CENTER);
       layoutTicket.add(ticketLabel, 0, 0, 3, 1);
       
       //text box for passenger to enter their name
       var nameLabel = new Label("Enter name:");
       TextField name = new TextField();
       layoutTicket.add(nameLabel, 0, 1);
       layoutTicket.add(name, 1, 1);
        
       //drop down for starting point
       var startPointLabel = new Label("Select Starting Point:");

       String startPoints[] = {"Please Choose" ,"Wagsville", "Gujranwala", "Flipperton", "New Wingsford", "Chesterdale",
            	"Waddlesborough", "Bread Ponds City"};
       @SuppressWarnings("unchecked")
		ComboBox startPointDropDown = new ComboBox(FXCollections.observableArrayList(startPoints));
       startPointDropDown.setPromptText("Select Start");
       startPointDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(startPointLabel, 0, 2);
       layoutTicket.add(startPointDropDown, 0, 3);
       
       //drop down for destination point
       var destinationPointLabel = new Label("Select Destination Point:");
       
       @SuppressWarnings("unchecked")
		ComboBox destinationPointDropDown = new ComboBox(FXCollections.observableArrayList(destinationPoints));
       destinationPointDropDown.setItems(FXCollections.observableArrayList(destinationPoints));
       destinationPointDropDown.setPromptText("Select Destination");
       destinationPointDropDown.getSelectionModel().selectFirst();
   
       layoutTicket.add(destinationPointLabel, 1, 2);
       layoutTicket.add(destinationPointDropDown, 1, 3);
       
       startPointDropDown.setOnAction(new EventHandler<ActionEvent>() {
    	   
    	   @Override public void handle(ActionEvent e) {
    		   destinationPoints.clear();
	    	   String startingSelection = startPointDropDown.getSelectionModel().getSelectedItem().toString();
	    	   ArrayList<Train> destinationTrains = db.selectQuery("SELECT * FROM Trains WHERE starting='" + startingSelection + "'");
	    	   for(int i = 0; i < destinationTrains.size(); ++i) {
	    		   	if(destinationTrains.get(i).getIsExpress() == 1) {
	    		   		destinationPoints.add(destinationTrains.get(i).getID() + " " + destinationTrains.get(i).getTo() + "(Express)");
	    		   	}else {
	    		   		destinationPoints.add(destinationTrains.get(i).getID() + " " + destinationTrains.get(i).getTo() + "(Standard)");
	    		   		
	    		   	}
			    	 
			      }
	    	   updateDropDown(destinationPointDropDown);
    	   }
       });
       
       //meal options check box
       var mealsLabel = new Label("Select Meal Options:");
       layoutTicket.add(mealsLabel, 0, 4);
       
       CheckBox breakfastCheckBox = new CheckBox("Breakfast");
       CheckBox lunchCheckBox = new CheckBox("Lunch");
       CheckBox dinnerCheckBox = new CheckBox("Dinner");
       
       breakfastCheckBox.setSelected(false);
       lunchCheckBox.setSelected(false);
       dinnerCheckBox.setSelected(false);
       
       layoutTicket.add(breakfastCheckBox, 0, 5);
       layoutTicket.add(lunchCheckBox, 0, 6);
       layoutTicket.add(dinnerCheckBox, 0, 7);
  
       //seat drop down menu
       var seatLabel = new Label("Select Seat:");
       ComboBox<String> seatDropDown = new ComboBox<String>(FXCollections.observableArrayList());
       seatDropDown.setItems(FXCollections.observableArrayList(seatOptions));
       seatDropDown.setPromptText("Seat Type");
       seatDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(seatLabel, 1, 4);
       layoutTicket.add(seatDropDown, 1, 5);
       
       destinationPointDropDown.setOnAction(new EventHandler<ActionEvent>() {
    	   
    	   @Override public void handle(ActionEvent e) {
    		   seatOptions.clear();
    		   updateSeatOptions(seatDropDown, seatOptions);
    		   //TODO: Fix null error when a new starting point is selected and destination returns to null, causing a null access error for destination selection
	    	   String destinationSelection = destinationPointDropDown.getSelectionModel().getSelectedItem().toString();
	    	   int selectedTrainID = 0;
	    	   
	    	   //Resets check boxes in case the selected meals aren't offered on new selection
	    	   breakfastCheckBox.setSelected(false);
	    	   lunchCheckBox.setSelected(false);
	    	   dinnerCheckBox.setSelected(false);
	    	   
	    	   if(!destinationSelection.isEmpty()) {
	    		   selectedTrainID = Integer.parseInt(destinationSelection.substring(0,3));
	    	   }else {
	    		   selectedTrainID = 0;
	    	   }
	    	   
	    	   ArrayList<Train> selectedTrainList = db.selectQuery("SELECT * FROM Trains WHERE trainID=" + selectedTrainID);
	    	   selectedTrain = selectedTrainList.get(0);
	    	   
	    	   if(selectedTrain.getBreakfast() == 0) {
	    		   breakfastCheckBox.setDisable(true);
	    	   }else {
	    		   breakfastCheckBox.setDisable(false);
	    	   }
	    	   if(selectedTrain.getLunch() == 0) {
	    		   lunchCheckBox.setDisable(true);
	    	   }else {
	    		   lunchCheckBox.setDisable(false);
	    	   }
	    	   if(selectedTrain.getDinner() == 0) {
	    		   dinnerCheckBox.setDisable(true);
	    	   }else {
	    		   dinnerCheckBox.setDisable(false);
	    	   }
	    	   
	    	   if(selectedTrain.getSoftSeat() != 0) {
	    		   seatOptions.add("Soft Seat");
	    	   }
	    	   
	    	   if(selectedTrain.getHardSeat() != 0) {
	    		   seatOptions.add("Hard Seat");
	    	   }
	    	   
	    	   if(selectedTrain.getSoftSleeper() != 0) {
	    		   seatOptions.add("Soft Sleeper");
	    	   }
	    	   
	    	   if(selectedTrain.getHardSleeper() != 0) {
	    		   seatOptions.add("Hard Sleeper");
	    	   }
	    	   updateSeatOptions(seatDropDown, seatOptions);
    	   }
       });
       
       // return to main button
       Button returnToMainButton = new Button("Go back to Main Screen");
       returnToMainButton.setOnAction(e -> screen.setScene(mainScene));
       layoutTicket.add(returnToMainButton, 0, 8);
       
       // book ticket button
       Button bookTicketButton = new Button("Book Ticket");
       layoutTicket.add(bookTicketButton, 1, 8);
       
       //send values to ticket confirmation page
       ticketConfirmationPage(layoutTicket, screen, bookTicketButton, name,
               startPointDropDown, destinationPointDropDown, breakfastCheckBox, lunchCheckBox, dinnerCheckBox,
               seatDropDown );
   }
    
    
    public void ticketConfirmationPage(GridPane layoutTicket, Stage screen, Button bookTicketButton, TextField name,
            ComboBox startPointDropDown, ComboBox destinationPointDropDown, CheckBox breakfast, CheckBox lunch, CheckBox dinner,
            ComboBox seatDropDown) {
        
        //layout
        GridPane layoutTicketConfirmation = new GridPane();
        
        layoutTicketConfirmation.setId("ticketpane");
        layoutTicketConfirmation.setPadding(new Insets(5, 5, 5, 5));
        layoutTicketConfirmation.setVgap(20);
        layoutTicketConfirmation.setHgap(20);
        
        //declaring labels and buttons
        var ticketConfirmationLabel = new Label("Ticket Confirmation" + "\n");
        ticketConfirmationLabel.setId("title");
        ticketConfirmationLabel.setAlignment(Pos.CENTER);
        GridPane.setHalignment(ticketConfirmationLabel, HPos.CENTER);
        
        Label nameConfirmation = new Label();
        Label startPointConfirmation = new Label();
        Label destinationPointConfirmation = new Label();
        Label mealConfirmation = new Label();
        Label seatConfirmation = new Label();
        Label priceConfirmation = new Label();
        Label daysToTravel = new Label();
        Label datePurchasedConfirmation = new Label();
        
        //setting alignment
        GridPane.setHalignment(nameConfirmation, HPos.LEFT);
        GridPane.setHalignment(startPointConfirmation, HPos.LEFT);
        GridPane.setHalignment(destinationPointConfirmation, HPos.LEFT);
        GridPane.setHalignment(mealConfirmation, HPos.LEFT);
        GridPane.setHalignment(seatConfirmation, HPos.LEFT);
        GridPane.setHalignment(priceConfirmation, HPos.LEFT);
        GridPane.setHalignment(daysToTravel, HPos.LEFT);
        GridPane.setHalignment(datePurchasedConfirmation, HPos.LEFT);
         
        Button returnToMainButton3 = new Button("Confirm and Return to Main Screen");
        GridPane.setHalignment(returnToMainButton3, HPos.LEFT);
        returnToMainButton3.setOnAction(e -> {
        	screen.setScene(mainScene);
        	//TO-DO DECREMENT TRAIN CAPACITY WHEN USER RETURNS TO MAIN SCREEN
        });
        
        Button returnToTicketPage = new Button("Go Back to Ticket Page");
        GridPane.setHalignment(returnToTicketPage, HPos.LEFT);
        returnToTicketPage.setOnAction(e -> screen.setScene(ticketScene));
        
        //adding labels and buttons to layout
        layoutTicketConfirmation.add(ticketConfirmationLabel, 0, 0);
        layoutTicketConfirmation.add(nameConfirmation, 0, 1);
        layoutTicketConfirmation.add(startPointConfirmation, 0, 2);
        layoutTicketConfirmation.add(destinationPointConfirmation, 0, 3);
        layoutTicketConfirmation.add(mealConfirmation, 0, 4);
        layoutTicketConfirmation.add(seatConfirmation, 0, 5);
        layoutTicketConfirmation.add(priceConfirmation, 0, 6);
        layoutTicketConfirmation.add(daysToTravel, 0, 7);
        layoutTicketConfirmation.add(datePurchasedConfirmation, 0, 8);
        layoutTicketConfirmation.add(returnToMainButton3, 0, 9);
        layoutTicketConfirmation.add(returnToTicketPage, 1, 9);
               
        layoutTicketConfirmation.setAlignment(Pos.CENTER);
         
        ticketConfirmationScene = new Scene(layoutTicketConfirmation, 1366, 845);
        
        //gets values selected, adds them to labels and displays them on the ticket confirmation page
        bookTicketButton.setOnAction(e -> {
            
            nameConfirmation.setText("Ticket confirmed for    " + name.getText().toUpperCase());
            startPointConfirmation.setText("Starting point:    " + startPointDropDown.getValue().toString().toUpperCase());
            destinationPointConfirmation.setText("Destination point:    " + destinationPointDropDown.getValue().toString().toUpperCase());
            mealConfirmation.setText("Meal options:   " );
            
            if(breakfast.isSelected()) {
                mealConfirmation.setText(mealConfirmation.getText() + " " + breakfast.getText().toUpperCase());
            }
            if (lunch.isSelected()) {
                mealConfirmation.setText(mealConfirmation.getText() + " " + lunch.getText().toUpperCase());
            }
            if(dinner.isSelected()) {
                mealConfirmation.setText(mealConfirmation.getText() + " " + dinner.getText().toUpperCase());
            }
            if(!(breakfast.isSelected()) && !(lunch.isSelected()) && !(dinner.isSelected())) {
                mealConfirmation.setText(mealConfirmation.getText() + " NONE");
            }
            
            seatConfirmation.setText("Seat type:    " + seatDropDown.getValue().toString().toUpperCase());
            double totalPrice = CalculateTicketPrice(breakfast, lunch, dinner, seatDropDown);
            priceConfirmation.setText("Price:    " + totalPrice);
            
            daysToTravel.setText("Travel Time:    " + selectedTrain.getDays() + " days");
            
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDateTime now = LocalDateTime.now();
  
            datePurchasedConfirmation.setText("Ticket purchase date:    " + date.format(now));
            
            screen.setScene(ticketConfirmationScene);
            ticketConfirmationScene.getStylesheets().addAll(this.getClass().getResource("ticketpage.css").toExternalForm());
                
        }); 
    }
    
    public double CalculateTicketPrice(CheckBox breakfastSelection, CheckBox lunchSelection, CheckBox dinnerSelection,
    		ComboBox seatDropDown) {
    	double totalPrice = 14.99; //base price
    	double pricePerKm = 0.20;
    	
    	//calculate standard or express train cost
    	if(selectedTrain.getIsExpress() == 1) {
    		totalPrice += 29.99;
    	}
    	else {
    		totalPrice += 19.99;
    	}
    	
    	//calculate distance to travel cost
    	totalPrice += selectedTrain.getDistance() * pricePerKm;
    	
    	//calculate meals cost
        if(breakfastSelection.isSelected()) {
            totalPrice += 14.50;
        }
        if (lunchSelection.isSelected()) {
        	totalPrice += 18.85;
        }
        if(dinnerSelection.isSelected()) {
        	totalPrice += 24.99;
        }
    	
    	//calculate selected seat cost
    	if(seatDropDown.getValue().toString() == "Hard Seat") {
    		totalPrice += 7.99;
    	}
    	else if(seatDropDown.getValue().toString() == "Soft Seat") {
    		totalPrice += 12.99;
    	}
    	else if(seatDropDown.getValue().toString() == "Hard Sleeper") {
    		totalPrice += 17.99;
    	}
    	else {
    		totalPrice += 22.99;
    	}
    	
    	return totalPrice;
    }
}
