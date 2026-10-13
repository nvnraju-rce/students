package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 50: FocusAdapter - change colour when a field gets/loses focus
public class FocusDemo extends Frame {
    FocusDemo() {
        setLayout(new FlowLayout());
        TextField a = new TextField(12), b = new TextField(12);
        FocusAdapter fa = new FocusAdapter() {
            public void focusGained(FocusEvent e) { ((Component) e.getSource()).setBackground(Color.yellow); }
            public void focusLost(FocusEvent e)   { ((Component) e.getSource()).setBackground(Color.white); }
        };
        a.addFocusListener(fa); b.addFocusListener(fa);
        add(a); add(b);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(300, 100);
        setVisible(true);
    }
    public static void main(String[] args) { new FocusDemo(); }
}
