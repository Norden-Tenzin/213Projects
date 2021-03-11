package Project3.src;

import javax.swing.JRadioButton;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

  @FXML
  private Button resetButton;


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
  void disableManagerTypeSelect(ActionEvent event) {
      managerTypeButtonBar.setDisable(true);
  }

  @FXML
  void disableDepartmentSelect(ActionEvent event) {
    
    int tabIndex = mangeEmployees_TabPane.getSelectionModel().getSelectedIndex();
    switch(tabIndex){
      case 0: 
        departmentButtonBar_add.setDisable(true);
        break;
      case 1: 
        departmentButtonBar_RMV.setDisable(true);
        break;
      case 2: 
        departmentButtonBar_SH.setDisable(true);
        break;
    }
  }

  @FXML
  void disableEmployeeSelect(ActionEvent event) {
      if(employeeTypeSelect_MNGR_add.isSelected()){
        managerTypeButtonBar.setDisable(false);
      }
      int tabIndex = mangeEmployees_TabPane.getSelectionModel().getSelectedIndex();
      switch(tabIndex){
        case 0: 
          employeeButtonBar_add.setDisable(true);
          break;
        case 1: 
          employeeButtonBar_RMV.setDisable(true);
          break;
      }

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
    String[] output;
    String finalOutput = "";

    String input = "";
    String command = "";
    String department = "";
    String managerType = "";
    String firstName = firstName_Input_add.getText();
    String lastName = lastName_Input_add.getText();
    String dateHired = dateHired_Input_add.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    String hourlyRate = hourlyRate_Input.getText();

    if (departmentSelect_CS_add.isSelected())
      department = "CS";
    else if (departmentSelect_ECE_add.isSelected())
      department = "ECE";
    else if (departmentSelect_IT_add.isSelected())
      department = "IT";

    if (employeeTypeSelect_MNGR_add.isSelected())
      command = "AM";
    else if (employeeTypeSelect_FT_add.isSelected())
      command = "AF";
    else if (employeeTypeSelect_PT_add.isSelected())
      command = "AP";

    if (managerTypeSelect_MNGR.isSelected())
      managerType = "1";
    else if (managerTypeSelect_DH.isSelected())
      managerType = "2";
    else if (managerTypeSelect_Dir.isSelected())
      managerType = "3";

    int tabIndex = mangeEmployees_TabPane.getSelectionModel().getSelectedIndex();
    switch (tabIndex) {
    case 0:
      input = command + " " + lastName + "," + firstName + " " + department + " " + dateHired + " " + hourlyRate + " " + managerType;
      break;
    }
    output = pp.run(input);

    for (String str : output) {
      System.out.println(str);
      if (str != null) {
        finalOutput += str + "\n";
      }
    }
    messageOuput.setText(finalOutput);
  }

  // for printing
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
      managerTypeButtonBar.setDisable(true);
      // pp.run();
  }

  @FXML
  void resetData(ActionEvent event) {
    lastName_Input_add.clear();
    lastName_Input_rmv.clear();
    lastName_Input_sh.clear();

    firstName_Input_add.clear();
    firstName_Input_rmv.clear();
    firstName_Input_sh.clear();
 
    dateHired_Input_add.getEditor().clear();
    dateHired_Input_rmv.getEditor().clear();
    dateHired_Input_sh.getEditor().clear();

    departmentSelect_CS_add.setSelected(false);
    departmentSelect_CS_rmv.setSelected(false);
    departmentSelect_CS_sh.setSelected(false);

    departmentSelect_ECE_add.setSelected(false);
    departmentSelect_ECE_rmv.setSelected(false);
    departmentSelect_ECE_sh.setSelected(false);

    departmentSelect_IT_add.setSelected(false);
    departmentSelect_IT_rmv.setSelected(false);
    departmentSelect_IT_sh.setSelected(false);

    employeeTypeSelect_FT_add.setSelected(false);
    employeeTypeSelect_FT_rmv.setSelected(false);

    employeeTypeSelect_PT_add.setSelected(false);
    employeeTypeSelect_PT_rmv.setSelected(false);

    employeeTypeSelect_MNGR_add.setSelected(false);
    employeeTypeSelect_MNGR_rmv.setSelected(false);

    managerTypeSelect_MNGR.setSelected(false);
    managerTypeSelect_DH.setSelected(false);
    managerTypeSelect_Dir.setSelected(false);

    managerTypeButtonBar.setDisable(true);
    departmentButtonBar_add.setDisable(false);
    departmentButtonBar_RMV.setDisable(false);
    departmentButtonBar_SH.setDisable(false);
    employeeButtonBar_add.setDisable(false);
    employeeButtonBar_RMV.setDisable(false);

    hourlyRate_Input.setText("");
    numHours_Input.setText("");
  }

}
