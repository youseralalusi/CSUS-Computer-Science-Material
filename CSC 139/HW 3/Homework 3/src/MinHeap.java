
/**
 *
 * @author
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> {

    private T[] data;
    private int capacity;
    private int size;

    /**
     * default constructor
     *
     */
    public MinHeap() {
        size = 0;
        capacity = 10;
        data = (T[]) new Comparable[10];
    }

    /**
     * insert item to heap
     *
     * @param t
     */
    public void insert(T t) {
        if (t == null) {
            return;
        }
        // resize if it is needed
        if (size >= capacity) {
            capacity += 10;
            T[] tmp = (T[]) new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
        // put t to the end of the array
        data[size] = t;
        size++;

        // move it up
        int index = size - 1;
        while (index > 0) {
            int parent;
            if (index % 2 == 0) {
                parent = index / 2 - 1;
            } else {
                parent = index / 2;
            }
            if (data[index].compareTo(data[parent]) < 0) {
                T tmp = data[index];
                data[index] = data[parent];
                data[parent] = tmp;
            } else {
                break;
            }
            index = parent;
        }
    }

    /**
     * remove item from heap
     *
     * @return
     */
    public T remove() {
        // empty case 
        if (isEmpty()) {
            return null;
        }
        // get value
        T val = data[0];
        size--;

        // put the final item into the first celll
        data[0] = data[size];

        /// move it down
        int index = 0;
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            // if this index has left child
            if (left < size) {
                // assume that he left on is a candidate
                int candidate = left;
                // if the right one is also in the array
                if (right < size) {
                    // compare it with left one
                    if (data[right].compareTo(data[left]) < 0) {
                        // make right chid to the canditate 
                        // if the right child is smaller
                        // than the left child
                        candidate = right;
                    }
                }
                // exchangevalue of the index and the candidate 
                if (data[candidate].compareTo(data[index]) < 0) {
                    T tmp = data[candidate];
                    data[candidate] = data[index];
                    data[index] = tmp;

                    // move index forward
                    index = candidate;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return val;
    }

    /**
     *
     * @return true if the heap is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return false
     */
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += data[i].toString() + System.lineSeparator();
        }
        return str;
    }
    
    public T min(){
        return data[0];
    }
}
