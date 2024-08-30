import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class IssueBookForm extends JFrame {

    private static final long serialVersionUID = 1L;
    static IssueBookForm frame;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2; 
    private JTextField textField_3;
    private JTextField textField_4; 
    
    // Main method to launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new IssueBookForm(); // Create an instance of IssueBookForm
                    frame.setVisible(true); // Make the frame visible
                } catch (Exception e) {
                    e.printStackTrace(); // Print any exceptions to the console
                }
            }
        });
    }

    // Constructor to create the form
    public IssueBookForm() {
        setResizable(false); // Disable window resizing
        setIconImage(Toolkit.getDefaultToolkit().getImage(IssueBookForm.class.getResource("/images/hiclipart.com (1).png"))); // Set the window icon
        setTitle("Issue Entity Page"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setBounds(100, 100, 701, 487); // Set the position and size of the window
        contentPane = new JPanel();
        contentPane.setBorder(new CompoundBorder()); // Set border for the content pane
        setContentPane(contentPane); // Set the content pane
        
        // Labels for the form fields
        JLabel lblBookName = new JLabel("Book Number:");
        lblBookName.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_1.setColumns(10);
        
        JLabel lblStudentId = new JLabel("Student ID:");
        lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        JLabel lblStudentName = new JLabel("Name:");
        lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        JLabel lblStudentContact = new JLabel("Contact:");
        lblStudentContact.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        // Button to issue a book
        JButton btnIssueBook = new JButton("Issue Item");
        btnIssueBook.setBackground(Color.BLUE);
        btnIssueBook.setForeground(Color.WHITE);
        btnIssueBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnIssueBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input from text fields
                String booknumber = textField_1.getText();
                String studentid = textField_2.getText();
                String studentname = textField_3.getText();
                String studentcontact = textField_4.getText();
                
                if (IssueBookDatabase.checkBook(booknumber)) {
                    // Save issued book details to database
                    int i = IssueBookDatabase.save(booknumber, studentid, studentname, studentcontact);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!"); // Show success message
                        LibrarianHomePage.main(new String[]{}); // Navigate to home page
                        frame.dispose(); // Close current form
                    } else {
                        JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, Unable to issue!"); // Show failure message
                    }
                } else {
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, Book doesn't exist!"); // Show error message if book doesn't exist
                }
            }
        });
        
        // Button to go back to the previous page
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianHomePage.main(new String[]{}); // Navigate to home page
                frame.dispose(); // Close current form
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBorder(null); // Remove border from the panel
        panel.setBackground(Color.GRAY); // Set background color for the panel
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_4.setColumns(10);
        
        // Group layout to arrange the components
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(20)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblStudentContact, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentId)
                        .addComponent(lblBookName))
                    .addGap(106)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addGap(18)
                            .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                    .addGap(43))
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(37)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBookName))
                    .addGap(30)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentId))
                    .addGap(28)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentName))
                    .addGap(28)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentContact))
                    .addGap(55)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(btnIssueBook, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGap(30))
        );
        
        // Add title label to the panel
        JLabel lblNewLabel = new JLabel("Issue Entity");
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
        lblNewLabel.setForeground(Color.WHITE);
        contentPane.setLayout(gl_contentPane); // Set the layout for the content pane
    }
}
