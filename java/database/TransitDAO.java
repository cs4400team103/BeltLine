package BeltLineApplication.java.database;

import BeltLineApplication.java.model.Transit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransitDAO {
    /**
     * @param route
     * @param minRange
     * @param maxRange
     * @param containSite
     * @param transportType
     * @return ObservableList<Object>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObservableList<Transit> filter(String route, Double minRange, Double maxRange, String containSite, String transportType) throws SQLException, ClassNotFoundException {
        //get minRange and maxRange values
        if (maxRange == 0.0) {
            maxRange = 999.99;
        }

        String price = "price BETWEEN " + minRange + " AND " + maxRange;

        //create where statements for each variable
        if (!route.isEmpty()) {
            route = " route = '" + route + "'";
        }
        if (!containSite.isEmpty()) {
            containSite = " site = '" + containSite + "'";
        }
        if (!transportType.isEmpty()) {
            transportType = " type = '" + transportType + "'";
        }

        String query =
                "select * from transit where ;";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
        } catch (SQLException e) {
            System.out.println("Something is wrong with your SQL: " + e);
            throw e;
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        ObservableList<Transit> row = getTransitList(rs);

        return row;
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
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error with getting transport type on Administrator Create Transit" + e);
        }
        return false;
    }

    /**
     * updates transit
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

    /**
     * deletes a transit object from the database
     * @param transit
     */
    public static void delete(Transit transit) {
        String delete = "Delete from transit WHERE Type = '" + transit.getType()
                + "' and ROUTE = '" + transit.getRoute()
                + "' and Price = '" + transit.getPrice() + "';";
        try {
            Connector.dbExecuteUpdate(delete);
        } catch (Exception e) {
            System.out.println("Error with delete transit query" + e);
        }
    }

    /**
     * returns a transit list
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObservableList<Transit> populateTransit() throws SQLException, ClassNotFoundException {
        String query = "";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            ObservableList<Transit> transit = getTransitList(rs);
            return transit;
        } catch (Exception e) {
            System.out.println("Error with update transit query" + e);
        }
        return null;
    }

    private Transit getTransit(ResultSet rs) throws SQLException {
        Transit transit = null;
        if (rs.next()) {
            transit = new Transit();
            transit.setType(rs.getString("Type"));
            transit.setRoute(rs.getString("Route"));
            transit.setPrice(rs.getDouble("Price"));
            transit.setNumberOfConnectedSites(rs.getInt("# of Connected Sites"));
            transit.setNumberOfTransitLogged(rs.getInt("# of Transit Logged"));
        }
        return transit;
    }

    /**
     * returns the list of transit based on the result set
     * @param rs
     * @return
     * @throws SQLException
     */
    private static ObservableList<Transit> getTransitList(ResultSet rs) throws SQLException {
        ObservableList<Transit> trans = FXCollections.observableArrayList();
        if (rs.next()) {
            Transit transit = new Transit();
            transit.setType(rs.getString("Type"));
            transit.setRoute(rs.getString("Route"));
            transit.setPrice(rs.getDouble("Price"));
            transit.setNumberOfConnectedSites(rs.getInt("# of Connected Sites"));
            transit.setNumberOfTransitLogged(rs.getInt("# of Transit Logged"));
            trans.add(transit);
        }
        return trans;
    }
}
