package BeltLineApplication.java.database;

import java.sql.SQLException;

public class SiteDAO {
    /**
     * Create Site
     */
    public static void createSite(String sname, String address, int zipcode, Boolean openEveryday, String managerUsername) throws SQLException {
        String query =
                "INSERT INTO site" +
                        "VALUES ('" + sname + "','" + address + "','" + zipcode + "','" + openEveryday + "', '" +
                        managerUsername + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create site query" + e);
        }
    }
}
