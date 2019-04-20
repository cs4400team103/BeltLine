package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.SiteDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AdministratorEditSiteController {
    @FXML
    private TextField name;
    @FXML
    private TextField zipcode;
    @FXML
    private TextField address;
    @FXML
    private ChoiceBox manager;
    @FXML
    private CheckBox openEveryday;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void initialize() {

    }

    public void back() throws Exception {
        Parent administratorManageSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorManageSite.fxml"));
        Scene rootScene = new Scene(administratorManageSite, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void update() {
        //make sure none of them are empty
        if (!name.getText().isEmpty() || !address.getText().isEmpty() || !zipcode.getText().isEmpty() || !manager.getSelectionModel().isEmpty()) {
            //try to update the site
            try {
                SiteDAO.updateSite(name.getText(), address.getText(), Integer.parseInt(zipcode.getText()), openEveryday.isSelected(), manager.getSelectionModel().getSelectedItem().toString());
            } catch (Exception e) {
                System.out.println("Issue with SQL" + e);
                throw e;
            }
            alert.setTitle("Update Site");
            alert.setHeaderText(null);
            alert.setContentText("Success! Site has been updated Successfully!");
        }
    }
}
