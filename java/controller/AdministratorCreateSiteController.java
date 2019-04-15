package BeltLineApplication.java.controller;

import BeltLineApplication.java.database.ManagerDAO;
import BeltLineApplication.java.database.SiteDAO;
import BeltLineApplication.java.model.Manager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class AdministratorCreateSiteController {
    @FXML
    private ComboBox<String> managerChoiceCombo;
    //Need to configure ChoiceBox
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField zipcodeTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private CheckBox everyday;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void getManagerList() throws SQLException, ClassNotFoundException {
        ObservableList<String> list = ManagerDAO.getManagerList();
        managerChoiceCombo.setItems(list);
    }

    public void create() throws Exception {
        if (!nameTextField.getText().isEmpty() ||  !zipcodeTextField.getText().isEmpty() || !managerChoiceCombo.getSelectionModel().getSelectedItem().isEmpty()) {
            SiteDAO.createSite(nameTextField.getText(), addressTextField.getText(), Integer.parseInt(zipcodeTextField.getText()), everyday.isSelected(), managerChoiceCombo.getSelectionModel().getSelectedItem());
            alert.setTitle("Created Site");
            alert.setHeaderText(null);
            alert.setContentText("Success! Site has been created successfully!");
        }
    }
}
