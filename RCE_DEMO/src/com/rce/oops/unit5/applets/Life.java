package com.rce.oops.unit5.applets;
import java.applet.Applet;
import java.awt.Graphics;
/* <applet code="Life" width="300" height="100"></applet> */
// Program 55: Applet life cycle - init, start, stop, destroy, paint
public class Life extends Applet {
    String log = "";
    public void init()    { log += "init ";  System.out.println("init"); }
    public void start()   { log += "start "; System.out.println("start"); }
    public void stop()    { log += "stop ";  System.out.println("stop"); }
    public void destroy() { System.out.println("destroy"); }
    public void paint(Graphics g) {
        g.drawString(log, 20, 40);
        System.out.println("paint");
    }
}
