package Demo5;

//Superclass
class Animal {
 // Field
 String sound;

 // Constructor
 public Animal(String sound) {
     this.sound = sound;
 }

 // Method to be overridden
 public void makeSound() {
     System.out.println("The animal makes a sound: " + sound);
 }

 // Another method
 public void sleep() {
     System.out.println("The animal is sleeping");
 }
}

//Subclass
class Dog extends Animal {

 // Constructor
 public Dog(String sound) {
     // Use super to call the superclass constructor
     super(sound);
 }

 // Overriding the makeSound() method
 @Override
 public void makeSound() {
     // Use super to call the superclass method
     super.makeSound();
     System.out.println("The dog barks: " + sound);
 }

 // Additional method
 public void showSuperSleep() {
     // Use super to call another method in superclass
     super.sleep();
 }
}

//Main class to test the method overriding and super keyword usage
public class Main {
 public static void main(String[] args) {
     // Create a Dog object
     Dog myDog = new Dog("Woof");
     myDog.makeSound();  // Output: The animal makes a sound: Woof
                         //          The dog barks: Woof

     // Demonstrating the use of super to call a superclass method
     myDog.showSuperSleep();  // Output: The animal is sleeping
 }
}
