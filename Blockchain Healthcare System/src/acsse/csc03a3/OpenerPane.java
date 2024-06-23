package acsse.csc03a3;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OpenerPane<T> extends AnchorPane {
	OutputStream os;
	InputStream is;
	
	private String[] personType = {"Doctor", "Patient"};
	Label myLabel = new Label();
	ChoiceBox<String> choiceBox = new ChoiceBox<>();
	Button registerButton = new Button("Register");
	 Button loginButton = new Button("Login");
	 ImageView imageView = new ImageView("logo.jpeg");  
	 Alert alert = new Alert(AlertType.ERROR);  
	 Label label = new Label("     MediBlock");  
	 Stage secondaryscene = new Stage();
	 
	 DoctorRegistrationPane<T> docregister;
	 DoctorLoginPane<T> doclogin;
	 LoginPane<T> patlogin;
	 RegisterPane<T> patregister;
	 
	 Button btnAboutUs = new Button("About Us");
	 
	 Socket socket = new Socket();
	 
	public OpenerPane() {
		  
		SetupPane();
		 this.setStyle("-fx-background-color: #ADD8E6;");
		
		registerButton.setOnAction(e->{
			 if (choiceBox.getValue() == null) {
				    alert.setTitle("Selection");
			        alert.setHeaderText("No selection");  
			        alert.setAlertType(AlertType.WARNING);
			        alert.setContentText("Please enter Person Type");
			        alert.showAndWait();
		            return;
		        }
		        // Proceed to the registration pane
		        String selectedPerson = choiceBox.getValue();
		        if ("Patient".equals(selectedPerson)) {
		           
		        	patregister = new RegisterPane<T>();
		    		Scene scene = new Scene(patregister, 500, 450);
		        	secondaryscene.setScene(scene);
		        	secondaryscene.show();
		        	
		        } else if ("Doctor".equals(selectedPerson)) {
		        	
		        	docregister = new DoctorRegistrationPane<T>();
		    		Scene scene = new Scene(docregister, 500, 450);
		        	secondaryscene.setScene(scene);
		        	secondaryscene.show();
		        }
		});
		
		
		
		
		loginButton.setOnAction(e->{
			 if (choiceBox.getValue() == null) {
		        	alert.setTitle("Selection");
			        alert.setHeaderText("No selection");  
			        alert.setAlertType(AlertType.WARNING);
			        alert.setContentText("Please enter Person Type");
			        alert.showAndWait();
		            return;
		        }
		        //Click Login, Jump into LoginPane
		        String selectedPerson = choiceBox.getValue();
		        if ("Patient".equals(selectedPerson)) {
		        	
		        	patlogin = new LoginPane<>();
		        	Scene scene = new Scene(patlogin, 500, 450);
		        	secondaryscene.setScene(scene);
		        	secondaryscene.show();
		        } else if ("Doctor".equals(selectedPerson)) {
		        	 //Click Login, Jump into Doctor LoginPane
		            doclogin = new DoctorLoginPane<>();
		        	Scene scene = new Scene(doclogin, 500, 450);
		        	secondaryscene.setScene(scene);
		        	secondaryscene.show();
		            
		        }
		        
		        
		});
		
		btnAboutUs.setOnAction(e->{
			 Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("About Mediblock");
		        alert.setHeaderText(null);
		        alert.setContentText(
		            "Welcome to Mediblock – your secure and innovative solution for managing and controlling your health information. " +
		            "At Mediblock, we believe in empowering patients by giving them complete control over their medical records, " +
		            "ensuring their data is secure, private, and easily accessible.\n\n" +
		            "Our Mission\n" +
		            "Mediblock aims to revolutionize the way medical information is managed and shared. Our mission is to create a " +
		            "patient-centered healthcare ecosystem where individuals have the autonomy to manage their health data, decide " +
		            "who can access it, and ensure its integrity and security.\n\n" +
		            "Key Features\n" +
		            "Patient-Centric Control\n" +
		            "Mediblock puts you in the driver’s seat. You decide which records you want to share with healthcare providers. " +
		            "With just a few clicks, you can grant access to specific data while keeping other information private, ensuring " +
		            "that your medical history is shared on a need-to-know basis.\n\n" +
		            "Blockchain Security\n" +
		            "Your health information is sensitive, and protecting it is our top priority. Mediblock leverages blockchain " +
		            "technology to provide an immutable, transparent, and secure platform for storing your medical records. Every " +
		            "transaction, whether adding new data or sharing existing records, is encrypted and stored in a block, creating " +
		            "a tamper-proof ledger.\n\n" +
		            "Seamless Access for Healthcare Providers\n" +
		            "Healthcare providers can access the records you share with them through a secure interface. This ensures they have " +
		            "the most accurate and up-to-date information to provide you with the best possible care. Providers can view the " +
		            "data, but only with your explicit permission, maintaining your privacy and control.\n\n" +
		            "Join the Mediblock community today and take control of your health data. Experience the peace of mind that comes " +
		            "with knowing your medical records are secure, private, and in your hands."
		        );

		        alert.showAndWait();
		});
		 
	}
	
	public void SetupPane() {
		// Create the Login button
       
		btnAboutUs.setLayoutX(350);
		btnAboutUs.setLayoutY(10);
		btnAboutUs.setPrefHeight(33.0);
		btnAboutUs.setPrefWidth(98.0);
		
        loginButton.setLayoutX(166.0);
        loginButton.setLayoutY(311.0);
        loginButton.setPrefHeight(33.0);
        loginButton.setPrefWidth(98.0);

        // Create the Register button
        
        registerButton.setLayoutX(166.0);
        registerButton.setLayoutY(271.0);
        registerButton.setPrefHeight(33.0);
        registerButton.setPrefWidth(98.0);

        // Create the ImageView for the logo
        
        imageView.setFitHeight(204.0);
        imageView.setFitWidth(210.0);
        imageView.setLayoutX(117.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        
        // Create the Label for "MediBlock"
       
        label.setLayoutX(113.0);
        label.setLayoutY(218.0);
        label.setPrefHeight(43.0);
        label.setPrefWidth(204.0);
        Font font = new Font(26.0);
        label.setFont(font);

        // Create the ChoiceBox
        
        choiceBox.setLayoutX(140.0);
        choiceBox.setLayoutY(355.0);   
        choiceBox.setPrefWidth(150.0);
      
        choiceBox.getItems().addAll(personType);
        
        // Add all components to the AnchorPane
        getChildren().addAll(loginButton, registerButton, imageView, label, choiceBox, btnAboutUs);

	}
	
	 public void selectType(ActionEvent event) {
	        String selectedPerson = choiceBox.getValue();
	        myLabel.setText(selectedPerson);
	        
	 }

	    
	
	
}
