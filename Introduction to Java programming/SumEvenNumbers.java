//a Java program that calculates the sum of all even 
//numbers between 1 and 100. 

public class SumEvenNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) { // Check if the number is even
                sum += i; // Add even number to sum
            }
        }
        System.out.println("The sum of all even numbers between 1 and 100 is: " + sum);
    }
}

