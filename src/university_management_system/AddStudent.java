package university_management_system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame {

    JTextField tfname, tffname, tfrollno, tfdob, tfaddress, tfphone, tfemail, tfssc, tfhsc, tfnid;
    JLabel lbladdress, lbldob, heading, lblname, lblfname, lblrollno, lblphone, lblemail, lblssc, lblhsc, lblnid, lblprogram, lblfaculty;
    JComboBox cbprogram, cbfaculty;
    JDateChooser dcdob;

    AddStudent() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Bangladesh University of Business and Technology"); // Window title
        getContentPane().setBackground(new Color(255, 255, 255)); // Background color R G B
        setLayout(null); // Absolute positioning

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);

        lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(540, 150, 150, 30);
        add(tffname);

        lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblrollno);

        tfrollno = new JTextField();
        tfrollno.setBounds(170, 200, 150, 30);
        add(tfrollno);

        lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(540, 200, 150, 30);
        add(dcdob);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(170, 250, 150, 30);
        add(tfaddress);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(540, 250, 150, 30);
        add(tfphone);

        lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(170, 300, 150, 30);
        add(tfemail);

        lblssc = new JLabel("SSC Grade");
        lblssc.setBounds(400, 300, 200, 30);
        lblssc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblssc);

        tfssc = new JTextField();
        tfssc.setBounds(540, 300, 150, 30);
        add(tfssc);

        lblhsc = new JLabel("HSC Grade");
        lblhsc.setBounds(50, 350, 200, 30);
        lblhsc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblhsc);

        tfhsc = new JTextField();
        tfhsc.setBounds(170, 350, 150, 30);
        add(tfhsc);

        lblnid = new JLabel("NID Number");
        lblnid.setBounds(400, 350, 200, 30);
        lblnid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(540, 350, 150, 30);
        add(tfnid);

        lblfaculty = new JLabel("Faculty");
        lblfaculty.setBounds(50, 400, 200, 30);
        lblfaculty.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfaculty);

        String faculty[] = {"Business", "Arts and Humanities", "Engineering and Applied Sciences", "Law", "Social Science" , "CS & AI"};
        cbfaculty = new JComboBox(faculty);
        cbfaculty.setBounds(170, 400, 200, 30);
        cbfaculty.setBackground(Color.WHITE);
        add(cbfaculty);

        lblprogram = new JLabel("Program");
        lblprogram.setBounds(400, 400, 200, 30);
        lblprogram.setFont(new Font("serif", Font.BOLD, 20));
        add(lblprogram);

        String program[] = {"BBA" , "MBA" , "EMBA" , "B.A" , "M.A" , "B.Sc" , "LL.B" ,"LL.M" ,"M.Sc"};
        cbprogram = new JComboBox(program);
        cbprogram.setBounds(540, 400, 150, 30);
        cbprogram.setBackground(Color.WHITE);
        add(cbprogram);
        
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
