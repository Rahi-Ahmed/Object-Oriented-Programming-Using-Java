/*Create a Java class called "Student" with the following attributes:
- Name (String)
- Age (int)
- Grade (char)
- Course (String)
The "Student" class should have the following features:
- Implement a parameterized constructor that accepts values for name, age, grade, and course. 
  Inside the constructor, initialize the respective attributes.
- Implement a default constructor that sets default values for name, age, grade, and course.
- Implement a finalizer method to perform any necessary cleanup operations when an object is no longer in use.
- Define appropriate visibility modifiers for the attributes and methods to ensure encapsulation.
- Implement getter and setter methods for all the attributes.
- Create a method called "displayDetails" that prints the student's name, age, grade, and course.
- Create an object of the inbuilt class "StringBuffer" and append the student's name and course to it.
- Use the inbuilt class "Character" to determine if the student's grade is a passing grade (A, B, C, D) or a failing grade (F).
*/


package LabEx;

public class Student {
    private String name;
    private int age;
    private char grade;
    private String course;

    // Parameterized constructor
    public Student(String name, int age, char grade, String course) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.course = course;
    }

    // Default constructor
    public Student() {
        this.name = "";
        this.age = 0;
        this.grade = '\0';
        this.course = "";
    }

    // Finalizer method
    @Override
    protected void finalize() throws Throwable {
        // Perform cleanup operations here
        System.out.println("Performing cleanup for student: " + name);
        super.finalize();
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter methods for grade
    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // Getter and setter methods for course
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
    }

    public static void main(String[] args) {
        // Create a student object using the parameterized constructor
        Student student = new Student("John Doe", 18, 'A', "Computer Science");

        // Display student details
        student.displayDetails();

        // Create a StringBuffer object and append student name and course
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(student.getName()).append(" - ").append(student.getCourse());
        System.out.println("StringBuffer content: " + stringBuffer.toString());

        // Determine if the student's grade is passing or failing
        if (student.getGrade() == 'A' || student.getGrade() == 'B' || student.getGrade() == 'C'
                || student.getGrade() == 'D') {
            System.out.println("The student has a passing grade.");
        } else if (student.getGrade() == 'F') {
            System.out.println("The student has a failing grade.");
        } else {
            System.out.println("Invalid grade.");
        }
    }
}

