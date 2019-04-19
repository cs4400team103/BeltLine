package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.SiteDAO;
import BeltLineApplication.java.database.TransitDAO;
import BeltLineApplication.java.limiter.TextFieldLimit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class AdministratorEditTransitController {
    @FXML
    private Label TransportType;
    @FXML
    private TextFieldLimit route;
    @FXML
    private TextFieldLimit price;
    @FXML
    private ListView<String> connectedSites;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void initialize() {
        //set the text
        TransportType.setText(TransitDAO.getTransportType());
        route.setText(TransitDAO.getRouteText());
        price.setText(Double.toString(TransitDAO.getPriceText()));

        //adjust max length
        route.setMaxLength(100);
        price.setMaxLength(9);
    }

    public void update() {
        //make sure none of them are empty
        if (!route.getText().isEmpty() || !price.getText().isEmpty() || !connectedSites.getSelectionModel().getSelectedItems().isEmpty()) {
            //try to update the site
            try {
                TransitDAO.updateTransit(route.getText(),Double.parseDouble(price.getText()), connectedSites);
            } catch (Exception e) {
                System.out.println("Issue with SQL" + e);
                throw e;
            }
            alert.setTitle("Update Site");
            alert.setHeaderText(null);
            alert.setContentText("Success! Site has been updated Successfully!");
        }
    }

    public void back() throws Exception {
        Parent administratorManageTransit = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorManageTransit.fxml"));
        Scene rootScene = new Scene(administratorManageTransit, 650, 450);
        Main.pstage.setScene(rootScene);
    }
}
