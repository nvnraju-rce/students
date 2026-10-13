package com.rce.oops.unit4;
class Outer {

    interface Inner {
        void display();
    }
}
class Test implements Outer.Inner {

    @Override
    public void display() {
        System.out.println("Hello from nested interface");
    }
}
public class NestedInterfaceDemo {

    public static void main(String[] args) {

        Outer.Inner obj = new Test();

        obj.display();
    }
}
