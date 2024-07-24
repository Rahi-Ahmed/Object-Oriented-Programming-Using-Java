package Demo6_upcast_downcast;

//Superclass
class Animal {
 // Method to be overridden
 public void makeSound() {
     System.out.println("The animal makes a sound");
 }

 // Additional method
 public void sleep() {
     System.out.println("The animal is sleeping");
 }
}

//Subclass Dog
class Dog extends Animal {
 @Override
 public void makeSound() {
     System.out.println("The dog barks");
 }

 public void fetch() {
     System.out.println("The dog is fetching a ball");
 }
}

//Subclass Cat
class Cat extends Animal {
 @Override
 public void makeSound() {
     System.out.println("The cat meows");
 }

 public void climb() {
     System.out.println("The cat is climbing a tree");
 }
}

//Main class to demonstrate upcasting and downcasting
public class Main {
 public static void main(String[] args) {
     // Upcasting: Dog and Cat objects are treated as Animal objects
     Animal myDog = new Dog();
     Animal myCat = new Cat();

     // Calling overridden methods
     myDog.makeSound();  // Output: The dog barks
     myCat.makeSound();  // Output: The cat meows

     // Demonstrating polymorphism with upcasting
     Animal[] animals = {myDog, myCat};
     for (Animal animal : animals) {
         animal.makeSound();
         animal.sleep();
     }

     // Downcasting: Converting Animal references back to Dog and Cat references
     if (myDog instanceof Dog) {
         Dog realDog = (Dog) myDog;
         realDog.fetch();  // Output: The dog is fetching a ball
     }

     if (myCat instanceof Cat) {
         Cat realCat = (Cat) myCat;
         realCat.climb();  // Output: The cat is climbing a tree
     }

     // Demonstrating ClassCastException
     try {
         Dog wrongCast = (Dog) myCat;  // This will throw an exception
     } catch (ClassCastException e) {
         System.out.println("Cannot cast Cat to Dog: " + e.getMessage());
     }
 }
}
