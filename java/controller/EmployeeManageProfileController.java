package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EmployeeManageProfileController {
    public void back() throws Exception {
        //again back needs to be adjusted based on current login individual....
        Parent userLogin = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(userLogin, 650, 400);
        Main.pstage.setScene(rootScene);
    }
    public void update() throws Exception {
        //TODO: add update information...
        Parent userLogin = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/UserLogin.fxml"));
        Scene rootScene = new Scene(userLogin, 650, 400);
        Main.pstage.setScene(rootScene);
    }
}
