import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

// Class for creating a frame to delete a librarian from the database
public class DeleteLibrarian extends JFrame {
	private static final long serialVersionUID = 1L;
	static DeleteLibrarian frame;
	private JPanel contentPane;
	private JTextField textField;

	// Main method to run the DeleteLibrarian frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to set up the DeleteLibrarian frame
	public DeleteLibrarian() {
		// Set the icon for the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png"));
		setResizable(false); // Disable resizing of the frame
		setTitle("Delete User Page"); // Set the title of the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
		setBounds(100, 100, 717, 391); // Set the size and position of the frame
		
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder()); // Set the border for the content pane
		setContentPane(contentPane); // Add the content pane to the frame
		
		// Label for entering the unique ID of the librarian to be deleted
		JLabel lblEnterId = new JLabel("Enter Unique ID:");
		lblEnterId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Text field to input the unique ID
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		
		// Button to delete the librarian based on the entered ID
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid = textField.getText();
				if(sid == null || sid.trim().equals("")){
					JOptionPane.showMessageDialog(DeleteLibrarian.this, "Id can't be blank");
				}else{
					int id = Integer.parseInt(sid);
					int i = LibrarianDatabase.delete(id);
					if(i > 0){
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Button to go back to the previous page
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Panel for the header of the frame
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblEnterId)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
					.addGap(112))
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addGap(81))
		);

		// Label for the title of the frame
		JLabel lblNewLabel = new JLabel("Delete User Account");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
}
