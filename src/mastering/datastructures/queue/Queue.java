package mastering.datastructures.queue;

import mastering.datastructures.linkedlist.Iterator;
import mastering.datastructures.linkedlist.LinkedList;

public class Queue<T> {
    private final LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T element) {
        list.insertLast(element);
    }

    public T dequeue() {
        return list.delete(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T first() {
        return list.getIterator().getValue();
    }

    public T last() {
        return list.getLast();
    }

    public void display() {
        list.display();
    }

    protected Iterator<T> getIterator() {
        return list.getIterator();
    }
}
