package com.rce.oops.unit5.list_menu;
import java.awt.*;
import java.awt.event.*;
// Program 38: MenuBar > Menu > MenuItem
public class MenuDemo extends Frame implements ActionListener {
    Label status = new Label("Choose a menu item");
    MenuDemo() {
        super("Menu Demo");
        MenuBar mb = new MenuBar();
        Menu file = new Menu("File");
        MenuItem nw = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");
        file.add(nw); file.add(open);
        file.addSeparator();
        file.add(exit);
        mb.add(file);
        setMenuBar(mb);                 // setMenuBar(), not add()
        nw.addActionListener(this); open.addActionListener(this); exit.addActionListener(this);
        add(status);
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Exit")) System.exit(0);
        status.setText(cmd + " clicked");
    }
    public static void main(String[] a) { new MenuDemo(); }
}
