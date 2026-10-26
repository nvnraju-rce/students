package com.rce.oops.unit5.list_menu;
import java.awt.*;
import java.awt.event.*;
// Program 39: Scrollbar - AdjustmentEvent
public class ScrollbarDemo {
    public static void main(String[] args) {
        Frame f = new Frame("Scrollbar");
        f.setLayout(new FlowLayout());
        Label label = new Label("Value: 0     ");
        Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 100);
        sb.setPreferredSize(new Dimension(250, 20));
        sb.addAdjustmentListener(e -> label.setText("Value: " + sb.getValue()));
        f.add(sb); f.add(label);
        f.setSize(320, 120);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
