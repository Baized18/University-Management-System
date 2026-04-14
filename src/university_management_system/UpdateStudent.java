package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfaddress, tfphone, tfemail, tfcourse, tfbranch;
    JLabel labelname, labelfname, labelrollno, labeldob, labelssc, labelhsc, labelnid;

    Choice crollno;
    JButton update, cancel;

    UpdateStudent() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(900, 700);
        setLocation(350, 50);
        setResizable(false);

        // Heading
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // Roll Number Selection
        JLabel lblselect = new JLabel("Select Roll Number");
        lblselect.setBounds(50, 100, 200, 30);
        lblselect.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblselect);

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

        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(170, 150, 150, 30);
        add(labelname);

        // Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(540, 150, 150, 30);
        add(labelfname);

        // Roll Number
        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50, 200, 200, 30);
        lblroll.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblroll);

        labelrollno = new JLabel();
        labelrollno.setBounds(170, 200, 150, 30);
        add(labelrollno);

        // DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(540, 200, 150, 30);
        add(labeldob);

        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170, 250, 150, 30);
        add(tfaddress);

        // Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(540, 250, 150, 30);
        add(tfphone);

        // Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170, 300, 150, 30);
        add(tfemail);

        // SSC
        JLabel lblssc = new JLabel("SSC Grade");
        lblssc.setBounds(400, 300, 200, 30);
        lblssc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblssc);

        labelssc = new JLabel();
        labelssc.setBounds(540, 300, 150, 30);
        add(labelssc);

        // HSC
        JLabel lblhsc = new JLabel("HSC Grade");
        lblhsc.setBounds(50, 350, 200, 30);
        lblhsc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblhsc);

        labelhsc = new JLabel();
        labelhsc.setBounds(170, 350, 150, 30);
        add(labelhsc);

        // NID
        JLabel lblnid = new JLabel("NID Number");
        lblnid.setBounds(400, 350, 200, 30);
        lblnid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblnid);

        labelnid = new JLabel();
        labelnid.setBounds(540, 350, 150, 30);
        add(labelnid);

        // Course
        JLabel lblcourse = new JLabel("Faculty");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(170, 400, 150, 30);
        add(tfcourse);

        // Branch
        JLabel lblbranch = new JLabel("Program");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(540, 400, 150, 30);
        add(tfbranch);

        // Load Data
        loadData();

        crollno.addItemListener(e -> loadData());

        // Update Button
        update = new JButton("Update");
        update.setBounds(250, 550, 140, 40);
        update.setBackground(new Color(0, 123, 255));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Times New Roman", Font.BOLD, 16));
        update.setFocusPainted(false);
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(update);

        update.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                update.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(MouseEvent e) {
                update.setBackground(new Color(0, 123, 255));
            }
        });

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 140, 40);
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

        update.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true);
    }

    void loadData() {
        try {
            DBConnection c = new DBConnection();
            String query = "select * from student where Roll_Number='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father_name"));
                labelrollno.setText(rs.getString("Roll_Number"));
                labeldob.setText(rs.getString("Date_of_Birth"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                labelssc.setText(rs.getString("SSC_Grade"));
                labelhsc.setText(rs.getString("HSC_Grade"));
                labelnid.setText(rs.getString("NID_No"));
                tfcourse.setText(rs.getString("Faculty"));
                tfbranch.setText(rs.getString("Program"));
            }

        } catch (Exception e) {
            e.printStackTrace(); //prints detailed error information
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {

            try {
                String query = "update student set Address='" + tfaddress.getText()
                        + "', Phone='" + tfphone.getText()
                        + "', Email='" + tfemail.getText()
                        + "', Faculty='" + tfcourse.getText()
                        + "', Program='" + tfbranch.getText()
                        + "' where Roll_Number='" + labelrollno.getText() + "'";

                DBConnection c = new DBConnection();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}