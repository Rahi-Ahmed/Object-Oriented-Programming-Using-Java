package adt;

//Node class representing a single element in an ADT linked list
class Node {
 int data; // Data part of the node
 Node next; // Reference to the next node

 // Constructor to create a new node
 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//ADTLinkedList class containing the operations for a linked list
class ADTLinkedList {
 Node head; // Head of the linked list

 // Method to add a new node to the linked list
 void add(int data) {
     Node newNode = new Node(data); // Create a new node with the given data
     if (head == null) { // If the list is empty, set the new node as the head
         head = newNode;
     } else { // Otherwise, traverse to the end of the list and add the new node
         Node temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         temp.next = newNode;
     }
 }

 // Method to remove a node from the linked list
 void remove(int data) {
     if (head == null) return; // If the list is empty, do nothing

     if (head.data == data) { // If the head node is to be removed
         head = head.next;
         return;
     }

     Node temp = head;
     while (temp.next != null && temp.next.data != data) {
         temp = temp.next;
     }

     if (temp.next != null) {
         temp.next = temp.next.next;
     }
 }

 // Method to search for a node in the linked list
 boolean search(int data) {
     Node temp = head; // Start from the head node
     while (temp != null) { // Traverse the list
         if (temp.data == data) { // If the node is found
             return true;
         }
         temp = temp.next; // Move to the next node
     }
     return false; // Node not found
 }

 // Method to print all the nodes in the linked list
 void printList() {
     Node temp = head; // Start from the head node
     while (temp != null) { // Traverse the list until the end
         System.out.print(temp.data + " "); // Print the data of the current node
         temp = temp.next; // Move to the next node
     }
     System.out.println(); // Print a newline at the end
 }

 // Main method to test the ADT linked list
 public static void main(String[] args) {
     ADTLinkedList list = new ADTLinkedList();
     list.add(10); // Add node with data 10
     list.add(20); // Add node with data 20
     list.add(30); // Add node with data 30
     list.printList(); // Print the linked list: Output should be "10 20 30"
     list.remove(20); // Remove node with data 20
     list.printList(); // Print the linked list: Output should be "10 30"
     System.out.println(list.search(30)); // Search for node with data 30: Output should be true
     System.out.println(list.search(40)); // Search for node with data 40: Output should be false
 }
}
