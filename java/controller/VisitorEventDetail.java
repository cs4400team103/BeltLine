package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class VisitorEventDetail {
    @FXML
    Button logVisit;
    @FXML
    Button back;

    public void logVisit() throws Exception {
        //logVisit
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/VisitorExploreSite.fxml"));
        Scene rootScene = new Scene(root, 725, 650);
        Main.pstage.setScene(rootScene);
    }
}