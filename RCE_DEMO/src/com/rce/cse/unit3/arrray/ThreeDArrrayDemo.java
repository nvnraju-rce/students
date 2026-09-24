package com.rce.cse.unit3.arrray;

public class ThreeDArrrayDemo {

	    public static void main(String[] args) {
	        int[][][] marks = {
	            {
	                {80, 75, 90},
	                {70, 85, 88}
	            },
	            {
	                {90, 92, 95},
	                {85, 89, 91}
	            }
	        };
	        // Display the 3D array
	        for (int i = 0; i < marks.length; i++) {

	            System.out.println("Layer " + (i + 1));

	            for (int j = 0; j < marks[i].length; j++) {

	                for (int k = 0; k < marks[i][j].length; k++) {
	                    System.out.print(marks[i][j][k] + "\t");
	                }

	                System.out.println();
	            }

	            System.out.println();
	        }
	    }
	}


