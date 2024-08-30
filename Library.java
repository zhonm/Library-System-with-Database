import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Class for creating the main library system window
public class Library extends JFrame {

	private static final long serialVersionUID = 1L;
	static Library frame;
	private JPanel contentPane;

	// Main method to run the library system window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Library();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to set up the library system window
	public Library() {
		// Set the icon for the window
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Disable resizing of the window
		setTitle("Our Lady Of Fatima University Library System"); // Set the title of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 594, 392); // Set the size and position of the window
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder()); // Set the border for the content pane
		setContentPane(contentPane); // Add the content pane to the window
		
		// Button for admin login
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(Color.RED);
		btnAdminLogin.setForeground(Color.WHITE);
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose(); // Close the library system window
			}
		});
		btnAdminLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button for user (librarian) login
		JButton btnLibrarianLogin = new JButton("User Login");
		btnLibrarianLogin.setBackground(Color.BLUE);
		btnLibrarianLogin.setForeground(Color.WHITE);
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianLogin.main(new String[]{});
			}
		});
		btnLibrarianLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Panel for the header of the window
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		
		// Placeholder label for an image (not used)
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Library.class.getResource("/images/hiclipart.com (1).png")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdminLogin, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
						.addComponent(btnLibrarianLogin, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 493, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addGap(78))
		);
		
		// Label for the title of the window
		JLabel lblLibraryManagement = new JLabel("OLFU Library Management System");
		panel.add(lblLibraryManagement);
		lblLibraryManagement.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblLibraryManagement.setForeground(Color.GREEN);
		contentPane.setLayout(gl_contentPane);
	}
}
