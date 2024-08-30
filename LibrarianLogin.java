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
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Class for creating the librarian login window
public class LibrarianLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	static LibrarianLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	// Main method to run the librarian login window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to initialize the librarian login window
	public LibrarianLogin() {
		// Set the icon for the window
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Make the window non-resizable
		setTitle("Librarian Login Page"); // Set the title of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 516, 385); // Set the size and position of the window
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder()); // Set the border for the content pane
		setContentPane(contentPane); // Add the content pane to the window
		
		// Label for the name input field
		JLabel lblEnterName = new JLabel("Name:");
		lblEnterName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Label for the password input field
		JLabel lblEnterPassword = new JLabel("Password:");
		lblEnterPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Text field for entering the name
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		
		// Login button with action listener
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				// Validate the librarian's credentials
				if(LibrarianDatabase.validate(name, password)){
					LibrarianHomePage.main(new String[]{});
					frame.dispose(); // Close the login window
				}else{
					// Show error message if credentials are incorrect
					JOptionPane.showMessageDialog(LibrarianLogin.this, "Username or Password Incorrect", "Login Error!", JOptionPane.ERROR_MESSAGE);
					textField.setText(""); // Clear the name field
					passwordField.setText(""); // Clear the password field
				}
			}
		});
		
		// Password field for entering the password
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		// Panel for the top section of the window
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLUE);
		
		// Back button with action listener
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.GRAY);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				dispose(); // Close the current window
			}
		});
		
		// Layout for the content pane
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterName)
						.addComponent(lblEnterPassword))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
					.addGap(34))
		);
		
		// Label for the Librarian Login form
		JLabel lblAdminLoginForm = new JLabel("Librarian Login");
		panel.add(lblAdminLoginForm);
		lblAdminLoginForm.setForeground(Color.WHITE);
		lblAdminLoginForm.setFont(new Font("Times New Roman", Font.BOLD, 34));
		contentPane.setLayout(gl_contentPane);
	}
}
