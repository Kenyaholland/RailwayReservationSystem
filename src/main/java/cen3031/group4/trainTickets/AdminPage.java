package cen3031.group4.trainTickets;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminPage {
	GridPane layoutAdmin;
	Stage screen;
	Scene mainScene;
	Scene backOfficeScene;
	String username = "1";
	String password = "1";
	String checkUser, checkPw;
	String id;
	String cancel;
	
	AdminPage(GridPane layoutAdmin, Stage screen, Scene mainScene, Scene backOfficeScene){
		this.layoutAdmin = layoutAdmin;
		this.screen = screen;
		this.mainScene = mainScene;
		this.backOfficeScene = backOfficeScene;
	}

	public void createAdminPage() {
		createTitle();
		
		createLogin();
		
		createButtons();
		
	}
	
	public void createTitle() {
		var adminLabel = new Label("Welcome to Administration");
	       adminLabel.setId("title");
	       adminLabel.setAlignment(Pos.CENTER);
	       layoutAdmin.add(adminLabel, 0, 0);
	}
	
	@SuppressWarnings("unchecked")
	public void createLogin() {
		Label Username = new Label("Username= 1");
        final TextField txtUserName = new TextField();
        
        Label Password = new Label("Password= 1");
        final PasswordField pf = new PasswordField();
        
        Button Login = new Button("Login");
        final Label Message = new Label();
        Login.setId("btnLogin");
        
        layoutAdmin.add(Username, 0, 1);
        layoutAdmin.add(txtUserName, 1, 1);
        layoutAdmin.add(Password, 0, 2);
        layoutAdmin.add(pf, 1, 2);
        layoutAdmin.add(Login, 2, 2);
        layoutAdmin.add(Message, 1, 3);
        
        GridPane Adminpane = new GridPane();
        Adminpane.setId("pane");
        Adminpane.setPadding(new Insets(5,5,5,5));
        Adminpane.setVgap(20);
        Adminpane.setHgap(20);
        Adminpane.setAlignment(Pos.CENTER);
        
        Login.setOnAction(new EventHandler() {

			@Override
			public void handle(Event event) {
				checkUser = txtUserName.getText().toString();
				checkPw = pf.getText().toString();
             if(checkUser.equals(username) && checkPw.equals(password)){
              screen.setScene(backOfficeScene);
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
	
	public void createButtons() {	
		
		Button returnToMainButton2 = new Button("Go back to main screen");
        returnToMainButton2.setOnAction(e -> screen.setScene(mainScene));
        layoutAdmin.add(returnToMainButton2, 6, 6);
        
	}
}
