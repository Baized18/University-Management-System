package university_management_system; 
// Declares that this class belongs to the package "university_management_system"

import javax.swing.*; 
// Imports all Swing classes such as JFrame, JLabel, ImageIcon etc.
// Swing is used to create modern GUI applications in Java

import java.awt.*; 
// Imports AWT classes like Image
// AWT is the older GUI library but still used for graphics operations

public class Splash extends JFrame implements Runnable { 
// Splash class is created
// extends JFrame → makes this class a window frame
// implements Runnable → allows the class to run a thread using run() method

    Thread t; 
    // Declaring a thread object which will run background tasks

    Splash() { 
    // Constructor of Splash class
    // This runs automatically when object of Splash is created

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BUBT1.jpg"));
        // Loads image from project resource folder "icons"
        // ClassLoader helps locate the file inside project resources

        Image i2 = i1.getImage().getScaledInstance(1300, 750, Image.SCALE_DEFAULT);
        // Converts ImageIcon to Image
        // Resizes the image to width 1300 and height 750

        ImageIcon i3 = new ImageIcon(i2);
        // Converts resized Image back to ImageIcon so Swing components can display it

        JLabel image = new JLabel(i3);  
        // Creates a label and places the image inside it

        add(image);
        // Adds the image label to the JFrame window

        t = new Thread(this);
        // Creates a thread and passes the current class (this)
        // Because the class implements Runnable

        t.start();
        // Starts the thread which will execute the run() method

        setVisible(true);
        // Makes the splash window visible on screen

        int x = 1;
        // Variable used to control animation growth

        for (int i = 2; i <= 600; i += 6, x += 1) {
        // Loop to gradually increase the window size
        // i increases window size
        // x helps adjust animation effect

            setLocation(700 - ((i + x) / 2), 400 - (i / 2));
            // Moves the frame position while it grows
            // Keeps the window centered during animation

            setSize(i + 3 * x, i + x / 2);
            // Gradually increases the frame size

            try {
                Thread.sleep(10);
                // Pauses the animation for 10 milliseconds
                // This creates smooth animation effect
            } catch (Exception e) {
                // Exception handling (ignored here)
            }
        }

        setLocation(350, 150);
        // Final position of splash screen

        setSize(1000, 650);
        // Final size of splash screen

    }

    public static void main(String args[]) {
    // Main method – program execution starts here

        Splash s = new Splash();
        // Creates Splash object which calls the constructor
        // Splash screen window appears
    }

    public void run() {
    // run() method executes when thread starts

        try {
            Thread.sleep(4000);
            // Keeps splash screen visible for 4 seconds

            setVisible(false);
            // After 4 seconds splash screen disappears
            
            // Next Frame
            Login l = new Login();
            // Opens the Login window (next screen)

        } catch (Exception e) {
            // Exception handling
        }
    }

}