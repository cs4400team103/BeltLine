package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.EmployeeDAO;
import BeltLineApplication.java.database.ManagerDAO;
import BeltLineApplication.java.database.StaffDAO;
import BeltLineApplication.java.database.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class RegisterEmployeeOnlyController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private ChoiceBox state;
    @FXML
    private ChoiceBox userType;
    @FXML
    private TextField zipcode;
    @FXML
    private Button add;
    private int counter;

    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private Button remove = new Button("remove");

    public void registerEmployee() throws Exception {
        Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(administratorFunctionality, 350, 250);

        //None of the fields can be empty
        if (!username.getText().isEmpty() || !password.getText().isEmpty() || !confirmPassword.getText().isEmpty() || !fname.getText().isEmpty() || !lname.getText().isEmpty() || !emailTextField.getText().isEmpty()) {
            //password must equal password
            if (password.getText().equals(confirmPassword.getText())) {
                //Employee will be a user and an employee
                UserDAO.registerUser(username.getText(), password.getText(), fname.getText(), lname.getText());
                EmployeeDAO.registerEmployee(username.getText(), phone.getText(), address.getText(), city.getText(), state.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(zipcode.getText()));

                if (userType.getSelectionModel().getSelectedItem().toString().equals("Manager")) {
                    ManagerDAO.registerManager(username.getText());
                }

                if (userType.getSelectionModel().getSelectedItem().toString().equals("Staff")) {
                    StaffDAO.registerStaff(username.getText());
                }

                Main.pstage.setScene(rootScene);
            } else {
                errorAlert.setTitle("Password Fail");
                errorAlert.setHeaderText("Passwords do not match");
                errorAlert.setContentText("Please try again");
                errorAlert.showAndWait();
            }
        } else {
            errorAlert.setTitle("Required Fields");
            errorAlert.setHeaderText("All fields are required");
            errorAlert.setContentText("Please try again");
            errorAlert.showAndWait();
        }
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/RegisterNavigation.fxml"));
        Scene rootScene = new Scene(root, 250, 300);
        Main.pstage.setScene(rootScene);
    }
}
