import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Main class for the admin home page
public class AdminHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	static AdminHomePage frame;
	private JPanel contentPane;

	// Entry point of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to initialize the admin home page
	public AdminHomePage() {
		// Set the icon of the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Make the frame non-resizable
		setTitle("Admin Home Page"); // Set the title of the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 582, 477); // Set the bounds of the frame
		
		contentPane = new JPanel(); // Create a new content pane
		contentPane.setBorder(new CompoundBorder()); // Set the border of the content pane
		setContentPane(contentPane); // Add the content pane to the frame
		
		// Button to add a new user
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianAdminForm.main(new String[]{});
				frame.dispose();
			}
		});
		
		// Button to view existing users
		JButton btnViewLibrarian = new JButton("View User");
		btnViewLibrarian.setBackground(Color.GRAY);
		btnViewLibrarian.setForeground(Color.WHITE);
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewLibrarian.main(new String[]{});
			}
		});
		btnViewLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to delete a user
		JButton btnDeleteLibrarian = new JButton("Delete User");
		btnDeleteLibrarian.setBackground(Color.GRAY);
		btnDeleteLibrarian.setForeground(Color.WHITE);
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarian.main(new String[]{});
				frame.dispose();
			}
		});
		btnDeleteLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to sign out
		JButton btnLogout = new JButton("SignOut");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Red panel at the top of the frame
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		
		// Secondary panel
		JPanel panel_1 = new JPanel();
		
		// Layout for the content pane
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		// Horizontal group layout configuration
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		// Vertical group layout configuration
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(67))
		);
		
		// Label for the new label icon
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon(AdminHomePage.class.getResource("/images/laptop.png")));
		panel_1.add(lblNewLabel);
		
		// Label for the admin section
		JLabel lblAdminSection = new JLabel("OLFU Admin Home");
		panel.add(lblAdminSection);
		lblAdminSection.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblAdminSection.setForeground(Color.WHITE);
		
		// Set the layout for the content pane
		contentPane.setLayout(gl_contentPane);
	}
}
