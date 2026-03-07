package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    Login() {

        // Window Title
        setTitle("Bangladesh University of Business and Technology");

        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("BUBT Annex");
        heading.setBounds(200, 10, 250, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(new Color(30, 30, 120));
        add(heading);

        // Username Label
        JLabel un = new JLabel("Username :");
        un.setBounds(40, 70, 100, 25);
        un.setFont(new Font("Arial", Font.BOLD, 14));
        add(un);

        // Username Field
        JTextField tfun = new JTextField();
        tfun.setBounds(150, 70, 180, 25);
        tfun.setFont(new Font("Arial", Font.PLAIN, 14));
        add(tfun);

        // Password Label
        JLabel pw = new JLabel("Password :");
        pw.setBounds(40, 110, 100, 25);
        pw.setFont(new Font("Arial", Font.BOLD, 14));
        add(pw);

        // Password Field
        JPasswordField tfpw = new JPasswordField();
        tfpw.setBounds(150, 110, 180, 25);
        tfpw.setFont(new Font("Arial", Font.PLAIN, 14));
        add(tfpw);

        // Login Button
        JButton login = new JButton("Login");
        login.setBounds(60, 170, 120, 35);
        login.setBackground(new Color(0, 102, 204));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);   // tells that add button clicked
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setFocusPainted(false);
        add(login);

        // Cancel Button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(210, 170, 120, 35);
        cancel.setBackground(new Color(200, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);       //tells that cancel button is clicked
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setFocusPainted(false);
        add(cancel);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usericon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 40, 180, 180);
        add(image);

        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {  //actionevent class tracks source of the button clicked
        
    }

    public static void main(String[] args) {
        new Login();
    }
}
