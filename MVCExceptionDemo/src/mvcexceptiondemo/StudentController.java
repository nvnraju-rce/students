package mvcexceptiondemo;

public class StudentController {

    public void registerStudent(Student student) throws StudentException {

        if (student.getAge() < 18) {
            // throw = actually generates/throws the exception
            throw new StudentException(
                    "Student age must be 18 or above"
            );
        }

    }
}
