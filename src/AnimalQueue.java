import java.io.ObjectStreamException;

public class AnimalQueue<T> implements QueueInterface<T> {

    private T[] queue;

    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;

    public AnimalQueue(){
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY + 1];
        queue = tempQueue;
    }


    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
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

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;

            @SuppressWarnings ("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize; index++ ) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }
}
