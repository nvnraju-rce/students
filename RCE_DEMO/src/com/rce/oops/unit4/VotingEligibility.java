package com.rce.oops.unit4;

import java.util.Scanner;

//Custom Exception
class VotingEligibilityException extends Exception {

 public VotingEligibilityException(String message) {
     super(message);
 }
}

//Main Class
public class VotingEligibility {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     try {
         System.out.print("Enter age: ");
         int age = sc.nextInt();

         // Age validation
         if (age < 18 || age > 60) {
             throw new VotingEligibilityException(
                 "Age must be between 18 and 60"
             );
         }

         System.out.println("eligible to vote");

     } catch (VotingEligibilityException e) {
         System.out.println(e.getMessage());

     } catch (Exception e) {
         System.out.println("Invalid input");
     }

     sc.close();
 }
}
