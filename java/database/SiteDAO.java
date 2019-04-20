package BeltLineApplication.java.database;

import BeltLineApplication.java.controller.UserLoginController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static void updateSite(String sname, String address, int zipcode, Boolean openEverday, String managerUsername) {
        String query = "UPDATE";

        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create site query" + e);
        }
    }

    public static boolean checkSiteExist(String username) {
        String query = "Select exists (select ManagerUsername from Site where ManagerUsername = "
                + "'" + username + "') as 'Exists?';";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error getting if site exists on Manager Create Event" + e);
        }
        return false;
    }

    public static String getSite(String manager) throws SQLException , ClassNotFoundException {
        String query = "Select SName from Site where ManagerUsername = "
                + "'" + manager + "';";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            String siteName = rs.getString("SName");
            return siteName;

        } catch (Exception e) {
            System.out.println("Error getting site name for Manager Create Event");
        }
        return null;
    }

    public static void visitSite(String date) throws ParseException {
        //actually get sname
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date jDate = sd.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(jDate.getTime());
        String query = "INSERT INTO VisitSite"
                + "VALUES (" + UserLoginController.getUsername() + ", " + "sname, " + sqlDate + ");"; //username sname and date
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
        } catch (Exception e) {
            System.out.println("Error with SQL");
        }
    }
}
