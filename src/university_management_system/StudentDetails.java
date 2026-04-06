package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, delete, cancel;

    StudentDetails() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel rollsearch = new JLabel("Search by Roll Number");
        rollsearch.setBounds(20, 20, 150, 20);
        add(rollsearch);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
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

        table = new JTable();
        loadTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 160, 900, 500);
        add(jsp);

        // Buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 100, 30);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(140, 70, 100, 30);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(260, 70, 100, 30);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(380, 70, 100, 30);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(500, 70, 100, 30);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(620, 70, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // ✅ Apply Hover Effects
        addHoverEffect(search, new Color(40,167,69), new Color(33,136,56));
        addHoverEffect(print, new Color(23,162,184), new Color(19,132,150));
        addHoverEffect(add, new Color(0,123,255), new Color(0,105,217));
        addHoverEffect(update, new Color(255,193,7), new Color(224,168,0));
        addHoverEffect(delete, new Color(220,53,69), new Color(200,35,51));
        addHoverEffect(cancel, new Color(108,117,125), new Color(90,98,104));

        setSize(900, 700);
        setLocation(350, 50);
        setVisible(true);
    }

    // 🔄 Load Table Data
    public void loadTable() {
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Reusable Hover Method
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