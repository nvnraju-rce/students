package com.rce.oops.unit5.events;
import java.awt.*;
import java.awt.event.*;
// Program 42: Complete event program (course example)
public class Simple extends Frame implements ActionListener {
    Label label = new Label("Choose branches");
    Checkbox c1 = new Checkbox("AI & DS");
    Checkbox c2 = new Checkbox("CSE (IoT)");
    Checkbox c3 = new Checkbox("Cyber Security");
    Button button = new Button("Submit");
    Simple() {
        setLayout(new FlowLayout());
        add(label); add(c1); add(c2); add(c3);
        add(button);
        button.addActionListener(this);
        setSize(400, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String m = "Selected: ";
        if (c1.getState()) m += "AI&DS ";
        if (c2.getState()) m += "IoT ";
        if (c3.getState()) m += "Cyber";
        label.setText(m);
    }
    public static void main(String[] a) { new Simple(); }
}
