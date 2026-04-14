package university_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;

    Marks(String rollno) {

        this.rollno = rollno;

        setTitle("Bangladesh University of Business and Technology");
        setSize(600, 650);
        setLocation(450, 80);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Student Result");
        heading.setBounds(180, 20, 300, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(heading);

        // Roll Number
        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(60, 120, 400, 25);
        lblrollno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(lblrollno);

        // Semester
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 150, 400, 25);
        lblsemester.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(lblsemester);

        // Subjects + Marks
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 220, 400, 25);
        sub1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 260, 400, 25);
        sub2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 300, 400, 25);
        sub3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 340, 400, 25);
        sub4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 380, 400, 25);
        sub5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(sub5);

        try {
            DBConnection c = new DBConnection();

            // Fetch Subjects
            ResultSet rs1 = c.s.executeQuery(
                    "select * from subject where Roll_Number='" + rollno + "'");

            while (rs1.next()) {
                sub1.setText(rs1.getString("Subject1"));
                sub2.setText(rs1.getString("Subject2"));
                sub3.setText(rs1.getString("Subject3"));
                sub4.setText(rs1.getString("Subject4"));
                sub5.setText(rs1.getString("Subject5"));
            }

            // Fetch Marks
            ResultSet rs2 = c.s.executeQuery(
                    "select * from marks where Roll_Number='" + rollno + "'");

            while (rs2.next()) {
                sub1.setText(sub1.getText() + "   :   " + rs2.getString("Marks1"));
                sub2.setText(sub2.getText() + "   :   " + rs2.getString("Marks2"));
                sub3.setText(sub3.getText() + "   :   " + rs2.getString("Marks3"));
                sub4.setText(sub4.getText() + "   :   " + rs2.getString("Marks4"));
                sub5.setText(sub5.getText() + "   :   " + rs2.getString("Marks5"));

                lblsemester.setText("Semester: " + rs2.getString("Semester"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cancel Button (Red Style)
        cancel = new JButton("Close");
        cancel.setBounds(220, 500, 150, 40);
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

        cancel.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks(""); 
    }
}