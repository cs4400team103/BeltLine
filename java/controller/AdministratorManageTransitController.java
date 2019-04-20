package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.TransitDAO;
import BeltLineApplication.java.limiter.TextFieldLimit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class AdministratorManageTransitController {
    @FXML
    private ChoiceBox transportType;
    @FXML
    private ChoiceBox containSite;
    @FXML
    private TextFieldLimit route;
    @FXML
    private TextFieldLimit minRange;
    @FXML
    private TextFieldLimit maxRange;
    @FXML
    private TableView<Object> transitTable;
    @FXML
    private TableColumn routeCol;
    @FXML
    private TableColumn transportTypeCol;
    @FXML
    private TableColumn priceCol;
    @FXML
    private TableColumn connectedSitesCol;
    @FXML
    private TableColumn transitLoggedCol;

    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<Object> trans = TransitDAO.getTransitRow();
        transitTable.setItems(trans);

        //connectedSitesCol.setStyle("-fx-cell-size: 50px");
        route.setMaxLength(50);
        minRange.setMaxLength(3);
        maxRange.setMaxLength(3);

    }

    public void filter() {
        if (!transportType.getSelectionModel().isEmpty() || !containSite.getSelectionModel().isEmpty() || !route.getText().isEmpty()) {

        }
    }

    public void back() throws Exception {
        //TODO: how to implement if user is a administrator only or administrator visitor
        Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
        Scene rootScene = new Scene(administratorFunctionality, 350, 250);
        Main.pstage.setScene(rootScene);
    }

    public void delete() {
        //TODO: delete row from database
    }

    public void edit() throws Exception {
        Parent administratorEditSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorEditTransit.fxml"));
        Scene rootScene = new Scene(administratorEditSite, 405, 245);
        Main.pstage.setScene(rootScene);

        //TODO: get selected value, get selected value items and transport them into the edit site page
        // with text.setText("");...
    }

    public void create() throws Exception {
        Parent administratorCreateSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorCreateTransit.fxml"));
        Scene rootScene = new Scene(administratorCreateSite, 600, 450);
        Main.pstage.setScene(rootScene);
    }
}
