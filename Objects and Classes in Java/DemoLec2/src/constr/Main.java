package constr;

class MyClass {
    private String name;
    private int age;

    // Default constructor
    public MyClass() {
        this.name = "John Doe";
        this.age = 30;
    }

    // Parameterized constructor
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}


public class Main {
    public static void main(String[] args) {
        // Creating an object using the default constructor
        MyClass obj1 = new MyClass();
        System.out.println("Default Constructor:");
        obj1.displayInfo();

        // Creating an object using the parameterized constructor
        MyClass obj2 = new MyClass("Alice", 25);
        System.out.println("Parameterized Constructor:");
        obj2.displayInfo();
    }
}
