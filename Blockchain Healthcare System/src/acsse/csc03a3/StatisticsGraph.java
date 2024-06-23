package acsse.csc03a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StatisticsGraph<T> extends AnchorPane  {
	
	
	//Graphical representation of data of Blood Type and Gender through a Barchart
	 private ObservableList<String> genders = FXCollections.observableArrayList();
	    private ObservableList<String> bloodTypes = FXCollections.observableArrayList();

	    
	    public StatisticsGraph() throws ClassNotFoundException {
	    	setUpGraph();
	    }
	         
	    public void setUpGraph() throws ClassNotFoundException {
	        retrieveDataFromDatabase();
	        this.setStyle("-fx-background-color: #ADD8E6;");
	     
	        CategoryAxis xAxis = new CategoryAxis();  
	        xAxis.setLabel("Category");
	       xAxis.setTickLabelFill(Color.GREEN);
	       

	        NumberAxis yAxis = new NumberAxis();
	        yAxis.setLabel("Number Scale");
	        yAxis.setTickLabelFill(Color.BLUE);
	         
	        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
	        barChart.setTitle("Gender and Blood Type Distribution");
	        
	        

	        XYChart.Series<String, Number> genderSeries = new XYChart.Series<>();
	        genderSeries.setName("Gender");
	           
	        XYChart.Series<String, Number> bloodTypeSeries = new XYChart.Series<>();
	        bloodTypeSeries.setName("Blood Type");

	        // Populate gender data
	        for (String gender : genders) {
	            genderSeries.getData().add(new XYChart.Data<>(gender, getCount(gender, "Gender")));
	        }

	        // Populate blood type data
	        for (String bloodType : bloodTypes) {
	            bloodTypeSeries.getData().add(new XYChart.Data<>(bloodType, getCount(bloodType, "Blood_Type")));
	        }
	        
	      
	        
             
	        barChart.getData().addAll(genderSeries, bloodTypeSeries);
	        
	      
	        getChildren().add(barChart);
	        
	    }  
	    
	    public void retrieveDataFromDatabase() throws ClassNotFoundException {
	        try {
	        	  
	        	Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctestproject", "root", "");
	            String sql = "SELECT Gender, Blood_Type FROM storepatient";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                genders.add(resultSet.getString("Gender"));
	                bloodTypes.add(resultSet.getString("Blood_Type"));
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    public int getCount(String value, String column) {
	        int count = 0;
	        if (column.equals("Gender")) {
	            for (String gender : genders) {
	                if (gender.equals(value)) {
	                    count++;
	                }
	            }
	        } else if (column.equals("Blood_Type")) {
	            for (String bloodType : bloodTypes) {
	                if (bloodType.equals(value)) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }

	     
}
