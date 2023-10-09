import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStack<E> {
    private final static int DEFAULT_CAPACITY = 50;
    private E[] list;
    private int capacity;
    private int size;


    public GenericStack() {
        list =  (E[]) new Object [DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public GenericStack(int capacity) {
        list =  (E[]) new Object [capacity];
        this.capacity = capacity;
    }
    
    public int getSize() {
        return size;
    }

    public void push(E o) {
        //check size, if full create new arr that is double the size and copy
        if(size == capacity) {
            if(capacity == 0) capacity = 1;
            else capacity *= 2;
            E[] newList = (E[]) new Object[capacity];
            System.arraycopy(list, 0, newList, 0, capacity / 2);
            list = newList;
        }
        list[size] = o;
        size++;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E element = list[size - 1];
        E[] newList = Arrays.copyOf(list, capacity - 1);
        list = newList;
        capacity--;
        size--;
        return element;
    }

    public boolean isEmpty() {
       return size == 0 ? true : false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
