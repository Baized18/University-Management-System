package university_management_system;
// Package containing classes for the university management system

import javax.swing.*;
// Swing package used for GUI components like JFrame, JButton, JLabel

import java.awt.*;
// AWT package used for graphics, colors, fonts, and images

import java.awt.event.*;
// Event package used to handle button clicks and user actions

public class Login extends JFrame implements ActionListener {
// Login class that creates the login window and handles button events

    JButton login, cancel;
    JTextField tfun, tfpw;

    Login() {
    // Constructor to create and display the login interface

        setTitle("Bangladesh University of Business and Technology");

        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(null);

        JLabel heading = new JLabel("BUBT Annex");
        heading.setBounds(200, 10, 250, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(new Color(30, 30, 120));
        add(heading);

        JLabel un = new JLabel("Username :");
        un.setBounds(40, 70, 100, 25);
        un.setFont(new Font("Arial", Font.BOLD, 14));
        add(un);

        JTextField tfun = new JTextField();
        tfun.setBounds(150, 70, 180, 25);
        tfun.setFont(new Font("Arial", Font.PLAIN, 14));
        add(tfun);

        JLabel pw = new JLabel("Password :");
        pw.setBounds(40, 110, 100, 25);
        pw.setFont(new Font("Arial", Font.BOLD, 14));
        add(pw);

        JPasswordField tfpw = new JPasswordField();
        tfpw.setBounds(150, 110, 180, 25);
        tfpw.setFont(new Font("Arial", Font.PLAIN, 14));
        add(tfpw);

        login = new JButton("Login");
        login.setBounds(60, 170, 120, 35);
        login.setBackground(new Color(0, 102, 204));
        login.setForeground(Color.WHITE);
        login.addActionListener(this); // Register login button event
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setFocusPainted(false);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(210, 170, 120, 35);
        cancel.setBackground(new Color(200, 0, 0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this); // Register cancel button event
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setFocusPainted(false);
        add(cancel);

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

    public void actionPerformed(ActionEvent ae) {
    // Method triggered when login or cancel button is clicked

        if (ae.getSource() == login){
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
    // Main method where program execution starts

        new Login();
    }
}