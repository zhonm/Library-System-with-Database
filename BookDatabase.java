import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// This class handles the database operations for books
public class BookDatabase {

    // Method to establish a connection to the database
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return con; // Return the established connection
    }

    // Method to save a new book to the database
    public static int save(String codeNumber, String name, String author, String publisher, int quantity) {
        int status = 0; // Status of the database operation
        try {
            // Get a connection to the database
            Connection con = BookDatabase.getConnection();
            // Prepare the SQL statement for insertion
            PreparedStatement ps = con.prepareStatement("insert into books(book_number, name, author, publisher, quantity) values(?,?,?,?,?)");
            // Set the values for the prepared statement
            ps.setString(1, codeNumber);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
            // Execute the update and get the status
            status = ps.executeUpdate();
            // Close the database connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return status; // Return the status of the operation
    }

    // Method to update an existing book in the database
    public static int update(String codeNumber, String name, String author, String publisher, int quantity) {
        int status = 0; // Status of the database operation
        try {
            // Get a connection to the database
            Connection con = BookDatabase.getConnection();
            // Prepare the SQL statement for updating
            PreparedStatement ps = con.prepareStatement("update books set name=?, author=?, publisher=?, quantity=? where book_number=?");
            // Set the values for the prepared statement
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, publisher);
            ps.setInt(4, quantity);
            ps.setString(5, codeNumber);
            // Execute the update and get the status
            status = ps.executeUpdate();
            // Close the database connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return status; // Return the status of the operation
    }
}
