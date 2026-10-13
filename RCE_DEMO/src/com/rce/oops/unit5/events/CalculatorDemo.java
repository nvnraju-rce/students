package com.rce.oops.unit5.events;
import java.awt.*;
import java.awt.event.*;
// Program 43: Mini calculator - TextFields + Buttons + ActionListener
public class CalculatorDemo extends Frame implements ActionListener {
    TextField t1 = new TextField(8), t2 = new TextField(8);
    Label result = new Label("Result: ");
    Button add = new Button("+"), sub = new Button("-"), mul = new Button("*"), div = new Button("/");
    CalculatorDemo() {
        super("Calculator");
        setLayout(new FlowLayout());
        add(t1); add(t2);
        add(add); add(sub); add(mul); add(div);
        add(result);
        add.addActionListener(this); sub.addActionListener(this);
        mul.addActionListener(this); div.addActionListener(this);
        setSize(300, 160);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(t1.getText());
            double y = Double.parseDouble(t2.getText());
            double r = 0;
            switch (e.getActionCommand()) {
                case "+": r = x + y; break;
                case "-": r = x - y; break;
                case "*": r = x * y; break;
                case "/": r = x / y; break;
            }
            result.setText("Result: " + r + "          ");
        } catch (NumberFormatException ex) {
            result.setText("Enter numbers only");
        }
    }
    public static void main(String[] a) { new CalculatorDemo(); }
}
