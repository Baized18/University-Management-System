package university_management_system;

import javax.swing.*; // For GUI components (JFrame, JLabel, JTextField, etc.)
import java.awt.*; // For layout, colors, fonts
import com.toedter.calendar.JDateChooser; // For date picker
import java.awt.event.*; // For handling button events

public class AddStudent extends JFrame implements ActionListener {

    // Declare all input fields
    JTextField tfname, tffname, tfrollno, tfaddress, tfphone, tfemail, tfssc, tfhsc, tfnid;

    // Labels for UI
    JLabel lbladdress, lbldob, heading, lblname, lblfname, lblrollno, lblphone, lblemail, lblssc, lblhsc, lblnid, lblprogram, lblfaculty;

    // Dropdowns for program and faculty
    JComboBox cbprogram, cbfaculty;

    // Date chooser for DOB
    JDateChooser dcdob;

    // Buttons
    JButton submit, cancel;

    AddStudent() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when window closes

        setTitle("Bangladesh University of Business and Technology"); // Window title
        getContentPane().setBackground(new Color(255, 255, 255)); // White background
        setLayout(null); // Absolute layout

        setSize(900, 700); // Window size
        setLocation(350, 50); // Window position

        // Heading
        heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        // Name label and field
        lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        // Father's Name
        lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(540, 150, 150, 30);
        add(tffname);

        // Roll Number
        lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblrollno);

        tfrollno = new JTextField();
        tfrollno.setBounds(170, 200, 150, 30);
        add(tfrollno);

        // Date of Birth
        lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser(); // Calendar input
        dcdob.setBounds(540, 200, 150, 30);
        add(dcdob);

        // Address
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170, 250, 150, 30);
        add(tfaddress);

        // Phone
        lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(540, 250, 150, 30);
        add(tfphone);

        // Email
        lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170, 300, 150, 30);
        add(tfemail);

        // SSC Grade
        lblssc = new JLabel("SSC Grade");
        lblssc.setBounds(400, 300, 200, 30);
        lblssc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblssc);

        tfssc = new JTextField();
        tfssc.setBounds(540, 300, 150, 30);
        add(tfssc);

        // HSC Grade
        lblhsc = new JLabel("HSC Grade");
        lblhsc.setBounds(50, 350, 200, 30);
        lblhsc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblhsc);

        tfhsc = new JTextField();
        tfhsc.setBounds(170, 350, 150, 30);
        add(tfhsc);

        // NID Number
        lblnid = new JLabel("NID Number");
        lblnid.setBounds(400, 350, 200, 30);
        lblnid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(540, 350, 150, 30);
        add(tfnid);

        // Faculty Dropdown
        lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(50, 400, 200, 30);
        lblfaculty.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblfaculty);

        String faculty[] = {"Business", "Arts and Humanities", "Engineering and Applied Sciences", "Law", "Social Science", "CS & AI"};
        cbfaculty = new JComboBox(faculty);
        cbfaculty.setBounds(170, 400, 200, 30);
        add(cbfaculty);

        // Program Dropdown
        lblprogram = new JLabel("Program");
        lblprogram.setBounds(400, 400, 200, 30);
        lblprogram.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblprogram);

        String program[] = {"BBA", "MBA", "EMBA", "B.A", "M.A", "B.Sc", "LL.B", "LL.M", "M.Sc"};
        cbprogram = new JComboBox(program);
        cbprogram.setBounds(540, 400, 150, 30);
        add(cbprogram);

        // Submit Button (Modern Blue Style)
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 140, 40);
        submit.setBackground(new Color(0, 123, 255)); // Modern blue
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.setFocusPainted(false); // Remove focus border
        submit.setBorder(BorderFactory.createEmptyBorder()); // Clean look
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor
        add(submit);

// Hover effect for Submit
        submit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(new Color(0, 105, 217)); // Darker blue
            }

            public void mouseExited(MouseEvent e) {
                submit.setBackground(new Color(0, 123, 255));
            }
        });

// Cancel Button (Modern Red Style)
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 140, 40);
        cancel.setBackground(new Color(220, 53, 69)); // Modern red
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cancel);

// Hover effect for Cancel
        cancel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(new Color(200, 35, 51)); // Darker red
            }

            public void mouseExited(MouseEvent e) {
                cancel.setBackground(new Color(220, 53, 69));
            }
        });

// Add ActionListener
        submit.addActionListener(this);
        cancel.addActionListener(this);

        setVisible(true); // Show window
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {

            // Get all input values
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = tfrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String ssc = tfssc.getText();
            String hsc = tfhsc.getText();
            String nid = tfnid.getText();
            String faculty = (String) cbfaculty.getSelectedItem();
            String program = (String) cbprogram.getSelectedItem();

            try {
                // SQL query to insert data
                String query = "insert into student values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + ssc + "', '" + hsc + "', '" + nid + "', '" + faculty + "', '" + program + "')";

                DBConnection con = new DBConnection(); // Database connection
                con.s.executeUpdate(query); // Execute query

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false); // Close form on cancel
        }
    }

    public static void main(String[] args) {
        new AddStudent(); // Run the form
    }
}
