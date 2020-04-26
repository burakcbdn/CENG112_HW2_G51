import java.util.Queue;

public class IQueue<T> implements QueueInterface<T> {

    private T[] queue;

    private int frontIndex;
    private int backIndex;
    private static final int CAPACITY = 10;


    public IQueue(){
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[CAPACITY + 1];
        queue = tempQueue;
    }


    @Override
    public boolean enqueue(T newEntry) {
        if (isFull()) {
            return false;
        }else {
            backIndex = (backIndex + 1) % queue.length;
            queue[backIndex] = newEntry;
            return true;
        }
    }

    @Override
    public boolean isFull() {
        return frontIndex == 0 && backIndex -2 == CAPACITY;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            System.out.println("This queue is empty");
            return null;
        } else {
            return queue[frontIndex];
        }
    }


    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("This queue is empty");
            return null;
        } else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

}
