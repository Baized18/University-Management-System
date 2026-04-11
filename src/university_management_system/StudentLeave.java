package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

// Class for Student Leave Application
public class StudentLeave extends JFrame implements ActionListener {

    // UI Components
    Choice crollno, ctime;   // Dropdowns for roll number and leave duration
    JDateChooser dcdate;     // Date picker
    JButton submit, cancel;  // Buttons

    // Constructor
    StudentLeave() {

        // Frame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bangladesh University of Business and Technology");
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading label
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        add(heading);

        // Label for roll number
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 250, 20);
        lblrollno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(lblrollno);

        // Dropdown for roll numbers
        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);

        // Load roll numbers from database
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("Roll_Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Label for date
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(lbldate);

        // Date chooser component
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        // Label for duration
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(lbltime);

        // Dropdown for leave duration
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 120, 35);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 120, 35);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);

        // Apply hover effects to buttons
        addHoverEffect(submit, new Color(0,123,255), new Color(0,105,217)); // blue
        addHoverEffect(cancel, new Color(220,53,69), new Color(200,35,51)); // red

        setVisible(true);
    }

    // Method to add hover effect to buttons
    public void addHoverEffect(JButton btn, Color normal, Color hover) {
        btn.setBackground(normal);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Mouse events for hover
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover); // when mouse enters
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(normal); // when mouse exits
            }
        });
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {

        // If submit button clicked
        if (ae.getSource() == submit) {

            String rollno = crollno.getSelectedItem(); // get selected roll number

            // get selected date from date chooser
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            String duration = ctime.getSelectedItem(); // get duration

            // SQL query to insert leave data
            String query = "insert into studentleave values('" + rollno + "', '" + date + "', '" + duration + "')";

            try {
                DBConnection c = new DBConnection();
                c.s.executeUpdate(query); // execute insert query
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false); // close window after submit
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // If cancel button clicked
            setVisible(false); // close window
        }
    }

    // Main method
    public static void main(String[] args) {
        new StudentLeave();
    }
}