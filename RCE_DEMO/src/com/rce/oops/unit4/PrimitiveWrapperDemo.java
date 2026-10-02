package com.rce.oops.unit4;

public class PrimitiveWrapperDemo {

    public static void main(String[] args) {

        // 1. Primitive Data Types
        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 10000L;
        float f = 10.5f;
        double d = 25.75;
        char ch = 'A';
        boolean flag = true;

        System.out.println("===== PRIMITIVE DATA TYPES =====");

        System.out.println("byte     : " + b);
        System.out.println("short    : " + s);
        System.out.println("int      : " + i);
        System.out.println("long     : " + l);
        System.out.println("float    : " + f);
        System.out.println("double   : " + d);
        System.out.println("char     : " + ch);
        System.out.println("boolean  : " + flag);

        // 2. Wrapper Classes - Autoboxing
        Byte wb = b;
        Short ws = s;
        Integer wi = i;
        Long wl = l;
        Float wf = f;
        Double wd = d;
        Character wch = ch;
        Boolean wflag = flag;

        System.out.println("\n===== WRAPPER CLASSES =====");

        System.out.println("Byte      : " + wb);
        System.out.println("Short     : " + ws);
        System.out.println("Integer   : " + wi);
        System.out.println("Long      : " + wl);
        System.out.println("Float     : " + wf);
        System.out.println("Double    : " + wd);
        System.out.println("Character : " + wch);
        System.out.println("Boolean   : " + wflag);

        // 3. Unboxing
        int num = wi;
        double decimal = wd;

        System.out.println("\n===== UNBOXING =====");
        System.out.println("Integer converted to int: " + num);
        System.out.println("Double converted to double: " + decimal);

        // 4. Wrapper Class Utility Methods
        System.out.println("\n===== WRAPPER CLASS METHODS =====");

        String str = "123";

        int value = Integer.parseInt(str);
        System.out.println("String to int: " + value);

        String number = "45.67";
        double result = Double.parseDouble(number);
        System.out.println("String to double: " + result);

        System.out.println("Maximum Integer: " + Integer.MAX_VALUE);
        System.out.println("Minimum Integer: " + Integer.MIN_VALUE);

        System.out.println("Character is Letter: "
                           + Character.isLetter('A'));

        System.out.println("Character is Digit: "
                           + Character.isDigit('5'));
    }
}
