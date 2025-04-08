package quizsystem;

import java.util.*;
import java.io.*;
import usermanagement.User;
import usermanagement.UserAlreadyExistsException;

public class QuizManagementSystem {
    public static void main(String[] args) throws IOException {
        try {
            User.register("admin", "admin123");
            User.register("user1", "password");
        } catch (UserAlreadyExistsException e) {
            System.out.println("Registration error: " + e.getMessage());
        }

        User loggedInUser = User.login("user1", "password");
        if (loggedInUser != null) {
            System.out.println("Login successful!");

            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Quiz Type: 1 for Java Basics (timed quiz), 2 for Advanced Java (with penalty)");
            int quizType = sc.nextInt();

            if (quizType == 1) {
                Quiz1 quiz = new Quiz1("Java Basics", "A quiz on Java fundamental concepts.", 900);
                quiz.addQue(new Question("What is the correct way to declare a variable in Java?",
                        Arrays.asList("int x = 10;", "x int = 10;", "10 = int x;", "declare int x = 10;"),
                        "int x = 10;"));
                quiz.addQue(new Question("Which of these is not a Java keyword?",
                        Arrays.asList("static", "Boolean", "void", "private"),
                        "Boolean"));
                quiz.addQue(new Question("Which of the following is used to print in Java?",
                        Arrays.asList("System.out.println()", "print()", "console.log()", "echo()"),
                        "System.out.println()"));

                quiz.addQue(new Question("Which data type is used to create a variable that should store text?",
                        Arrays.asList("int", "String", "boolean", "char"),
                        "String"));

                quiz.addQue(new Question("Which of the following is a correct array declaration in Java?",
                        Arrays.asList("int[] arr;", "array int arr;", "int arr[]", "arr{10}"),
                        "int[] arr;"));

                quiz.addQue(new Question("What is the size of an int variable in Java?",
                        Arrays.asList("4 bytes", "2 bytes", "8 bytes", "Depends on the system"),
                        "4 bytes"));

                quiz.addQue(new Question("What is the range of values for the byte data type in Java?",
                        Arrays.asList("-128 to 127", "0 to 255", "-32768 to 32767", "-2147483648 to 2147483647"),
                        "-128 to 127"));

                quiz.addQue(new Question("Which keyword is used to define a constant variable in Java?",
                        Arrays.asList("static", "final", "const", "immutable"),
                        "final"));

                quiz.addQue(new Question("What will be the output of the following code? int a = 5; System.out.println(a++);",
                        Arrays.asList("5", "6", "Error", "None"),
                        "5"));

                quiz.addQue(new Question("What does the `new` keyword do in Java?",
                        Arrays.asList("Creates a new object", "Defines a new method", "Declares a variable", "Allocates memory statically"),
                        "Creates a new object"));

                quiz.addQue(new Question("What is the entry point of any Java program?",
                        Arrays.asList("public static void main(String[] args)", "main()", "public void main(String args[])", "System.out.println()"),
                        "public static void main(String[] args)"));

                quiz.addQue(new Question("Which operator is used for concatenation in Java?",
                        Arrays.asList("+", "-", "*", "&&"),
                        "+"));
                quiz.startQuiz();
            } else if (quizType == 2) {
                Quiz2 quiz = new Quiz2("Advanced Java", "A quiz on advanced Java topics with penalty for wrong answers.", 1);
                quiz.addQue(new Question("Which class is the superclass of all classes in Java?",
                        Arrays.asList("Object", "Class", "System", "Runtime"),
                        "Object"));
                quiz.addQue(new Question("Which method must be implemented by all threads in Java?",
                        Arrays.asList("start()", "run()", "stop()", "sleep()"),
                        "run()"));
                quiz.addQue(new Question("Which of the following is used to implement multiple inheritance in Java?",
                        Arrays.asList("Interfaces", "Abstract Classes", "Classes", "Enums"),
                        "Interfaces"));

                quiz.addQue(new Question("Which package contains the `Collection` interface?",
                        Arrays.asList("java.util", "java.io", "java.lang", "java.sql"),
                        "java.util"));

                quiz.addQue(new Question("Which of the following is not a feature of Java?",
                        Arrays.asList("Platform Independence", "Memory Management", "Pointers", "Object-Oriented"),
                        "Pointers"));

                quiz.addQue(new Question("Which method is called by the garbage collector before an object is destroyed?",
                        Arrays.asList("finalize()", "dispose()", "destroy()", "terminate()"),
                        "finalize()"));

                quiz.addQue(new Question("Which type of inheritance is not supported in Java?",
                        Arrays.asList("Multiple Inheritance", "Multilevel Inheritance", "Single Inheritance", "Hierarchical Inheritance"),
                        "Multiple Inheritance"));

                quiz.addQue(new Question("Which Java feature allows a method to have multiple forms?",
                        Arrays.asList("Polymorphism", "Encapsulation", "Abstraction", "Inheritance"),
                        "Polymorphism"));

                quiz.addQue(new Question("What is the use of the `transient` keyword in Java?",
                        Arrays.asList("To prevent serialization", "To create a constant", "To define a static variable", "To mark a method as final"),
                        "To prevent serialization"));

                quiz.addQue(new Question("Which of the following is true about a Java thread?",
                        Arrays.asList("It can be created by extending the `Thread` class or implementing the `Runnable` interface",
                                "It can only be created by implementing the `Runnable` interface",
                                "It always runs in the background",
                                "Threads cannot share resources"),
                        "It can be created by extending the `Thread` class or implementing the `Runnable` interface"));

                quiz.addQue(new Question("Which method is used to suspend the currently executing thread?",
                        Arrays.asList("sleep()", "wait()", "pause()", "stop()"),
                        "sleep()"));

                quiz.addQue(new Question("Which of the following statements is true about Java Generics?",
                        Arrays.asList("Generics allow code reuse and type safety",
                                "Generics are used only for collections",
                                "Generics can only be used with primitive types",
                                "Generics allow unchecked type casting"),
                        "Generics allow code reuse and type safety"));
                quiz.startQuiz();
            } else {
                System.out.println("Invalid quiz type.");
            }
        } else {
            System.out.println("Login failed.");
        }
    }
}
