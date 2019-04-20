package BeltLineApplication.java.database;

import BeltLineApplication.java.model.Transit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransitDAO {
    private static String transportType;
    private static String routeText;
    private static double priceText;

    //getters
    public static String getTransportType() {
        return transportType;
    }
    public static String getRouteText() {
        return routeText;
    }
    public static double getPriceText() {
        return priceText;
    }

    //setters
    public static void setTransportType(String transportType) {
        TransitDAO.transportType = transportType;
    }
    public static void setRouteText(String routeText) {
        TransitDAO.routeText = routeText;
    }
    public static void setPriceText(double priceText) {
        TransitDAO.priceText = priceText;
    }

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
    public static ResultSet filter(String site, String type) throws SQLException {
        return null;
    }

    /**
     * create a transit
     *
     * @param type
     * @param route
     * @param price
     * @throws SQLException
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

    /**
     * update connect
     *
     * @param sname
     * @param route
     * @param type
     */
    public static void connect(String sname, String route, String type) {
        String query =
                "update connect set route = " + "'" + route + "', type = "
                        + "'" + type + "' where sname = " + "'" + sname + "';";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with connect query" + e);
        }
    }

    /**
     * Get connected sites from site
     *
     * @return connected sites list
     */
    public static ObservableList<String> getConnectedSites() throws SQLException, ClassNotFoundException {
        String query = "select SName from site);";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting connected sites from Administrator Create Transit" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        while (rs.next()) {
            String site = rs.getString("SName");
            list.add(site);
        }
        return list;
    }

    /**
     * get type from transit
     *
     * @return ObservableList<String>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObservableList<String> getType() throws SQLException, ClassNotFoundException {
        String query = "select Type from Transit);";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting transport type on Administrator Create Transit" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        while (rs.next()) {
            String site = rs.getString("type");
            list.add(site);
        }
        return list;
    }

    /**
     * check if route and type match another other route and type as a primary key
     *
     * @param route
     * @param type
     * @return boolean
     */
    public static boolean checkRouteType(String route, String type) {
        String query = "Select exists (select route, type from Transit where route = "
                + "'" + route + "' type = '" + type + "') as 'Exists?';";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting transport type on Administrator Create Transit" + e);
        }
        return false;
    }

    /**
     * updates transit TODO: FINISH
     *
     * @param route
     * @param price
     */
    public static void updateTransit(String type, String route, double price) {
        String updateTransit =
                "update" + "');";
        try {
            Connector.dbExecuteUpdate(updateTransit);
        } catch (Exception e) {
            System.out.println("Error with update transit query" + e);
        }
    }

    public static ObservableList<Object> getTransitRow() throws SQLException, ClassNotFoundException {
        String query = "";
        try {
            Connector.dbExecuteQuery(query);
        } catch (Exception e) {
            System.out.println("Error with update transit query" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);

        int i = 1;
        ObservableList<Object> row = FXCollections.observableArrayList();
        while (i < rs.getMetaData().getColumnCount() && rs.next()) {
            row.add(rs.getString(i));
        }
        return row;
    }
}
