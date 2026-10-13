package com.rce.oops.advanced.jdbc;


import java.util.Scanner;
public class SkipByTwo {

        // Write your code here...
        public static void main (String args[]){
			Scanner sc = new Scanner(System.in);
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int i = start; i<= end; i += 2){
				if(i> start){
					System.out.print(" ");
				}
				System.out.println(i);
			}
			System.out.println();
			sc.close();
		}
}
        
        
