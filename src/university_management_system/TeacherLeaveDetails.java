package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Used to convert ResultSet data into JTable format easily (avoids manual table population)
import java.awt.event.*;

// Main class to display teacher details
public class TeacherLeaveDetails extends JFrame implements ActionListener {

    // UI Components
    Choice cEmpId;
    JTable table;
    JButton search, print , delete, cancel;

    // Fonts
    Font mainFont = new Font("Times New Roman", Font.PLAIN, 16);
    Font headingFont = new Font("Times New Roman", Font.BOLD, 18);

    // Constructor
    TeacherLeaveDetails() {

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading label
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 220, 25);
        heading.setFont(headingFont);
        add(heading);

        // Dropdown
        cEmpId = new Choice();
        cEmpId.setBounds(240, 20, 150, 25);
        cEmpId.setFont(mainFont);
        add(cEmpId);

        // Load Employee IDs
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while (rs.next()) {
                cEmpId.add(rs.getString("Employee_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table
        table = new JTable();
        table.setFont(mainFont);
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));

        loadTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 900, 500);
        add(jsp);

        // Buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 100, 30);
        search.setFont(mainFont);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(140, 70, 100, 30);
        print.setFont(mainFont);
        print.addActionListener(this);
        add(print);

        delete = new JButton("Delete");
        delete.setBounds(260, 70, 100, 30);
        delete.setFont(mainFont);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(380, 70, 100, 30);
        cancel.setFont(mainFont);
        cancel.addActionListener(this);
        add(cancel);

        // Hover Effects
        addHoverEffect(search, new Color(40,167,69), new Color(33,136,56));
        addHoverEffect(print, new Color(23,162,184), new Color(19,132,150));
        addHoverEffect(delete, new Color(220,53,69), new Color(200,35,51));
        addHoverEffect(cancel, new Color(108,117,125), new Color(90,98,104));

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // Load table data
    public void loadTable() {
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hover effect method
    public void addHoverEffect(JButton btn, Color normal, Color hover) {
        btn.setBackground(normal);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
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

    // Button actions
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            String query = "select * from teacherleave where Employee_ID='" + cEmpId.getSelectedItem() + "'";
            try {
                DBConnection c = new DBConnection();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == delete) {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Select a row first");
            } else {
                String empId = table.getModel().getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null, "Delete this teacher?");

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        DBConnection c = new DBConnection();
                        c.s.executeUpdate("delete from teacher where Employee_ID='" + empId + "'");
                        JOptionPane.showMessageDialog(null, "Deleted Successfully");
                        loadTable();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}