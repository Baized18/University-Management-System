package university_management_system;

import javax.swing.*; //used in Java to import all the classes from the Swing package, which is used to create GUI (Graphical User Interface) applications Newer and improved
import java.awt.*; //Older GUI library 

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBT1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 600; i += 6, x += 1) {
            setLocation(700 - ((i + x) / 2), 400 - (i / 2));
            setSize(i + 3 * x, i + x / 2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        setLocation(350, 150);
        setSize(1300, 750);

    }

    public static void main(String args[]) {
        Splash s = new Splash();
    }

      public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
            
            // Next Frame
          
        } catch (Exception e) {
            
        }
    }

    
}
