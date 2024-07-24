package inbclasses;

public class StringExample {
    public static void main(String[] args) {
        // Creating string objects using string literals
        String str1 = "Hello";
        String str2 = "World";

        // Concatenating strings using the + operator
        String str3 = str1 + " " + str2;
        System.out.println(str3); // Output: Hello World

        // Getting the length of a string
        int length = str3.length();
        System.out.println("Length: " + length); // Output: Length: 11

        // Accessing characters in a string
        char firstChar = str3.charAt(0);
        char lastChar = str3.charAt(length - 1);
        System.out.println("First character: " + firstChar); // Output: First character: H
        System.out.println("Last character: " + lastChar); // Output: Last character: d

        // Checking if a string contains a specific substring
        boolean containsWorld = str3.contains("World");
        System.out.println("Contains 'World': " + containsWorld); // Output: Contains 'World': true

        // Converting a string to uppercase or lowercase
        String uppercase = str3.toUpperCase();
        String lowercase = str3.toLowerCase();
        System.out.println("Uppercase: " + uppercase); // Output: Uppercase: HELLO WORLD
        System.out.println("Lowercase: " + lowercase); // Output: Lowercase: hello world

        // Splitting a string into an array of substrings
        String[] words = str3.split(" ");
        System.out.println("Words:");
        for (String word : words) {
            System.out.println(word);
        }
        // Output:
        // Words:
        // Hello
        // World

        // Comparing strings
        String str4 = "Hello";
        String str5 = "hello";
        boolean equals = str4.equals(str5);
        boolean equalsIgnoreCase = str4.equalsIgnoreCase(str5);
        System.out.println("Equals: " + equals); // Output: Equals: false
        System.out.println("Equals Ignore Case: " + equalsIgnoreCase); // Output: Equals Ignore Case: true
    }
}
