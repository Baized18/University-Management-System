package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfqualification, tfsalary;
    JLabel labelempid, labelname, labeldob, labeldepartment;
    JButton submit, cancel;
    Choice cEmpId;

    UpdateTeacher() {

        setTitle("Bangladesh University of Business and Technology");
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(250, 20, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // Select Emp ID
        JLabel lblselect = new JLabel("Select Employee ID");
        lblselect.setBounds(50, 100, 200, 30);
        lblselect.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblselect);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 30);
        add(cEmpId);

        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("Employee_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        add(labelname);

        // DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 150, 200, 30);
        lbldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 150, 150, 30);
        add(labeldob);

        // Emp ID
        JLabel lblemp = new JLabel("Employee ID");
        lblemp.setBounds(50, 200, 200, 30);
        lblemp.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemp);

        labelempid = new JLabel();
        labelempid.setBounds(200, 200, 150, 30);
        add(labelempid);

        // Department
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(400, 200, 200, 30);
        lbldept.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldept);

        labeldepartment = new JLabel();
        labeldepartment.setBounds(600, 200, 150, 30);
        add(labeldepartment);

        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        // Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        // Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        // Qualification
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(400, 300, 200, 30);
        lblqualification.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblqualification);

        tfqualification = new JTextField();
        tfqualification.setBounds(600, 300, 150, 30);
        add(tfqualification);

        // Salary
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(50, 350, 200, 30);
        lblsalary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 350, 150, 30);
        add(tfsalary);

        // Load Data
        loadData();
        cEmpId.addItemListener(e -> loadData());

        // Update Button
        submit = new JButton("Update");
        submit.setBounds(250, 500, 140, 40);
        submit.setBackground(new Color(0, 123, 255));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 140, 40);
        cancel.setBackground(new Color(220, 53, 69));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true);
    }

    void loadData() {
        try {
            DBConnection c = new DBConnection();
            String query = "select * from teacher where Employee_ID='" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                labelname.setText(rs.getString("Name"));
                labeldob.setText(rs.getString("Date_of_Birth"));
                labelempid.setText(rs.getString("Employee_ID"));
                labeldepartment.setText(rs.getString("Department"));

                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfqualification.setText(rs.getString("Qualification"));
                tfsalary.setText(rs.getString("Salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            try {
                String query = "update teacher set Address='" + tfaddress.getText()
                        + "', Phone='" + tfphone.getText()
                        + "', Email='" + tfemail.getText()
                        + "', Qualification='" + tfqualification.getText()
                        + "', Salary='" + tfsalary.getText()
                        + "' where Employee_ID='" + labelempid.getText() + "'";

                DBConnection con = new DBConnection();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}