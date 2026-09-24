package com.rce.cse.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read file path
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        // Read word to search
        System.out.print("Enter word to search: ");
        String searchWord = sc.nextLine();

        boolean found = false;

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();

                if (word.equalsIgnoreCase(searchWord)) {
                    found = true;
                    break;
                }
            }

            fileScanner.close();

            if (found) {
                System.out.println("Word '" + searchWord + "' exists in the file.");
            } else {
                System.out.println("Word '" + searchWord + "' does not exist in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        sc.close();
    }
}
