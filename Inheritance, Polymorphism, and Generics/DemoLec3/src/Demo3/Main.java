package Demo3;

class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }

    protected void eat() {
        System.out.println("Animal is eating");
    }

    private void sleep() {
        System.out.println("Animal is sleeping");
    }

    final void run() {
        System.out.println("Animal is running");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat is meowing");
    }

    // Trying to override eat() with a different return type will result in a compilation error
    // public boolean eat() { ... } // Compilation error: 'eat()' in 'Cat' clashes with 'eat()' in 'Animal'

    // Trying to override sleep() with a different access modifier will result in a compilation error
    // protected void sleep() { ... } // Compilation error: 'sleep()' in 'Cat' clashes with 'sleep()' in 'Animal'

    // Trying to override run() of the parent class marked as final will result in a compilation error
    // public void run() { ... } // Compilation error: cannot override 'run()' in 'Animal'; overridden method is final
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();

        animal.makeSound(); // Output: Animal is making a sound
        animal.eat(); // Output: Animal is eating
        // animal.sleep(); // Error: 'sleep()' has private access in 'Animal'
        animal.run(); // Output: Animal is running

        cat.makeSound(); // Output: Cat is meowing
        cat.eat(); // Output: Animal is eating (Inherited from superclass)
        // cat.sleep(); // Error: 'sleep()' has private access in 'Animal'
        cat.run(); // Output: Animal is running (Inherited from superclass)
    }
}
