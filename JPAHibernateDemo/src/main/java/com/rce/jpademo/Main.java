package com.rce.jpademo;

//Persistence = Saving Java object data into a database so that it 
//remains available even after the Java program stops.
 class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        System.out.println("===== JPA + Hibernate Demo =====");

        // CREATE / INSERT
        Student s1 = new Student(4047,"Raju", 20);
        Student s2 = new Student(4048,"Ravi", 21);

        dao.save(s1);
        dao.save(s2);

        // READ / SELECT
        System.out.println();
        System.out.println("Students from Database:");

        for (Student student : dao.findAll()) {
            System.out.println(student);
        }

        dao.close();

        System.out.println();
        System.out.println("===== Program Completed =====");
    }
}
