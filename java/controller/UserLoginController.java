package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class UserLoginController {

    @FXML
    private Label email;
    @FXML
    private Label password;
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button login;
    @FXML
    private Button register;

    private Alert errorAlert = new Alert(AlertType.ERROR);

    public void login() throws Exception {

        //TODO: Need to check for other logins...
        Parent userFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/userFunctionality.fxml"));
        Scene userFunctionalityScene = new Scene(userFunctionality, 250, 200);

        if (UserDAO.loginUser(emailText.getText(), passwordText.getText())) {
            //go to next page
            Main.pstage.setScene(userFunctionalityScene);
        } else {
            errorAlert.setTitle("User UserLoginController");
            errorAlert.setHeaderText("Username and password do not match");
            errorAlert.setContentText("Please try again or register as a new user");
            errorAlert.showAndWait();
        }
    }

    public void register() throws Exception {
        Parent registerNavigation = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/RegisterNavigation.fxml"));
        Scene registerNavigationScene = new Scene(registerNavigation, 250, 300);
        Main.pstage.setScene(registerNavigationScene);
    }
}
