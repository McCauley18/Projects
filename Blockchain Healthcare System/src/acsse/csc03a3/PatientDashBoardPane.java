package acsse.csc03a3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PatientDashBoardPane<T> extends AnchorPane implements Runnable  {
	OutputStream os;
	InputStream is;
	Alert alert = new Alert(AlertType.INFORMATION);
	Socket socket = new Socket();
	
	Transaction<T> transact;
	   
	    private TextField txtOne = new TextField("Where you at TxtOne");
	    private TextField txtTwo = new TextField("Where you at TxtTwo");
	    Button btnNewRecord = new Button(" New Record ");
	    
	    Button btnLogout = new Button("  Log Out  ");
         
	    Label lblMediBlock = new Label("MediBlock");
	    
	    DoctorDashBoardPane<T> doctorpane;
	    
	    DoctorLoginPane<T> doctorlogin;
	    
        Button btnSendtoDoctor = new Button("Send to Doctor");
        Scene scenez;
        //Special Stuff    
   	   Stage secondaryscene = new Stage();
   	   NewRecordPane<T> newrecordpane ;    
   	 // End of special
   	 TabPane tabpane = new TabPane();   
   	 ImageView imageView= new ImageView("logo.jpeg");
   	 
   	 ListView<String> listview = new ListView<String>();
   	 ObservableList<String> observeitems = FXCollections.observableArrayList();
	   	
  
	public PatientDashBoardPane() {  
		SetUpPatientDashBoardPaneUI();
		 this.setStyle("-fx-background-color: #ADD8E6;");
		btnNewRecord.setOnAction(e->{		
			 this.setStyle("-fx-background-color: #ADD8E6;");
			newrecordpane = new NewRecordPane<>(this);
			Scene scene = new Scene(newrecordpane, 450, 450);
			secondaryscene.setScene(scene);
			secondaryscene.show();
			
		});
   
		
		listview.setOnMouseClicked(e->{  
			if (e.getClickCount() ==2 ) {
				String selectedListItem = listview.getSelectionModel().getSelectedItem();
	            System.out.println(selectedListItem);
	            if (selectedListItem != null) {
	                // Assuming you have a method named displayDetails in ViewRecordPane to display details
	            	displayDetails(selectedListItem);
	                //secondaryscene.show();
	                
//	                viewrecordpane = new ViewRecordPane();
//	    			scenez = new Scene(viewrecordpane, 450, 450);
//	    		    secondaryscene.setScene(scenez);
//	    		    secondaryscene.show();  
	            }  
			}
		    
		      
		});     
		
		
		
		 
		
		btnSendtoDoctor.setOnAction(e->{
			doctorlogin = new DoctorLoginPane<>();
			
			scenez = new Scene(doctorlogin, 500, 500);
			secondaryscene.setScene(scenez);
			secondaryscene.show();
			
			
			
		});
		
		btnLogout.setOnAction( e->{
			secondaryscene = (Stage) btnLogout.getScene().getWindow();
			secondaryscene.close();
		});
		
		
		
		
	}
	
	 
	
	//*****************************************//
  	public void displayDetails(String selectedName) {
        // Retrieve details from the database based on the selected name and display them
        // Example code to retrieve and display details from the database
  		try {
  	        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
  	        String query = "SELECT * FROM storepatient WHERE Name =?";
  	        PreparedStatement statement = connect.prepareStatement(query);
  	        statement.setString(1, selectedName);
  	        ResultSet resultSet = statement.executeQuery();
  	        if (resultSet.next()) {  
  	            int age = resultSet.getInt("Age");
  	            String name = resultSet.getString("Name");
  	            String gender = resultSet.getString("Gender");
  	            String bloodtype = resultSet.getString("Blood_Type");
  	            String allergies = resultSet.getString("Allergy");
  	            String diagnosis = resultSet.getString("Diagnosis");
  	            String phonenumber = resultSet.getString("Phone_Number");
  	            String address = resultSet.getString("Address");
  	            Timestamp dateTime = resultSet.getTimestamp("Date_Time");

  	            // Assign fetched values to respective text fields
  	            alert.setHeaderText( name + " : " +  "Record");
  	            alert.setTitle("Patient Record");
  	            alert.setContentText( "\n" + "Name: " + name + "\n" + "Gender: " + gender + "\n"+ "Age: " + age + "\n"+ "Blood Type: " + bloodtype+ "\n" + "Allergy: " + allergies+ "\n"+ "Diagnosis: " + diagnosis + "\n" + "Phone Number: " + phonenumber+ "\n"+ "Address: " + address+ "\n" + "Date And Time: " + dateTime + "\n" );
                alert.showAndWait();
  	            
  	             
  	        } else {
  	            System.out.println("No record found for the selected name.");
  	        }
  	        connect.close();
  	    } catch (SQLException ex) {
  	        ex.printStackTrace();
  	    }
    }
	//****************************************//
	
	 public void setTransaction(Transaction<T> transaction) {
	        this.transact = transaction; 
	    }
	

	
	public void handleNewTopicAdded(String newTopic) {
        // Add the new topic to the listview
        observeitems.add(newTopic);
        listview.setItems(observeitems);
    }  
	
	
	public ObservableList<String> getItems() {
	    return observeitems;
	}  
	   
	 
    public void addItemToListView(String item) {
        observeitems.add(item);
    }  
    
	
	public void SetUpPatientDashBoardPaneUI() {
		
		 lblMediBlock.setLayoutX(60);
	        lblMediBlock.setLayoutY(14);
	        lblMediBlock.setPrefSize(120, 35);  
	        lblMediBlock.setFont(new Font(24));
	         
	        imageView.setLayoutX(14);
	        imageView.setLayoutY(14);
	        imageView.setFitWidth(38);
	        imageView.setFitHeight(35);
	       
		listview.setLayoutX(15.0);  
		listview.setLayoutY(56.0);
		listview.setPrefHeight(328.0);  
		listview.setPrefWidth(300.0);
	 
        txtOne.setLayoutX(29.0);
        txtOne.setLayoutY(132.0);
 
        txtTwo.setLayoutX(147.0);
        txtTwo.setLayoutY(217.0);

       
        btnNewRecord.setLayoutX(222.0);
        btnNewRecord.setLayoutY(14.0);
         
        btnLogout.setLayoutX(14.0);
        btnLogout.setLayoutY(394.0);
            
        btnSendtoDoctor.setLayoutX(220.0);
        btnSendtoDoctor.setLayoutY(394.0);
        
          
        
        
        getChildren().addAll(btnSendtoDoctor, tabpane, listview , lblMediBlock, btnNewRecord, btnLogout, imageView);
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	 
		
		

        	 
        	 
        	
        	 
			


	
}
