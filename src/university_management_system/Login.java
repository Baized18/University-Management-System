package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel un = new JLabel("Username :");  // usename text
        un.setBounds(40, 60, 100, 20);  //(distance from left , distance from top , width of label , height of label )
        add(un);

        JTextField tfun = new JTextField();    //textfieldusername
        tfun.setBounds(150, 60, 150, 20);
        add(tfun);

        JLabel pw = new JLabel("Password :");  // password text
        pw.setBounds(40, 100, 100, 20);  //(distance from left , distance from top , width of label , height of label )
        add(pw);

        JPasswordField tfpw = new JPasswordField();    //textfieldpassword
        tfpw.setBounds(150, 100, 150, 20);
        add(tfpw);

        JButton login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(login);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(cancel);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usericon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setLocation(600, 300);
        setSize(600, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
         = new Login();
    }
}
