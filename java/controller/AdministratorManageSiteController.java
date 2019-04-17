package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdministratorManageSiteController {

    public void filter() {
        //filter table
    }

    public void back() throws Exception {
        Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(administratorFunctionality, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void delete() {
        //TODO: delete row from database
    }

    public void edit() throws Exception {
        Parent administratorEditSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorEditSite.fxml"));
        Scene rootScene = new Scene(administratorEditSite, 405, 245);
        Main.pstage.setScene(rootScene);

        //TODO: get selected value, get selected value items and transport them into the edit site page
        // with text.setText("");...
    }

    public void create() throws Exception {
        Parent administratorCreateSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorCreateSite.fxml"));
        Scene rootScene = new Scene(administratorCreateSite, 600, 450);
        Main.pstage.setScene(rootScene);
    }
}
