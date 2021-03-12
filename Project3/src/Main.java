package Project3.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class Main extends Application {
    @Override 
   public  void start (Stage primaryStage) {
        try {
           FXMLLoader fxmlLoader = new FXMLLoader (getClass (). getResource ( "View.fxml" ));
           Parent root = (Parent) fxmlLoader.load ();
           Scene scene = new Scene (root);
           primaryStage.setTitle ( "Payroll Processing" );
           primaryStage.setScene (scene);
           primaryStage.setResizable(false);
           primaryStage.show ();
       } catch (Exception e) {
           e.printStackTrace ();
       }
   }

   public  static  void main (String [] args) {
       launch (args);
   }
}

/**
 * TODO:
 * 
 * 3. Javadoc - V last
 * 4. Comments
 * 7. Testing doc
 * 8. RadioButton toggleGroup - T
 * 9. last name first name swap in UI
 */