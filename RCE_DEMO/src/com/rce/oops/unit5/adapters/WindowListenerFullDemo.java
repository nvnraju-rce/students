package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 45: Implementing the interface = ALL 7 methods (compare with CloseDemo)
public class WindowListenerFullDemo extends Frame implements WindowListener {
    WindowListenerFullDemo() {
        super("WindowListener (all 7 methods)");
        addWindowListener(this);
        setSize(350, 150);
        setVisible(true);
    }
    public void windowOpened(WindowEvent e)      { System.out.println("windowOpened"); }
    public void windowClosing(WindowEvent e)     { System.out.println("windowClosing"); dispose(); }
    public void windowClosed(WindowEvent e)      { System.out.println("windowClosed"); System.exit(0); }
    public void windowIconified(WindowEvent e)   { System.out.println("windowIconified"); }
    public void windowDeiconified(WindowEvent e) { System.out.println("windowDeiconified"); }
    public void windowActivated(WindowEvent e)   { System.out.println("windowActivated"); }
    public void windowDeactivated(WindowEvent e) { System.out.println("windowDeactivated"); }
    public static void main(String[] a) { new WindowListenerFullDemo(); }
}
