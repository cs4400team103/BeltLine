package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import BeltLineApplication.java.limiter.TextFieldLimit;

public class RegisterUserController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextFieldLimit fname;
    @FXML
    private TextFieldLimit lname;
    @FXML
    private TextFieldLimit username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextFieldLimit emailTextField;
    @FXML
    private Button add;
    private int counter;

    private Alert errorAlert = new Alert(AlertType.ERROR);
    private Button remove = new Button("remove");

    public void initialize() {
        //set limit on textFields
        fname.setMaxLength(5);
        lname.setMaxLength(50);
        username.setMaxLength(50);
    }

    public void registerUser() throws Exception {
        Parent userFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/userFunctionality.fxml"));
        Scene userFunctionalityScene = new Scene(userFunctionality, 250, 200);

        //None of the fields can be empty
        if (!username.getText().isEmpty() || !password.getText().isEmpty() || !confirmPassword.getText().isEmpty() || !fname.getText().isEmpty() || !lname.getText().isEmpty() || !emailTextField.getText().isEmpty()) {
            //password must equal password
            if (password.getText().equals(confirmPassword.getText())) {
                UserDAO.registerUser(username.getText(), password.getText(), fname.getText(), lname.getText());
                Main.pstage.setScene(userFunctionalityScene);
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

    public void addEmail() {
        Label email = new Label(emailTextField.getText());
        double textFieldLocationY = emailTextField.getLayoutY();
        double textFieldLocationX = emailTextField.getLayoutX();
        email.setStyle("-fx-layoutY: " + textFieldLocationY);
        email.setStyle("-fx-locationX: " + textFieldLocationX);

        remove = new Button("remove");
        int num = getCounter();
        String numStr = "" + num;
        remove.setId(numStr);
        num++;
        setCounter(num);
        remove.setOnAction(e -> removeEmail());

        double addLocationY = add.getLayoutY();
        double addLocationX = add.getLayoutX();
        email.setStyle("-fx-layoutY: " + addLocationY);
        email.setStyle("-fx-locationX: " + addLocationX);

        anchorPane.getChildren().addAll(email, remove);
    }

    public void removeEmail() {
        remove.getId();
        //TODO: add remove email functions
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int c) {
        this.counter = c;
    }
}
