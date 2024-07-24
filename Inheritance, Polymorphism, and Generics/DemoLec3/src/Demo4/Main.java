package Demo4;

//In Java, static methods cannot be overridden in the traditional sense, 
//but they can be hidden by redefining them in a subclass. Here's an example that 
//demonstrates hiding a static method:


class Parent {
    public static void method1() {
        System.out.println("Parent's static method1");
    }
}

class Child extends Parent {
    public static void method1() {
        System.out.println("Child's static method1");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent.method1(); // Output: Parent's static method1
        Child.method1();  // Output: Child's static method1
        
        // Using a reference of Parent type to call the static method
        Parent obj = new Child();
        obj.method1(); // Output: Parent's static method1
    }
}

//In the above example, we have a Parent class with a static method method1. 
//The Child class extends Parent and redefines method1 with its own implementation. 
//When we call method1 on an object or reference of the Child class, the hidden static method 
//in the Parent class is not invoked; instead, the method in the Child class is called. 
//However, when we use a reference of the Parent type to call the static method on an object of 
//the Child class, the static method in the Parent class is called because static methods are 
//resolved at compile-time based on the reference type, not the actual object type.
