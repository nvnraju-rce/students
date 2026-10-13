package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 49: KeyAdapter - show the key typed in a TextField
public class KeyDemo extends Frame {
    KeyDemo() {
        setLayout(new FlowLayout());
        TextField tf = new TextField(15);
        Label l = new Label("Type something                    ");
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) { l.setText("You typed: " + e.getKeyChar()); }
        });
        add(tf); add(l);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(300, 120);
        setVisible(true);
    }
    public static void main(String[] a) { new KeyDemo(); }
}
