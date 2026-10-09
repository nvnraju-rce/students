package com.rce.oops.unit2;
class A{
	void show() {
		System.out.println("Clas A");
	}
}
class B extends A{
	void show() {
		System.out.println("Clas b");
	}
}

public class TestDemo {
	public static void main (String args[]) {
		A obj = new B();
		obj.show();
	}

}
