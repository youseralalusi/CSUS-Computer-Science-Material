
/**
 *
 * @author
 * @param <T>
 */
public class MyPriorityQueue<T extends Comparable<T>> {

    private MinHeap<T> heap;

    /**
     * default constructor
     *
     *
     */
    public MyPriorityQueue() {
        heap = new MinHeap<>();
    }

    public void enqueue(T task) {
        heap.insert(task);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T dequeue() {
        return heap.remove();
    }
    
    public T front(){
        return heap.min();
    }

}
