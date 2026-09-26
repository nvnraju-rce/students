package com.rce.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * Collection.sort()
 * Collection.max()
 * Collection.min()
 * 
 */
public class ArrayCollectionOperations {
    public static void main(String[] args) {

        ArrayList<Integer> marks =
                new ArrayList<>(Arrays.asList(65, 78, 92, 55, 88));

        System.out.println("Maximum = " + Collections.max(marks));
        System.out.println("Minimum = " + Collections.min(marks));
        
        Collections.sort(marks);
        System.out.println("Ascending: " + marks);

        Collections.reverse(marks);
        System.out.println("Descending: " + marks);
    }
}
