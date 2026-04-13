package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Used to convert ResultSet data into JTable format easily (avoids manual table population)
import java.awt.event.*;

// Main class for showing student details
public class StudentDetails extends JFrame implements ActionListener {

    // UI Components
    Choice crollno;
    JTable table;
    JButton search, print, update, add, delete, cancel;

    // Fonts
    Font mainFont = new Font("Times New Roman", Font.PLAIN, 16);
    Font headingFont = new Font("Times New Roman", Font.BOLD, 18);

    // Constructor
    StudentDetails() {

        // Frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading label
        JLabel rollsearch = new JLabel("Search by Roll Number");
        rollsearch.setBounds(20, 20, 220, 25);
        rollsearch.setFont(headingFont); // ✅ font applied
        add(rollsearch);

        // Dropdown
        crollno = new Choice();
        crollno.setBounds(240, 20, 150, 25);
        crollno.setFont(mainFont);
        add(crollno);

        // Load roll numbers
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("Roll_Number"));
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

        add = new JButton("Add");
        add.setBounds(260, 70, 100, 30);
        add.setFont(mainFont);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(380, 70, 100, 30);
        update.setFont(mainFont);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(500, 70, 100, 30);
        delete.setFont(mainFont);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(620, 70, 100, 30);
        cancel.setFont(mainFont);
        cancel.addActionListener(this);
        add(cancel);

        // Hover Effects
        addHoverEffect(search, new Color(40,167,69), new Color(33,136,56));
        addHoverEffect(print, new Color(23,162,184), new Color(19,132,150));
        addHoverEffect(add, new Color(0,123,255), new Color(0,105,217));
        addHoverEffect(update, new Color(255,193,7), new Color(224,168,0));
        addHoverEffect(delete, new Color(220,53,69), new Color(200,35,51));
        addHoverEffect(cancel, new Color(108,117,125), new Color(90,98,104));

        // Frame settings
        setSize(910, 700);
        setLocation(350, 50);
        setVisible(true);
        setResizable(false);
    }

    // Load table data
    public void loadTable() {
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from Student");
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

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {

            String query = "select * from Student where Roll_Number='" + crollno.getSelectedItem() + "'";
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

        } else if (ae.getSource() == add) {

            setVisible(false);
            new AddStudent();

        } else if (ae.getSource() == update) {

            setVisible(false);
            new UpdateStudent();

        } else if (ae.getSource() == delete) {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Select a row first");
            } else {
                String roll = table.getModel().getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null, "Delete this student?");

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        DBConnection c = new DBConnection();
                        c.s.executeUpdate("delete from student where Roll_Number='" + roll + "'");
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
        new StudentDetails();
    }
}