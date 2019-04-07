package BeltLineApplication.java.database;

import BeltLineApplication.java.database.Connector;
import BeltLineApplication.java.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    /* *
     * Register a User
     */
    public static User registerUser(String username, String password, String fname, String lname) throws SQLException {
        String query =
                "BEGIN\n" +
                        "INSERT INTO user\n" +
                        "(USERNAME, PASSWORD, STATUS, FNAME, LNAME)\n" +
                        "VALUES\n"
                        + username + "', '" + password + "','" + "Pending" + "','" + fname + "', '" + lname + "',);\n" +
                        "END;";
        try {
            //ResultSet result = Connector.executeQuery(query);
            User user = null;
            //User user = setUser(result);
            return user;
        } catch (Exception e) {
            System.out.println("Error with Register User Query" + e);
            throw e;
        }
    }

    private static User setUser(ResultSet rs) throws SQLException {
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
