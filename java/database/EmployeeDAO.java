package BeltLineApplication.java.database;

import java.sql.SQLException;

public class EmployeeDAO extends UserDAO {
    /**
     * Register a Employee
     */
    public static void registerEmployee(String username, String phone, String address, String city, String state, int zipcode) throws SQLException {
        String query =
                "INSERT INTO employee" +
                        "(Username, EmployeeID, Phone, Address, City, State, Zipcode)" +
                        "VALUES ('" + username + "','" + 1 + "','" + phone + "','" + address + "', '" +
                        city + "', '" + state + "', '" + zipcode + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Employee Query" + e);
        }

    }
}
