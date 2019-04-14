package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VisitorFunctionalityOnlyController {

    public void exploreEvent() throws Exception {
        Parent exploreEvent = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorExploreEvent.fxml"));
        Scene rootScene = new Scene(exploreEvent, 725, 645);
        Main.pstage.setScene(rootScene);
    }

    public void exploreSite() throws Exception {
        Parent exploreSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorExploreSite.fxml"));
        Scene rootScene = new Scene(exploreSite, 725, 645);
        Main.pstage.setScene(rootScene);
    }

    public void viewTransitHistory() throws Exception {
        Parent transitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTransitHistory.fxml"));
        Scene rootScene = new Scene(transitHistory, 600, 450);
        Main.pstage.setScene(rootScene);
    }

    public void takeTransit() throws Exception {
        Parent transitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTakeTransit.fxml"));
        Scene rootScene = new Scene(transitHistory, 600, 450);
        Main.pstage.setScene(rootScene);
    }

    public void viewVisitHistory() throws Exception {
        Parent visitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorVisitHistory.fxml"));
        Scene rootScene = new Scene(visitHistory, 600, 450);
        Main.pstage.setScene(rootScene);
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(root, 280, 215);
        Main.pstage.setScene(rootScene);
    }

}
