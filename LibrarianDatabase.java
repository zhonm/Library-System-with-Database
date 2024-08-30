import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// This class manages database operations for librarian records
public class LibrarianDatabase {

    // Method to save librarian details into the database
    public static int save(String name, String password, String email, String address, String city, String contact) {
        int status = 0; // To hold the result of database operation
        try {
            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Prepare SQL statement for inserting librarian data
            PreparedStatement ps = con.prepareStatement(
                "insert into librarian(Name, Password, Email, Address, City, Contact) values(?,?,?,?,?,?)");
            // Set the values for the prepared statement
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, contact);
            // Execute the update and store the status
            status = ps.executeUpdate();
            // Close the database connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return status; // Return the operation status
    }

    // Method to delete a librarian record from the database
    public static int delete(int id) {
        int status = 0; // To hold the result of database operation
        try {
            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Prepare SQL statement for deleting librarian data
            PreparedStatement ps = con.prepareStatement("delete from librarian where Unique_ID=?");
            // Set the unique ID for the prepared statement
            ps.setInt(1, id);
            // Execute the update and store the status
            status = ps.executeUpdate();
            // Close the database connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return status; // Return the operation status
    }

    // Method to validate librarian login credentials
    public static boolean validate(String name, String password) {
        boolean status = false; // To hold the validation result
        try {
            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Prepare SQL statement for selecting librarian data
            PreparedStatement ps = con.prepareStatement("select * from librarian where Name=? and Password=?");
            // Set the name and password for the prepared statement
            ps.setString(1, name);
            ps.setString(2, password);
            // Execute the query and store the result
            ResultSet rs = ps.executeQuery();
            // If the librarian exists, set status to true
            status = rs.next();
            // Close the database connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            System.out.println(e);
        }
        return status; // Return the validation result
    }
}
