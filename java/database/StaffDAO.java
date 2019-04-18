package BeltLineApplication.java.database;

public class StaffDAO {
    public static void registerStaff(String username) {
        String query =
                "INSERT INTO staff" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Employee Query" + e);
        }
    }
}
