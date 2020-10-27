package cen3031.group4.trainTickets;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


/**
 * JavaFX App
 */
public class App extends Application {

	Stage window;
	Scene mainScene, ticketScene, adminScene, ticketConfirmationScene;
	
    public static void main(String[] args) {
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
        
        /* ------------- ticket confirmation page ------------- */
        VBox layoutTicketConfirmation = new VBox(20);
        
        var ticketConfirmationLabel = new Label("Ticket Confirmation");
        Button returnToMainButton3 = new Button("Go back to main screen");
        returnToMainButton3.setOnAction(e -> screen.setScene(mainScene));
        layoutTicketConfirmation.getChildren().addAll(ticketConfirmationLabel, returnToMainButton3);
        
        
        layoutTicketConfirmation.setAlignment(Pos.CENTER);
        ticketConfirmationScene = new Scene(layoutTicketConfirmation, 1366, 845);
        
        
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
    
    public void ticketPage(GridPane layoutTicket, Stage screen) {
   	 //title
       var ticketLabel = new Label("Welcome to Ticket Booking");
       ticketLabel.setId("title");
       ticketLabel.setAlignment(Pos.CENTER);
       layoutTicket.add(ticketLabel, 0, 0, 3, 1);
        
       //drop down for starting point
       var startPointLabel = new Label("Select Starting Point:");
       String startPoints[] = {"Wagsville", "Gujranwala", "Flipperton", "New Wingsford", "Chesterdale",
            	"Waddlesborough", "Bread Ponds City", "Billngton"};
       @SuppressWarnings("unchecked")
		ComboBox startPointDropDown = new ComboBox(FXCollections.observableArrayList(startPoints));
       startPointDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(startPointLabel, 0, 1);
       layoutTicket.add(startPointDropDown, 0, 2);
       
       //drop down for destination point
       var destinationPointLabel = new Label("Select Destination Point:");
       String destinationPoints[] = {"Gujranwala", "Bread Ponds City", "Flipperton", "New Wingsford", "Chesterdale",
           	"Waddlesborough", "Billington", "Owl", "Sparrow", "Cockatoo", "Pidgey",
           	"Kiwi", "Heronwok", "Hoopoes", "Dodo", "Penguin", "Flamingo", "Moron", 
           	"Peacock", "Dove", "Eagle", "Vulture", "Crane", "Stork", "Ostrich", "Goose", "Thrush"};
       @SuppressWarnings("unchecked")
		ComboBox destinationPointDropDown = new ComboBox(FXCollections.observableArrayList(destinationPoints));
       destinationPointDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(destinationPointLabel, 1, 1);
       layoutTicket.add(destinationPointDropDown, 1, 2);
           
       //meal options check box
       var mealsLabel = new Label("Select Meal Options:");
       layoutTicket.add(mealsLabel, 0, 3);
       
       String meals[] = { "Breakfast", "Lunch", "Dinner" }; 
       CheckBox mealsCheckBox = null;
       for (int i = 0; i < meals.length; i++) {
           mealsCheckBox = new CheckBox(meals[i]); 
           mealsCheckBox.setSelected(false); 
           layoutTicket.add(mealsCheckBox, 0, i+4); 
       } 
       
       //express check box
       var expressLabel = new Label("Select Express:");
       CheckBox expressCheckBox = new CheckBox("Express");
       expressCheckBox.setSelected(false);
       layoutTicket.add(expressLabel, 1, 3);
       layoutTicket.add(expressCheckBox, 1, 4);
       
       //seat drop down menu
       var seatLabel = new Label("Select Seat:");
       String seats[] = {"Soft Seat", "Hard Seat", "Soft Sleeper", "Hard Sleeper"};
       @SuppressWarnings("unchecked")
		ComboBox seatDropDown = new ComboBox(FXCollections.observableArrayList(seats));
       seatDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(seatLabel, 2, 3);
       layoutTicket.add(seatDropDown, 2, 4);
       
       // return to main button
       Button returnToMainButton = new Button("Go back to Main Screen");
       returnToMainButton.setOnAction(e -> screen.setScene(mainScene));
       layoutTicket.add(returnToMainButton, 0, 7);
       
       // book ticket button
       Button bookticketButton = new Button("Book Ticket");
       bookticketButton.setOnAction(e -> screen.setScene(ticketConfirmationScene));
       layoutTicket.add(bookticketButton, 1, 7);
   	
   }
}