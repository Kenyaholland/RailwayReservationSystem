package cen3031.group4.trainTickets;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


/**
 * JavaFX App
 */
public class App extends Application {

	Stage window;
	Scene mainScene, ticketScene, adminScene;
	
    public static void main(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage screen) throws Exception {
    	
    	window = screen;

    	//main page
    	screen.setTitle("Train Ticketing System");
    	
        var welcomeLabel = new Label("Welcome to Train");
        welcomeLabel.setTextFill(Color.web("#FFFFFF"));
        
        Button bookTicketButton = new Button("Book a ticket now");
        bookTicketButton.setOnAction(e -> screen.setScene(ticketScene));
        
        Button adminButton = new Button("Sign in as Admin");
        adminButton.setOnAction(e -> screen.setScene(adminScene)); //for now
        
        Button exitButton = new Button("Exit Program");
        exitButton.setOnAction(e -> window.close());
        
        VBox layoutMain = new VBox(20);
        layoutMain.setId("mainPane");
        layoutMain.getChildren().addAll(welcomeLabel, bookTicketButton, adminButton, exitButton);
        layoutMain.setAlignment(Pos.CENTER);
        
        mainScene = new Scene(layoutMain, 640, 480);
        mainScene.getStylesheets().addAll(this.getClass().getResource("mainmenu.css").toExternalForm());
        
        //ticket page
        var ticketLabel = new Label("Welcome to Ticket Booking");
        
        Button returnToMainButton = new Button("Go back to main screen");
        returnToMainButton.setOnAction(e -> screen.setScene(mainScene));
        
        VBox layoutTicket = new VBox(20);
        layoutTicket.getChildren().addAll(ticketLabel, returnToMainButton);
        layoutTicket.setAlignment(Pos.CENTER);
        ticketScene = new Scene(layoutTicket, 640, 480);
        
        //admin page
        var adminLabel = new Label("Welcome to Administration page");
        
        Button returnToMainButton2 = new Button("Go back to main screen");
        returnToMainButton2.setOnAction(e -> screen.setScene(mainScene));
        
        VBox layoutAdmin = new VBox(20);
        layoutAdmin.getChildren().addAll(adminLabel, returnToMainButton2);
        layoutAdmin.setAlignment(Pos.CENTER);
        adminScene = new Scene(layoutAdmin, 640, 480);
        
        window.setScene(mainScene);
        window.show();
    }
}