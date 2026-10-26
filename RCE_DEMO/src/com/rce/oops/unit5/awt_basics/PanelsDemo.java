package com.rce.oops.unit5.awt_basics;


import java.awt.*;
import java.awt.event.*;
// Program 30: Nested containers - Panels inside a Frame
public class PanelsDemo {
    public static void main(String[] a) {
        Frame f = new Frame("Panels inside Frame");     // BorderLayout by default
        Panel top = new Panel();                        // FlowLayout by default
        top.setBackground(Color.cyan);
        top.add(new Label("Name:"));
        top.add(new TextField(12));
        Panel bottom = new Panel();
        bottom.setBackground(Color.orange);
        bottom.add(new Button("OK"));
        bottom.add(new Button("Cancel"));
        f.add(top, BorderLayout.NORTH);
        f.add(bottom, BorderLayout.SOUTH);
        f.add(new TextArea("Center area takes the remaining space"), BorderLayout.CENTER);
        f.setSize(350, 250);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
