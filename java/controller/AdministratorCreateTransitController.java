package BeltLineApplication.java.controller;

import BeltLineApplication.java.database.TransitDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AdministratorCreateTransitController {
    @FXML
    private TextField route;
    @FXML
    private TextField price;
    @FXML
    private ChoiceBox type;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    //TODO: Fix choicebox stuff;
    public void create() throws SQLException {
        if (!route.getText().isEmpty() ||  !price.getText().isEmpty() || !type.getSelectionModel().isEmpty()) {
            try {
                TransitDAO.createTransit(route.getText(), type.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(price.getText()));
            }
            catch(SQLException e) {
                System.out.println("Issue with SQL");
            }
            alert.setTitle("Created Transport");
            alert.setHeaderText(null);
            alert.setContentText("Success! Transport has been created successfully!");
        }
    }
}
