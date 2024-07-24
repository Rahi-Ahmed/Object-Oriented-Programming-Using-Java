package inbclasses;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        // Create a File object representing a file or directory
        File file = new File("path/to/file.txt");
        
		/*
		 * For example, if the file "file.txt" is located in the directory
		 * "C:\Documents\Files", the file path would be "C:\Documents\Files\file.txt".
		 * Similarly, on a Unix-based system, the file path might be
		 * "/home/user/Documents/file.txt".
		 */
        

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists");
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("File size (in bytes): " + file.length());
            System.out.println("Is directory? " + file.isDirectory());
        } else {
            System.out.println("File does not exist");
        }
    }
}
