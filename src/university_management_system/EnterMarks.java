package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5;
    JTextField tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton submit, cancel;

    EnterMarks() {

        setTitle("Bangladesh University of Business and Technology");
        setSize(1000, 550);
        setLocation(300, 120);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Enter Student Marks");
        heading.setBounds(300, 20, 400, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(heading);

        // Roll Number
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 30);
        lblrollnumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 30);
        add(crollno);

        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("Roll_Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Semester
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 150, 200, 30);
        lblsemester.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblsemester);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
                "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 150, 200, 30);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        // Labels
        JLabel lblentersubject = new JLabel("Enter Subjects");
        lblentersubject.setBounds(120, 200, 200, 30);
        lblentersubject.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(370, 200, 200, 30);
        lblentermarks.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblentermarks);

        // Subject Fields
        int y = 240;
        tfsub1 = new JTextField(); tfsub1.setBounds(50, y, 200, 30); add(tfsub1);
        tfmarks1 = new JTextField(); tfmarks1.setBounds(300, y, 200, 30); add(tfmarks1);

        y += 40;
        tfsub2 = new JTextField(); tfsub2.setBounds(50, y, 200, 30); add(tfsub2);
        tfmarks2 = new JTextField(); tfmarks2.setBounds(300, y, 200, 30); add(tfmarks2);

        y += 40;
        tfsub3 = new JTextField(); tfsub3.setBounds(50, y, 200, 30); add(tfsub3);
        tfmarks3 = new JTextField(); tfmarks3.setBounds(300, y, 200, 30); add(tfmarks3);

        y += 40;
        tfsub4 = new JTextField(); tfsub4.setBounds(50, y, 200, 30); add(tfsub4);
        tfmarks4 = new JTextField(); tfmarks4.setBounds(300, y, 200, 30); add(tfmarks4);

        y += 40;
        tfsub5 = new JTextField(); tfsub5.setBounds(50, y, 200, 30); add(tfsub5);
        tfmarks5 = new JTextField(); tfmarks5.setBounds(300, y, 200, 30); add(tfmarks5);

        // Image (optional)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(600, 150, 350, 250);
        add(image);

        // Submit Button (Blue)
        submit = new JButton("Submit");
        submit.setBounds(200, 450, 150, 40);
        submit.setBackground(new Color(0, 123, 255));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(submit);

        submit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(MouseEvent e) {
                submit.setBackground(new Color(0, 123, 255));
            }
        });

        // Cancel Button (Red)
        cancel = new JButton("Back");
        cancel.setBounds(400, 450, 150, 40);
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

        submit.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            try {
                DBConnection c = new DBConnection();

                String query1 = "insert into subject values('" + crollno.getSelectedItem() + "', '"
                        + cbsemester.getSelectedItem() + "', '" + tfsub1.getText() + "', '"
                        + tfsub2.getText() + "', '" + tfsub3.getText() + "', '"
                        + tfsub4.getText() + "', '" + tfsub5.getText() + "')";

                String query2 = "insert into marks values('" + crollno.getSelectedItem() + "', '"
                        + cbsemester.getSelectedItem() + "', '" + tfmarks1.getText() + "', '"
                        + tfmarks2.getText() + "', '" + tfmarks3.getText() + "', '"
                        + tfmarks4.getText() + "', '" + tfmarks5.getText() + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}