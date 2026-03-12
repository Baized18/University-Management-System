package university_management_system; // Package for university management system

import javax.swing.*; // Swing for GUI components like JFrame, JButton, JLabel
import java.awt.*; // AWT for graphics, colors, fonts, images
import java.awt.event.*; // Event handling for buttons, actions
import java.sql.*; // JDBC for database connectivity

public class Login extends JFrame implements ActionListener { // Login GUI and button event handler

    JButton login, cancel; // Buttons for login and cancel
    JTextField tfun, tfpw; // Text fields for username and password

    Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            // Constructor to create login window
        setTitle("Bangladesh University of Business and Technology"); // Window title
        getContentPane().setBackground(new Color(240, 248, 255)); // Background color
        setLayout(null); // Absolute positioning

        JLabel heading = new JLabel("BUBT Annex"); // Main heading
        heading.setBounds(200, 10, 250, 30); // Position & size
        heading.setFont(new Font("Times New Roman", Font.BOLD, 22)); // Font style
        heading.setForeground(new Color(30, 30, 120)); // Font color
        add(heading);

        JLabel un = new JLabel("Username :"); // Label for username
        un.setBounds(40, 70, 100, 25);
        un.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(un);

        tfun = new JTextField(); // Username input field
        tfun.setBounds(150, 70, 180, 25);
        tfun.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(tfun);

        JLabel pw = new JLabel("Password :"); // Label for password
        pw.setBounds(40, 110, 100, 25);
        pw.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(pw);

        tfpw = new JPasswordField(); // Password input field
        tfpw.setBounds(150, 110, 180, 25);
        tfpw.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(tfpw);

        login = new JButton("Login"); // Login button
        login.setBounds(60, 170, 120, 35);
        login.setBackground(new Color(0, 102, 204)); // Button color
        login.setForeground(Color.WHITE); // Text color
        login.addActionListener(this); // Handle login click
        login.setFont(new Font("Times New Roman", Font.BOLD, 14));
        login.setFocusPainted(false);
        add(login);

        cancel = new JButton("Cancel"); // Cancel button
        cancel.setBounds(210, 170, 120, 35);
        cancel.setBackground(new Color(200, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this); // Handle cancel click
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cancel.setFocusPainted(false);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usericon.jpg")); // Load image
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH); // Resize image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Display image
        image.setBounds(380, 40, 180, 180);
        add(image);

        setSize(600, 300); // Window size
        setLocationRelativeTo(null); // Center window
        setVisible(true); // Show window
    }

    public void actionPerformed(ActionEvent ae) { // Handle button clicks
        if (ae.getSource() == login) { // Login button clicked
            String username = tfun.getText(); // Get username
            String password = tfpw.getText(); // Get password

            String query = "select * from login where username='" + username + "' and password='" + password + "'"; // SQL query

            try {
                DBConnection c = new DBConnection(); // Connect to DB
                ResultSet rs = c.s.executeQuery(query); // Execute query

                if (rs.next()) { // If login success
                    setVisible(false); // Hide login window
                    new Project(); // Open main project window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password"); // Show error
                    setVisible(false); // Hide login window
                }

            } catch (Exception e) {
                e.printStackTrace(); // Print any errors
            }

        } else if (ae.getSource() == cancel) { // Cancel button clicked
            setVisible(false); // Close login window
        }
    }

    public static void main(String[] args) { // Main method
        new Login(); // Launch login window
    }
}