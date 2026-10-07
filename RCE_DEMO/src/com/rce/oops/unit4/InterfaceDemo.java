package com.rce.oops.unit4;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

// ---------- 0. User-defined interface ----------
interface Shape {
    double PI = 3.14159;                 // constant (public static final)
    double area();                       // abstract method (the "contract")
    default void describe() {            // default method (Java 8+)
        System.out.println(getClass().getSimpleName() + " area = " + area());
    }
}

class Circle implements Shape {
    double r;
    Circle(double r) { this.r = r; }
    public double area() { return PI * r * r; }
}

class Rectangle implements Shape {
    double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    public double area() { return l * b; }
}

// ---------- Comparable + Cloneable + Serializable ----------
class Student implements Comparable<Student>, Cloneable, Serializable {
    int id;
    String name;
    Student(int id, String name) { this.id = id; this.name = name; }

    public int compareTo(Student o) { return Integer.compare(id, o.id); }   // natural order by id

    @Override
    public Student clone() {
        try { return (Student) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }

    public String toString() { return id + ":" + name; }
}

// ---------- Iterable + Iterator ----------
class NumberRange implements Iterable<Integer> {
    private final int from, to;
    NumberRange(int from, int to) { this.from = from; this.to = to; }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int cur = from;
            public boolean hasNext() { return cur <= to; }
            public Integer next() { return cur++; }
        };
    }
}

// ---------- CharSequence ----------
class ReversedText implements CharSequence {
    private final String s;
    ReversedText(String s) { this.s = s; }
    public int length() { return s.length(); }
    public char charAt(int i) { return s.charAt(s.length() - 1 - i); }
    public CharSequence subSequence(int a, int b) {
        return new StringBuilder(this).substring(a, b);
    }
    public String toString() { return new StringBuilder(this).toString(); }
}

// ---------- AutoCloseable ----------
class Resource implements AutoCloseable {
    Resource() { System.out.println("Resource opened"); }
    void use() { System.out.println("Using resource"); }
    public void close() { System.out.println("Resource closed automatically"); }
}

public class InterfaceDemo {
    public static void main(String[] args) throws Exception {

        System.out.println("--- User-defined interface ---");
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4) };
        for (Shape s : shapes) s.describe();

        System.out.println("\n--- Comparable (natural order) ---");
        List<Student> list = new ArrayList<>(List.of(
                new Student(3, "Ravi"), new Student(1, "Anil"), new Student(2, "Sita")));
        Collections.sort(list);
        System.out.println(list);

        System.out.println("\n--- Comparator (custom order by name, descending) ---");
        Comparator<Student> byNameDesc = (a, b) -> b.name.compareTo(a.name);
        list.sort(byNameDesc);
        System.out.println(list);

        System.out.println("\n--- Iterable / Iterator ---");
        for (int n : new NumberRange(1, 5)) System.out.print(n + " ");
        System.out.println();

        System.out.println("\n--- CharSequence ---");
        CharSequence cs = new ReversedText("Java");
        System.out.println(cs + " length=" + cs.length() + " charAt(0)=" + cs.charAt(0));

        System.out.println("\n--- Cloneable ---");
        Student s1 = new Student(10, "Latha");
        Student s2 = s1.clone();
        s2.name = "Changed";
        System.out.println(s1 + " | " + s2);

        System.out.println("\n--- Serializable (marker interface) ---");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) { out.writeObject(s1); }
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()))) {
            System.out.println("Restored: " + in.readObject());
        }

        System.out.println("\n--- AutoCloseable (try-with-resources) ---");
        try (Resource r = new Resource()) { r.use(); }

        System.out.println("\n--- Runnable ---");
        Thread t = new Thread(() -> System.out.println("Running in " + Thread.currentThread().getName()));
        t.start();
        t.join();

        System.out.println("\n--- Callable (returns a value) ---");
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> 5 * 5;
        System.out.println("Result = " + ex.submit(task).get());
        ex.shutdown();

        System.out.println("\n--- Supplier ---");
        Supplier<String> greet = () -> "Hello from Supplier";
        System.out.println(greet.get());
    }
}
