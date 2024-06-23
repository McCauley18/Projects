package acsse.csc03a3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPane<T> extends AnchorPane {

	private Button btnLogin = new Button("Login");
	private Label lblMediBlock = new Label("MediBlock");
	Label lblLogin = new Label("Patient Login");
    private Label lblLStatus = new Label("Status");
      
    //txtPassword = new TextField();
     TextField  txtUsername = new TextField();
     PasswordField txtPassword = new PasswordField();
    Label lblUsername = new Label("Username:");
    Label lblNotRegistered = new Label("Not a Registered User?");
    Label lblPassword = new Label("Password:");
    
    ImageView imageView = new ImageView("logo.jpeg");  
    
    Hyperlink hyperLogin = new Hyperlink("Register");
      
    RegisterPane<T> registerpane;
    DoctorDashBoardPane<T> doctordashboardlogin; // = new DoctorDashBoardPane();
	 //Special Stuff
	 Stage secondaryscene = new Stage();
	   
	 // End of special
	 
	 PatientDashBoardPane<T> patientdashboard;
	 
	 List<Transaction<T>> transactions;
    public LoginPane() {
    	Login();  
    	 this.setStyle("-fx-background-color: #ADD8E6;");
    	  txtUsername.setPromptText("Username:");
         txtPassword.setPromptText("Password:");
    	btnLogin.setOnAction(event -> {
    		try {
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
        		Statement statement = connect.createStatement();
        		String sqlstrin = "Select * from patient where Username='"+txtUsername.getText()+ "'";
        		ResultSet result = statement.executeQuery(sqlstrin);
        		if( result.next()) {  
        			String storedHashedPassword = result.getString("Password");
                    String inputPassword = txtPassword.getText();
                    String hashedInputPassword = hashPassword(inputPassword);
        			
                    if (storedHashedPassword.equals(hashedInputPassword)) {
                        patientdashboard = new PatientDashBoardPane<T>();
                        Scene scene = new Scene(patientdashboard, 350, 450);
                        secondaryscene.setScene(scene);
                        secondaryscene.show();
                        System.out.println("Login Successfully");
                        lblLStatus.setText("Successful login");
                        lblLStatus.setStyle("-fx-text-fill: green;");
                    } else {
                        System.out.println("Incorrect credentials");
                        lblLStatus.setText("Incorrect credentials");
                        lblLStatus.setStyle("-fx-text-fill: red;");
                    }
        			
        		}else {
        			System.out.println("User is not found");
        			lblLStatus.setText("Incorrect credentials");
        			lblLStatus.setStyle("-fx-text-fill: red;");
        		}
        		connect.close();
        		
        	}catch(Exception ret) {
        		ret.printStackTrace();
        	}
  
    	});
    	
    	hyperLogin.setOnAction( e->{
    		
    		registerpane = new RegisterPane<T>();
    		Scene scene = new Scene(registerpane, 500, 450);
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
 
    
    public void Login() {
    	
    	hyperLogin.setLayoutX(305);
    	hyperLogin.setLayoutY(319);
    	hyperLogin.setPrefSize(60, 30);
             
        btnLogin.setLayoutX(194.0);
        btnLogin.setLayoutY(241.0);
        btnLogin.setPrefHeight(40.0);
        btnLogin.setPrefWidth(200.0);
          
        lblMediBlock.setLayoutX(60.0);
        lblMediBlock.setLayoutY(14.0);
        lblMediBlock.setPrefHeight(35.0);
        lblMediBlock.setPrefWidth(120.0);
        lblMediBlock.setFont(new Font(24.0));

          
        lblLogin.setLayoutX(200.0);
        lblLogin.setLayoutY(59.0);
        lblLogin.setPrefHeight(46.0);
        lblLogin.setPrefWidth(141.0);
        lblLogin.setFont(new Font(24.0));

        
        lblUsername.setLayoutX(36.0);
        lblUsername.setLayoutY(121.0);
        lblUsername.setPrefHeight(34.0);
        lblUsername.setPrefWidth(82.0);
 
        lblLStatus.setLayoutX(200.0);
        lblLStatus.setLayoutY(360.0);
        lblLStatus.setPrefHeight(46.0);
        lblLStatus.setPrefWidth(270.0);
        lblLStatus.setFont(new Font(24.0));

       
        lblNotRegistered.setLayoutX(157.0);
        lblNotRegistered.setLayoutY(319.0);
        lblNotRegistered.setPrefHeight(35.0);
        lblNotRegistered.setPrefWidth(150.0);
        lblNotRegistered.setFont(new Font(14.0));

        
        lblPassword.setLayoutX(36.0);
        lblPassword.setLayoutY(173.0);
        lblPassword.setPrefHeight(34.0);
        lblPassword.setPrefWidth(82.0);

       
        txtUsername.setLayoutX(151.0);
        txtUsername.setLayoutY(121.0);
        txtUsername.setPrefHeight(35.0);
        txtUsername.setPrefWidth(242.0);

        
        txtPassword.setLayoutX(151.0);
        txtPassword.setLayoutY(173.0);
        txtPassword.setPrefHeight(35.0);
        txtPassword.setPrefWidth(242.0);

        imageView.setLayoutX(14);
        imageView.setLayoutY(14);
        imageView.setFitWidth(38);
        imageView.setFitHeight(35);
        

        getChildren().addAll(hyperLogin, btnLogin, lblMediBlock,imageView, lblLogin, lblUsername, lblLStatus, lblNotRegistered, lblPassword, txtUsername, txtPassword);
    }

}
