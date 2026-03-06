package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    Login () {
    
     setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
}
    
    
    
     public static void main(String[] args) {
        new Login();
    }
}
