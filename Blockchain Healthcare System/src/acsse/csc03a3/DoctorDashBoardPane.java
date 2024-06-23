package acsse.csc03a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DoctorDashBoardPane<T> extends AnchorPane {
	   
	private Button btnLogout = new Button("Log Out");
    private TextField txtSearch = new TextField( );
    private TextArea txtViewArea = new TextArea();  
    private Button btnSearch = new Button("Search");
    private Button btnView = new Button("View");
      
    
    Label lblLogo = new Label("Logo");
	      
    NewRecordPane<T> newrecordpane;  
    Blockchain<T> blockchain = new Blockchain<>();
	Transaction<T> Onetransaction;
	Block<T> block ;   
	
	Label lblMediBlock = new Label("MediBlock");
	ImageView imageView = new ImageView("logo.jpeg");
	
	StatisticsGraph<T> statz; // = new StatisticsGraph<>();
	
	Button btnStats = new Button("Statistics");
    //Special Stuff
	 Stage secondaryscene = new Stage();
	   
	 Scene scenez;
	 // End of special
	 
	 Alert alert = new Alert(AlertType.INFORMATION);
	 
	String receiver = "Lucas";
	
	 List<Transaction<T>> listtransaction = new ArrayList<>(); // = new List<Transaction<T>>();
	  
	 public DoctorDashBoardPane(Transaction<T> tracy) {
		 this.Onetransaction = tracy;
	 }
	public DoctorDashBoardPane() {
		SetUpDashBoardUI();
		 
		 this.setStyle("-fx-background-color: #ADD8E6;");
		txtSearch.setPromptText("Search: ");
		// Initialize block here
        block = new Block<>("", listtransaction);
		
		newrecordpane  = new NewRecordPane<>();  
		
		Onetransaction = new Transaction<>("", "", (T)  newrecordpane.data); // Null initially
		
		btnSearch.setOnAction(e -> {  
			                                                   
			 String txtSearchName = txtSearch.getText();
			 if(!txtSearchName.isEmpty()){
				 try {
					if(verifyNameExistanct(txtSearchName)) {
						 txtViewArea.setText("Record of Patient: " + txtSearchName + " exist." + "\n" + "View Now");
					 }else {
						 txtViewArea.setText("Record of Patient: " + txtSearchName + " does not exist.");
						  
					 }
				} catch (ClassNotFoundException exe) {
					// TODO Auto-generated catch block
					exe.printStackTrace();    
				}  
			 }else
			 {
				    alert.setHeaderText("Message: ");
				    alert.setContentText("Please enter a name to search.");
				    alert.showAndWait();
		      
			 }
			  
		 });  
		 
		 
		 btnView.setOnAction(e->{
			 
			 //Search for record and display respective message
			 String SearchNameFound = txtSearch.getText().trim();
			 if(!SearchNameFound.isEmpty()) {
				 displayDetails(SearchNameFound);
			 }else {
				    alert.setContentText("Please enter a name to view.");
		            alert.showAndWait();       
			 }   
			  
			 System.out.println(  retrieveBlocksFromDatabase() );
			 
			      
		 });
		 
		 btnStats.setOnAction(  e->{
			 try {
				statz = new StatisticsGraph<>();
				scenez = new Scene(statz);
				 secondaryscene.setScene(scenez);
				 secondaryscene.show();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 });
		 
		 
		 btnLogout.setOnAction( e->{
			 secondaryscene = (Stage) btnLogout.getScene().getWindow();
	    	 
			 secondaryscene.close();
		 });
		 
		 
		
	} 
	
	public boolean verifyNameExistanct(String strName) throws ClassNotFoundException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
			  
	        String query = "SELECT * FROM storepatient WHERE Name =?";
	        PreparedStatement statement = connect.prepareStatement(query);
	        statement.setString(1, strName);
	        ResultSet resultSet = statement.executeQuery();
	        return resultSet.next(); // If next() returns true, the name exists in the database
			
		}catch(SQLException sql) {
			sql.printStackTrace();
			return false;
		}
	}
	  
	@SuppressWarnings("unchecked")
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
 
  	          Onetransaction.setSender(name);
  	          Onetransaction.setReceiver(receiver); 
  	            
  	            String strData =  "Name: " + name + "\n" + "Gender: " + gender + "\n"+ "Age: " + age + "\n"+ "Blood Type: " + bloodtype+ "\n" + "Allergy: " + allergies+ "\n"+ "Diagnosis: " + diagnosis + "\n" + "Phone Number: " + phonenumber+ "\n"+ "Address: " + address+ "\n" + "Date And Time: " + dateTime + "\n";
  	            Onetransaction.setData((T) strData);
  	             
  	          addTransactionBlockToChain(Onetransaction);  
  	           
  	            alert.setHeaderText( name + " : " +  "Record");
  	            alert.setTitle("Patient Record");
  	            alert.setContentText("Sender: " + Onetransaction.getSender() + "\n" + "Receiver: " + Onetransaction.getReceiver() + "\n\n" + Onetransaction.getData() + "\n" );
                alert.showAndWait();
                saveBlocksToDatabase();
  	        } else {
  	            System.out.println("No record found for the selected name.");
  	        }
  	        connect.close();
  	    } catch (SQLException ex) {
  	        ex.printStackTrace();
  	    }	
    }
	
	public void addTransactionBlockToChain(Transaction<T> transaction) {
	    // Create an instance of your blockchain
	    listtransaction.add(transaction); 	
	     
         block = new Block<>(block.calculateHash() , listtransaction ); // = new Block<>(previousHash,  listtransaction );
         
         //Setting Nonce
         block.setNonce( hashCode());
	     //Get validator and set to previoushash() then register and finally add to addBlock()
	     String selectedValidator = block.getPreviousHash();
	     Random rand = new Random();
	     blockchain.registerStake(selectedValidator, rand.nextInt(100000)); // Register stake
	     boolean isChainValid = blockchain.isChainValid(); // Check validity of the chain

	     blockchain.addBlock(listtransaction);
	    
	    System.out.println("Chain Validity: " +  isChainValid);
	}
	
 
	public String retrieveBlocksFromDatabase() {
	    StringBuilder result = new StringBuilder();
	    try {
	        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
	        String selectQuery = "SELECT * FROM blockchainstorage";
	        PreparedStatement selectStatement = connect.prepareStatement(selectQuery);
	        ResultSet resultSet = selectStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            String blockData = resultSet.getString("blockchainz");
	            result.append(blockData).append("\n");
	        }  
	        
	        connect.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return result.toString();
	}
		
		
		 
	private void saveBlocksToDatabase() {
        try {
        	//Connect to database to write/Insert my blocks 
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
         
                String insertQuery = "INSERT INTO blockchainstorage (blockchainz) VALUES (?)";
                PreparedStatement insertStatement = connect.prepareStatement(insertQuery);
                insertStatement.setString(1, block.toString() );
                insertStatement.executeUpdate();
            connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
	public DoctorDashBoardPane(Blockchain<T> bchain) {
		this.blockchain = bchain;
	}
	
	public void SetUpDashBoardUI() {
		btnStats.setLayoutX(280.7);
		btnStats.setLayoutY(390.0);
		btnStats.setPrefHeight(30);
		btnStats.setPrefWidth(90);
		
		lblMediBlock.setLayoutX(60);
        lblMediBlock.setLayoutY(14);
        lblMediBlock.setPrefSize(120, 35);  
        lblMediBlock.setFont(new Font(24));
       
        imageView.setLayoutX(14);
        imageView.setLayoutY(14);
        imageView.setFitWidth(38);
        imageView.setFitHeight(35);
       
        btnLogout.setLayoutX(22.0);
        btnLogout.setLayoutY(390.0);
        
        
        btnLogout.setPrefHeight(30.0);
        btnLogout.setPrefWidth(90.0);

       
        lblLogo.setLayoutX(20.0);
        lblLogo.setLayoutY(19.0);
        lblLogo.setPrefHeight(26.0);
        lblLogo.setPrefWidth(60.0);

        
        txtSearch.setLayoutX(20.0);
        txtSearch.setLayoutY(53.0);
        txtSearch.setPrefHeight(34.0);
        txtSearch.setPrefWidth(358.0);

        
        txtViewArea.setLayoutX(20.0);  
        txtViewArea.setLayoutY(137.0);
        txtViewArea.setPrefHeight(233.0);
        txtViewArea.setPrefWidth(358.0);

        btnView.setLayoutX(210.0);
        btnView.setPrefHeight(26.0);  
        btnView.setPrefWidth(147.0);
        btnView.setLayoutY(95.0);
        
        
        btnSearch.setLayoutX(40.0);
        btnSearch.setLayoutY(95.0);
        btnSearch.setPrefHeight(26.0);
        btnSearch.setPrefWidth(147.0);
       

        getChildren().addAll(btnLogout, lblMediBlock,btnStats, imageView, lblLogo, btnView,  txtSearch, txtViewArea, btnSearch);
 	  
	}
}
