// Importing necessary libraries for GUI components
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Class for handling the book return functionality
public class ReturnBook extends JFrame {

    // Serialization ID for the JFrame
    private static final long serialVersionUID = 1L;
    // Static instance of this frame
    static ReturnBook frame;
    // Panel to contain all the components
    private JPanel contentPane;
    // Text fields for user input
    private JTextField textField;
    private JTextField textField_1;

    // Main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Creating and displaying this application's GUI
                    frame = new ReturnBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor to initialize the JFrame components
    public ReturnBook() {
        // Setting the icon image for the JFrame
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
        // Setting the title of the JFrame
        setTitle("Return Books Page");
        // Disabling the resize feature
        setResizable(false);
        // Setting the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting the bounds of the JFrame
        setBounds(100, 100, 701, 423);
        // Initializing the content pane
        contentPane = new JPanel();
        // Setting a border for the content pane
        contentPane.setBorder(new CompoundBorder());
        // Adding the content pane to the JFrame
        setContentPane(contentPane);

        // Label for book number input
        JLabel lblBookCallno = new JLabel("Book Number:");
        lblBookCallno.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // Label for student ID input
        JLabel lblStudentId = new JLabel("Student ID:");
        lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // Text field for entering the book number
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setColumns(10);

        // Text field for entering the student ID
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_1.setColumns(10);

        // Button to return the book
        JButton btnReturnBook = new JButton("Return Item");
        btnReturnBook.setBackground(Color.RED);
        btnReturnBook.setForeground(Color.WHITE);
        btnReturnBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
        // Adding action listener for the return button
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Getting text from text fields
                String bookcallno = textField.getText();
                String studentid = textField_1.getText();
                
                // Validation for student ID length
                if (studentid.length() < 10) {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Incorrect student id, Please try again!");
                    return;
                }
                
                // Attempting to delete the book entry from the database
                int i = ReturnBookDatabase.delete(bookcallno, studentid);
                // If deletion is successful, show success message
                if (i > 0) {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Book returned successfully!");
                    // Redirecting to the librarian home page
                    LibrarianHomePage.main(new String[]{});
                    // Disposing the current frame
                    frame.dispose();
                } else {
                    // If deletion fails, show error message
                    JOptionPane.showMessageDialog(ReturnBook.this, "Incorrect student id, Please try again!");
                }
            }
        });

        // Button to go back to the previous page
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        // Adding action listener for the back button
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirecting to the librarian home page
                LibrarianHomePage.main(new String[]{});
                // Disposing the current frame
                frame.dispose();
            }
        });

        // Panel for the return book label
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder());
        panel.setBackground(Color.GRAY);
        // Group layout for arranging components in the content pane
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(27)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblBookCallno, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        					.addGap(0))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblStudentId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(18)))
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
        				.addComponent(textField_1, 432, 432, 432)
        				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
        			.addGap(116))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(68)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblBookCallno))
        			.addGap(28)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblStudentId))
        			.addGap(40)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnReturnBook, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        			.addContainerGap(52, Short.MAX_VALUE))
        );

        // Label for the return book panel
        JLabel lblReturnBook = new JLabel("Return Books");
        panel.add(lblReturnBook);
        lblReturnBook.setForeground(Color.WHITE);
        lblReturnBook.setFont(new Font("Times New Roman", Font.BOLD, 34));
        // Setting the layout for the content pane
        contentPane.setLayout(gl_contentPane);
    }
}
