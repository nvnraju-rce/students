package com.rce.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListLoop {
    public static void main(String[] args) {

        ArrayList<Integer> marks =
                new ArrayList<>(Arrays.asList(65, 78, 92, 55, 88));

        System.out.println("Using normal for loop:");
        for (int i = 0; i < marks.size(); i++) {
            System.out.println(marks.get(i));
        }

        System.out.println("\nUsing enhanced for loop:");
        for (int mark : marks) {
            System.out.println(mark);
        }
    }
}
