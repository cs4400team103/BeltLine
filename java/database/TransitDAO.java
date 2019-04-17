package BeltLineApplication.java.database;

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
                "INSERT INTO site" +
                        "VALUES ('" + type + "','" + route + "','" + price + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create site query" + e);
        }
    }
}
