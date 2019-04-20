package BeltLineApplication.java.database;

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
        String query = "Insert into";
    }


}
