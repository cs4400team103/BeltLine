package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Completed
 * @author Yaroslava
 */
public class AdministratorVisitorFunctionalityController {
    public void manageProfile() throws Exception {
        Parent administratorManageProfile = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/EmployeeManageProfile.fxml"));
        Scene rootScene = new Scene(administratorManageProfile, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void manageUser() throws Exception {
        Parent administratorManageUser = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorManageUser.fxml"));
        Scene rootScene = new Scene(administratorManageUser, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void manageTransit() throws Exception {
        Parent administratorManageTransit = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorManageTransit.fxml"));
        Scene rootScene = new Scene(administratorManageTransit, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void manageSite() throws Exception {
        Parent administratorManageSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorManageSite.fxml"));
        Scene rootScene = new Scene(administratorManageSite, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void takeTransit() throws Exception {
        Parent userTakeTransit = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTakeTransit.fxml"));
        Scene rootScene = new Scene(userTakeTransit, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void viewTransitHistory() throws Exception {
        Parent userTransitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserTransitHistory.fxml"));
        Scene rootScene = new Scene(userTransitHistory, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void exploreEvent() throws Exception {
        Parent exploreEvent = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorExploreEvent.fxml"));
        Scene rootScene = new Scene(exploreEvent, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void exploreSite() throws Exception {
        Parent exploreSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorExploreSite.fxml"));
        Scene rootScene = new Scene(exploreSite, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void viewVisitHistory() throws Exception {
        Parent visitHistory = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/VisitorVisitHistory.fxml"));
        Scene rootScene = new Scene(visitHistory, 650, 400);
        Main.pstage.setScene(rootScene);
    }

    public void back() throws Exception {
        Parent userLogin = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(userLogin, 650, 400);
        Main.pstage.setScene(rootScene);
    }
}
