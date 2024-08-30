import java.sql.Connection;
import java.sql.DriverManager;

// This class is responsible for creating a connection to the database
public class Database {
    // Method to establish and return a connection to the database
    public static Connection getConnection(){
        Connection con = null; // Initialize the connection object to null
        try{
            // Load the MySQL JDBC driver to enable database connection
            Class.forName("com.mysql.jdbc.Driver");
            // Attempt to establish a connection to the specified database URL with the given username and password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
        }catch(Exception e){
            // If there is any exception (error) during the database connection, print the error message
            System.out.println(e);
        }
        return con; // Return the database connection object
    }
}
