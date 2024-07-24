package inbclasses;

public class CharacterExample {
    public static void main(String[] args) {
        char ch = 'A';

        // Checking if the character is a letter
        System.out.println("Is letter? " + Character.isLetter(ch));

        // Converting to lowercase
        char lowercase = Character.toLowerCase(ch);
        System.out.println("Lowercase: " + lowercase);

        // Checking if the character is a digit
        char digit = '7';
        System.out.println("Is digit? " + Character.isDigit(digit));

        // Checking if the character is whitespace
        char space = ' ';
        System.out.println("Is whitespace? " + Character.isWhitespace(space));

        // Converting a character to its Unicode code point
        int codePoint = Character.codePointAt(Character.toString(ch), 0);
        System.out.println("Code Point: " + codePoint);
    }
}
