package university_management_system;

import javax.swing.*; // GUI components
import java.awt.*; // Layout, color, fonts
import com.toedter.calendar.JDateChooser; // For date picker
import java.awt.event.*; // Event handling

public class AddTeacher extends JFrame implements ActionListener {

    // Text fields for input
    JTextField tfname, tfdob, tfempid, tfaddress, tfphone, tfemail, tfqualification, tfsalary;

    // Labels
    JLabel heading, lblname, lbldob, lblempid, lbladdress, lblphone, lblemail, lblqualification, lblsalary, lbldepartment;

    // Dropdown for department
    JComboBox cbdepartment;

    JDateChooser dcdob;

    // Buttons
    JButton submit, cancel;

    // Constructor
    AddTeacher() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close app when window closes

        setTitle("Bangladesh University of Business and Technology"); // Window title
        getContentPane().setBackground(new Color(255, 255, 255)); // White background
        setLayout(null); // Absolute layout

        setSize(900, 700); // Window size
        setLocation(350, 50); // Window position
        setResizable(false);

        // Heading
        heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // Name label and field
        lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        // Date of Birth
        lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 150, 200, 30);
        lbldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser(); // Calendar input
        dcdob.setBounds(540, 150, 150, 30);
        add(dcdob);

        // Employee ID
        lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblempid);

        tfempid = new JTextField();
        tfempid.setBounds(170, 200, 150, 30);
        add(tfempid);

        // Department dropdown
        lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(400, 200, 200, 30);
        lbldepartment.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldepartment);

        String dept[] = {"CSE", "BBA", "EEE", "Law", "English", "Mathematics"};
        cbdepartment = new JComboBox(dept);
        cbdepartment.setBounds(540, 200, 150, 30);
        add(cbdepartment);

        // Address
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170, 250, 150, 30);
        add(tfaddress);

        // Phone
        lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(540, 250, 150, 30);
        add(tfphone);

        // Email
        lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170, 300, 150, 30);
        add(tfemail);

        // Qualification
        lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(400, 300, 200, 30);
        lblqualification.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblqualification);

        tfqualification = new JTextField();
        tfqualification.setBounds(540, 300, 150, 30);
        add(tfqualification);

        // Salary
        lblsalary = new JLabel("Salary");
        lblsalary.setBounds(50, 350, 200, 30);
        lblsalary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(170, 350, 150, 30);
        add(tfsalary);

        // Submit Button (Modern Blue Style)
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 140, 40);
        submit.setBackground(new Color(0, 123, 255)); // Modern blue
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.setFocusPainted(false); // Remove focus border
        submit.setBorder(BorderFactory.createEmptyBorder()); // Clean look
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        add(submit);

// Hover effect for Submit
        submit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(new Color(0, 105, 217)); // Darker blue
            }

            public void mouseExited(MouseEvent e) {
                submit.setBackground(new Color(0, 123, 255));
            }
        });

// Cancel Button (Modern Red Style)
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 140, 40);
        cancel.setBackground(new Color(220, 53, 69)); // Modern red
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cancel);

// Hover effect for Cancel
        cancel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(new Color(200, 35, 51)); // Darker red
            }

            public void mouseExited(MouseEvent e) {
                cancel.setBackground(new Color(220, 53, 69));
            }
        });

// Add ActionListener
        submit.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true); // Make frame visible
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String name = tfname.getText();

// Correct way to get date from JDateChooser
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();

            String empid = tfempid.getText();
            String department = (String) cbdepartment.getSelectedItem();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = tfqualification.getText();
            String salary = tfsalary.getText();

            try {
                // SQL query to insert teacher data
                String query = "INSERT INTO Teacher VALUES('" + name + "', '" + dob + "', '" + empid + "', '" + department + "', '" + address + "', '" + phone + "', '" + email + "', '" + qualification + "', '" + salary + "')";

                DBConnection con = new DBConnection(); // Connect to DB
                con.s.executeUpdate(query); // Execute query

                JOptionPane.showMessageDialog(null, "Teacher Added Successfully");
                setVisible(false); // Close window

            } catch (Exception e) {
                e.printStackTrace(); // Show error in console
            }

        } else {
            setVisible(false); // Close on cancel
        }
    }

    // Main method to run program
    public static void main(String[] args) {
        new AddTeacher();
    }
}
