package Demo1;

//Animal class representing a generic animal
class Animal {
 private String name;

 // Method to make a generic animal sound
 public void makeSound() {
     System.out.println("The animal makes a sound.");
 }

 // Method to simulate eating
 public void eat() {
     System.out.println("The animal is eating.");
 }

 // Getter for the animal's name
 public String getName() {
     return name;
 }

 // Setter for the animal's name
 public void setName(String name) {
     this.name = name;
 }

 // Static method in the Animal class
 public static void sleep() {
     System.out.println("The animal is sleeping.");
 }
}

//Dog class inheriting from Animal class
class Dog extends Animal {
 // Override method to make a dog-specific sound
 @Override
 public void makeSound() {
     System.out.println("The dog barks.");
 }

 // Method specific to dogs, wagging the tail
 public void wagTail() {
     System.out.println("The dog wags its tail.");
 }

 // Static method in the Dog class, hiding the sleep() method in Animal class
 public static void sleep() {
     System.out.println("The dog is sleeping.");
 }

 // Method specific to dogs, fetching
 public void fetch() {
     System.out.println("The dog is fetching.");
 }
}

//Main class to execute the program
public class Main {
 public static void main(String[] args) {
     // Create an instance of Animal
     Animal animal = new Animal();

     // Call methods on the Animal object
     animal.makeSound();  // Output: The animal makes a sound.
     animal.eat();        // Output: The animal is eating.

     // Create an instance of Dog
     Dog dog = new Dog();

     // Call methods on the Dog object
     dog.makeSound();     // Output: The dog barks.
     dog.eat();           // Output: The animal is eating.
     dog.wagTail();       // Output: The dog wags its tail.

     // Set and retrieve the name of the dog
     dog.setName("Buddy");
     System.out.println("Dog's name: " + dog.getName());  // Output: Dog's name: Buddy

     // Call the static sleep() method in Animal class
     Animal.sleep();  // Output: The animal is sleeping.

     // Create an Animal reference pointing to a Dog object
     Animal animalDog = new Dog();

     // Call the overridden makeSound() method specific to dogs
     animalDog.makeSound();  // Output: The dog barks.

     // Call the static sleep() method in Dog class, hiding the superclass method
     Dog.sleep();  // Output: The dog is sleeping.

     // Call the fetch() method specific to dogs
     dog.fetch();  // Output: The dog is fetching.
 }
}
