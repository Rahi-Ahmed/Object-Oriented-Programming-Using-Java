import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayOperationsWithUserInputRetry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // 2D Array Declaration with User Input
            int[][] twoDArray = getTwoDArrayInput(scanner);

            // 3D Array Declaration with User Input
            int[][][] threeDArray = getThreeDArrayInput(scanner);

            // Jagged Array Declaration with User Input
            int[][] jaggedArray = getJaggedArrayInput(scanner);

            // Passing Arrays as Parameters
            int[] arrayToPass = getArrayInput(scanner);
            printArray(arrayToPass);

            // Copying Arrays
            int[] copiedArray = Arrays.copyOf(arrayToPass, arrayToPass.length);
            System.out.println("Copied Array: " + Arrays.toString(copiedArray));

            // Methods of Arrays Class
            Arrays.sort(copiedArray);
            System.out.println("Sorted Array: " + Arrays.toString(copiedArray));

            // Searching in array
            int searchElement = getIntInput(scanner, "Enter element to search for: ");
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

    private static int[][] getTwoDArrayInput(Scanner scanner) {
        int rows, cols;
        while (true) {
            try {
                rows = getIntInput(scanner, "Enter number of rows for 2D array: ");
                cols = getIntInput(scanner, "Enter number of columns for 2D array: ");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.nextLine(); // clear the buffer
            }
        }

        int[][] array = new int[rows][cols];
        System.out.println("Enter elements for 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = getIntInput(scanner, "Element [" + i + "][" + j + "]: ");
            }
        }
        System.out.println("2D Array: " + Arrays.deepToString(array));
        return array;
    }

    private static int[][][] getThreeDArrayInput(Scanner scanner) {
        int depth, rows, cols;
        while (true) {
            try {
                depth = getIntInput(scanner, "Enter number of 2D arrays for 3D array: ");
                rows = getIntInput(scanner, "Enter number of rows for 3D array: ");
                cols = getIntInput(scanner, "Enter number of columns for 3D array: ");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.nextLine(); // clear the buffer
            }
        }

        int[][][] array = new int[depth][rows][cols];
        System.out.println("Enter elements for 3D array:");
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    array[i][j][k] = getIntInput(scanner, "Element [" + i + "][" + j + "][" + k + "]: ");
                }
            }
        }
        System.out.println("3D Array: " + Arrays.deepToString(array));
        return array;
    }

    private static int[][] getJaggedArrayInput(Scanner scanner) {
        int rows;
        while (true) {
            try {
                rows = getIntInput(scanner, "Enter number of rows for jagged array: ");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.nextLine(); // clear the buffer
            }
        }

        int[][] array = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int rowLength;
            while (true) {
                try {
                    rowLength = getIntInput(scanner, "Enter number of elements in row " + (i + 1) + ": ");
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    scanner.nextLine(); // clear the buffer
                }
            }
            array[i] = new int[rowLength];
            System.out.println("Enter elements for row " + (i + 1) + ":");
            for (int j = 0; j < rowLength; j++) {
                array[i][j] = getIntInput(scanner, "Element [" + i + "][" + j + "]: ");
            }
        }
        System.out.println("Jagged Array: " + Arrays.deepToString(array));
        return array;
    }

    private static int[] getArrayInput(Scanner scanner) {
        System.out.println("Enter elements for an array to pass as parameter (comma separated):");
        int[] array;
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] inputArray = input.split(",");
                array = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter comma separated integers.");
            }
        }
        return array;
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            try {
                System.out.print(prompt);
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear the buffer
            }
        }
        return number;
    }

    // Method to print array
    public static void printArray(int[] array) {
        System.out.println("Array passed as parameter: " + Arrays.toString(array));
    }
}
