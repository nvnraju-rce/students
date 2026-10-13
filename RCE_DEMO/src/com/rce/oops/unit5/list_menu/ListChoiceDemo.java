package t63_list_menu;
import java.awt.*;
import java.awt.event.*;
// Program 37: List (multiple selection) and Choice (drop-down)
public class ListChoiceDemo extends Frame implements ItemListener {
    List list = new List(3, true);
    Choice ch = new Choice();
    Label status = new Label("Pick something                              ");
    ListChoiceDemo() {
        super("List and Choice");
        setLayout(new FlowLayout());
        list.add("Java"); list.add("Python"); list.add("C++");
        ch.add("AI & DS"); ch.add("CSE"); ch.add("Cyber Security");
        add(list); add(ch); add(status);
        list.addItemListener(this);
        ch.addItemListener(this);
        setSize(350, 220);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        String[] items = list.getSelectedItems();
        status.setText("List: " + String.join(",", items) + " | Branch: " + ch.getSelectedItem());
    }
    public static void main(String[] a) { new ListChoiceDemo(); }
}
