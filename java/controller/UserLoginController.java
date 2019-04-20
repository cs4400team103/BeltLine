package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.EmailDAO;
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
    private static String userType;
    private static String username;

    public static void setUserType(String user) {
        userType = user;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUsername(String user) {
        username = user;
    }
    public static String getUsername() {
        return username;
    }

    public void login() throws Exception {
        if (!emailText.getText().isEmpty() || !passwordText.getText().isEmpty()) {
            //fist get username from email.
            String username = EmailDAO.getUsername(email.getText());
            setUsername(username);

            String userType = UserDAO.isUser(username);
            setUserType(userType);

            if (UserDAO.loginUser(emailText.getText(), passwordText.getText())) {
                if (userType.equals("Manager")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 350, 235);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else if (userType.equals("ManagerVisitor")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerVisitorFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 350, 385);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else if (userType.equals("Staff")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 235, 275);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else if (userType.equals("StaffVisitor")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffVisitorFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 350, 325);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else if (userType.equals("Administrator")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 350, 235);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else if (userType.equals("AdministratorVisitor")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 350, 275);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                }  else if (userType.equals("Visitor")) {
                    Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorFunctionality.fxml"));
                    Scene rootScene = new Scene(root, 250, 320);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                } else {
                    Parent userFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/userFunctionality.fxml"));
                    Scene rootScene = new Scene(userFunctionality, 250, 200);
                    //go to next page
                    Main.pstage.setScene(rootScene);
                }
            } else {
                errorAlert.setTitle("User UserLoginController");
                errorAlert.setHeaderText("Email and password do not match");
                errorAlert.setContentText("Please try again.");
                errorAlert.showAndWait();
            }
        } else {
            errorAlert.setTitle("User UserLoginController");
            errorAlert.setHeaderText("Email and password must be filled");
            errorAlert.setContentText("Please try again or if this is your first time, register");
            errorAlert.showAndWait();
        }
    }

    /**
     * goes to register page
     * @throws Exception
     */
    public void register() throws Exception {
        Parent registerNavigation = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/RegisterNavigation.fxml"));
        Scene registerNavigationScene = new Scene(registerNavigation, 250, 300);
        Main.pstage.setScene(registerNavigationScene);
    }
}
