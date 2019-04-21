
package BeltLineApplication.java.database;

import BeltLineApplication.java.controller.UserLoginController;
import BeltLineApplication.java.model.Site;
import BeltLineApplication.java.model.Transit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Yaroslava
 * @author Julia
 */
public class SiteDAO {
    /**
     * Create Site
     */
    public static void createSite(String sname, String address, int zipcode, Boolean openEveryday, String managerUsername) throws SQLException {
        String query =
                "INSERT INTO site" +
                        "(SName, Address, Zipcode, OpenEverday, managerUsername)" +
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

    public static ObservableList<String> getManagerList() throws SQLException, ClassNotFoundException {
        String query = "select ManagerUsername from site;";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting managerUsername from ManagerList get List" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        while (rs.next()) {
            String username = rs.getString("ManagerUsername");
            list.add(username);
        }
        return list;
    }

    public static ObservableList<Site> filter(String site, String manager, String openEverday) throws SQLException, ClassNotFoundException{
        //create where statements for each variable
        if (!site.isEmpty()) {
            site = " site = '" + site + "'";
        }
        if (!manager.isEmpty()) {
            manager = " manager = '" + manager + "'";
        }
        if (!openEverday.isEmpty()) {
            openEverday = " openEverday = '" + openEverday + "'";
        }

        String query =
                "select site, manager, openEverday from site where " + site + manager + openEverday + ";";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
        } catch (SQLException e) {
            System.out.println("Something is wrong with your SQL: " + e);
            throw e;
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        ObservableList<Site> row = getSiteList(rs);

        return row;
    }

    /**
     * returns the list of transit based on the result set
     * @param rs
     * @return
     * @throws SQLException
     */
    private static ObservableList<Site> getSiteList(ResultSet rs) throws SQLException {
        ObservableList<Site> list = FXCollections.observableArrayList();
        if (rs.next()) {
            Site s = new Site();
            s.setSname(rs.getString("SName"));
            s.setManagerUsername(rs.getString("ManagerUsername"));
            s.setOpenEveryday(rs.getInt("OpenEveryday"));
            list.add(s);
        }
        return list;
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ObservableList<Site> populateSite() throws SQLException, ClassNotFoundException {
        String query = "Select Site.SName, concat(User.FirstName,\" \", User.LastName) as 'Manager', Site.OpenEveryday\n" +
                "from Site join User on Site.ManagerUsername = User.Username\n" +
                "where Site.OpenEveryday = 'OpenEveryday' and Site.SName = 'sname' and concat(User.FirstName,\" \", User.LastName) = 'manager name' ;\n";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            ObservableList<Site> s = getSiteList(rs);
            return s;
        } catch (Exception e) {
            System.out.println("Error with update site query" + e);
        }
        return null;
    }

    //TODO: fix openEveryday stuff either yes or digits..
    public static void delete(Site site) {
        String delete = "Delete from site WHERE SName = '" + site.getSname()
                + "' and ManagerUsername = '" + site.getManagerUsername()
                + "' and OpenEverday = '" + site.getOpenEveryday() + "';";
        try {
            Connector.dbExecuteUpdate(delete);
        } catch (Exception e) {
            System.out.println("Error with delete transit query" + e);
        }
    }
}