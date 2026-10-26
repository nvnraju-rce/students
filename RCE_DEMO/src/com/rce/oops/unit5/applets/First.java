package com.rce.oops.unit5.applets;
import java.applet.Applet;
import java.awt.*;
/* <applet code="First" width="400" height="200"></applet> */
// Program 56: Welcome message applet
public class First extends Applet {
    public void init() {
        setBackground(Color.yellow);
        setForeground(Color.green);
    }
    public void paint(Graphics g) {
        g.drawString("Welcome to Ramachandra College", 40, 40);
    }
}
