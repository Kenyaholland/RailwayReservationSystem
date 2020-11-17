package cen3031.group4.trainTickets;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pages {

	Stage screen;
	Stage window;
	Scene mainScene, ticketScene, adminScene, ticketConfirmationScene;
	static TrainDB db;
	Train selectedTrain;
	ArrayList<String> destinationPoints;
	ArrayList<String> seatOptions;
	TicketPage ticketpage;
	
	Pages(Stage screen, TrainDB db, Scene mainScene, Stage window){
		this.screen = screen;
		Pages.db = db;
		this.mainScene = mainScene;
		this.window = window;
		db = new TrainDB();
		destinationPoints = new ArrayList<String>();
		seatOptions = new ArrayList<String>();
		ticketpage = null;
	}
	
	
	
	public void mainPage() {
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
    }
    
    public void ticketPage() {
    	 /* ------------- ticket page ------------- */
        GridPane layoutTicket = new GridPane();
        layoutTicket.setId("ticketpane");
        layoutTicket.setPadding(new Insets(5, 5, 5, 5));
        layoutTicket.setVgap(20);
        layoutTicket.setHgap(20);
        layoutTicket.setAlignment(Pos.CENTER);
        
        ticketpage = new TicketPage(layoutTicket, screen, mainScene, selectedTrain, destinationPoints, seatOptions, db);
        ticketpage.createTicketPage();
        
        ticketScene = new Scene(layoutTicket, 1366, 845);
        ticketScene.getStylesheets().addAll(this.getClass().getResource("ticketpage.css").toExternalForm());
    }
    
    public void ticketConfirmationPage() {
    	ticketpage.makeTicketConfirmationPage(ticketConfirmationScene, mainScene, ticketScene);
    }
    
    public void adminPage() {
    	/* ------------- admin page ------------- */
        var adminLabel = new Label("Welcome to Administration page");
        
        Button returnToMainButton2 = new Button("Go back to main screen");
        returnToMainButton2.setOnAction(e -> screen.setScene(mainScene));
        
        VBox layoutAdmin = new VBox(20);
        layoutAdmin.getChildren().addAll(adminLabel, returnToMainButton2);
        layoutAdmin.setAlignment(Pos.CENTER);
        adminScene = new Scene(layoutAdmin, 900, 500);
        //adminScene.getStylesheets().addAll(this.getClass().getResource("adminmenu.css").toExternalForm());
    }
    
    public void displayMainScene() {
		// display main scene 
        window.setScene(mainScene);
        window.show();
	}
}
