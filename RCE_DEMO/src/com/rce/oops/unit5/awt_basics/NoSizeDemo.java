package com.rce.oops.unit5.awt_basics;
import java.awt.*;
// Program 29: Why setSize/setVisible are essential - run, then uncomment the lines
public class NoSizeDemo {
    public static void main(String[] a) {
        Frame f = new Frame("Nothing appears!");
        f.add(new Button("Hidden"));
        // f.setSize(300, 150);     // 1. uncomment
        // f.setVisible(true);      // 2. uncomment
        System.out.println("Frame created but not visible");
    }
}
