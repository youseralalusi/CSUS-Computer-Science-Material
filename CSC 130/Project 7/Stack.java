public class Stack<T> {



	private Node<T> head;

	private int size;

	public Stack() {

		head=null;

		size=0;

	}

	public int size() {

		return size;

	}

	public void push(T data) {

		Node<T> newNode=new Node<>(data);

		newNode.next=head;

		head=newNode;

		size++;

	}

	public boolean isEmpty() {

		return (size==0);

	}

	public T pop() throws StackEmptyException {

		if(head==null){

			StackEmptyException e=new StackEmptyException();

			throw e;

		}

		Node<T> temp=head;

		head=head.next;

		size--;

		T a=temp.data;

		return a;

	}

	public T top() throws StackEmptyException {

		if(head==null){

			StackEmptyException e=new StackEmptyException();

			throw e;

		}

		T b=head.data;

		return b;

	}

}

class StackEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

}