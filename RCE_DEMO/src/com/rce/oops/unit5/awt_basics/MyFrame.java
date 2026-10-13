package t61_awt_basics;
import java.awt.*;
import java.awt.event.*;
// Program 27: First AWT window (association - Frame object)
public class MyFrame {
    public static void main(String[] a) {
        Frame f = new Frame("My First AWT");
        Button b = new Button("Click me");
        f.setLayout(new FlowLayout());
        f.add(b);
        f.setSize(300, 200);
        f.setVisible(true);
        // close button works only with a WindowListener
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
