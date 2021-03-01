public class Queue<T> {



	private Node<T> front;

	private Node<T> rear;

	private int size;

	public Queue() {

		front=null;

		rear=null;

		size=0;

	}

	public void enqueue(T data) {

		Node<T> newNode=new Node<T>(data);

		size++;

		if(front==null && rear==null){

			front=newNode;

			rear=newNode;

			return;



		}

		rear.next=newNode;

		rear=newNode;

		return;

	}

	public int size() {

		return size;

	}

	public boolean isEmpty() {

		return (size==0);

	}

	public T dequeue() throws QueueEmptyException {

		if(size==0){

			throw new QueueEmptyException();

		}

		size--;

		T temp=front.data;

		if(front.next==null){

			rear=null;

		}

		front=front.next;

		return temp;

	}

	public T front() throws QueueEmptyException {

		if(size==0){

			throw new QueueEmptyException();

		}

		T temp=front.data;

		return temp;

	}

}

class QueueEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

}