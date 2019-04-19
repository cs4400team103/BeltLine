package BeltLineApplication.java.controller;
import BeltLineApplication.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class VisitorExploreEvent {
    @FXML
    Button filter;
    @FXML
    Button eventDetail;
    @FXML
    Button back;
    @FXML
    CheckBox includeSoldOut;
    @FXML
    CheckBox includeVisited;

    public void filter() throws Exception {
        //sql?
    }

    public void eventDetail() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorEventDetail.fxml"));
        Scene rootScene = new Scene(root, 600, 450);
        Main.pstage.setScene(rootScene);
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(root, 250, 350);
        Main.pstage.setScene(rootScene);
    }

    public void includeSoldOut() throws Exception{
        //sql?
    }

    public void includeVisited() throws Exception {
        //sql?
    }
}
