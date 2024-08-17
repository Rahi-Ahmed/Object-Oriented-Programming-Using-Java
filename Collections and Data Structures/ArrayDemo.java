import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Initialize arrays
        int[] intArray = {5, 3, 8, 1, 2};
        String[] stringArray = {"Apple", "Orange", "Banana", "Pear"};

        // Print original arrays
        System.out.println("Original integer array: " + Arrays.toString(intArray));
        System.out.println("Original string array: " + Arrays.toString(stringArray));

        // Traversal
        System.out.println("\nTraversing integer array:");
        for (int i : intArray) {
            System.out.print(i + " ");
        }

        System.out.println("\nTraversing string array:");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }

        // Update an element
        intArray[2] = 10;
        stringArray[1] = "Mango";

        System.out.println("\n\nUpdated integer array: " + Arrays.toString(intArray));
        System.out.println("Updated string array: " + Arrays.toString(stringArray));

        // Search for an element
        int searchInt = 10;
        String searchString = "Mango";
        System.out.println("\nSearching for " + searchInt + " in integer array: " + linearSearch(intArray, searchInt));
        System.out.println("Searching for \"" + searchString + "\" in string array: " + linearSearch(stringArray, searchString));

        // Sorting arrays
        Arrays.sort(intArray);
        Arrays.sort(stringArray);

        System.out.println("\nSorted integer array: " + Arrays.toString(intArray));
        System.out.println("Sorted string array: " + Arrays.toString(stringArray));
    }

    // Linear search for integer array
    public static boolean linearSearch(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // Linear search for string array
    public static boolean linearSearch(String[] array, String value) {
        for (String s : array) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
