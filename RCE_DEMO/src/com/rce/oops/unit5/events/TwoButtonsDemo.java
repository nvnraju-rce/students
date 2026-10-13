package com.rce.oops.unit5.events;
import java.awt.*;
import java.awt.event.*;
// Program 41: getSource() and getActionCommand() - which button fired?
public class TwoButtonsDemo extends Frame implements ActionListener {
    Label label = new Label("Press a button                    ");
    Button yes = new Button("Yes");
    Button no = new Button("No");
    TwoButtonsDemo() {
        setLayout(new FlowLayout());
        add(yes); add(no); add(label);
        yes.addActionListener(this);
        no.addActionListener(this);
        setSize(300, 120);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        label.setText(cmd + " clicked");
        if (e.getSource() == yes) setBackground(Color.green);
        else setBackground(Color.pink);
    }
    public static void main(String[] a) { new TwoButtonsDemo(); }
}
