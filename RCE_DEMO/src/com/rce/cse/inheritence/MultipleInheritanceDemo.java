package com.rce.cse.inheritence;
//Multiple inherentace is not supported directly in java
//Use interface class instead of class to support .
interface Father { //interface Class
    void house();
}

interface Mother { //interface Class
    void car();
}

class Child implements Father, Mother { //Implement interface  in Child Class

    public void house() {
        System.out.println("Father's house");
    }

    public void car() {
        System.out.println("Mother's car");
    }
}

public class MultipleInheritanceDemo {

    public static void main(String[] args) {

        Child c = new Child();

        c.house();
        c.car();
    }
}
