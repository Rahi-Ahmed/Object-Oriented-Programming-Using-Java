package queue;

import java.util.LinkedList;

//Queue class using LinkedList for the queue implementation
class Queue {
 private LinkedList<Integer> queue = new LinkedList<>();

 // Method to add an element to the queue
 public void enqueue(int data) {
     queue.addLast(data);
 }

 // Method to remove an element from the queue
 public int dequeue() {
     if (queue.isEmpty()) {
         throw new IllegalStateException("Queue is empty");
     }
     return queue.removeFirst();
 }

 // Method to check if the queue is empty
 public boolean isEmpty() {
     return queue.isEmpty();
 }

 // Main method to test the queue
 public static void main(String[] args) {
     Queue queue = new Queue();
     queue.enqueue(10); // Enqueue 10
     queue.enqueue(20); // Enqueue 20
     queue.enqueue(30); // Enqueue 30
     System.out.println(queue.dequeue()); // Dequeue, output should be 10
     System.out.println(queue.isEmpty()); // Check if the queue is empty, output should be false
 }
}
