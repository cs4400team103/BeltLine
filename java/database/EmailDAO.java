package BeltLineApplication.java.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailDAO {
    public static String getUsername(String email) {
        String username ="";
        String query = "SELECT username where email = '" + email + "';";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);

            while(rs.next()) {
                username = rs.getString("Username");
            }
            return username;
        } catch (Exception e) {
            System.out.println("Error with get username query" + e);
        }
        return username;
    }

    public static void registerEmail(String username, String email) {
        String query =
                "INSERT INTO email" +
                        "(Username, Email)" +
                        "VALUES ('" + username + "','" + email + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Email Query" + e);
        }
    }
}
