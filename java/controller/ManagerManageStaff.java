package BeltLineApplication.java.controller;
import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class ManagerManageStaff {
    @FXML
    Button filter;
    @FXML
    Button back;
    @FXML

    public void sitePopulate() {
        
    }

    public void filter() {
        //filter
        //first name last name start date end date
    }

    public void back() throws Exception {
        //back to hybrid visitor as well
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerFunctionality.fxml"));
        Scene rootScene = new Scene(root, 350, 250);
        Main.pstage.setScene(rootScene);
    }
}
