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
                        price + "', '" + capacity + "', '" + description + "','" + minStaffReq + "');";

        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with create event query" + e);
        }
    }

    public static void updateEvent() {
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
        String startDate = "01-02-2013";
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

    public static ObservableList<String> populateStaffSchedule() throws SQLException, ClassNotFoundException {
        String query = "Select Event.EName, Event.SName, Event.StartDate, Event.EndDate, count(distinct AssignTo.StaffUsername) as 'Staff Count'\n" +
                "from Event \n" +
                "join AssignTo on Event.EName = AssignTo.EName and Event.StartDate = AssignTo.StartDate and Event.SName = AssignTo.SiteName\n" +
                "where Event.Description  like \"%keyword%\" and Event.Ename = 'ename' and Event.StartDate > 'before' and Event.EndDate < 'after'\n" +
                "group by Event.Ename, Event.SName, Event.StartDate, Event.EndDate;\n";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with getting Schedule for staff" + e);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        while (rs.next()) {
            String username = rs.getString("ManagerUsername");
            list.add(username);
        }
        return list;
    }

    public static ObservableList<String> staffSchedFilter(String eName, String dKey, String sDate, String eDate) throws ClassNotFoundException, SQLException {
        String w = null;
        String a = null;
        String b = null;
        String c = null;
        String e = null;
        String d = null;
        String f = null;
        String g = null;
        String h = null;
        String i = null;
        String j = null;
        String date = null;
        if (!eName.isEmpty() || !sDate.isEmpty() || !eDate.isEmpty() || !dKey.isEmpty()) {
            w = "Where";
        }
        if (!eName.isEmpty() && !sDate.isEmpty() && !eDate.isEmpty() && !dKey.isEmpty()) {
            a = " Event.Ename = '" + eName + "'" + " and Event.Description  like '%" + dKey + "%' and Event.StartDate >= '" + sDate + "' and Event.EndDate =< '" + eDate + "'";
        }
        if (!eName.isEmpty() && !sDate.isEmpty() && !eDate.isEmpty()) {
            b = " Event.Ename = '" + eName + "'" + " and Event.StartDate >= '" + sDate + "' and Event.EndDate =< '" + eDate + "'";
        }
        if (!sDate.isEmpty() && !eDate.isEmpty() && !dKey.isEmpty()) {
            c = " Event.Description  like '%" + dKey + "%' and Event.StartDate >= '" + sDate + "' and Event.EndDate =< '" + eDate + "'";
        }
        if (!eName.isEmpty() && !sDate.isEmpty() && !dKey.isEmpty()) {
            d = " Event.Ename = '" + eName + "'" + " and Event.Description  like '%" + dKey + "%' and Event.StartDate >= '" + sDate +  "'";
        }
        if (!eName.isEmpty() && !eDate.isEmpty() && !dKey.isEmpty()) {
            e = " Event.Ename = '" + eName + "'" + " and Event.Description  like '%" + dKey + "%' and Event.EndDate =< '" + eDate + "'";
        }
        if (!eName.isEmpty() && !dKey.isEmpty()) {
            f = " Event.Ename = '" + eName + "'" + " and Event.Description  like '%" + dKey + "'";
        }
        if (!eName.isEmpty() && !sDate.isEmpty()) {
            g = " Event.Ename = '" + eName + "'" + " and Event.StartDate >= '" + sDate +  "'";
        }
        if (!eName.isEmpty() && !eDate.isEmpty()) {
            h = " Event.Ename = '" + eName + "'" + " and Event.EndDate =< '" + eDate + "'";
        }
        if (!dKey.isEmpty() && !sDate.isEmpty()) {
            i = " Event.Description  like '%" + dKey + "%' and Event.StartDate >= '" + sDate +  "'";
        }
        if (!dKey.isEmpty() && !eDate.isEmpty()) {
            j = " Event.Description  like '%" + dKey + "%' and Event.EndDate =< '" + eDate + "'";
        }
        if (!sDate.isEmpty() && !eDate.isEmpty()) {
            date = " Event.StartDate >= '" + sDate + "' and Event.EndDate =< '" + eDate + "'";
        }
        if (!eName.isEmpty()) {
            eName = " Event.Ename = '" + eName + "'";
        }
        if (!dKey.isEmpty()) {
            dKey = " Event.Description  like '%" + dKey + "%'";
        }
        if (!sDate.isEmpty()) {
            sDate = " Event.StartDate >= '" + sDate + "'";
        }
        if (!eDate.isEmpty()) {
            eDate = " Event.EndDate =< '" + eDate + "'";
        }


        String query =
                "Select Event.EName, Event.SName, Event.StartDate, Event.EndDate, count(distinct AssignTo.StaffUsername) as 'Staff Count'\n" +
                        "from Event \n" +
                        "join AssignTo on Event.EName = AssignTo.EName and Event.StartDate = AssignTo.StartDate and Event.SName = AssignTo.SiteName\n" +
                        w + a + b + c + d + e + f + g + h + i + j + date + eName + dKey + sDate + eDate + ";";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
        } catch (SQLException s) {
            System.out.println("Something is wrong with your SQL schedule: " + s);
        }
        ResultSet rs = Connector.dbExecuteQuery(query);
        ObservableList<String> list = FXCollections.observableArrayList();
        while (rs.next()) {
            eName = rs.getString(1);
            String sName = rs.getString(2);
            sDate = rs.getString(3);
            eDate = rs.getString(4);
            String sCount = rs.getString(5);
            list.add(eName + sName + sDate + eDate + sCount);
        }
        return list;
    }
}
