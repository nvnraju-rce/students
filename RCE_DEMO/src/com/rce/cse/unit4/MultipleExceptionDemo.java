package com.rce.cse.unit4;
import java.util.Scanner;
import java.util.InputMismatchException;
public class MultipleExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1. Arithmetic Exception");
            System.out.println("2. Array Exception");
            System.out.println("3. Input Mismatch Exception");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // ArithmeticException
                    int a = 10;
                    int b = 0;

                    int result = a / b;
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    // ArrayIndexOutOfBoundsException
                    int[] numbers = {10, 20, 30};

                    System.out.println(numbers[5]);
                    break;

                case 3:
                    // InputMismatchException
                    System.out.print("Enter an integer: ");
                    int number = sc.nextInt();

                    System.out.println("Number: " + number);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        catch (ArithmeticException e) {

            System.out.println(
                "Error: Cannot divide by zero");
        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                "Error: Array index is out of bounds" );
        }

        catch (InputMismatchException e) {

            System.out.println(
                "Error: Please enter an integer"   );
        }

        finally {

            System.out.println( "Finally block executed"   );

            sc.close();
        }

        System.out.println("Program Completed");
    }
}