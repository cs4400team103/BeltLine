package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.model.Employee;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.SQLException;

/**
 * @author Yaroslava
 */
public class EmployeeManageProfileController {
    private static Employee emp;

    /**
     * initializes data
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void initialize() throws SQLException, ClassNotFoundException {

    }

    /**
     * gets Employee object
     *
     * @return
     */
    public static Employee getEmployee() {
        return emp;
    }

    /**
     * sets employee object
     *
     * @param employee
     */
    public static void setEmployee(Employee employee) {
        emp = employee;
    }

    /**
     * goes back
     *
     * @throws Exception
     */
    public void back() throws Exception {
        if (UserLoginController.getUserType().equals("Manager")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerFunctionality.fxml"));
            Scene rootScene = new Scene(root, 350, 235);
            //go to next page
            Main.pstage.setScene(rootScene);
        } else if (UserLoginController.getUserType().equals("ManagerVisitor")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerVisitorFunctionality.fxml"));
            Scene rootScene = new Scene(root, 350, 385);
            //go to next page
            Main.pstage.setScene(rootScene);
        } else if (UserLoginController.getUserType().equals("Staff")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffFunctionality.fxml"));
            Scene rootScene = new Scene(root, 235, 275);
            //go to next page
            Main.pstage.setScene(rootScene);
        } else if (UserLoginController.getUserType().equals("StaffVisitor")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffVisitorFunctionality.fxml"));
            Scene rootScene = new Scene(root, 350, 325);
            //go to next page
            Main.pstage.setScene(rootScene);
        } else if (UserLoginController.getUserType().equals("Administrator")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionality.fxml"));
            Scene rootScene = new Scene(root, 350, 235);
            //go to next page
            Main.pstage.setScene(rootScene);
        } else if (UserLoginController.getUserType().equals("AdministratorVisitor")) {
            Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionality.fxml"));
            Scene rootScene = new Scene(root, 350, 275);
            //go to next page
            Main.pstage.setScene(rootScene);
        }
    }

    public void update() throws Exception {
        //TODO: add update information...
        Parent userLogin = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(userLogin, 650, 400);
        Main.pstage.setScene(rootScene);
    }
}
