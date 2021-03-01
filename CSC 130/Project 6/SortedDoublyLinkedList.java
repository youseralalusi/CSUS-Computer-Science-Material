/**
 * Youser Alalusi
 * CSC 130 - Lab 3
 * 10/5/2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


/*Declaring Node Class with its member variables*/
class Node {

	//Variable to hold name
	String name;

	//Two node class type variables holding next and previous pointers
	Node nextNodePointer, previousNodePointer;

	//Constructor to initialize a Node
	public Node(String name) {
		this.name=name;
	}
}

//Sorted Doubly Linked List class declaration
public class SortedDoublyLinkedList {

	//Main method start
	public static void main(String args[]) {

		//Initializing head with null
		Node head = null;

		try {
			//Creating scanner class object for reading it from a file input.txt
			Scanner scanner=new Scanner(new File("input.txt"));

			//Loop to iterate till the file terminates
			while (scanner.hasNext()) {

				//Read line from a file
				String line=scanner.nextLine();

				//Split a line into array using space
				String[] splittedLine=line.split(" ");

				/*
				 * If value at first index of the array is delete that means second value will
				 * also exist to delete that key value from the doubly linked list
				 */
				if(splittedLine[0].equalsIgnoreCase("delete")) {
					//Calling delete node method to delete that name from doubly linked list
					head=deleteNode(head,splittedLine[1]);
				}
				
				else {
					//Creating node class object
					Node node=new Node(splittedLine[0]);

					//Inserting Node in doubly linked list by passing node object as parameter
					head=insertNodeInLinkedListInSortedWay(head,node);
				}
			}
			//Closing scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		writeLinkedListInFile(head);
	}

	private static Node deleteNode(Node head, String name) {

		//If head is null it means nothing is in linked list and it will return null
		if(head==null) {
			return null;
		}
		else {
			//Assigning head to the new current Node type variable
			Node current=head;

			//Loop until current is null
			while(current!=null) {

				//If the node name is equal to the name to be deleted
				if(current.name.equalsIgnoreCase(name)) {

					/*
					 * If the node to be deleted is first node then assign head to the next of the
					 * node to be deleted
					 */
					if(head==current) {
						head=current.nextNodePointer;
					}

					//Changing next pointer of the node if node to be deleted is not last node
					if(current.nextNodePointer!=null) {
						current.nextNodePointer.previousNodePointer=current.previousNodePointer;
					}

					//Changing previous pointer of the node if node to be deleted is not first node
					if(current.previousNodePointer!=null) {
						current.previousNodePointer.nextNodePointer=current.nextNodePointer;
					}
				}

				//Setting current node to the next of the current node
				current=current.nextNodePointer;
			}
			//returning head node
			return head;
		}
	}

	private static Node insertNodeInLinkedListInSortedWay(Node head, Node newNode) {

		Node current;

		//If inserting node is first node
		if (head == null)
			head = newNode;

		/*
		 * If node to be inserted comes at the beginning that means the inserting node
		 * name is less than head node name
		 */
		else if (head.name.compareTo(newNode.name)>0 || head.name.compareTo(newNode.name)==0) {
			newNode.nextNodePointer = head;
			newNode.nextNodePointer.previousNodePointer = newNode;
			head = newNode;
		}

		//Else
		else{
			current = head;

			//iterate till we find the appropriate position
			while (current.nextNodePointer != null && current.nextNodePointer.name.compareTo(newNode.name)<0)
				current = current.nextNodePointer;

			//Assign newNode next to currentNodeNext
			newNode.nextNodePointer = current.nextNodePointer;

			//If the new node is not at the end of the list
			if (current.nextNodePointer != null)
				newNode.nextNodePointer.previousNodePointer = newNode;

			current.nextNodePointer = newNode;
			newNode.previousNodePointer = current;
		}
		return head;
	}

	private static void writeLinkedListInFile(Node head) {
		try {
			//Creating Print Stream class object to write output to output.txt file
			PrintStream printStream = new PrintStream(new File("output.txt"));

			//Declaring tailNode Node type object
			Node tailNode=null;

			//Iterate over doubly linked list in ascending sorted order
			while (head != null) {
				//printing the name into the file
				printStream.println(head.name);

				/*
				 * If the head reached at last then store and hold the head pointer current
				 * address in tailNode Because after printing names in ascending order then we
				 * have to print in descending order
				 */
				if(head.nextNodePointer==null)
					tailNode=head;  
				//setting next pointer to the head
				head = head.nextNodePointer;
			}
			printStream.println("=============");
			//In the previous traversal we have hold the tailNode value
			//Now printing linked list names in descending order or in reverse order
			while(tailNode!=null){
				printStream.println(tailNode.name);
				tailNode = tailNode.previousNodePointer;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}