/**
 * Youser Alalusi
 * 11/13/2020
 * CSC130 - DeleteTree
 */
import java.io.*;
import java.util.*;

class BST{

	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	static Node root;
	static FileWriter writer;
	//function to check if key is present in tree
	static Node search(Node root, int key) {
		if (root==null || root.data==key)
			return root;
		if (root.data > key)
			return search(root.left, key);
		return search(root.right, key);
	}
	//function to insert val into tree
	static void insert(int val){
		root = insertUtil(root,val);
	}
	//helper function to insert new Node
	static Node insertUtil(Node root, int key) {
		//check if tree is empty
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.data)
			root.left = insertUtil(root.left, key);
		else if (key > root.data)
			root.right = insertUtil(root.right, key);
		return root;
	}
	//function to delete node
	static void delete(int val) {
		//if val not present then insert into tree
		if(search(root,val)==null){
			insert(val);
			return;
		}
		root = deleteUtil(root, val);
	}
	//helper function to delete node
	static Node deleteUtil(Node root, int key) {
		//check if tree is empty
		if (root == null) return root;
		if (key < root.data)
			root.left = deleteUtil(root.left, key);
		else if (key > root.data)
			root.right = deleteUtil(root.right, key);
		else
		{
			//1 or 0 child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			//2 children
			root.data = min(root.right);
			root.right = deleteUtil(root.right, root.data);
		}

		return root;
	}

	static int min(Node root)
	{
		int min = root.data;
		while (root.left != null)
		{
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	//function to output inorder traversal to output.txt
	static void inorder(Node root)throws IOException{
		if(root==null) return;
		inorder(root.left);
		writer.write(root.data+" ");
		inorder(root.right);
	}
	//function to output inorder traversal to output.txt
	static void postorder(Node root)throws IOException{
		if(root==null) return;
		postorder(root.left);
		postorder(root.right);
		writer.write(root.data+" ");
	}
	//function to output preorder traversal to output.txt
	static void preorder(Node root)throws IOException{
		if(root==null) return;
		writer.write(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	////function to output level order traversal to output.txt
	static void levelOrder(Node root)throws IOException{
		Queue<Node> q = new LinkedList<Node>(); //queue to traverse tree level wise
		q.add(root);
		while(!q.isEmpty()){
			int n = q.size();
			for(int i=0;i<n;i++){
				Node temp = q.poll();
				writer.write(temp.data+" ");
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
			writer.write("\n");
		}
	}

	public static void main(String args[])throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()){
			String line = in.nextLine();
			if(line.length()==1){
				insert(Integer.valueOf(line));
			} else {
				int val = Integer.valueOf(line.split(" ")[1]);
				delete(val);
			}
		}
		File file = new File("output.txt");
		// String data = "Hi";
		try {
			writer = new FileWriter(file);
			writer.write("Inorder Traversal\n");
			inorder(root);
			writer.write("\nPostOrder traversal\n");
			postorder(root);
			writer.write("\nPreOrder traversal\n");
			preorder(root);
			writer.write("\nLevel Order traversal\n");
			levelOrder(root);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//close resources
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}