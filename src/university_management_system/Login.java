package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Used for handling events like button clicks, mouse actions, keyboard input (ActionListener, MouseAdapter, etc.)
import java.sql.*;       // Used for database operations such as connecting to DB, executing queries (Connection, Statement, ResultSet, etc.)

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfun;
    JPasswordField tfpw;

    Login() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // closes current screen only             //EXIT_ON_CLOSE      closes all screens
        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(null);

        JLabel heading = new JLabel("BUBT Annex");
        heading.setBounds(200, 10, 250, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        heading.setForeground(new Color(30, 30, 120));
        add(heading);

        JLabel un = new JLabel("Username :");
        un.setBounds(40, 70, 100, 25);
        un.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(un);

        tfun = new JTextField();
        tfun.setBounds(150, 70, 180, 25);
        tfun.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(tfun);

        JLabel pw = new JLabel("Password :");
        pw.setBounds(40, 110, 100, 25);
        pw.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(pw);

        tfpw = new JPasswordField();
        tfpw.setBounds(150, 110, 180, 25);
        tfpw.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        add(tfpw);

        // Buttons
        login = new JButton("Submit");
        login.setBounds(150, 160, 140, 40);
        login.setBackground(new Color(0, 123, 255));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Times New Roman", Font.BOLD, 16));
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(login);

        login.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                login.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(MouseEvent e) {
                login.setBackground(new Color(0, 123, 255));
            }
        });

        cancel = new JButton("Cancel");
        cancel.setBounds(310, 160, 140, 40);
        cancel.setBackground(new Color(220, 53, 69));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cancel);

        cancel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(new Color(200, 35, 51));
            }
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(new Color(220, 53, 69));
            }
        });

        login.addActionListener(this);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usericon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(380, 50, 100, 100);
        add(image);

        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfun.getText();
            String password = String.valueOf(tfpw.getPassword());

            String query = "SELECT * FROM login WHERE username=? AND password=?";

            try {
                DBConnection c = new DBConnection();
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}