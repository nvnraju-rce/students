package com.rce.cse.unit3.arrray;

class TwoDArrayDemo {
    public static void main(String[] args) {

        int[][] marks = {
            {80, 75, 90, 85},
            {70, 85, 88, 78},
            {90, 92, 95, 89}
        };

        // Display the array
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + "\t");
            }
            System.out.println();
        }
    }
}