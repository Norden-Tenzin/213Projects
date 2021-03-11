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

public class Controller {

  @FXML
  private TabPane mangeEmployees_TabPane;


  //Variables for add:
  @FXML
  private Tab addTab;

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
  private DatePicker dateHired_Input_add;

  @FXML
  private RadioButton employeeTypeSelect_MNGR_add;

  @FXML
  private RadioButton employeeTypeSelect_FT_add;

  @FXML
  private RadioButton employeeTypeSelect_PT_add;

  @FXML
  private TextField hourlyRate_Input;



  //Variables for remove:
  @FXML
  private Tab removeTab;

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


  //Variables for Set Hours:
  @FXML
  private Tab setHoursTab;

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


  //Submit button
  @FXML
  private Button submit;

  //process payment button
  @FXML
  private Button processPayment;

  //error message output:
  @FXML
  private TextArea messageOuput;

  // For print by department etc output:
  @FXML
  private TextArea printOutput;

  //print buttons:
  @FXML
  private Button viewAll_Button;

  @FXML
  private Button viewDateHired_Button;

  @FXML
  private Button viewDepartment_Button;

  //import/export buttons:
  @FXML
  private Button uploadFile_Button;

  @FXML
  private Button submitImport;

  //message box for import:
  @FXML
  private TextArea importOutput;

  //export variables:
  @FXML
  private Button export_Button;

  @FXML
  private TextArea exportOutput;

  // functions:

  @FXML
  void onExportSubmit(ActionEvent event) {

  }

  @FXML
  void onFileSubmit(ActionEvent event) {

  }

  @FXML
  void onFileUpload(ActionEvent event) {

  }


  //process payment
  @FXML
  void onProcessPayment(ActionEvent event) {

  }

  // add, remove, set hours
  @FXML
  void onSubmit(ActionEvent event) {

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

}
