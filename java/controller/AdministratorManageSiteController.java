package BeltLineApplication.java.controller;

import BeltLineApplication.Main;
import BeltLineApplication.java.database.SiteDAO;
import BeltLineApplication.java.database.TransitDAO;
import BeltLineApplication.java.model.Site;
import BeltLineApplication.java.model.Transit;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class AdministratorManageSiteController {
    @FXML
    private TableView<Site> site;
    @FXML
    private ChoiceBox manager;
    @FXML
    private ChoiceBox openEveryday;
    @FXML
    private ChoiceBox sites;
    @FXML
    private TableColumn<Site, String> nameCol;
    @FXML
    private TableColumn<Site, String> managerCol;
    @FXML
    private TableColumn<Site, String> openEverydayCol;

    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<Site> sit = SiteDAO.populateSite();
        site.setItems(sit);

        //will allow you to select a row without a radiobutton function
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                site.requestFocus();
                site.getSelectionModel().select(0);
                site.scrollTo(0);
            }
        });
    }

    public void filter() throws SQLException, ClassNotFoundException {
        ObservableList<Site> list = SiteDAO.filter(sites.getSelectionModel().getSelectedItem().toString(), manager.getSelectionModel().getSelectedItem().toString(), openEveryday.getSelectionModel().getSelectedItem().toString());
        site.setItems(list);
    }

    public void back() throws Exception {
        if (UserLoginController.getUserType().equals("Administrator")) {
            Parent administratorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorFunctionalityOnly.fxml"));
            Scene rootScene = new Scene(administratorFunctionality, 350, 250);
            Main.pstage.setScene(rootScene);
        } else {
            Parent administratorVisitorFunctionality = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorVisitorFunctionality.fxml"));
            Scene rootScene = new Scene(administratorVisitorFunctionality, 350, 250);
            Main.pstage.setScene(rootScene);
        }
    }

    public void delete() {
        //make sure this exists first
        if (site.getSelectionModel().getSelectedCells().get(0) != null) {
            //get selected row
            TablePosition pos = site.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Site item = site.getItems().get(row);
            SiteDAO.delete(item);
        }
    }

    public void edit() throws Exception {
        //make sure the table exists first
        if (site.getSelectionModel().getSelectedCells().get(0) != null) {
            //get selected row
            TablePosition pos = site.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            Site item = site.getItems().get(row);
            AdministratorEditSiteController.setSite(item);

            Parent administratorEditSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorEditSite.fxml"));
            Scene rootScene = new Scene(administratorEditSite, 405, 245);
            Main.pstage.setScene(rootScene);
        }
    }

    public void create() throws Exception {
        Parent administratorCreateSite = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/AdministratorCreateSite.fxml"));
        Scene rootScene = new Scene(administratorCreateSite, 600, 450);
        Main.pstage.setScene(rootScene);
    }
}
