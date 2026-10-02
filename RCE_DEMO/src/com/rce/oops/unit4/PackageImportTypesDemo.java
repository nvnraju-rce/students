package com.rce.oops.unit4;

import com.rce.oops.unit4.StudentsPkgDemo;
import com.rce.oops.unit4.*;
public class PackageImportTypesDemo {
	
    public static void main(String[] args) {
        StudentsPkgDemo student = new StudentsPkgDemo(101, "Rao");
        com.rce.oops.unit4.StudentsPkgDemo student2 = new StudentsPkgDemo(102, "Anil");
        student.display();
        student2.display();
        java.util.Scanner sc = new java.util.Scanner(System.in);
    }

}
