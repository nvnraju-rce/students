package com.rce.oops.unit5.applets;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/* <applet code="Click" width="250" height="100"></applet> */
// Program 58: Applet with a Button and event handling
public class Click extends Applet implements ActionListener {
    Button b = new Button("Click me");
    Label l = new Label("Press the button");
    public void init() {
        add(b); add(l);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        l.setText("Button pressed!");
    }
}
