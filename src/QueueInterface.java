public interface QueueInterface<T> {
    public boolean enqueue(T newEntry);
    public T getFront();
    public T dequeue();
    public boolean isEmpty();
    public boolean isFull();
}
