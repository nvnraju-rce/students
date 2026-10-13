package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 46: MouseAdapter - handle only the click
public class MouseDemo extends Frame {
    MouseDemo() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setTitle("Clicked at " + e.getX() + "," + e.getY());
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] a) { new MouseDemo(); }
}
