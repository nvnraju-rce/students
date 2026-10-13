package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 48: MouseMotionAdapter - follow the mouse
public class MouseMotionDemo extends Frame {
    MouseMotionDemo() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) { setTitle("Mouse at " + e.getX() + "," + e.getY()); }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] a) { new MouseMotionDemo(); }
}
