package mvcexceptiondemo;

public class StudentController {

    public void registerStudent(RceStudent student) throws StudentException {

        if (student.getAge() < 18) {
            System.out.println("Student age must be 18 or above");

            // throw = actually generates/throws the exception
            throw new StudentException(
                    "Student age must be 18 or above"
            );
        }
        
        

    }
}
