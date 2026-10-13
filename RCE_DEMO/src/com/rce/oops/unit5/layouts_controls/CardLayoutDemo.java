package t62_layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 33: CardLayout - a stack of cards, one visible at a time
public class CardLayoutDemo {
    public static void main(String[] a) {
        Frame f = new Frame("CardLayout");
        CardLayout cl = new CardLayout();
        Panel cards = new Panel(cl);
        for (int i = 1; i <= 3; i++) {
            Panel p = new Panel();
            p.add(new Label("This is card " + i));
            cards.add(p, "card" + i);
        }
        Button next = new Button("Next card");
        next.addActionListener(e -> cl.next(cards));
        f.add(cards, BorderLayout.CENTER);
        f.add(next, BorderLayout.SOUTH);
        f.setSize(300, 150);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
