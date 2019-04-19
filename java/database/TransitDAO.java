package BeltLineApplication.java.database;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransitDAO {
    //not done
    public static ResultSet filter(String site, String type, Double Price) throws SQLException, ClassNotFoundException {
        String query =
                "select * from transit where ;";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            return null;
        } catch (SQLException e) {
            System.out.println("Something is wrong with your SQL: " + e);
            throw e;
        }
    }
    //not done
    public static ResultSet filter(String site, String type) throws SQLException{
        return null;
    }

    /**
     * Create transit
     */
    public static void createTransit(String type, String route, double price) throws SQLException {
        String query =
                "INSERT INTO transit" +
                        "VALUES ('" + type + "','" + route + "','" + price + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create site query" + e);
        }
    }

    public static void connect(String sname, String route, String type) {
        //TODO: must update route and type
    }

    public static ObservableList<String> getConnectedSites() {
        return null;
    }

    public static void updateTransit(String route, double price, ListView<String> connectedSites) {
        String updateTransit =
                "update" + "');";
        try {
            Connector.dbExecuteUpdate(updateTransit);
        } catch (Exception e) {
            System.out.println("Error with create site query" + e);
        }

        for (int i=0; i < connectedSites.getSelectionModel().getSelectedItems().size(); i++) {
            String updateConnector =
                    "update" + "');";
            try {
                Connector.dbExecuteUpdate(updateConnector);
            } catch (Exception e) {
                System.out.println("Error with updating the connector query" + e);
            }
        }

    }
}
