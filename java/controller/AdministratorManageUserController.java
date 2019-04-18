package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdministratorManageUserController {

    public void filter() {
        //filter table
    }

    public void back() throws Exception {
        //TODO: how to implement if user is a administrator only or administrator visitor
        Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(administratorFunctionality, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void approve() throws Exception {
    //Administrator can approve a pending(or declined)account,
    }

    public void decline() throws Exception {
        //can decline a pending account,but cannot decline an approved account
    }
}
