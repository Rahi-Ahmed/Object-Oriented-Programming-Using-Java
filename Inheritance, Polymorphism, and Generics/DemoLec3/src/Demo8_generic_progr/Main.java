package Demo8_generic_progr;

//Generic class Box
class Box<T> {
 private T content;

 public void setContent(T content) {
     this.content = content;
 }

 public T getContent() {
     return content;
 }

 public void displayContent() {
     System.out.println("Content: " + content);
 }
}

//Utility class with a generic method
class ArrayUtils {
 public static <T> void swap(T[] array, int index1, int index2) {
     T temp = array[index1];
     array[index1] = array[index2];
     array[index2] = temp;
 }
}

//Main class to demonstrate generics
public class Main {
 public static void main(String[] args) {
     // Using the generic Box class
     Box<Integer> integerBox = new Box<>();
     integerBox.setContent(123);
     integerBox.displayContent();  // Output: Content: 123

     Box<String> stringBox = new Box<>();
     stringBox.setContent("Hello, Generics!");
     stringBox.displayContent();  // Output: Content: Hello, Generics!

     // Using the generic swap method
     Integer[] intArray = {1, 2, 3, 4, 5};
     System.out.println("Array before swap: " + java.util.Arrays.toString(intArray));
     ArrayUtils.swap(intArray, 1, 3);
     System.out.println("Array after swap: " + java.util.Arrays.toString(intArray));
     // Output: Array before swap: [1, 2, 3, 4, 5]
     // Output: Array after swap: [1, 4, 3, 2, 5]

     String[] strArray = {"A", "B", "C", "D"};
     System.out.println("Array before swap: " + java.util.Arrays.toString(strArray));
     ArrayUtils.swap(strArray, 0, 2);
     System.out.println("Array after swap: " + java.util.Arrays.toString(strArray));
     // Output: Array before swap: [A, B, C, D]
     // Output: Array after swap: [C, B, A, D]
 }
}
