package cen3031.group4.trainTickets;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
       
       //text box for passenger to enter their name
       var nameLabel = new Label("Enter name:");
       TextField name = new TextField();
       layoutTicket.add(nameLabel, 0, 1);
       layoutTicket.add(name, 1, 1);
        
       //drop down for starting point
       var startPointLabel = new Label("Select Starting Point:");
       String startPoints[] = {"Wagsville", "Gujranwala", "Flipperton", "New Wingsford", "Chesterdale",
                "Waddlesborough", "Bread Ponds City", "Billington"};
       @SuppressWarnings("unchecked")
        ComboBox startPointDropDown = new ComboBox(FXCollections.observableArrayList(startPoints));
       startPointDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(startPointLabel, 0, 2);
       layoutTicket.add(startPointDropDown, 0, 3);
       
       //drop down for destination point
       var destinationPointLabel = new Label("Select Destination Point:");
       String destinationPoints[] = {"Gujranwala", "Bread Ponds City", "Flipperton", "New Wingsford", "Chesterdale",
               "Waddlesborough", "Billington", "Owl", "Sparrow", "Cockatoo", "Pidgey",
               "Kiwi", "Heronwok", "Hoopoes", "Dodo", "Penguin", "Flamingo", "Moron",
               "Peacock", "Dove", "Eagle", "Vulture", "Crane", "Stork", "Ostrich", "Goose", "Thrush"};
       @SuppressWarnings("unchecked")
        ComboBox destinationPointDropDown = new ComboBox(FXCollections.observableArrayList(destinationPoints));
       destinationPointDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(destinationPointLabel, 1, 2);
       layoutTicket.add(destinationPointDropDown, 1, 3);
           
       //meal options check box
       var mealsLabel = new Label("Select Meal Options:");
       layoutTicket.add(mealsLabel, 0, 4);
       
       CheckBox breakfast = new CheckBox("Breakfast");
       breakfast.setSelected(false);
       layoutTicket.add(breakfast, 0, 5);
       
       CheckBox lunch = new CheckBox("Lunch");
       lunch.setSelected(false);
       layoutTicket.add(lunch, 0, 6);
       
       CheckBox dinner = new CheckBox("Dinner");
       dinner.setSelected(false);
       layoutTicket.add(dinner, 0, 7);
       
       //Express/Standard check box
       var expressLabel = new Label("Select Train:");
       CheckBox expressCheckBox = new CheckBox("Express");
       expressCheckBox.setSelected(false);
       layoutTicket.add(expressLabel, 1, 4);
       layoutTicket.add(expressCheckBox, 1, 5);
           
       CheckBox standardCheckBox = new CheckBox("Standard");
       standardCheckBox.setSelected(true);
       layoutTicket.add(standardCheckBox, 1, 6);
             
       //disables the other if one is selected, so user can't select both at once
       expressCheckBox.setOnAction(e -> {
           if(expressCheckBox.isSelected()) {
               standardCheckBox.setSelected(false);
           }else {
               standardCheckBox.setSelected(true);
           }
       });
       
       standardCheckBox.setOnAction(e -> {
           if(standardCheckBox.isSelected()) {
               expressCheckBox.setSelected(false);
           }else {
               expressCheckBox.setSelected(true);
           }
           
       });
  
       //seat drop down menu
       var seatLabel = new Label("Select Seat:");
       String seats[] = {"Soft Seat", "Hard Seat", "Soft Sleeper", "Hard Sleeper"};
       @SuppressWarnings("unchecked")
        ComboBox seatDropDown = new ComboBox(FXCollections.observableArrayList(seats));
       seatDropDown.getSelectionModel().selectFirst();
       layoutTicket.add(seatLabel, 2, 4);
       layoutTicket.add(seatDropDown, 2, 5);
       
       // return to main button
       Button returnToMainButton = new Button("Go back to Main Screen");
       returnToMainButton.setOnAction(e -> screen.setScene(mainScene));
       layoutTicket.add(returnToMainButton, 0, 8);
       
       // book ticket button
       Button bookTicketButton = new Button("Book Ticket");
       layoutTicket.add(bookTicketButton, 1, 8);
       
       //send values to ticket confirmation page
       ticketConfirmationPage(layoutTicket, screen, bookTicketButton, name,
               startPointDropDown, destinationPointDropDown, breakfast, lunch, dinner,
               expressCheckBox, standardCheckBox, seatDropDown );
   }
    
    
    public void ticketConfirmationPage(GridPane layoutTicket, Stage screen, Button bookTicketButton, TextField name,
            ComboBox startPointDropDown, ComboBox destinationPointDropDown, CheckBox breakfast, CheckBox lunch, CheckBox dinner,
            CheckBox expressCheckBox, CheckBox standardCheckBox, ComboBox seatDropDown) {
        
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
        Label trainConfirmation = new Label();
        Label seatConfirmation = new Label();
        Label priceConfirmation = new Label();
        Label datePurchasedConfirmation = new Label();
        
        //setting alignment
        GridPane.setHalignment(nameConfirmation, HPos.CENTER);
        GridPane.setHalignment(startPointConfirmation, HPos.CENTER);
        GridPane.setHalignment(destinationPointConfirmation, HPos.CENTER);
        GridPane.setHalignment(mealConfirmation, HPos.CENTER);
        GridPane.setHalignment(trainConfirmation, HPos.CENTER);
        GridPane.setHalignment(seatConfirmation, HPos.CENTER);
        GridPane.setHalignment(priceConfirmation, HPos.CENTER);
        GridPane.setHalignment(datePurchasedConfirmation, HPos.CENTER);
         
        Button returnToMainButton3 = new Button("Go back to main screen");
        GridPane.setHalignment(returnToMainButton3, HPos.CENTER);
        returnToMainButton3.setOnAction(e -> screen.setScene(mainScene));
        
        //adding labels and buttons to layout
        layoutTicketConfirmation.add(ticketConfirmationLabel, 0, 0);
        layoutTicketConfirmation.add(nameConfirmation, 0, 1);
        layoutTicketConfirmation.add(startPointConfirmation, 0, 2);
        layoutTicketConfirmation.add(destinationPointConfirmation, 0, 3);
        layoutTicketConfirmation.add(mealConfirmation, 0, 4);
        layoutTicketConfirmation.add(trainConfirmation, 0, 5);
        layoutTicketConfirmation.add(seatConfirmation, 0, 6);
        layoutTicketConfirmation.add(priceConfirmation, 0, 7);
        layoutTicketConfirmation.add(datePurchasedConfirmation, 0, 8);
        layoutTicketConfirmation.add(returnToMainButton3, 0, 9);
               
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
            
            trainConfirmation.setText("Train type:   ");
            if(expressCheckBox.isSelected()) {
                trainConfirmation.setText(trainConfirmation.getText() + " " + expressCheckBox.getText().toUpperCase());
            }
            if(standardCheckBox.isSelected()) {
                trainConfirmation.setText(trainConfirmation.getText() + " " + standardCheckBox.getText().toUpperCase());
            }
            
            seatConfirmation.setText("Seat type:    " + seatDropDown.getValue().toString().toUpperCase());
            priceConfirmation.setText("Price:    ");
            
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDateTime now = LocalDateTime.now();
  
            datePurchasedConfirmation.setText("Ticket purchase date:    " + date.format(now));
            
            screen.setScene(ticketConfirmationScene);
            ticketConfirmationScene.getStylesheets().addAll(this.getClass().getResource("ticketpage.css").toExternalForm());
                
        });
        
    }
}
