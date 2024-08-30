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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Main class for the Admin Login window
public class AdminLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	static AdminLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	// Entry point of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Constructor to initialize the Admin Login window
	public AdminLogin() {
		// Set the icon for the window
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Make the window non-resizable
		setTitle("Admin Login Page"); // Set the title of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 478, 330); // Set the size and position of the window
		
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
				// Check if the credentials are correct
				if(name.equals("admin") && password.equals("admin")){
					AdminHomePage.main(new String[]{});
					frame.dispose(); // Close the login window
				}else{
					// Show error message if credentials are incorrect
					JOptionPane.showMessageDialog(AdminLogin.this, "Username or Password Incorrect", "Login Error!", JOptionPane.ERROR_MESSAGE);
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
		panel.setBackground(Color.RED);
		
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterPassword)
						.addComponent(lblEnterName))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterPassword))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		// Label for the Admin Login form
		JLabel lblAdminLoginForm = new JLabel("Admin Login");
		panel.add(lblAdminLoginForm);
		lblAdminLoginForm.setForeground(Color.WHITE);
		lblAdminLoginForm.setFont(new Font("Times New Roman", Font.BOLD, 34));
		contentPane.setLayout(gl_contentPane);
	}
}
