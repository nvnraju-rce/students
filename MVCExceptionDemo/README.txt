MVC Exception Demo - Eclipse Project

Purpose:
Simple Student Registration application demonstrating:
1. MVC architecture
2. Custom Exception
3. throw
4. throws
5. try-catch
6. Java Swing UI

Project Structure:
src/
  mvcexceptiondemo/
    Student.java
    StudentException.java
    StudentController.java
    StudentView.java

How to import:
1. Open Eclipse.
2. File -> Import.
3. General -> Existing Projects into Workspace.
4. Select the extracted MVCExceptionDemo folder.
5. Finish.
6. Open StudentView.java.
7. Right-click -> Run As -> Java Application.

Test 1:
Roll No: 101
Name: Raju
Age: 20
Expected: Student Registered Successfully!

Test 2:
Roll No: 102
Name: Ravi
Age: 15
Expected: "Student age must be 18 or above"

Teaching points:
throws = declares that a method may throw an exception.
throw = actually throws an exception.
catch = handles the exception.
Model = Student
View = StudentView
Controller = StudentController
