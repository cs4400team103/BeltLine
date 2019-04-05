package BeltLineApplication.java.database;

import java.sql.*;

//The connector class allows connection to the MYSQL database.
// We can write simple queries here that will allow users to insert
// data to the database.
public class connector {
    public static void main(String args[]) {
    //create connection
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //this is your connector to the database. Make sure you change the user/password and even maybe the connection url
            //if you have a different one.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beltline","root","Robin12#");

            Statement stmt=con.createStatement();

            // TODO: Complete database connection
            /** TODO: Figure out if we need to add insert queries through here or we can hard code it?
             * Obviously we will need some but it will be under other DAOs.
             */
        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
