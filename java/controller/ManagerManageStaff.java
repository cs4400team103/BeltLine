package BeltLineApplication.java.controller;
import BeltLineApplication.Main;
import BeltLineApplication.java.database.SiteDAO;
import BeltLineApplication.java.database.StaffDAO;
import BeltLineApplication.java.model.Staff;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ManagerManageStaff {
    @FXML
    Button filter;
    @FXML
    Button back;
    @FXML
    ChoiceBox<String> sites;
    @FXML
    TableView<Staff> staffTable;
    @FXML
    TableColumn<Staff, String> staffName;
    @FXML
    TableColumn<Staff, Integer> numEventShifts;
    @FXML
    TextField fName;
    @FXML
    TextField lName;
    @FXML
    TextField startDate;
    @FXML
    TextField eDate;

    public void sitePopulate() throws SQLException, ClassNotFoundException {
        ObservableList<String> list = SiteDAO.getSites();
        sites.setItems(list);

        ObservableList<Staff> staff = StaffDAO.manageStaff();
        staffTable.setItems(staff);
    }

    public void filter() {
//        ObservableList<Staff> list = StaffDAO.filterStaff(route.getText(), Double.parseDouble(minRange.getText()), Double.parseDouble(maxRange.getText()), containSite.getSelectionModel().getSelectedItem().toString(), transportType.getSelectionModel().getSelectedItem().toString());
//        transitTable.setItems(list);
        //filter
        //first name last name start date end date
    }

    public void back() throws Exception {
        //back to hybrid visitor as well
        Parent root = FXMLLoader.load(getClass().getResource("/BeltLineApplication/resources/fxml/ManagerFunctionality.fxml"));
        Scene rootScene = new Scene(root, 350, 250);
        Main.pstage.setScene(rootScene);
    }
}
