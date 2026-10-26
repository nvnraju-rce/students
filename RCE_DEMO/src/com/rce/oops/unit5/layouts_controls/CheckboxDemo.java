package com.rce.oops.unit5.layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 35: Checkbox - many can be selected; ItemListener
public class CheckboxDemo extends Frame implements ItemListener {
    Checkbox c1 = new Checkbox("Java");
    Checkbox c2 = new Checkbox("Python", true);
    Checkbox c3 = new Checkbox("C++");
    Label status = new Label("Select languages");
    CheckboxDemo() {
        super("Checkbox");
        setLayout(new FlowLayout());
        add(c1); add(c2); add(c3); add(status);
        c1.addItemListener(this); c2.addItemListener(this); c3.addItemListener(this);
        setSize(350, 120);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        String m = "Selected:";
        if (c1.getState()) m += " Java";
        if (c2.getState()) m += " Python";
        if (c3.getState()) m += " C++";
        status.setText(m);
    }
    public static void main(String[] a) { new CheckboxDemo(); }
}
