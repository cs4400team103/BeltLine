package BeltLineApplication.java.database;

import BeltLineApplication.java.controller.UserLoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventDAO {
    public static void createEvent(String eName, String startDate, String sName, String endDate, Double price, int capacity, String description,
                                   int minStaffReq) throws SQLException {
        String query =
                "INSERT INTO event" +
                        "VALUES ('" + eName + "','" + startDate + "','" + sName + "','" + endDate + "', '" +
                        price + "', '" + capacity + "', '" + description + "','" + minStaffReq +"');";

        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create event query" + e);
        }
    }

    public static void updateEvent(){
        //update
    }

    public static void deleteEvent() {
        //delete
        String query =
                "DELETE FROM event" +
                        "WHERE";

        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with delete event query" + e);
        }
    }

    public static Boolean uniqueEvent(String eName, String site, String sDate, String eDate) throws ParseException {
        //check for ename and site
        String startDate="01-02-2013";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        return true;

    }

    public static void visitEvent(String date) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date jDate = sd.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(jDate.getTime());
        String query = "INSERT INTO VisitEvent ('Username', 'Ename', 'Sname', 'StartDate', 'VisitEventData')"
                + "VALUES (" + UserLoginController.getUsername() + ", " + ");";
    }

    public static ObservableList<String> getStaff() throws SQLException, ClassNotFoundException {
        String query = "SELECT FirstName, LastName" +
                "FROM User WHERE;"; //staff is not assigned to another event during this time
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting staff" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        while (rs.next()) {
            String fName = rs.getString("FirstName");
            String lName = rs.getString("LastName");
            list.add(fName + " " + lName);
        }
        return list;
    }

}
