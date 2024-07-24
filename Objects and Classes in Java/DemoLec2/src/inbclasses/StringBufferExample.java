package inbclasses;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        // Appending text to the StringBuffer
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        // Inserting text at a specific position
        sb.insert(5, " Java");
        System.out.println(sb); // Output: Hello Java World

        // Reversing the content of the StringBuffer
        sb.reverse();
        System.out.println(sb); // Output: dlroW avaJ olleH
    }
}
