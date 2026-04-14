package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    JTable table;

    FeeStructure() {

        setTitle("Bangladesh University of Business and Technology");
        setSize(1000, 650);
        setLocation(250, 50);
        setLayout(null);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        // Heading
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(350, 20, 400, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // Table
        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        table.setRowHeight(25);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20, 80, 950, 500);
        add(jsp);

        // Load Data
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}