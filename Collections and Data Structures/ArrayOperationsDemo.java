import java.util.Arrays;

public class ArrayOperationsDemo {
    public static void main(String[] args) {
        try {
            // 2D Array Declaration
            int[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            System.out.println("2D Array: " + Arrays.deepToString(twoDArray));

            // 3D Array Declaration
            int[][][] threeDArray = {
                {
                    {1, 2}, {3, 4}
                },
                {
                    {5, 6}, {7, 8}
                }
            };
            System.out.println("3D Array: " + Arrays.deepToString(threeDArray));

            // Jagged Array Declaration
            int[][] jaggedArray = new int[3][];
            jaggedArray[0] = new int[]{1, 2, 3};
            jaggedArray[1] = new int[]{4, 5};
            jaggedArray[2] = new int[]{6, 7, 8, 9};
            System.out.println("Jagged Array: " + Arrays.deepToString(jaggedArray));

            // Passing Arrays as Parameters
            int[] arrayToPass = {10, 20, 30, 40, 50};
            printArray(arrayToPass);

            // Copying Arrays
            int[] copiedArray = Arrays.copyOf(arrayToPass, arrayToPass.length);
            System.out.println("Copied Array: " + Arrays.toString(copiedArray));

            // Methods of Arrays Class
            Arrays.sort(copiedArray);
            System.out.println("Sorted Array: " + Arrays.toString(copiedArray));

            // Searching in array
            int index = Arrays.binarySearch(copiedArray, 30);
            System.out.println("Element 30 found at index: " + index);

            // Class Objects for Arrays
            Class<?> arrayClass = copiedArray.getClass();
            System.out.println("Class of the array: " + arrayClass.getName());
            System.out.println("Is array: " + arrayClass.isArray());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to print array
    public static void printArray(int[] array) {
        System.out.println("Array passed as parameter: " + Arrays.toString(array));
    }
}
