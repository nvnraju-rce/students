package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 44: WindowAdapter - override only windowClosing()
public class CloseDemo extends Frame {
    CloseDemo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
        setSize(300, 150);
        setVisible(true);
    }
    public static void main(String[] a) { new CloseDemo(); }
}
