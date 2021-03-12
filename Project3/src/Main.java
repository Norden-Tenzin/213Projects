package Project3.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class extends Application. It holds the start method used to run Javafx.
 * Its the place where we specify the fxml file used for the Javafx ui.
 * 
 * @Tenzin Norden, @Vedant Mehta
 */
public class Main extends Application {

    /**
     * Overridden start method which is where we choose the fxml file, the title and
     * make edits to PrimaryStage. Its used to run the JavaFx.
     *
     * @param primaryStage Stage object
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Payroll Processing");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to run the launch method which Main extends from Application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * TODO:
 * 
 * 3. Javadoc - V last 4. Comments 7. Testing doc 8. RadioButton toggleGroup - T
 */