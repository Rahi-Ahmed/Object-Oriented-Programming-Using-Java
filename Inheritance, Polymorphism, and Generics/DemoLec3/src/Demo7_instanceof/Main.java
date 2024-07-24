package Demo7_instanceof;

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

//Main class to demonstrate the use of instanceof operator
public class Main {
 public static void main(String[] args) {
     // Create instances of Dog and Cat
     Animal myDog = new Dog();
     Animal myCat = new Cat();
     
     // Demonstrating the use of instanceof operator
     checkAnimalType(myDog); // Output: This is a dog
                             //         The dog barks
                             //         The dog is fetching a ball

     checkAnimalType(myCat); // Output: This is a cat
                             //         The cat meows
                             //         The cat is climbing a tree
 }

 // Method to check the type of Animal and perform type-specific actions
 public static void checkAnimalType(Animal animal) {
     if (animal instanceof Dog) {
         Dog dog = (Dog) animal;
         System.out.println("This is a dog");
         dog.makeSound();
         dog.fetch();
     } else if (animal instanceof Cat) {
         Cat cat = (Cat) animal;
         System.out.println("This is a cat");
         cat.makeSound();
         cat.climb();
     } else {
         System.out.println("This is some other kind of animal");
         animal.makeSound();
     }
 }
}
