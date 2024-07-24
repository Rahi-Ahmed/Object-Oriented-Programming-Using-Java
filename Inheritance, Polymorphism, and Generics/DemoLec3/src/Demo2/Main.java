package Demo2;

//Superclass: Animal
class Animal {
 private String name;

 // Constructor
 public Animal(String name) {
     this.name = name;
 }

 // Getter and Setter methods for name
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 // Method to make the animal sleep
 public void sleep() {
     System.out.println(name + " is sleeping.");
 }
}

//Subclass: Cat
class Cat extends Animal {
 private String breed;

 // Constructor
 public Cat(String name, String breed) {
     super(name); // Calling the superclass constructor
     this.breed = breed;
 }

 // Getter and Setter methods for breed
 public String getBreed() {
     return breed;
 }

 public void setBreed(String breed) {
     this.breed = breed;
 }

 // Method to make the cat sleep
 // This method overrides the sleep() method in the superclass
 @Override
 public void sleep() {
     System.out.println(getName() + " the " + breed + " is sleeping.");
 }

 // Additional method exclusive to the Cat class
 public void meow() {
     System.out.println(getName() + " the " + breed + " is meowing.");
 }
}

public class Main {
 public static void main(String[] args) {
     // Creating an instance of the Cat class
     Cat cat = new Cat("Tom", "Persian");

     // Accessing superclass member via getter method
     System.out.println("Name: " + cat.getName());

     // Accessing subclass member
     System.out.println("Breed: " + cat.getBreed());

     // Calling overridden method in the subclass
     cat.sleep();

     // Calling method exclusive to the Cat class
     cat.meow();
 }
}
