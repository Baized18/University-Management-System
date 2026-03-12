package university_management_system;

import javax.swing.*;
import java.awt.*;

public class AddStudent extends JFrame {

    JTextField tfname, tffname , tfrollno;

    AddStudent() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(540, 150, 150, 30);
        add(tffname);
        
         JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 250, 200, 30);
        lblrollno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblrollno);

        tfrollno = new JTextField();
        tfrollno.setBounds(170, 250, 150, 30);
        add(tfrollno);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
