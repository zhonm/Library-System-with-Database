// Importing SQL package classes for database operations
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Class to handle database operations related to returning books
public class ReturnBookDatabase {

    // Method to delete the book issue entry from the database
    public static int delete(String bookcallno, String studentid) {
        // Status to keep track of the operation success
        int status = 0;
        try {
            // Establishing a connection to the database
            Connection con = Database.getConnection();

            // Updating the book's quantity before deletion
            status = updatebook(bookcallno);

            // If the book update is successful, proceed to delete
            if (status > 0) {
                // Preparing SQL statement to delete the book issue entry
                PreparedStatement ps = con.prepareStatement("DELETE FROM issuebooks WHERE Book_Number=? AND Student_ID=?");
                // Setting the parameters for the SQL statement
                ps.setString(1, bookcallno);
                ps.setString(2, studentid);
                // Executing the update and storing the result in status
                status = ps.executeUpdate();
            }

            // Closing the database connection
            con.close();
        } catch (Exception e) {
            // Printing any exception that occurs
            System.out.println(e);
        }
        // Returning the operation status
        return status;
    }

    // Method to update the book's quantity in the database
    public static int updatebook(String bookcallno) {
        // Status to keep track of the operation success
        int status = 0;
        // Variable to store the current quantity of the book
        int quantity = 0;
        try {
            // Establishing a connection to the database
            Connection con = Database.getConnection();

            // Preparing SQL statement to select the book's quantity
            PreparedStatement ps = con.prepareStatement("SELECT Quantity FROM books WHERE Book_Number=?");
            // Setting the parameter for the SQL statement
            ps.setString(1, bookcallno);
            // Executing the query and storing the result in a ResultSet
            ResultSet rs = ps.executeQuery();
            // If the book exists, retrieve its current quantity
            if (rs.next()) {
                quantity = rs.getInt("Quantity");
            }

            // Preparing SQL statement to update the book's quantity
            PreparedStatement ps2 = con.prepareStatement("UPDATE books SET Quantity=? WHERE Book_Number=?");
            // Incrementing the book's quantity by 1
            ps2.setInt(1, quantity + 1);
            // Setting the parameter for the SQL statement
            ps2.setString(2, bookcallno);

            // Executing the update and storing the result in status
            status = ps2.executeUpdate();
            // Closing the database connection
            con.close();
        } catch (Exception e) {
            // Printing any exception that occurs
            System.out.println(e);
        }
        // Returning the operation status
        return status;
    }
}
