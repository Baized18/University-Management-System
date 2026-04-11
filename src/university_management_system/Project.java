package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame settings
        setTitle("BUBT University Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setLayout(new BorderLayout());

        // ===== Background Image =====
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBTinside.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(i2));
        background.setLayout(new BorderLayout());
        add(background);

        // ===== Title Header =====
        JLabel heading = new JLabel("Bangladesh University of Business and Technology", JLabel.CENTER);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 36));
        heading.setForeground(Color.WHITE);
        heading.setOpaque(true);
        heading.setBackground(new Color(0, 51, 102));
        heading.setPreferredSize(new Dimension(100, 60));
        background.add(heading, BorderLayout.NORTH);

        // ===== Menu Bar =====
        JMenuBar mb = new JMenuBar();
        mb.setBackground(new Color(230, 230, 230));
        mb.setFont(new Font("Arial", Font.BOLD, 14));

        // ===== New Information =====
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(new Color(0, 102, 204));
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty");
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student");
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // ===== View Details =====
        JMenu details = new JMenu("View Details");
        details.setForeground(new Color(204, 0, 0));
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // ===== Apply Leave =====
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        // ===== Leave Details =====
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);
        
        // ===== Examination =====
        JMenu exam = new JMenu("Examination");
        exam.setForeground(new Color(0, 102, 204));
        mb.add(exam);

        JMenuItem results = new JMenuItem("Results");
        results.addActionListener(this);
        exam.add(results);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // ===== Fee =====
        JMenu fee = new JMenu("Fee");
        fee.setForeground(new Color(204, 0, 0));
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee");
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // ===== Utility =====
        JMenu utility = new JMenu("Utility");
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.addActionListener(this);
        utility.add(calc);

        // ===== About =====
        JMenu about = new JMenu("About");
        mb.add(about);

        JMenuItem ab = new JMenuItem("About System");
        ab.addActionListener(this);
        about.add(ab);

        // ===== Exit =====
        JMenu exit = new JMenu("Exit");
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Close");
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String msg = ae.getActionCommand();

        if (msg.equals("Close")) {
            System.exit(0);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("New Faculty")) {
            new AddTeacher();
        } else if (msg.equals("New Student")) {
            new AddStudent();
        } else if (msg.equals("About System")) {
            JOptionPane.showMessageDialog(null,
                    "University Management System\nDeveloped for BUBT",
                    "About", JOptionPane.INFORMATION_MESSAGE);
        }else if (msg.equals("Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("Student Details")) {
            new StudentDetails();
        }else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        }else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
