package BeltLineApplication.java.database;

import java.sql.SQLException;

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


}
