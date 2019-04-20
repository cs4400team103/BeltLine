package BeltLineApplication.java.database;

import java.sql.SQLException;

public class VisitorDAO extends UserDAO {
    public static void registerVisitor(String username)throws SQLException {
        String query =
                "INSERT INTO visitor" +
                        "(Username)" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Visitor Query" + e);
        }

    }
}
