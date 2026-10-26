package com.rce.oops.unit5.layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 34: Label and Button
public class ButtonLabelDemo extends Frame implements ActionListener {
    Label l = new Label("Enter name:");
    TextField tf = new TextField(12);
    Button b = new Button("Submit");
    Label result = new Label("                              ");
    ButtonLabelDemo() {
        super("Button and Label");
        setLayout(new FlowLayout());
        l.setAlignment(Label.CENTER);
        add(l); add(tf); add(b); add(result);
        b.addActionListener(this);
        setSize(300, 150);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        result.setText("Hello, " + tf.getText());   // setText() on a Label shows results
    }
    public static void main(String[] a) { new ButtonLabelDemo(); }
}
