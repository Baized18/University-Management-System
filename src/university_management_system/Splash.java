package university_management_system; // Package for university management system

import javax.swing.*; // Swing for GUI components
import java.awt.*; // AWT for image and graphics operations

public class Splash extends JFrame implements Runnable { // Splash screen class with threading

    Thread t; // Thread for running splash animation

    Splash() { // Constructor to create and display splash screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBT1.jpg")); // Load image
        Image i2 = i1.getImage().getScaledInstance(1300, 750, Image.SCALE_DEFAULT); // Resize image
        ImageIcon i3 = new ImageIcon(i2); // Create ImageIcon from resized image

        JLabel image = new JLabel(i3); // Add image to label
        add(image); // Add label to frame

        t = new Thread(this); // Initialize thread
        t.start(); // Start thread

        setVisible(true); // Show splash screen

        int x = 1; // Variable for animation adjustment

        for (int i = 2; i <= 600; i += 6, x += 1) { // Animation loop for resizing and moving window
            setLocation(700 - ((i + x) / 2), 400 - (i / 2)); // Update window position
            setSize(i + 3 * x, i + x / 2); // Update window size

            try {
                Thread.sleep(10); // Delay for smooth animation
            } catch (Exception e) {
            }
        }

        setLocation(350, 150); // Final position
        setSize(1000, 650); // Final size
    }

    public static void main(String args[]) { // Main method to launch splash screen
        Splash s = new Splash(); // Create and show splash screen
    }

    public void run() { // Thread run method controlling splash duration
        try {
            Thread.sleep(4000); // Keep splash screen visible for 4 seconds
            setVisible(false); // Hide splash screen
            Login l = new Login(); // Open login window
        } catch (Exception e) {
        }
    }
}