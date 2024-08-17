package iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Class demonstrating the usage of iterators in Java
public class IteratorDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10); // Add 10 to the list
        list.add(20); // Add 20 to the list
        list.add(30); // Add 30 to the list

        // Get an iterator for the list
        Iterator<Integer> iterator = list.iterator();

        // Iterate through the list
        while (iterator.hasNext()) {
            int value = iterator.next(); // Get the next element
            System.out.println(value); // Print the value
        }
    }
}
