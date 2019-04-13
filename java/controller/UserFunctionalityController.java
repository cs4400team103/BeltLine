package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class UserFunctionalityController {
    @FXML
    Button takeTransit;
    @FXML
    Button viewTransitHistory;
    @FXML
    Button back;

    public void takeTransit() throws Exception {
        Parent takeTransit = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTakeTransit.fxml"));
        Scene userTakeTransitScene = new Scene(takeTransit, 600, 450);
        Main.pstage.setScene(userTakeTransitScene);
    }
    public void viewTransitHistory() throws Exception {
        Parent viewTransitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTransitHistory.fxml"));
        Scene userViewTransitHistoryScene = new Scene(viewTransitHistory, 600, 450);
        Main.pstage.setScene(userViewTransitHistoryScene);
    }
    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(root, 280, 215);
        Main.pstage.setScene(rootScene);
    }
}
