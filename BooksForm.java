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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;

public class BooksForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private boolean isEditMode = false; // Flag to check if the form is in edit mode

    // Main method to launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BooksForm frame = new BooksForm(); // Create an instance of BooksForm
                    frame.setVisible(true); // Make the frame visible
                } catch (Exception e) {
                    e.printStackTrace(); // Print any exceptions to the console
                }
            }
        });
    }

    // Constructor to create the form
    public BooksForm() {
        setTitle("Add/Edit Books Page"); // Set the title of the window
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\zhonm\\eclipse-workspace\\Library\\src\\images\\olfu logo.png")); // Set the window icon
        setResizable(false); // Disable window resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setBounds(100, 100, 644, 500); // Set the position and size of the window
        contentPane = new JPanel();
        contentPane.setBorder(new CompoundBorder());
        setContentPane(contentPane);

        // Labels for the form fields
        JLabel lblcodeNumber = new JLabel("Book Number:");
        lblcodeNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblPublisher = new JLabel("Publisher:");
        lblPublisher.setFont(new Font("Times New Roman", Font.BOLD, 18));

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // Text fields for user input
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_4.setColumns(10);

        // Button to add or edit books
        JButton btnAddBooks = new JButton("Add Books");
        btnAddBooks.setBackground(Color.BLUE);
        btnAddBooks.setForeground(Color.WHITE);
        btnAddBooks.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnAddBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input from text fields
                String codeNumber = textField.getText();
                String name = textField_1.getText();
                String author = textField_2.getText();
                String publisher = textField_3.getText();
                String squantity = textField_4.getText();

                int quantity;
                try {
                    quantity = Integer.parseInt(squantity); // Parse quantity to integer
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BooksForm.this, "Please enter a valid quantity."); // Show error message if quantity is invalid
                    return;
                }

                int i;
                if (isEditMode) {
                    i = BookDatabase.update(codeNumber, name, author, publisher, quantity); // Update book if in edit mode
                } else {
                    i = BookDatabase.save(codeNumber, name, author, publisher, quantity); // Save new book if not in edit mode
                }

                if (i > 0) {
                    JOptionPane.showMessageDialog(BooksForm.this, isEditMode ? "Item updated successfully!" : "Item added successfully!"); // Show success message
                    LibrarianHomePage.main(new String[]{}); // Navigate to home page
                    dispose(); // Close current form
                } else {
                    JOptionPane.showMessageDialog(BooksForm.this, "Sorry, unable to save!"); // Show failure message
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
                dispose(); // Close current form
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY); // Set background color for the panel

        // Group layout to arrange the components
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblAuthor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(lblQuantity, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(lblPublisher)
                                .addComponent(lblcodeNumber, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(btnAddBooks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(textField_1)
                                .addComponent(textField_2)
                                .addComponent(textField_3)
                                .addComponent(textField_4)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(130, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblName)
                            .addContainerGap(730, Short.MAX_VALUE))))
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblcodeNumber))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblName)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAuthor))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPublisher))
                    .addGap(21)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblQuantity))
                    .addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                    .addContainerGap())
        );

        // Title label for the form
        JLabel lblAddBooks = new JLabel("Add/Edit Books Information");
        panel.add(lblAddBooks);
        lblAddBooks.setForeground(Color.WHITE);
        lblAddBooks.setFont(new Font("Times New Roman", Font.BOLD, 34));
        contentPane.setLayout(gl_contentPane);
    }

    // Method to set the form in edit mode with pre-filled data
    public void setEditMode(String codeNumber, String name, String author, String publisher, String quantity) {
        isEditMode = true; // Enable edit mode
        textField.setText(codeNumber); // Set book number
        textField_1.setText(name); // Set book name
        textField_2.setText(author); // Set author name
        textField_3.setText(publisher); // Set publisher name
        textField_4.setText(quantity); // Set quantity
        setTitle("Edit Book Information"); // Change the window title
    }
}
