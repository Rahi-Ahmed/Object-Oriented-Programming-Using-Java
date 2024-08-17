package DoublyLnkdList;

//Node class representing a single element in a doubly linked list
class DoublyNode {
 int data; // Data part of the node
 DoublyNode next; // Reference to the next node
 DoublyNode prev; // Reference to the previous node

 // Constructor to create a new node
 DoublyNode(int data) {
     this.data = data;
     this.next = null;
     this.prev = null;
 }
}

//DoublyLinkedList class containing a sequence of nodes
class DoublyLinkedList {
 DoublyNode head; // Head of the linked list

 // Method to add a new node to the end of the linked list
 void add(int data) {
     DoublyNode newNode = new DoublyNode(data); // Create a new node with the given data
     if (head == null) { // If the list is empty, set the new node as the head
         head = newNode;
     } else { // Otherwise, traverse to the end of the list and add the new node
         DoublyNode temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         temp.next = newNode;
         newNode.prev = temp; // Set the previous reference of the new node
     }
 }

 // Method to print all the nodes in the linked list
 void printList() {
     DoublyNode temp = head; // Start from the head node
     while (temp != null) { // Traverse the list until the end
         System.out.print(temp.data + " "); // Print the data of the current node
         temp = temp.next; // Move to the next node
     }
     System.out.println(); // Print a newline at the end
 }

 // Main method to test the doubly linked list
 public static void main(String[] args) {
     DoublyLinkedList list = new DoublyLinkedList();
     list.add(100); // Add node with data 100
     list.add(200); // Add node with data 200
     list.add(300); // Add node with data 300
     list.printList(); // Print the linked list: Output should be "100 200 300"
 }
}
