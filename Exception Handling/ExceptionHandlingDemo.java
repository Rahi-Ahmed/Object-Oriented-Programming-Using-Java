import java.io.*;

// Custom Exception
//The constructor takes a String argument message which 
//represents the error message.
//super(message); calls the constructor of 
//the superclass (Exception) 
//and passes the error message to it. 
//This way, when the CustomException is thrown, 
//it can carry the error message, which can be 
//retrieved using the getMessage() 
//method inherited from the Throwable class.
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionHandlingDemo {

    // Method to demonstrate checked exception
    public static void readFile() throws IOException {
        FileReader file = new FileReader("non_existent_file.txt");
        BufferedReader fileInput = new BufferedReader(file);

        // Throw IOException if the file does not exist
        throw new IOException("File not found");
    }

    // Method to demonstrate unchecked exception
    public static void divideByZero() {
        int a = 10, b = 0;
        int result = a / b; // This will throw ArithmeticException
    }

    // Method to demonstrate custom exception
    public static void checkAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age less than 18 is not allowed");
        } else {
            System.out.println("Age is valid");
        }
    }

    public static void main(String[] args) {
        // Checked Exception Handling
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        // Unchecked Exception Handling
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // Custom Exception Handling
        try {
            checkAge(16);
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }

        // Finally block demonstration
        try {
            System.out.println("Inside try block");
            throw new Exception("Test Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        // Try-with-resources demonstration
        try (FileReader fr = new FileReader("example.txt");
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
