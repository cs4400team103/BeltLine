package BeltLineApplication.java.database;

import BeltLineApplication.java.model.Staff;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO {
    public static void registerStaff(String username) {
        String query =
                "INSERT INTO staff" +
                        "(Username)" +
                        "VALUES ('" + username + "');";
        try {
            Connector.dbExecuteUpdate(query);
        } catch (Exception e) {
            System.out.println("Error with Register Employee Query" + e);
        }
    }
    public static ObservableList<Staff> manageStaff() throws SQLException, ClassNotFoundException {
            String query = "select concat(user.firstname + \" \" + user.lastname) as 'Staff Name', COUNT(assignto.startdate) as '# Event Shifts'\n" +
                    "from user\n" +
                    "join assignto on user.username = assignto.staffusername;";
            try {
                ResultSet rs = Connector.dbExecuteQuery(query);
                ObservableList<Staff> staff = FXCollections.observableArrayList();;
                while (rs.next()) {
                    Staff s = new Staff();
                    s.setName(rs.getString(1));
                    s.setShifts(rs.getInt(2));
                    staff.add(s);
                }

            } catch (Exception e) {
                System.out.println("Error with update getting staff" + e);
            }
            return null;

    }

//    public static ObservableList<Staff>  filterStaff(){
//
//    }
}
