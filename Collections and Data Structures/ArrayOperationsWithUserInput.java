import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationsWithUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // 2D Array Declaration with User Input
            System.out.print("Enter number of rows for 2D array: ");
            int rows = scanner.nextInt();
            System.out.print("Enter number of columns for 2D array: ");
            int cols = scanner.nextInt();
            int[][] twoDArray = new int[rows][cols];
            System.out.println("Enter elements for 2D array:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    twoDArray[i][j] = scanner.nextInt();
                }
            }
            System.out.println("2D Array: " + Arrays.deepToString(twoDArray));

            // 3D Array Declaration with User Input
            System.out.print("Enter number of 2D arrays for 3D array: ");
            int depth = scanner.nextInt();
            int[][][] threeDArray = new int[depth][rows][cols];
            System.out.println("Enter elements for 3D array:");
            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < rows; j++) {
                    for (int k = 0; k < cols; k++) {
                        threeDArray[i][j][k] = scanner.nextInt();
                    }
                }
            }
            System.out.println("3D Array: " + Arrays.deepToString(threeDArray));

            // Jagged Array Declaration with User Input
            System.out.print("Enter number of rows for jagged array: ");
            int jaggedRows = scanner.nextInt();
            int[][] jaggedArray = new int[jaggedRows][];
            for (int i = 0; i < jaggedRows; i++) {
                System.out.print("Enter number of elements in row " + (i + 1) + ": ");
                int rowLength = scanner.nextInt();
                jaggedArray[i] = new int[rowLength];
                System.out.println("Enter elements for row " + (i + 1) + ":");
                for (int j = 0; j < rowLength; j++) {
                    jaggedArray[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Jagged Array: " + Arrays.deepToString(jaggedArray));

            // Passing Arrays as Parameters
            System.out.println("Enter elements for an array to pass as parameter (comma separated):");
            scanner.nextLine(); // consume newline
            String[] inputArray = scanner.nextLine().split(",");
            int[] arrayToPass = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
            printArray(arrayToPass);

            // Copying Arrays
            int[] copiedArray = Arrays.copyOf(arrayToPass, arrayToPass.length);
            System.out.println("Copied Array: " + Arrays.toString(copiedArray));

            // Methods of Arrays Class
            Arrays.sort(copiedArray);
            System.out.println("Sorted Array: " + Arrays.toString(copiedArray));

            // Searching in array
            System.out.print("Enter element to search for: ");
            int searchElement = scanner.nextInt();
            int index = Arrays.binarySearch(copiedArray, searchElement);
            System.out.println("Element " + searchElement + " found at index: " + index);

            // Class Objects for Arrays
            Class<?> arrayClass = copiedArray.getClass();
            System.out.println("Class of the array: " + arrayClass.getName());
            System.out.println("Is array: " + arrayClass.isArray());

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    // Method to print array
    public static void printArray(int[] array) {
        System.out.println("Array passed as parameter: " + Arrays.toString(array));
    }
}

