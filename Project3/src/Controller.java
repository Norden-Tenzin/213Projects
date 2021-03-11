package Project3.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;

public class Controller {
  private PayrollProcessing pp = new PayrollProcessing();

  @FXML
  private TabPane mangeEmployees_TabPane;

  @FXML
  private AnchorPane addPane;

  // Variables for add:
  @FXML
  private Tab addTab;

  @FXML
  private ButtonBar managerTypeButtonBar;

  @FXML
  private RadioButton managerTypeSelect_MNGR;

  @FXML
  private RadioButton managerTypeSelect_DH;

  @FXML
  private RadioButton managerTypeSelect_Dir;

  @FXML
  private TextField lastName_Input_add;

  @FXML
  private TextField firstName_Input_add;

  @FXML
  private RadioButton departmentSelect_CS_add;

  @FXML
  private RadioButton departmentSelect_ECE_add;

  @FXML
  private RadioButton departmentSelect_IT_add;

  @FXML
  private ButtonBar departmentButtonBar_add;

  @FXML
  private ButtonBar employeeButtonBar_add;

  @FXML
  private DatePicker dateHired_Input_add;

  @FXML
  private RadioButton employeeTypeSelect_MNGR_add;

  @FXML
  private RadioButton employeeTypeSelect_FT_add;

  @FXML
  private RadioButton employeeTypeSelect_PT_add;

  @FXML
  private TextField hourlyRate_Input;

  // Variables for remove:
  @FXML
  private Tab removeTab;

  @FXML
  private ButtonBar departmentButtonBar_RMV;

  @FXML
  private ButtonBar employeeButtonBar_RMV;

  @FXML
  private TextField lastName_Input_rmv;

  @FXML
  private TextField firstName_Input_rmv;

  @FXML
  private RadioButton departmentSelect_CS_rmv;

  @FXML
  private RadioButton departmentSelect_ECE_rmv;

  @FXML
  private RadioButton departmentSelect_IT_rmv;

  @FXML
  private DatePicker dateHired_Input_rmv;

  @FXML
  private RadioButton employeeTypeSelect_MNGR_rmv;

  @FXML
  private RadioButton employeeTypeSelect_FT_rmv;

  @FXML
  private RadioButton employeeTypeSelect_PT_rmv;

  // Variables for Set Hours:
  @FXML
  private Tab setHoursTab;

  @FXML
  private ButtonBar departmentButtonBar_SH;

  @FXML
  private TextField lastName_Input_sh;

  @FXML
  private TextField firstName_Input_sh;

  @FXML
  private RadioButton departmentSelect_CS_sh;

  @FXML
  private RadioButton departmentSelect_ECE_sh;

  @FXML
  private RadioButton departmentSelect_IT_sh;

  @FXML
  private DatePicker dateHired_Input_sh;

  @FXML
  private TextField numHours_Input;

  // Submit button
  @FXML
  private Button submit;

  // process payment button
  @FXML
  private Button processPayment;

  // error message output:
  @FXML
  private TextArea messageOuput;

  // For print by department etc output:
  @FXML
  private TextArea printOutput;

  // print buttons:
  @FXML
  private Button viewAll_Button;

  @FXML
  private Button viewDateHired_Button;

  @FXML
  private Button viewDepartment_Button;

  // import/export buttons:
  @FXML
  private Button uploadFile_Button;

  @FXML
  private Button submitImport;

  // message box for import:
  @FXML
  private TextArea importOutput;

  // export variables:
  @FXML
  private Button export_Button;

  @FXML
  private TextArea exportOutput;

  // functions:

  @FXML
  void disableDepartmentSelect(ActionEvent event) {
    if(departmentSelect_CS_add.isSelected()){
      departmentSelect_ECE_add.setDisable(true);
      departmentSelect_IT_add.setDisable(true);
    }
  }

  @FXML
  void disableEmployeeSelect(ActionEvent event) {

  }

  @FXML
  void onExportSubmit(ActionEvent event) {

  }

  @FXML
  void onFileSubmit(ActionEvent event) {

  }

  @FXML
  void onFileUpload(ActionEvent event) {

  }

  // process payment
  @FXML
  void onProcessPayment(ActionEvent event) {

  }

  // add, remove, set hours
  @FXML
  void onSubmit(ActionEvent event) {
    String input = "";
    String command = "";
    String department = "";
    String firstName = firstName_Input_add.getText();
    String lastName = lastName_Input_add.getText();
    String dateHired = dateHired_Input_add.getValue().toString();
    String hourlyRate = hourlyRate_Input.getText();
    if(departmentSelect_CS_add.isSelected()) department = "CS";
    else if(departmentSelect_ECE_add.isSelected()) department = "ECE";
    else if(departmentSelect_IT_add.isSelected()) department = "IT";

    if(employeeTypeSelect_MNGR_add.isSelected()) command = "AM";
    else if(employeeTypeSelect_FT_add.isSelected()) command = "AF";
    else if(employeeTypeSelect_PT_add.isSelected()) command = "AP";

    int tabIndex = mangeEmployees_TabPane.getSelectionModel().getSelectedIndex();
    switch(tabIndex){
      case 0: 
        input = command + " " + lastName + "," + firstName + " " + department + " " + dateHired + " " + hourlyRate;
        break;
    }
    pp.run(input);
  }

  //for printing
  @FXML
  void onViewAll(ActionEvent event) {

  }

  @FXML
  void onViewDateHired(ActionEvent event) {

  }

  @FXML
  void onViewDepartment(ActionEvent event) {

  }

  @FXML
  public void initialize() {
      System.out.println("mother fucker");
      // pp.run();
  }
}
