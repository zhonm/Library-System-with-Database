import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Class for creating the main home page for the librarian
public class LibrarianHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	static LibrarianHomePage frame;
	private JPanel contentPane;

	// Main method to run the Librarian Home Page
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to set up the Librarian Home Page
	public LibrarianHomePage() {
		// Set the icon for the window
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Disable resizing of the window
		setTitle("Librarian Home Page"); // Set the title of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 750, 470); // Set the size and position of the window
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new CompoundBorder()); // Set the border for the content pane
		setContentPane(contentPane); // Add the content pane to the window
		
		// Button to add books
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to view books
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.setBackground(Color.GRAY);
		btnViewBooks.setForeground(Color.WHITE);
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBooks.main(new String[]{});
			}
		});
		btnViewBooks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to issue books
		JButton btnIssueBook = new JButton("Issue Books");
		btnIssueBook.setBackground(Color.GRAY);
		btnIssueBook.setForeground(Color.WHITE);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to view issued books
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.setBackground(Color.GRAY);
		btnViewIssuedBooks.setForeground(Color.WHITE);
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks.main(new String[]{});
			}
		});
		btnViewIssuedBooks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to remove books
		JButton btnReturnBook = new JButton("Remove Books");
		btnReturnBook.setBackground(Color.GRAY);
		btnReturnBook.setForeground(Color.WHITE);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to logout
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Placeholder label (not used)
		JLabel lblNewLabel = new JLabel("");
		
		// Panel for the header of the window
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(Color.WHITE);
		
		// Panel for the image (not used)
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(302))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnViewBooks, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
									.addComponent(btnIssueBook, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
									.addComponent(btnReturnBook, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
									.addComponent(btnViewIssuedBooks, 0, 0, Short.MAX_VALUE))
								.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnViewIssuedBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))))
		);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\file.png"));
		panel_1.add(lblNewLabel_1);
		
		// Label for the title of the window
		JLabel lblLibrarianSection = new JLabel("OLFU Librarian Home Page");
		panel.add(lblLibrarianSection);
		lblLibrarianSection.setForeground(Color.WHITE);
		lblLibrarianSection.setFont(new Font("Times New Roman", Font.BOLD, 34));
		contentPane.setLayout(gl_contentPane);
	}

}
