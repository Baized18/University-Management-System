package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbprogram, cbsemester;

    JLabel labelname, labelfname, labeltotal;

    JButton update, pay, back;

    StudentFeeForm() {

        setTitle("Student Fee Management System");
        setSize(900, 520);
        setLocation(300, 100);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        // ================= HEADING =================
        JLabel heading = new JLabel("Student Fee Form");
        heading.setBounds(300, 20, 400, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // ================= ROLL NO =================
        JLabel lblroll = new JLabel("Roll No");
        lblroll.setBounds(50, 80, 150, 25);
        lblroll.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblroll);

        crollno = new Choice();
        crollno.setBounds(200, 80, 180, 25);
        add(crollno);

        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                crollno.add(rs.getString("Roll_Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ================= NAME =================
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 120, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 120, 300, 25);
        labelname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(labelname);

        // ================= FATHER =================
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(50, 160, 150, 25);
        lblfname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(200, 160, 300, 25);
        labelfname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(labelfname);

        // ================= PROGRAM =================
        JLabel lblprogram = new JLabel("Program");
        lblprogram.setBounds(50, 200, 150, 25);
        lblprogram.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblprogram);

        String program[] = {"BBA", "MBA", "EMBA", "B.A", "M.A", "B.Sc", "LL.B", "LL.M", "M.Sc"};
        cbprogram = new JComboBox(program);
        cbprogram.setBounds(200, 200, 180, 25);
        cbprogram.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(cbprogram);

        // ================= SEMESTER =================
        JLabel lblsem = new JLabel("Semester");
        lblsem.setBounds(50, 240, 150, 25);
        lblsem.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblsem);

        String semester[] = {
            "Semester1", "Semester2", "Semester3", "Semester4",
            "Semester5", "Semester6", "Semester7", "Semester8"
        };

        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 240, 180, 25);
        cbsemester.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(cbsemester);

        // ================= TOTAL =================
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(50, 280, 150, 25);
        lbltotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200, 280, 250, 25);
        labeltotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labeltotal.setForeground(new Color(0, 102, 204));
        add(labeltotal);

        // ================= BUTTON STYLE =================
        Font btnFont = new Font("Times New Roman", Font.BOLD, 16);

        update = new JButton("Update");
        update.setBounds(50, 350, 120, 35);
        update.setFont(btnFont);
        styleButton(update, new Color(0, 123, 255), new Color(0, 105, 217));
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(190, 350, 120, 35);
        pay.setFont(btnFont);
        styleButton(pay, new Color(40, 167, 69), new Color(30, 140, 55));
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Close");
        back.setBounds(330, 350, 120, 35);
        back.setFont(btnFont);
        styleButton(back, new Color(220, 53, 69), new Color(180, 40, 55));
        back.addActionListener(this);
        add(back);

        // Load initial student
        loadStudent();

        crollno.addItemListener(e -> loadStudent());

        setVisible(true);
    }

    // ================= LOAD STUDENT =================
    void loadStudent() {
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery(
                    "SELECT * FROM student WHERE Roll_Number='" + crollno.getSelectedItem() + "'"
            );

            if (rs.next()) {
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father_Name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= BUTTON ACTION =================
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {

            try {
                String program = (String) cbprogram.getSelectedItem();
                String semester = (String) cbsemester.getSelectedItem();

                DBConnection c = new DBConnection();
                ResultSet rs = c.s.executeQuery(
                        "SELECT * FROM fee WHERE Program='" + program + "'"
                );

                if (rs.next()) {
                    String fee = rs.getString(semester);
                    labeltotal.setText(" : " + fee + " Tk");
                } else {
                    labeltotal.setText(" : Not Found");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == pay) {

            try {
                DBConnection c = new DBConnection();

                String rollno = crollno.getSelectedItem();
                String program = (String) cbprogram.getSelectedItem();
                String semester = (String) cbsemester.getSelectedItem();

                // STEP 1: CHECK IF ALREADY PAID
                String checkQuery
                        = "SELECT * FROM FeesPaid WHERE Roll_Number='" + rollno
                        + "' AND Program='" + program
                        + "' AND Semester='" + semester + "'";

                ResultSet rs = c.s.executeQuery(checkQuery);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,
                            "❌ Fee already paid for this semester!");
                } else {

                    // STEP 2: INSERT PAYMENT
                    String query
                            = "INSERT INTO FeesPaid VALUES('"
                            + rollno + "','"
                            + program + "','"
                            + semester + "','"
                            + labeltotal.getText() + "')";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,
                            "✅ Fee Paid Successfully");

                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    // ================= BUTTON STYLE METHOD =================
    void styleButton(JButton btn, Color normal, Color hover) {
        btn.setBackground(normal);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(normal);
            }
        });
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
