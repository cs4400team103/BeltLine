package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.UserDAO;
import BeltLineApplication.java.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class Login {

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

    public void login(ActionEvent event) throws Exception {

        Parent userFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/userFunctionality.fxml"));
        Scene userFunctionalityScene = new Scene(userFunctionality, 250, 200);


        if (UserDAO.loginUser(emailText.getText(), passwordText.getText())) {
            //go to next page
            Main.pstage.setScene(userFunctionalityScene);
        } else {
            errorAlert.setTitle("User Login");
            errorAlert.setHeaderText("Username and password do not match");
            errorAlert.setContentText("Please try again or register as a new user");
            errorAlert.showAndWait();
        }
    }
}
