package Project3.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestUI {

    @FXML
    private Label bigLabel;

    @FXML
    private Button bigButton;

    @FXML
    void onClick(ActionEvent event) {
      System.out.println("YO");
      bigLabel.setText("Butt");
    }

}
