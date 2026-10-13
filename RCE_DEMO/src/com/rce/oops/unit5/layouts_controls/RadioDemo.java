package t62_layouts_controls;
import java.awt.*;
import java.awt.event.*;
// Program 36: Radio buttons = Checkbox + CheckboxGroup (only one selectable)
public class RadioDemo extends Frame implements ItemListener {
    CheckboxGroup g = new CheckboxGroup();
    Checkbox cash = new Checkbox("Cash", g, true);
    Checkbox card = new Checkbox("Card", g, false);
    Checkbox upi  = new Checkbox("UPI",  g, false);
    Label status = new Label("Payment: Cash          ");
    RadioDemo() {
        super("Radio buttons");
        setLayout(new FlowLayout());
        add(cash); add(card); add(upi); add(status);
        cash.addItemListener(this); card.addItemListener(this); upi.addItemListener(this);
        setSize(350, 120);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        Checkbox sel = g.getSelectedCheckbox();
        status.setText("Payment: " + sel.getLabel());
    }
    public static void main(String[] a) { new RadioDemo(); }
}
