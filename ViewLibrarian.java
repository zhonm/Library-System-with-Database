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

// Class to display the librarian details in a table format
public class ViewLibrarian extends JFrame {

    // Serialization ID for the JFrame
    private static final long serialVersionUID = 1L;
    // Panel to contain all the components
    private JPanel contentPane;
    // Table to display the librarian data
    private JTable table;

    // Main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Creating and displaying this application's GUI
                    ViewLibrarian frame = new ViewLibrarian();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor to initialize the JFrame components
    public ViewLibrarian() {
        // Setting the icon image for the JFrame
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
        // Setting the title of the JFrame
        setTitle("User List Page");
        // Setting the default close operation
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // Setting the bounds of the JFrame
        setBounds(100, 100, 686, 451);
        // Initializing the content pane
        contentPane = new JPanel();
        // Setting a border for the content pane
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Setting the layout manager for the content pane
        contentPane.setLayout(new BorderLayout(0, 0));
        // Adding the content pane to the JFrame
        setContentPane(contentPane);

        // Initializing the data array for table rows
        String data[][]=null;
        // Initializing the column array for table headers
        String column[]=null;
        try{
            // Establishing a connection to the database
            Connection con=Database.getConnection();
            // Preparing SQL statement to fetch all librarian details
            PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            // Executing the query
            ResultSet rs=ps.executeQuery();
            
            // Getting metadata of the result set
            ResultSetMetaData rsmd=rs.getMetaData();
            // Getting the number of columns
            int cols=rsmd.getColumnCount();
            // Populating the column headers
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }
            
            // Moving to the last row to get the row count
            rs.last();
            int rows=rs.getRow();
            // Moving back before the first row to begin iteration
            rs.beforeFirst();

            // Populating the data for table rows
            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            // Closing the database connection
            con.close();
        }catch(Exception e){
            // Printing any exception that occurs
            System.out.println(e);
        }
        
        // Creating the table with the fetched data
        table = new JTable(data,column);
        // Adding a scroll pane to the table
        JScrollPane sp=new JScrollPane(table);
        
        // Adding the scroll pane to the center of the content pane
        contentPane.add(sp, BorderLayout.CENTER);
    }
}
