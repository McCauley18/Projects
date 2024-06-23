package acsse.csc03a3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.security.auth.kerberos.EncryptionKey;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
  
public class RegisterPane<T> extends AnchorPane {
	Button btnRegister = new Button("Register");
	Label lblRegistration = new Label("Patient Registration");
	Label lblUsername = new Label("Username:");
	Label lblEmailAddress = new Label("Email Address:");
	Label lblPassword = new Label("Password:");
	TextField txtUsername = new TextField();
	TextField txtEmail = new TextField();
	PasswordField txtPassword = new PasswordField();
	
	
	Label lblAlreadyRegistered = new Label("Already registered? ");
	 Label lblRStatus = new Label("Status");
	 Hyperlink hyperRegister = new Hyperlink("Login");
	 Label lblMediBlock = new Label("MediBlock");
	 
	ImageView imageView = new ImageView("logo.jpeg");
	 
	 List<Transaction<T>> transactions;   
	   
	 
	 //Special Stuff
	 Stage secondaryscene = new Stage();
	     
	 // End of special   
	 LoginPane<T> loginpane;
	 
	 @SuppressWarnings("unchecked")
	
	public RegisterPane() {
		 setUpRegisterUI();
		 this.setStyle("-fx-background-color: #ADD8E6;");
		   txtUsername.setPromptText("Username: ");
			  txtEmail.setPromptText("Email:"); 
			  txtPassword.setPromptText("Password:");  
		 
		 btnRegister.setOnAction(e -> {
			
	        	  
	        	try {  
	        	    Class.forName("com.mysql.jdbc.Driver");
	        	    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
	        	     
	        	    String checkIfExistsQuery = "SELECT * FROM patient WHERE Email=?";  
	        	    PreparedStatement checkIfExistsStatement = connect.prepareStatement(checkIfExistsQuery);
	        	    checkIfExistsStatement.setString(1, txtEmail.getText());
	        	    ResultSet existingUserResult = checkIfExistsStatement.executeQuery();
	        	      
	        	    if (existingUserResult.next()) {   
	        	        System.out.println("User with the same email already exists. Registration unsuccessful.");
	        	    } else {  
	        	        // If user does not exist, proceed with registration
	        	    	
	        	       String hashedPassword =  hashPassword(txtPassword.getText());
	        	        String registerQuery = "INSERT INTO patient (Username, Email, Password) VALUES (?, ?, ?)";
	        	        PreparedStatement registerStatement = connect.prepareStatement(registerQuery);
	        	        registerStatement.setString(1, txtUsername.getText());
	        	        registerStatement.setString(2, txtEmail.getText());
	        	        registerStatement.setString(3, hashedPassword);
	        	        int rowsAffected = registerStatement.executeUpdate();
	        	        if (rowsAffected > 0) {
	        	        	 loginpane = new LoginPane<T>();
	        				 Scene scene = new Scene(loginpane, 500, 450);
	        		        	secondaryscene.setScene(scene);
	        		        	secondaryscene.show();
	        	            System.out.println("User registered successfully.");
	        	            lblRStatus.setText("Successful registration");
	        	            lblRStatus.setStyle("-fx-text-fill: green;");
	        	        } else {
	        	            System.out.println("Registration unsuccessful. Please try again later.");
	        	        }
	        	    }
	        	    
	        	    connect.close(); 
	        	} catch (Exception ex) {
	        	    ex.printStackTrace();
	        	}
	
	        });
	          
	        hyperRegister.setOnAction(e -> { 
	        	 LoginPane<T> loginpane = new LoginPane<>();
	        	Scene scene = new Scene(loginpane, 500, 450);
	        	secondaryscene.setScene(scene);
	        	secondaryscene.show();
	        });
	        
	        
	 }  
	 
	 
	 
	 private String hashPassword(String password) throws NoSuchAlgorithmException {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] encodedHash = digest.digest(password.getBytes());
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : encodedHash) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    }  
	 
	 public boolean IdentifierCheck(String usernam) {
		 for (Transaction<T> transaction : transactions) {
            if (transaction.getSender().equals(usernam)) {
			    return true; 
	            }
	        }  
			
			return false;
		}

	    private void setUpRegisterUI() {
	        setPrefSize(529, 447);

	        
	        btnRegister.setLayoutX(194);
	        btnRegister.setLayoutY(273);
	        btnRegister.setPrefSize(170, 34);
	       
	        getChildren().add(btnRegister);

	        
	        lblRegistration.setLayoutX(200);
	        lblRegistration.setLayoutY(63);
	        lblRegistration.setPrefSize(234, 34);
	        lblRegistration.setFont(new Font(24));
	        getChildren().add(lblRegistration);

	        
	        lblUsername.setLayoutX(36);
	        lblUsername.setLayoutY(120);
	        lblUsername.setPrefSize(82, 34);
	        getChildren().add(lblUsername);

	        
	        lblEmailAddress.setLayoutX(36);
	        lblEmailAddress.setLayoutY(165);
	        lblEmailAddress.setPrefSize(94, 34);
	        getChildren().add(lblEmailAddress);

	        
	        lblPassword.setLayoutX(36);
	        lblPassword.setLayoutY(211);
	        lblPassword.setPrefSize(82, 34);
	        getChildren().add(lblPassword);

	       
	        txtUsername.setLayoutX(158);
	        txtUsername.setLayoutY(119);
	        txtUsername.setPrefSize(242, 35);
	        getChildren().add(txtUsername);

	       
	        txtEmail.setLayoutX(158);
	        txtEmail.setLayoutY(164);
	        txtEmail.setPrefSize(242, 35);
	        getChildren().add(txtEmail);

	        
	        txtPassword.setLayoutX(158);
	        txtPassword.setLayoutY(210);
	        txtPassword.setPrefSize(242, 35);
	        getChildren().add(txtPassword);

	        
	        lblAlreadyRegistered.setLayoutX(158);
	        lblAlreadyRegistered.setLayoutY(328);
	        lblAlreadyRegistered.setPrefSize(129, 35);
	        lblAlreadyRegistered.setFont(new Font(14));
	        getChildren().add(lblAlreadyRegistered);

	       
	        lblRStatus.setLayoutX(160);
	        lblRStatus.setLayoutY(370);
	        lblRStatus.setPrefSize(250, 42);
	        lblRStatus.setFont(new Font(24));
	        getChildren().add(lblRStatus);  

	       
	        hyperRegister.setLayoutX(305);
	        hyperRegister.setLayoutY(332);
	        hyperRegister.setPrefSize(60, 30);
	        
	        getChildren().add(hyperRegister);

	        

	        
	        lblMediBlock.setLayoutX(60);
	        lblMediBlock.setLayoutY(14);
	        lblMediBlock.setPrefSize(120, 35);  
	        lblMediBlock.setFont(new Font(24));
	        getChildren().add(lblMediBlock);

	        
	       
	        imageView.setLayoutX(14);
	        imageView.setLayoutY(14);
	        imageView.setFitWidth(38);
	        imageView.setFitHeight(35);
	        getChildren().add(imageView);
	    }

	    private void btnRegisterClicked() {
	        // Handle Register button click event
	        System.out.println("Register button clicked!");
	    }

	    private void hyperRegisterClicked() {
	        // Handle Hyperlink click event
	        System.out.println("Hyperlink clicked!");
	    }

}





//INSERT INTO `patient`(`username`, `email`, `password`) VALUES ('[value-1]','[value-2]','[value-3]')






////////////////





