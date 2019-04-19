package BeltLineApplication.java.controller;
import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ManagerDailyDetail {
    @FXML
    Button back;

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerSiteReport.fxml"));
        Scene rootScene = new Scene(root, 550, 500);
        Main.pstage.setScene(rootScene);
    }
}
