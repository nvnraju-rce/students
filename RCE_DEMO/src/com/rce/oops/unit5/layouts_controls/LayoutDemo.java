package t62_layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 31: BorderLayout - five regions
public class LayoutDemo {
    public static void main(String[] a) {
        Frame f = new Frame("Layouts");
        f.setLayout(new BorderLayout());
        f.add(new Button("N"), BorderLayout.NORTH);
        f.add(new Button("S"), BorderLayout.SOUTH);
        f.add(new Button("E"), BorderLayout.EAST);
        f.add(new Button("W"), BorderLayout.WEST);
        f.add(new Button("C"), BorderLayout.CENTER);
        f.setSize(300, 200);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
