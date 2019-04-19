package BeltLineApplication.java.controller;

import BeltLineApplication.java.database.ManagerDAO;
import BeltLineApplication.java.database.TransitDAO;
import BeltLineApplication.java.limiter.TextFieldLimit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AdministratorCreateTransitController {
    @FXML
    private TextFieldLimit route;
    @FXML
    private TextFieldLimit price;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private ComboBox<String> connectedSites;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void initialize() {
        ObservableList<String> list = TransitDAO.getConnectedSites();
        type.setItems(list);

        route.setMaxLength(100);
        price.setMaxLength(9);
    }

    //TODO: Fix choicebox stuff;
    public void create() throws SQLException {
        if (!route.getText().isEmpty() ||  !price.getText().isEmpty() || !type.getSelectionModel().isEmpty()) {
            try {
                TransitDAO.createTransit(route.getText(), type.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(price.getText()));
            }
            catch(SQLException e) {
                System.out.println("Issue with SQL");
            }
            try {
                String connectedSite;
                while (connectedSites.getSelectionModel().selectedIndexProperty() != null) {
                    connectedSite = connectedSites.getSelectionModel().selectedIndexProperty().toString();
                    TransitDAO.connect(connectedSite, route.getText(), type.getSelectionModel().getSelectedItem());
                    connectedSites.getSelectionModel().selectNext(); //does this work?
                }
            } catch (Exception e) {
                System.out.println("Issue with connected sites at administrator create transit");
            }
            alert.setTitle("Created Transport");
            alert.setHeaderText(null);
            alert.setContentText("Success! Transport has been created successfully!");
        }
    }
}
