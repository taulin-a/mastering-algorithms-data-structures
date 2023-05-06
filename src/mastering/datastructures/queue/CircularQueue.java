package mastering.datastructures.queue;

import mastering.datastructures.linkedlist.CircularLinkedList;

public class CircularQueue<T> {
    private final CircularLinkedList<T> list;

    public CircularQueue() {
        list = new CircularLinkedList<>();
    }

    public void enqueue(T element) {
        list.append(element);
    }

    public T dequeue() {
        return list.delete(0);
    }

    public void display() {
        list.display();
    }
}
