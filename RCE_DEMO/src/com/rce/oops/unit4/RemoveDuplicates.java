package com.rce.oops.unit4;

import java.util.*;
public class RemoveDuplicates {
	// Write your code here...
	public static void main (String args[]){
        int number ;
	 Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		int a[] = new int[number];
	 for (int i = 0; i < number; i++) { //45 12 89 12 33 45
            a[i] = sc.nextInt();
        }
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++){
			  System.out.println("Sorted;;;;"+a[i]+" ");
		}
		for (int i = 0; i < a.length; i++){
	       if(a[i] == a[i+1]){
			  System.out.print("One"+a[i]+" ");
			 
			   
		   }else{
           System.out.print("Two"+a[i]+" ");
		   }
}
		 
       
    }
}

        
        
        
        

