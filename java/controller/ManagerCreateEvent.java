package BeltLineApplication.java.controller;
import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ManagerCreateEvent {
    @FXML
    Button back;
    @FXML
    Button createEvent;
    //assign staff??
    //public void assignStaff

    public void back() throws Exception {
        //also manager visitor
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerFunctionality.fxml"));
        Scene rootScene = new Scene(root, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void createEvent() throws Exception {
        //creat event
    }

}
