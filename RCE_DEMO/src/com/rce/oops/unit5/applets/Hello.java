package com.rce.oops.unit5.applets;
import java.applet.Applet;
import java.awt.Graphics;
/* <applet code="Hello" width="300" height="100"></applet> */
// Program 54: Hello Applet
public class Hello extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello Applet", 40, 40);
    }
}
