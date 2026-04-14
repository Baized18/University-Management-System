package university_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField tfsearch;
    JButton submit, cancel;
    JTable table;

    ExaminationDetails() {

        setTitle("Bangladesh University of Business and Technology");
        setSize(1000, 500);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(350, 20, 300, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(heading);

        // Search Label
        JLabel lblsearch = new JLabel("Enter Roll Number");
        lblsearch.setBounds(80, 90, 200, 30);
        lblsearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblsearch);

        // Search Field
        tfsearch = new JTextField();
        tfsearch.setBounds(260, 90, 180, 30);
        tfsearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(tfsearch);

        // Result Button (Blue Style)
        submit = new JButton("Result");
        submit.setBounds(470, 90, 120, 35);
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

        // Back Button (Red Style)
        cancel = new JButton("Cancel");
        cancel.setBounds(610, 90, 120, 35);
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

        // Table
        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        table.setRowHeight(25);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20, 150, 950, 280);
        add(jsp);

        // Load Data
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Click row → auto fill roll number
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                tfsearch.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        submit.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            String roll = tfsearch.getText();

            if (roll.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Roll Number");
            } else {
                setVisible(false);
                new Marks(roll);
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}