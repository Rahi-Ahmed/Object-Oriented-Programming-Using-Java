package stack;

import java.util.LinkedList;

//Stack class using LinkedList for the stack implementation
class Stack {
 private LinkedList<Integer> stack = new LinkedList<>();

 // Method to push an element onto the stack
 public void push(int data) {
     stack.addFirst(data);
 }

 // Method to pop an element from the stack
 public int pop() {
     if (stack.isEmpty()) {
         throw new IllegalStateException("Stack is empty");
     }
     return stack.removeFirst();
 }

 // Method to peek the top element of the stack
 public int peek() {
     if (stack.isEmpty()) {
         throw new IllegalStateException("Stack is empty");
     }
     return stack.getFirst();
 }

 // Method to check if the stack is empty
 public boolean isEmpty() {
     return stack.isEmpty();
 }

 // Main method to test the stack
 public static void main(String[] args) {
     Stack stack = new Stack();
     stack.push(10); // Push 10 onto the stack
     stack.push(20); // Push 20 onto the stack
     stack.push(30); // Push 30 onto the stack
     System.out.println(stack.pop()); // Pop from the stack, output should be 30
     System.out.println(stack.peek()); // Peek the top element, output should be 20
     System.out.println(stack.isEmpty()); // Check if the stack is empty, output should be false
 }
}
