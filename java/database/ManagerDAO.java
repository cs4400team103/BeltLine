package BeltLineApplication.java.database;

import BeltLineApplication.java.model.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {
    public static ObservableList<String> getManagerList() throws SQLException, ClassNotFoundException {
        ObservableList<String> list =  FXCollections.observableArrayList();
        String query =
                "SELECT username from Manager m LEFT JOIN Site s ON m.username = s.managerUsername where s.managerUsername is NULL';";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String managerName  = rs.getString("username");
                list.add(managerName);
            }
        } catch (SQLException e) {
            System.out.println("Something is wrong with your SQL: " + e);
            throw e;
        }
        return list;
    }
}
