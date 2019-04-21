package BeltLineApplication.java.database;

import BeltLineApplication.java.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    /**
     * Register a User
     */
    public static void registerUser(String username, String password, String fname, String lname) throws SQLException {
        //password = hash(password);
        String query =
                "INSERT INTO user" +
                        "(Username, Password, Status, FirstName, LastName)" +
                        "VALUES ('" + username + "','" + password + "','" + "Pending" + "','" + fname + "', '" +
                        lname + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register User Query" + e);
        }
    }

//    public static String hash(String password) {
//        String pass = password;
//        String query = "DECLARE @pswd NVARCHAR(50) = '" + password + "'; \n" +
//                "DECLARE @salt VARBINARY(4) = CRYPT_GEN_RANDOM(4);\n" +
//                "DECLARE @hash VARBINARY(50); \n" +
//                "SET @hash = 0x0200 + @salt + HASHBYTES('SHA2_512', CAST(@pswd AS VARBINARY(MAX)) + @salt); \n" +
//                "SELECT @hash AS Password;";
//        try {
//            ResultSet rs = Connector.dbExecuteQuery(query);
//            while (rs.next()) {
//                pass = rs.getString(0);
//            }
//        } catch (Exception e) {
//            System.out.println("Error with hash User Query" + e);
//        }
//        return pass;
//    }

    /**
     * UserLoginController a User
     */
    public static boolean loginUser(String email, String password) throws SQLException, ClassNotFoundException {
        String query =
                "select * from user join email on user.username = email.username where email = '"
                        + email + "' and password = '" + password + "';";
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

    public static String isUser(String username) throws SQLException, ClassNotFoundException {
        String mang = "Manager";
        String mangVisitor = "ManagerVisitor";
        String admin = "Administrator";
        String adminVisitor = "AdministratorVisitor";
        String staff = "Staff";
        String staffVisitor = "StaffVisitor";
        String visitor = "Visitor";
        String user = "User";

        String query = "SELECT exists (SELECT username from ";
        String where = " WHERE username = '" + username + "';";

        //if manager
        try {
            query = query + mang + where;
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    try {
                        query = query + visitor + where;
                        ResultSet second = Connector.dbExecuteQuery(query);
                        while (second.next()) {
                            String numSec = rs.getString(0);
                            if (Integer.parseInt(numSec) == 1) {
                                return mangVisitor;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error with getting admin visitor type " + e);
                    }
                }
                return mang;
            }
        } catch (Exception e) {
            System.out.println("Error with getting manager type " + e);
        }

        //if admin
        try {
            query = query + admin + where;
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    try {
                        query = query + visitor + where;
                        ResultSet second = Connector.dbExecuteQuery(query);
                        while (second.next()) {
                            String numSec = rs.getString(0);
                            if (Integer.parseInt(numSec) == 1) {
                                return adminVisitor;
                            }
                            return admin;
                        }
                    } catch (Exception e) {
                        System.out.println("Error with getting admin visitor type " + e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error with getting staff type " + e);
        }

        //if staff
        try {
            query = query + staff + where;
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    try {
                        query = query + visitor + where;
                        ResultSet second = Connector.dbExecuteQuery(query);
                        while (second.next()) {
                            String numSec = rs.getString(0);
                            if (Integer.parseInt(numSec) == 1) {
                                return staffVisitor;
                            }
                            return staff;
                        }
                    } catch (Exception e) {
                        System.out.println("Error with getting staff visitor type " + e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error with getting staff type " + e);
        }

        //if visitor
        try {
            query = query + visitor + where;
            ResultSet rs = Connector.dbExecuteQuery(query);
            while (rs.next()) {
                String num = rs.getString(0);
                if (Integer.parseInt(num) == 1) {
                    return visitor;
                }
            }
        } catch (Exception e) {
            System.out.println("Error with getting visitor type " + e);
        }

        return user;
    }
}
