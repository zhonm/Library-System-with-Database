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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

public class LibrarianAdminForm extends JFrame {
    private static final long serialVersionUID = 1L;
    static LibrarianAdminForm frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldCity;
    private JTextField textFieldContact;
    private JPasswordField passwordField;

    // Main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new LibrarianAdminForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor to set up the form
    public LibrarianAdminForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
        setResizable(false);
        setTitle("Librarian Admin Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 658, 530);

        // Panel for the content
        contentPane = new JPanel();
        contentPane.setBorder(new CompoundBorder());
        setContentPane(contentPane);

        // Labels
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblContact = new JLabel("Contact:");
        lblContact.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // Text fields
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textFieldEmail.setColumns(10);

        textFieldAddress = new JTextField();
        textFieldAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textFieldAddress.setColumns(10);

        textFieldCity = new JTextField();
        textFieldCity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textFieldCity.setColumns(10);

        textFieldContact = new JTextField();
        textFieldContact.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textFieldContact.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        // Add User button
        JButton btnNewButton = new JButton("Add User");
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input data
                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String email = textFieldEmail.getText();
                String address = textFieldAddress.getText();
                String city = textFieldCity.getText();
                String contact = textFieldContact.getText(); // Get contact input

                // Save user data
                int i = LibrarianDatabase.save(name, password, email, address, city, contact); // Add contact to save method
                if (i > 0) {
                    JOptionPane.showMessageDialog(LibrarianAdminForm.this, "User added successfully!");
                    AdminHomePage.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(LibrarianAdminForm.this, "Sorry, unable to save!");
                }
            }
        });
        btnNewButton.setForeground(Color.WHITE);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminHomePage.main(new String[]{});
                frame.dispose();
            }
        });

        // Panel for the header
        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.GRAY);

        // GroupLayout for arranging components
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(lblName))
                            .addGap(72))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addPreferredGap(ComponentPlacement.RELATED)))
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(passwordField)
                        .addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                        .addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                            .addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addGap(26)
                            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textFieldCity, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldContact, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)) // Add contact field
                    .addGap(131))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCity, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addComponent(lblContact, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)) // Add contact label
                    .addGap(436))
                .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(15)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblName)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblAddress)
                        .addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblCity)
                        .addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblContact) // Add contact label
                        .addComponent(textFieldContact, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)) // Add contact field
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(62, Short.MAX_VALUE))
                    );
        
        // Add label for the header panel
        JLabel lblAddLibrarian = new JLabel("Add User Form");
        panel.add(lblAddLibrarian);
        lblAddLibrarian.setForeground(Color.WHITE);
        lblAddLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 34));
        contentPane.setLayout(gl_contentPane);
    }
}