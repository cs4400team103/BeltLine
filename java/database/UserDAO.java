package BeltLineApplication.java.database;

import BeltLineApplication.java.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    /**
     * Register a User
     */
    public static void registerUser(String username, String password, String fname, String lname) throws SQLException {
        String query =
                        "INSERT INTO user" +
                        "VALUES ('" + username + "','" + password + "','" + "Pending" + "','" + fname + "', '" +
                                lname + "',);";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register User Query" + e);
        }
    }

    /**
     * UserLoginController a User
     */
    //TODO: Make sure that string is email and not username! thanks :-)
    public static boolean loginUser(String username, String password) throws SQLException, ClassNotFoundException {
        String query =
                "select * from user where username = '" + username + "' and password = '" + password + "';";
        try {
            ResultSet rs = Connector.dbExecuteQuery(query);
            return (rs != null);
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
