package acsse.csc03a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;  

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewRecordPane<T> extends AnchorPane{
	
	private Button bbtnSave  = new Button("  Save  ");;
    private Button bbtnCancel  = new Button("  Cancel  ");;
    private Label lblName = new Label("Name:");
    private Label lblGender;
    private Label lblAge;
    //so store them values here and check for validity to ensure all is well;
    
    private Label lblAllergy;
    private Label lblDiagnosis;  
    private Label lblDateTime;
    private Label lblAddress;
    
     TextField txtName = new TextField(); 
     TextField txtGender = new TextField( );  
     TextField txtAge = new TextField( );
     TextField  txtAllergy = new TextField( );
     TextField  txtDiagnosis = new TextField( );  
     TextField txtPhoneNumber = new TextField();
     TextField txtBlood_Type = new TextField( );
     
     TextField txtDateTime = new TextField();
    Label lblAllergies = new Label("Allergies");
    
    
    TextField txtAddress = new TextField(  );  
    Label lblMediBlock = new Label("MediBlock");
    ImageView imageView = new ImageView("logo.jpeg");
	 
    Transaction<String> data;
    
    PatientDashBoardPane<T> patientboard; 
    TabPane tabpane = new TabPane();
    
    Scene scene;    
    Stage stage = new Stage();
    
    
     
  	 Stage secondaryscene = new Stage();
  	 NewRecordPane<T> newrecordpane;   
  	 
  	 TilePane tilepane = new TilePane();
  
  	  ObservableList<String> observeitems = FXCollections.observableArrayList();
  	  ListView<String> listview = new ListView<String>(observeitems);
  	  Alert alert = new Alert(AlertType.INFORMATION);    
  	   
  	 public NewRecordPane() {
  	 }
  
	public NewRecordPane( PatientDashBoardPane<T> patientboard ) {
        this.patientboard = patientboard;
        this.setStyle("-fx-background-color: #ADD8E6;");
		SetUpNewRecordPaneUI();
		tilepane.setPadding(new Insets(10));
		tilepane.setHgap(10);
		tilepane.setVgap(10);   
		
		//**********************************
		  txtName.setPromptText("Name:");
	      txtGender.setPromptText("Gender:");
	       txtAge.setPromptText("Age:"); 
	       txtAllergy.setPromptText("Allergy:");
	      txtDiagnosis.setPromptText("Diagnosis"); 
	      txtPhoneNumber.setPromptText("Phone Number");
	      txtBlood_Type.setPromptText("Blood Type:"); 
	      txtAddress.setPromptText("Address:");
		
		//***********************************
		
		

		alert.setTitle("Patient Data Status");
		 
		bbtnSave.setOnAction(e->{
			//Button click will ensure data is inserted/written to the database and hence transaction properties will be set
			String name = txtName.getText();
		    String gender = txtGender.getText();
		    int age = Integer.parseInt(txtAge.getText());
		    String allergies = txtAllergy.getText();
		    String diagnosis = txtDiagnosis.getText();
		    String bloodtype = txtBlood_Type.getText();
			String phonenumber = txtPhoneNumber.getText();  
			String address = txtAddress.getText();
		    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis()); // Current date and time
		    
		    try {    
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
		         
		        String insertQuery = "INSERT INTO storepatient (Name, Gender, Age, Blood_Type, Allergy, Diagnosis,Phone_Number, Address, Date_Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement insertStatement = connect.prepareStatement(insertQuery);
		        insertStatement.setString(1, name);  
		        insertStatement.setString(2, gender);   
		        insertStatement.setInt(3, age);             
				insertStatement.setString(4, bloodtype);
		        insertStatement.setString(5, allergies);           
		        insertStatement.setString(6, diagnosis);
		        insertStatement.setString(7, phonenumber);
		        insertStatement.setString(8, address);  
		        insertStatement.setTimestamp(9, currentTimestamp); // Set timestamp using the current date and time
		        
		        int rowsAffected = insertStatement.executeUpdate();
		        String insertedData = "Name: " + name + ", Gender: " + gender + ", Age: " + age + ", Blood Type: " + bloodtype + ", Allergies: " + allergies + ", Diagnosis: " + diagnosis + ", Phone: " + phonenumber + ", Address: " + address + ", Date Time: " + currentTimestamp;
                
		        
		        @SuppressWarnings("unchecked")
				T recordData = (T) insertStatement.toString();  
		         
		        
		        if (rowsAffected > 0) {
		            System.out.println("Patient data inserted successfully.");
		            
		            
		            data = new Transaction<String>("Sender", "Reciever", insertedData);
			        data.setData((String) recordData); 
		               
			        String titlez = txtName.getText();
			        observeitems.add(titlez);
			        listview.setItems(FXCollections.observableArrayList(observeitems));
			        
			                        
			        patientboard.handleNewTopicAdded(titlez);
			        
			        alert.setTitle("Record Status");
			        alert.setHeaderText("Successful");  
			        alert.setAlertType(AlertType.CONFIRMATION);
			        alert.setContentText("Record Added");
			        alert.showAndWait();
		        } else {  
		            System.out.println("Failed to insert patient data. Please try again later.");
		        }  
		        
		        connect.close();  
		    } catch (Exception ex) {
		        ex.printStackTrace();    
		    }
		    
		    stage = (Stage) bbtnSave.getScene().getWindow();
		    stage.close();
			
		});
 
		bbtnCancel.setOnAction( e->{
			
			txtAddress.clear();
	    	 txtAge.clear();
	    	 txtAllergy.clear();
	    	 txtPhoneNumber.clear();
	    	 txtDiagnosis.clear();
	    	 txtGender.clear();
	    	 txtName.clear();
	    	 
	    	 stage = (Stage) bbtnCancel.getScene().getWindow();
	    	 
	    	 stage.close();
		});
	}
	public void SetUpNewRecordPaneUI() {
		 
        lblGender = new Label("Gender:");
        lblAge = new Label("Age:");
        lblAllergy = new Label("Blood Type:");
        lblDiagnosis = new Label("Diagnosis:");
        lblDateTime = new Label("Phone Number:");
        lblAddress = new Label("Address:");
        
        
         
        lblMediBlock.setLayoutX(43);
        lblMediBlock.setLayoutY(6);  
        lblMediBlock.setPrefSize(110, 30);  
        lblMediBlock.setFont(new Font(18));

        // Set layout positions for elements
        AnchorPane.setLeftAnchor(bbtnSave, 246.0);
        
        bbtnSave.setPrefSize( 120.0, 40.0 );  
        bbtnCancel.setPrefSize( 120.0, 40.0 ); 
        
        
        AnchorPane.setTopAnchor(bbtnSave, 348.0);
        AnchorPane.setLeftAnchor(bbtnCancel, 43.0);
        AnchorPane.setTopAnchor(bbtnCancel, 348.0);
        AnchorPane.setLeftAnchor(lblName, 43.0);
        AnchorPane.setTopAnchor(lblName, 33.0);
        AnchorPane.setLeftAnchor(lblGender, 43.0);  
        AnchorPane.setTopAnchor(lblGender, 70.0);
        AnchorPane.setLeftAnchor(lblAge, 43.0);
        AnchorPane.setTopAnchor(lblAge, 107.0);
        AnchorPane.setLeftAnchor(lblAllergy, 43.0);
        AnchorPane.setTopAnchor(lblAllergy, 143.0);
        AnchorPane.setLeftAnchor(txtBlood_Type, 149.0);
        AnchorPane.setTopAnchor(txtBlood_Type, 143.0); 
        AnchorPane.setLeftAnchor(txtName, 149.0);
        AnchorPane.setTopAnchor(txtName, 33.0);
        AnchorPane.setLeftAnchor(txtGender, 149.0);
        AnchorPane.setTopAnchor(txtGender, 70.0);
        AnchorPane.setLeftAnchor(txtAge, 149.0);
        AnchorPane.setTopAnchor(txtAge, 107.0);
        
        AnchorPane.setLeftAnchor(lblDiagnosis, 43.0);
        AnchorPane.setTopAnchor(lblDiagnosis, 215.0);
        AnchorPane.setLeftAnchor(lblDateTime, 43.0);
        AnchorPane.setTopAnchor(lblDateTime, 257.0);
        
        
        AnchorPane.setLeftAnchor(lblAddress, 43.0);
        AnchorPane.setTopAnchor(lblAddress, 301.0);

          
           
        AnchorPane.setLeftAnchor(txtDiagnosis, 151.0);
        AnchorPane.setTopAnchor(txtDiagnosis, 218.0);
           
        AnchorPane.setLeftAnchor(txtPhoneNumber, 149.0);
        AnchorPane.setTopAnchor(txtPhoneNumber, 257.0);
           
        
        AnchorPane.setLeftAnchor(lblAddress, 43.0);
        AnchorPane.setTopAnchor(lblAddress, 301.0);
        AnchorPane.setLeftAnchor(txtAddress, 149.0);
        AnchorPane.setTopAnchor(txtAddress, 299.5);
         
     
        
        AnchorPane.setLeftAnchor(lblAllergies, 43.0);
        AnchorPane.setTopAnchor(lblAllergies, 180.0);
        AnchorPane.setLeftAnchor(txtAllergy, 149.0);  
        AnchorPane.setTopAnchor(txtAllergy, 180.5);
  
        imageView.setLayoutX(2);
        imageView.setLayoutY(2);
        imageView.setFitWidth(38);
        imageView.setFitHeight(35);
        
        getChildren().addAll(bbtnSave,lblAllergies, bbtnCancel,txtBlood_Type,  lblMediBlock,  lblName, lblGender, lblAge, lblAllergy, lblDiagnosis, lblDateTime, lblAddress, 
                             txtName, txtAddress,  txtGender, txtAge, txtAllergy, txtDiagnosis, txtPhoneNumber, imageView);	
	}   
	
	
	
}
