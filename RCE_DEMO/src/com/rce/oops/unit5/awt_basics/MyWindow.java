package com.rce.oops.unit5.awt_basics;
import java.awt.*;
import java.awt.event.*;
// Program 28: Window by extending Frame (inheritance)
public class MyWindow extends Frame {
    MyWindow() {
        super("Extending Frame");
        setSize(300, 150);
        setLayout(new FlowLayout());
        add(new Label("Hello AWT"));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
        setVisible(true);
    }
    public static void main(String[] a) { new MyWindow(); }
}
