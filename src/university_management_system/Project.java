package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame {
    
     Project() {
       setSize(1500, 800);
        setLocation(250, 100);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBTinside.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
    
        setVisible(true);
     }
    
    
    
     public static void main(String[] args) {
        new Project();
    }
}
