package t62_layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 32: FlowLayout and GridLayout side by side
public class FlowGridDemo {
    public static void main(String[] a) {
        Frame f = new Frame("Flow + Grid");
        f.setLayout(new GridLayout(2, 1));

        Panel flow = new Panel(new FlowLayout());
        flow.add(new Button("1")); flow.add(new Button("2")); flow.add(new Button("3"));

        Panel grid = new Panel(new GridLayout(2, 2));
        grid.add(new Button("A")); grid.add(new Button("B"));
        grid.add(new Button("C")); grid.add(new Button("D"));

        f.add(flow);
        f.add(grid);
        f.setSize(300, 250);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
