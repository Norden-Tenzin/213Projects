package Project3.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class HelloWorld extends Application {
    @Override 
   public  void start (Stage primaryStage) {
        try {
           FXMLLoader fxmlLoader = new FXMLLoader (getClass (). getResource ( "View.fxml" ));
           Parent root = (Parent) fxmlLoader.load ();
           Scene scene = new Scene (root);

           primaryStage.setTitle ( "test-Window" );
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
 * 1. Add valid error messages
 * 2. Prompt user for file
 * 3. Javadoc - V last
 * 4. Comments
 * 5. Process payment - T
 * 6. Export
 * 7. Testing doc
 * 8. RadioButton toggleGroup - T
 * 
 */