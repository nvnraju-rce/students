package com.rce.oops.unit4;

interface Parent
{
static void display()
{
System.out.println("Welcome to RCE from Parent class");
}
}
class StaticMethodExample
{
public static void main(String args[])
{
Parent.display();
}
}

