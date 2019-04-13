package BeltLineApplication.java.database;

import java.sql.SQLException;

public class EmployeeDAO extends UserDAO {
    /**
     * Register a User
     */
    public static void registerEmployee(String username, String password, String fname, String lname, int employeeID,
                                        String phone, String address, String city, String state, int zipcode ) throws SQLException {
        /**
         * * Register a User
         */
        registerUser(username, password, fname, lname);

        /**
         * Register an Employee
         */
        String query =
                "INSERT INTO employee" +
                        "VALUES ('" + username + "','" + employeeID + "','" + phone + "','" + address + "', '" +
                            city + "', '" + state + "', '" + zipcode + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Employee Query" + e);
        }

        //if administrator or manager or staff

        /**
         * Register an Administrator
         */
        query =
              "INSERT INTO administrator" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Administrator Query" + e);
        }

        /**
         * Register a Manager
         */
        query =
                "INSERT INTO manager" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Manager Query" + e);
        }

        /**
         * Register a Staff
         */
        query =
                "INSERT INTO staff" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Staff Query" + e);
        }

    }

    public static void registerEVisitor(String un)throws SQLException{
        String query =
                "INSERT INTO visitor" +
                        "VALUES ('" + un + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Employee-Visitor Query" + e);
        }

    }
    public static void registerEmployeeVisitor(String username, String password, String fname, String lname, int employeeID,
                                               String phone, String address, String city, String state, int zipcode ) throws SQLException {
        registerEmployee(username, password, fname, lname, employeeID, phone, address, city, state, zipcode);
        registerEVisitor(username);

    }





}
