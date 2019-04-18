package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AdministratorManageTransitController {
    @FXML
    private ChoiceBox transportType;
    @FXML
    private ChoiceBox containSite;
    @FXML
    private TextField route;
    @FXML
    private TextField minRange;
    @FXML
    private TextField maxRange;



    public void filter() {
        //filter table
    }

    public void back() throws Exception {
        //TODO: how to implement if user is a administrator only or administrator visitor
        Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(administratorFunctionality, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void delete() {
        //TODO: delete row from database
    }

    public void edit() throws Exception {
        Parent administratorEditSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorEditTransit.fxml"));
        Scene rootScene = new Scene(administratorEditSite, 405, 245);
        Main.pstage.setScene(rootScene);

        //TODO: get selected value, get selected value items and transport them into the edit site page
        // with text.setText("");...
    }

    public void create() throws Exception {
        Parent administratorCreateSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorCreateTransit.fxml"));
        Scene rootScene = new Scene(administratorCreateSite, 600, 450);
        Main.pstage.setScene(rootScene);
    }
}
