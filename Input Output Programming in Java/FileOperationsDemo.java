import java.io.*;
import java.nio.file.*;

public class FileOperationsDemo {

    public static void main(String[] args) {
        // Name of the file to be created and used in various operations
        String fileName = "example.txt";
        
        // Create a new file
        createFile(fileName);
        
        // Write some initial content to the file
        writeFile(fileName, "Hello, World!\nThis is a file operations demo.");
        
        // Append additional content to the existing file
        appendToFile(fileName, "\nAppending some text to the file.");
        
        // Read and display the content of the file
        readFile(fileName);
        
        // Copy the file to a new file
        copyFile(fileName, "example_copy.txt");
        
        // Move the copied file to a new location (or rename it)
        moveFile("example_copy.txt", "example_moved.txt");
        
        // Delete the moved file
        deleteFile("example_moved.txt");
    }

    // Method to create a new file
    public static void createFile(String fileName) {
        try {
            // Create a File object
            File file = new File(fileName);
            
            // Attempt to create the file
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists: " + fileName);
            }
        } catch (IOException e) {
            // Handle any exceptions that occur during file creation
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Method to write content to a file
    public static void writeFile(String fileName, String content) {
        // Try-with-resources statement to ensure the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the content to the file
            writer.write(content);
            System.out.println("Successfully wrote to the file: " + fileName);
        } catch (IOException e) {
            // Handle any exceptions that occur during file writing
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to append content to an existing file
    public static void appendToFile(String fileName, String content) {
        // Try-with-resources statement to ensure the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Append the content to the file
            writer.write(content);
            System.out.println("Successfully appended to the file: " + fileName);
        } catch (IOException e) {
            // Handle any exceptions that occur during file appending
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }

    // Method to read and display the content of a file
    public static void readFile(String fileName) {
        // Try-with-resources statement to ensure the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading file: " + fileName);
            
            // Read and display each line of the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle any exceptions that occur during file reading
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to copy a file to a new location
    public static void copyFile(String sourceFileName, String destFileName) {
        try {
            // Use Files.copy to copy the file
            Files.copy(Paths.get(sourceFileName), Paths.get(destFileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied from " + sourceFileName + " to " + destFileName);
        } catch (IOException e) {
            // Handle any exceptions that occur during file copying
            System.out.println("An error occurred while copying the file.");
            e.printStackTrace();
        }
    }

    // Method to move a file to a new location (or rename it)
    public static void moveFile(String sourceFileName, String destFileName) {
        try {
            // Use Files.move to move the file
            Files.move(Paths.get(sourceFileName), Paths.get(destFileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved from " + sourceFileName + " to " + destFileName);
        } catch (IOException e) {
            // Handle any exceptions that occur during file moving
            System.out.println("An error occurred while moving the file.");
            e.printStackTrace();
        }
    }

    // Method to delete a file
    public static void deleteFile(String fileName) {
        try {
            // Use Files.delete to delete the file
            Files.delete(Paths.get(fileName));
            System.out.println("File deleted: " + fileName);
        } catch (IOException e) {
            // Handle any exceptions that occur during file deletion
            System.out.println("An error occurred while deleting the file.");
            e.printStackTrace();
        }
    }
}
