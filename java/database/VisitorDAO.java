package BeltLineApplication.java.database;

import java.sql.SQLException;

public class VisitorDAO extends UserDAO {
    public static void registerVisitor(String username,String password, String fname, String lname)throws SQLException {

        registerUser(username, password, fname, lname);

        String query =
                "INSERT INTO visitor" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Visitor Query" + e);
        }

    }
}
