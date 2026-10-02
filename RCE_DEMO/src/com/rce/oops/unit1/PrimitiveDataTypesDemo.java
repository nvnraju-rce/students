package com.rce.oops.unit1;

import java.util.*;

public class PrimitiveDataTypesDemo {

    // Instance variables to demonstrate default values
    byte byteValue;
    short shortValue;
    int intValue;
    long longValue;
    float floatValue;
    double doubleValue;
    char charValue;
    boolean booleanValue;

    public static void main(String[] args) {

        PrimitiveDataTypesDemo obj = new PrimitiveDataTypesDemo();

        System.out.println("==============================================");
        System.out.println("       JAVA PRIMITIVE DATA TYPES");
        System.out.println("==============================================");

        System.out.println("\n1. DEFAULT VALUES OF PRIMITIVE DATA TYPES");
        System.out.println("----------------------------------------------");

        System.out.println("byte    Default Value : " + obj.byteValue);
        System.out.println("short   Default Value : " + obj.shortValue);
        System.out.println("int     Default Value : " + obj.intValue);
        System.out.println("long    Default Value : " + obj.longValue);
        System.out.println("float   Default Value : " + obj.floatValue);
        System.out.println("double  Default Value : " + obj.doubleValue);
        System.out.println("char    Default Value : [" + obj.charValue + "]");
        System.out.println("boolean Default Value : " + obj.booleanValue);

        System.out.println("\n2. PRIMITIVE DATA TYPES WITH VALUES");
        System.out.println("----------------------------------------------");

        System.out.println("\n3. SIZE OF PRIMITIVE DATA TYPES");
        System.out.println("----------------------------------------------");

        System.out.println("byte    : " + Byte.SIZE + " bits");
        System.out.println("short   : " + Short.SIZE + " bits");
        System.out.println("int     : " + Integer.SIZE + " bits");
        System.out.println("long    : " + Long.SIZE + " bits");
        System.out.println("float   : " + Float.SIZE + " bits");
        System.out.println("double  : " + Double.SIZE + " bits");
        System.out.println("char    : " + Character.SIZE + " bits");
      

        System.out.println("boolean : JVM-dependent storage size");

        System.out.println("\n==============================================");
    }
}
