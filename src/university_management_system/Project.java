package university_management_system; // Package for university management system

import javax.swing.*; // Swing for GUI components
import java.awt.*; // AWT for colors and layout
import java.awt.event.*; // Event handling for menu actions

public class Project extends JFrame implements ActionListener { // Main project dashboard GUI

    Project() { // Constructor to create main window
        setSize(1500, 800); // Window size
        setLocation(250, 100); // Window position

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBTinside.jpg")); // Load background image
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT); // Resize image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Add image to label
        add(image); // Add label to frame

        JMenuBar mb = new JMenuBar(); // Create menu bar

        // ===== New Information Menu =====
        JMenu newInformation = new JMenu("New Information"); 
        newInformation.setForeground(Color.BLUE); 
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information"); // Menu item for adding faculty
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this); // Handle click
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information"); // Menu item for adding student
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // ===== View Details Menu =====
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details"); // Menu item for viewing faculty
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details"); // Menu item for viewing student
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // ===== Apply Leave Menu =====
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave"); // Apply leave for faculty
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave"); // Apply leave for student
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);

        // ===== Leave Details Menu =====
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details"); // View faculty leave
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details"); // View student leave
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);

        // ===== Examination Menu =====
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results"); // View exam results
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks"); // Enter student marks
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        // ===== Update Details Menu =====
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details"); // Update faculty info
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details"); // Update student info
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        // ===== Fee Details Menu =====
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure"); // View fee structure
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form"); // View student fee form
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        // ===== Utility Menu =====
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad"); // Open Notepad
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator"); // Open Calculator
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        // ===== About Menu =====
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About"); // About application
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        // ===== Exit Menu =====
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit"); // Exit application
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb); // Attach menu bar
        setVisible(true); // Show main window
    }

    public void actionPerformed(ActionEvent ae) { // Handle menu item clicks
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) { // Exit program
            setVisible(false);
        } else if (msg.equals("Calculator")) { // Open calculator
            try { Runtime.getRuntime().exec("calc.exe"); } catch (Exception e) {}
        } else if (msg.equals("Notepad")) { // Open notepad
            try { Runtime.getRuntime().exec("notepad.exe"); } catch (Exception e) {}
        } 
        // Placeholder actions for other menu items
        else if (msg.equals("New Faculty Information")) { /* new AddTeacher(); */ }
        else if (msg.equals("New Student Information")) { /* new AddStudent(); */ }
        else if (msg.equals("View Faculty Details")) { /* new TeacherDetails(); */ }
        else if (msg.equals("View Student Details")) { /* new StudentDetails(); */ }
        else if (msg.equals("Faculty Leave")) { /* new TeacherLeave(); */ }
        else if (msg.equals("Student Leave")) { /* new StudentLeave(); */ }
        else if (msg.equals("Faculty Leave Details")) { /* new TeacherLeaveDetails(); */ }
        else if (msg.equals("Student Leave Details")) { /* new StudentLeaveDetails(); */ }
        else if (msg.equals("Update Faculty Details")) { /* new UpdateTeacher(); */ }
        else if (msg.equals("Update Student Details")) { /* new UpdateStudent(); */ }
        else if (msg.equals("Enter Marks")) { /* new EnterMarks(); */ }
        else if (msg.equals("Examination Results")) { /* new ExaminationDetails(); */ }
        else if (msg.equals("Fee Structure")) { /* new FeeStructure(); */ }
        else if (msg.equals("About")) { /* new About(); */ }
        else if (msg.equals("Student Fee Form")) { /* new StudentFeeForm(); */ }
    }

    public static void main(String[] args) { // Main method to launch Project window
        new Project();
    }
}