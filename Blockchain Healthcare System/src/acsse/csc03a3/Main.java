/**
 * 
 */
package acsse.csc03a3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**  
 *   
 */
public class Main<T> extends Application{

	/**          
	 * @param args  
	 */   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
     
	}             
	
          
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub  
		  
		  OpenerPane<T> grip = new OpenerPane<>();
		 
		  Scene scene= new Scene(grip, 450, 425);  
		  primaryStage.setScene(scene); 
		  primaryStage.show();   
	}

}
     