//Queue Interface

public interface QueueInterface<T> {

    //adding new entry to queue
    public boolean enqueue(T newEntry);

    //returns first entry of the queue
    public T getFront();

    //removes first entry from queue
    public T dequeue();

    //checks if the queue is empty or not
    public boolean isEmpty();

    //checks if the queue is full or not
    public boolean isFull();
}
