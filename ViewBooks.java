// Importing necessary packages for GUI and database operations
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;

// Class to display the books in a table format
public class ViewBooks extends JFrame {
    // Serialization ID for the JFrame
    private static final long serialVersionUID = 1L;
    // Panel to contain all the components
    private JPanel contentPane;
    // Table to display the book data
    private JTable table;

    // Main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Creating and displaying this application's GUI
                    ViewBooks frame = new ViewBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor to initialize the JFrame components
    public ViewBooks() {
        // Setting the icon image for the JFrame
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
        // Setting the title of the JFrame
        setTitle("Books List Page");
        // Setting the default close operation
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // Setting the bounds of the JFrame
        setBounds(100, 100, 631, 451);
        // Initializing the content pane
        contentPane = new JPanel();
        // Setting a border for the content pane
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Setting the layout manager for the content pane
        contentPane.setLayout(new BorderLayout(0, 0));
        // Adding the content pane to the JFrame
        setContentPane(contentPane);

        // Initializing the data array for table rows
        String data[][] = null;
        // Initializing the column array for table headers
        String column[] = null;
        try {
            // Establishing a connection to the database
            Connection con = BookDatabase.getConnection();
            // Preparing SQL statement to fetch all books
            PreparedStatement ps = con.prepareStatement("select * from books", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Executing the query
            ResultSet rs = ps.executeQuery();
            
            // Getting metadata of the result set
            ResultSetMetaData rsmd = rs.getMetaData();
            // Getting the number of columns
            int cols = rsmd.getColumnCount();
            // Populating the column headers
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = rsmd.getColumnName(i);
            }
            
            // Moving to the last row to get the row count
            rs.last();
            int rows = rs.getRow();
            // Moving back before the first row to begin iteration
            rs.beforeFirst();

            // Populating the data for table rows
            data = new String[rows][cols];
            int count = 0;
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = rs.getString(i);
                }
                count++;
            }
            // Closing the database connection
            con.close();
        } catch (Exception e) {
            // Printing any exception that occurs
            System.out.println(e);
        }

        // Creating the table with the fetched data
        table = new JTable(data, column);
        // Adding a scroll pane to the table
        JScrollPane sp = new JScrollPane(table);
        // Adding the scroll pane to the center of the content pane
        contentPane.add(sp, BorderLayout.CENTER);

        // Button to initiate editing of a selected book
        JButton btnEdit = new JButton("Click the book row you want to edit");
        btnEdit.setBackground(Color.BLUE);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 18));
        // Adding action listener for the edit button
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Getting the selected row index
                int selectedRow = table.getSelectedRow();
                // If a row is selected, proceed with editing
                if (selectedRow != -1) {
                    // Fetching data of the selected row
                    String codeNumber = table.getValueAt(selectedRow, 1).toString();
                    String name = table.getValueAt(selectedRow, 2).toString();
                    String author = table.getValueAt(selectedRow, 3).toString();
                    String publisher = table.getValueAt(selectedRow, 4).toString();
                    String quantity = table.getValueAt(selectedRow, 5).toString();

                    // Creating an instance of the book form for editing
                    BooksForm editForm = new BooksForm();
                    // Setting the form in edit mode with the selected book's data
                    editForm.setEditMode(codeNumber, name, author, publisher, quantity);
                    // Making the edit form visible
                    editForm.setVisible(true);
                    // Disposing the current frame
                    dispose();
                } else {
                    // If no row is selected, show an error message
                    JOptionPane.showMessageDialog(ViewBooks.this, "Please select a row to edit.");
                }
            }
        });

        // Adding the edit button to the bottom of the content pane
        contentPane.add(btnEdit, BorderLayout.SOUTH);
    }
}
