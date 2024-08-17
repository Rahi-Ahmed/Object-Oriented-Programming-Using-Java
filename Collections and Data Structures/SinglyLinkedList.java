package SinglyLnkdList;

//Node class representing a single element in a singly linked list
class Node {
 int data; // Data part of the node
 Node next; // Reference to the next node

 // Constructor to create a new node
 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//SinglyLinkedList class containing a sequence of nodes
class SinglyLinkedList {
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

 // Method to print all the nodes in the linked list
 void printList() {
     Node temp = head; // Start from the head node
     while (temp != null) { // Traverse the list until the end
         System.out.print(temp.data + " "); // Print the data of the current node
         temp = temp.next; // Move to the next node
     }
     System.out.println(); // Print a newline at the end
 }

 // Main method to test the singly linked list
 public static void main(String[] args) {
     SinglyLinkedList list = new SinglyLinkedList();
     list.add(10); // Add node with data 10
     list.add(20); // Add node with data 20
     list.add(30); // Add node with data 30
     list.printList(); // Print the linked list: Output should be "10 20 30"
 }
}
