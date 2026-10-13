package com.rce.oops.unit5.adapters;
import java.awt.*;
import java.awt.event.*;
// Program 47: MouseListener (5 methods) - shows every mouse event in a Label
public class MouseListenerFullDemo extends Frame implements MouseListener {
    Label l = new Label("Move/click the mouse inside the window");
    MouseListenerFullDemo() {
        super("MouseListener");
        add(l);
        addMouseListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setSize(350, 150);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent e)  { l.setText("clicked");  }
    public void mousePressed(MouseEvent e)  { l.setText("pressed");  }
    public void mouseReleased(MouseEvent e) { l.setText("released"); }
    public void mouseEntered(MouseEvent e)  { l.setText("entered");  }
    public void mouseExited(MouseEvent e)   { l.setText("exited");   }
    public static void main(String[] a) { new MouseListenerFullDemo(); }
}
