package university_management_system;
// Package containing classes for the university management system

import javax.swing.*;
// Swing package used for GUI components

import java.awt.*;
// AWT package used for image and graphics operations

public class Splash extends JFrame implements Runnable {
// Splash screen class that creates a loading window and runs a thread

    Thread t;

    Splash() {
    // Constructor to create and display the splash screen

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
                Thread.sleep(10); // Delay for smooth animation
            } catch (Exception e) {
            }
        }

        setLocation(350, 150);
        setSize(1000, 650);
    }

    public static void main(String args[]) {
    // Main method where program execution starts

        Splash s = new Splash();
    }

    public void run() {
    // Thread method that controls splash screen duration and opens login window

        try {
            Thread.sleep(4000); // Show splash screen for 4 seconds

            setVisible(false);

            Login l = new Login(); // Open login window

        } catch (Exception e) {
        }
    }

}