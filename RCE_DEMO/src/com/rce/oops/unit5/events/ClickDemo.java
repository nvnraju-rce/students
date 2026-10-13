package com.rce.oops.unit5.events;
import java.awt.*;
import java.awt.event.*;
// Program 40: Event delegation model - source, listener, handler
public class ClickDemo extends Frame implements ActionListener {
    Label l = new Label("Not clicked");
    ClickDemo() {
        Button b = new Button("Click");
        b.addActionListener(this);          // step 2: register
        setLayout(new FlowLayout());
        add(b); add(l);
        setSize(250, 150);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {   // step 3: handler
        l.setText("Clicked!");
    }
    public static void main(String[] a) { new ClickDemo(); }
}
