package com.rce.oops.unit5.applets;
import java.applet.*;
import java.awt.*;
/* <applet code="Shapes" width="260" height="150"></applet> */
// Program 57: Drawing shapes
public class Shapes extends Applet {
    public void paint(Graphics g) {
        g.setColor(Color.red);   g.drawRect(20, 20, 100, 60);
        g.setColor(Color.blue);  g.fillOval(140, 20, 80, 60);
        g.setColor(Color.black); g.drawLine(20, 100, 220, 100);
        g.drawString("Shapes", 90, 120);
    }
}
