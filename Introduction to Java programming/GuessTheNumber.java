//Write a Java program to generate a random number 
//between 1 and 100 and ask the user to guess 
//the number until they get it right. 
//The program should contain at least one overload method.
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess;
        boolean hasGuessedCorrectly = false;

        System.out.println("Guess the number between 1 and 100.");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < 1 || guess > 100) {
                System.out.println("Remember, the number is between 1 and 100.");
            } else if (guess < numberToGuess) {
                provideHint("higher");
            } else if (guess > numberToGuess) {
                provideHint("lower");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
            }
        }
        scanner.close();
    }

    // Overloaded method to provide a hint with direction
    public static void provideHint(String direction) {
        System.out.println("Hint: Guess " + direction + "!");
    }

    // Overloaded method to encourage the user
    public static void provideHint() {
        System.out.println("Keep trying!");
    }
}
