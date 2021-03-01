/**
 * Youser Alalusi
 * AVL Lab
 * 12/14/2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//class to represent the AVL tree node
class Node
{
	int key, height;
	Node left, right;

	Node(int d)
	{
		key = d;
		height = 1;
	}
}


//public class to represent an AVLTree
public class Tree {

	Node root;
	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}
	//Method to find minimum of two numbers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
	//Method to perform right rotation
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		//Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		//Return new root
		return x;
	}
	//Method for left rotation
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		//Perform rotation
		y.left = x;
		x.right = T2;

		//Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		//Return new root
		return y;
	}

	//returns balance factor of a node
	int getBalance(Node N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	Node insert(Node node, int key) {

		if (node == null)
			return (new Node(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		node.height = 1 + max(height(node.left),height(node.right));
		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key)
			return rightRotate(node);
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	//method to print the level order of tree
	void printLevelOrder()
	{

		int h = root.height;
		int i;
		//print all levels of tree
		for (i=1; i<=h; i++)
		{
			printLevel(root, i);
			System.out.println();
		}
	}

	//method print a level
	void printLevel (Node root ,int level)
	{
		if (root == null)
			return;
		if (level == 1)
			System.out.print("( "+root.key + " , "+root.height+", "+getBalance(root)+")");
		else if (level > 1)
		{
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	//main method
	public static void main(String[] args) throws FileNotFoundException {

		//declare a empty tree
		Tree tree = new Tree();
		//read a input file and insert all the values in AVL tree root
		Scanner scanner = new Scanner(new File("C:\\Users\\Youser Alalusi\\Desktop\\Main\\src\\main\\input.txt"));
		while(scanner.hasNextInt())
		{
			int x = scanner.nextInt();
			//insert x into AVL tree
			tree.root = tree.insert(tree.root, x);
		}

		//Print the level order of tree
		tree.printLevelOrder();

	}
}