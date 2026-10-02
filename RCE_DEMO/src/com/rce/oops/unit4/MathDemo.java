package com.rce.oops.unit4;

public class MathDemo {

    public static void main(String[] args) {

        // 1. Math.abs() - Absolute value
        int a = -25;
        System.out.println("Math.abs(-25) = " + Math.abs(a));

        // 2. Math.max() - Maximum of two numbers
        int x = 20;
        int y = 35;
        System.out.println("Math.max(20, 35) = " + Math.max(x, y));

        // 3. Math.min() - Minimum of two numbers
        System.out.println("Math.min(20, 35) = " + Math.min(x, y));

        // 4. Math.round() - Rounds to nearest integer
        double num = 12.67;
        System.out.println("Math.round(12.67) = " + Math.round(num));

        // 5. Math.sqrt() - Square root
        double square = 64;
        System.out.println("Math.sqrt(64) = " + Math.sqrt(square));

        // 6. Math.cbrt() - Cube root
        double cube = 27;
        System.out.println("Math.cbrt(27) = " + Math.cbrt(cube));

        // 7. Math.pow() - Power
        double base = 2;
        double exponent = 5;
        System.out.println("Math.pow(2, 5) = " + Math.pow(base, exponent));

        // 8. Math.sin() - Sine
        double angle = 30;
        double radians = Math.toRadians(angle);
        System.out.println("Math.sin(30°) = " + Math.sin(radians));

        // 9. Math.cos() - Cosine
        System.out.println("Math.cos(30°) = " + Math.cos(radians));

        // 10. Math.tan() - Tangent
        System.out.println("Math.tan(30°) = " + Math.tan(radians));
    }
}
