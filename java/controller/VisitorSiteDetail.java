package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class VisitorSiteDetail {
    @FXML
    Button back;
    @FXML
    Button logVisit;

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorExploreSite.fxml"));
        Scene rootScene = new Scene(root, 250, 550);
        Main.pstage.setScene(rootScene);
    }

    public void logVisit() throws Exception {
        //log visit
    }

}
