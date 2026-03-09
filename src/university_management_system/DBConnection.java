package university_management_system;

import java.sql.*;

public class DBConnection {

    public Connection c;
    public Statement s;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                "jdbc:mysql:///university_management_system", 
                "Baized", 
                "2442"
            );
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}