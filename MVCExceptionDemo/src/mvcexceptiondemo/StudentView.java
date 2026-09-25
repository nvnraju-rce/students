package mvcexceptiondemo;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtRollNo;
    private JTextField txtName;
    private JTextField txtAge;
    private StudentController controller;

    public StudentView() {

        controller = new StudentController();

        setTitle("Student Registration -  Exception Handling");
        setSize(500, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Roll No:"));
        txtRollNo = new JTextField();
        add(txtRollNo);

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Age:"));
        txtAge = new JTextField();
        add(txtAge);

        add(new JLabel(""));
        JButton btnRegister = new JButton("Register");
        add(btnRegister);

        btnRegister.addActionListener(e -> registerStudent());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerStudent() {

        try {
            int rollNo = Integer.parseInt(txtRollNo.getText().trim());
            String name = txtName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());

            if (name.isEmpty()) {
                throw new StudentException("Name cannot be empty");
            }

            Student student = new Student(rollNo, name, age);

            // Controller method declares: throws StudentException
            controller.registerStudent(student);

            JOptionPane.showMessageDialog(
                    this,
                    "Student Registered Successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (StudentException e) {

            // catch handles the exception thrown by the controller
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers for Roll No and Age.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new StudentView();
    }
}
