package BeltLineApplication.java.database;

import BeltLineApplication.java.database.Connector;
import BeltLineApplication.java.model.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    /**
     * Register a User
     */
    public static void registerUser(String username, String password, String fname, String lname) throws SQLException {
        String query =
                "BEGIN\n" +
                        "INSERT INTO user\n" +
                        "(USERNAME, PASSWORD, STATUS, FNAME, LNAME)\n" +
                        "VALUES\n"
                        + "'" + username + "','" + password + "','" + "Pending" + "','" + fname + "', '" + lname + "',);\n" +
                        "END;";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register User Query" + e);
        }
    }

    /**
     * Login a User
    */
    private static boolean loginUser(String username, String password) throws SQLException, ClassNotFoundException {
        String query =
                "BEGIN\n" +
                        "Select * from user\n" +
                        "where username = " + "'" + username +  "','" + password + "';" +
                        "END;";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            return rs != null;
        } catch (SQLException e) {
            System.out.println("Something is wrong with your SQL: " + e);
            throw e;
        }
    }

    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    private static User getUser(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setStatus(rs.getString("Status"));
            user.setFname(rs.getString("Fname"));
            user.setLname(rs.getString("Lname"));
        }
        return user;
    }
}
