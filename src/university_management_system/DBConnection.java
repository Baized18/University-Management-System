package university_management_system; // Package for university management system

import java.sql.*; // JDBC package for database connectivity

public class DBConnection { // Class to handle MySQL database connection

    public Connection c; // Connection object to connect to database
    public Statement s;  // Statement object to execute SQL queries

    public DBConnection() { // Constructor to initialize DB connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            c = DriverManager.getConnection( // Establish connection
                "jdbc:mysql:///university_management_system", // Database URL
                "Baized", // Database username
                "2442" // Database password
            );
            s = c.createStatement(); // Create statement object for executing queries
        } catch(Exception e) {
            e.printStackTrace(); // Print exception if connection fails
        }
    }
}