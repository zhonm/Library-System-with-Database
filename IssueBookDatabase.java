import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// This class handles database operations related to issuing books
public class IssueBookDatabase {

    // Method to check if a book is available in the database
    public static boolean checkBook(String bookcallno) {
        boolean status = false;
        try {
            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Prepare a SQL query to find the book by its call number
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE Book_Number=?");
            ps.setString(1, bookcallno);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            // If the book exists, set status to true
            status = rs.next();
            // Close the connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            e.printStackTrace();
        }
        return status;
    }

    // Method to save the issue details of a book to a student
    public static int save(String bookcallno, String studentid, String studentname, String studentcontact) {
        int status = 0;
        try {
            // Check if the book is available
            if (!checkBook(bookcallno)) {
                return 0; // Return 0 if the book is not found
            }

            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Update the book's quantity in the database
            status = updatebook(con, bookcallno);

            // If the update is successful, proceed to issue the book
            if (status > 0) {
                // Check if the book has already been issued to the same student
                PreparedStatement checkIssuedStmt = con.prepareStatement("SELECT * FROM issuebooks WHERE Book_Number=? AND Student_ID=?");
                checkIssuedStmt.setString(1, bookcallno);
                checkIssuedStmt.setString(2, studentid);
                ResultSet existingIssuedEntities = checkIssuedStmt.executeQuery();
                if (existingIssuedEntities.next()) {
                    // If the book is already issued, print a message and return 0
                    System.out.println("This entity has already been issued to the same student.");
                    return 0;
                }
                // Prepare a SQL statement to insert the issue details into the database
                PreparedStatement ps = con.prepareStatement("INSERT INTO issuebooks(Book_Number, Student_ID, Student_Name, Student_Contact) VALUES (?, ?, ?, ?)");
                ps.setString(1, bookcallno);
                ps.setString(2, studentid);
                ps.setString(3, studentname);
                ps.setString(4, studentcontact);
                // Execute the update
                status = ps.executeUpdate();
            }

            // Close the connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            e.printStackTrace();
        }
        return status;
    }

    // Method to update the book's quantity in the database
    public static int updatebook(Connection con, String bookcallno) {
        int status = 0;
        int quantity = 0;
        try {
            // Prepare a SQL query to get the current quantity of the book
            PreparedStatement ps = con.prepareStatement("SELECT Quantity FROM books WHERE Book_Number=?");
            ps.setString(1, bookcallno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Get the current quantity
                quantity = rs.getInt("Quantity");
            }

            // If there are books available, decrease the quantity by 1
            if (quantity > 0) {
                PreparedStatement ps2 = con.prepareStatement("UPDATE books SET Quantity=? WHERE Book_Number=?");
                ps2.setInt(1, quantity - 1);
                ps2.setString(2, bookcallno);
                // Execute the update
                status = ps2.executeUpdate();
            }
        } catch (Exception e) {
            // Print any exception that occurs
            e.printStackTrace();
        }
        return status;
    }

    // Method to update the issue details of a book
    public static int update(String bookcallno, String studentid, String studentname, String studentcontact) {
        int status = 0;
        try {
            // Establish a connection to the database
            Connection con = Database.getConnection();
            // Prepare a SQL statement to update the issue details
            PreparedStatement ps = con.prepareStatement(
                "UPDATE issuebooks SET Student_Name=?, Student_Contact=? WHERE Book_Number=? AND Student_ID=?");
            ps.setString(1, studentname);
            ps.setString(2, studentcontact);
            ps.setString(3, bookcallno);
            ps.setString(4, studentid);
            // Execute the update
            status = ps.executeUpdate();
            // Close the connection
            con.close();
        } catch (Exception e) {
            // Print any exception that occurs
            e.printStackTrace();
        }
        return status;
    }
}
