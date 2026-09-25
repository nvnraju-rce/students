package mvcexceptiondemo;

public class StudentController {

    public void registerStudent(Student student) throws StudentException {

      //  System.out.println("Registering student...");

        if (student.getAge() < 18) {
            // throw = actually generates/throws the exception
            throw new StudentException(
                    "Student age must be 18 or above"
            );
        }

    /*    System.out.println("Student registered successfully!");
        System.out.println("Roll No : " + student.getRollNo());
        System.out.println("Name    : " + student.getName());
        System.out.println("Age     : " + student.getAge());*/
    }
}
