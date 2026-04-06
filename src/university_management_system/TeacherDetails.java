package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, delete, cancel;

    TeacherDetails() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bangladesh University of Business and Technology");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 180, 20);
        add(heading);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 20, 150, 25);
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

        table = new JTable();
        loadTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 900, 500);
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

        // ✅ Hover Effects
        addHoverEffect(search, new Color(40, 167, 69), new Color(33, 136, 56));
        addHoverEffect(print, new Color(23, 162, 184), new Color(19, 132, 150));
        addHoverEffect(add, new Color(0, 123, 255), new Color(0, 105, 217));
        addHoverEffect(update, new Color(255, 193, 7), new Color(224, 168, 0));
        addHoverEffect(delete, new Color(220, 53, 69), new Color(200, 35, 51));
        addHoverEffect(cancel, new Color(108, 117, 125), new Color(90, 98, 104));

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // 🔄 Load table data
    public void loadTable() {
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🎨 Hover Effect Method
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

            String query = "select * from Teacher where Employee_ID='" + cEmpId.getSelectedItem() + "'";
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
            new AddTeacher();

        } else if (ae.getSource() == update) {

            setVisible(false);
            // new UpdateTeacher();

        } // ✅ DELETE FUNCTION
        else if (ae.getSource() == delete) {

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
        new TeacherDetails();
    }
}
