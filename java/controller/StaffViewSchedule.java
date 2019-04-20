package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StaffViewSchedule {
    @FXML
    Button filter;
    @FXML
    Button back;
    @FXML
    Button viewEvent;

    public void filter() {
        //filter, event name, description keyword, start date, end date


    }

    public void back() throws Exception {
        //back to hybrid visitor as well
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffFunctionality.fxml"));
        Scene rootScene = new Scene(root, 750, 600);
        Main.pstage.setScene(rootScene);
    }

    public void viewEvent() throws Exception {
        //if they have chosen a button go to that event
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/StaffEventDetail.fxml"));
        Scene rootScene = new Scene(root, 600, 400);
        Main.pstage.setScene(rootScene);
    }
}
