package mastering.datastructures.queue;

import mastering.datastructures.linkedlist.LinkedList;

public class DoubleEndedQueue<T> {
    public enum Type {
        IP_RESTRICTED, OP_RESTRICTED
    }

    private final LinkedList<T> list;
    private final Type type;

    public DoubleEndedQueue(Type type) {
        list = new LinkedList<>();
        this.type = type;
    }

    public void enqueueFront(T element) {
        if (type == Type.IP_RESTRICTED)
            throw new UnsupportedOperationException();

        list.insert(element, 0);
    }

    public T dequeueFront() {
        return list.delete(0);
    }

    public void enqueueRear(T element) {
        list.insertLast(element);
    }

    public T dequeueRear() {
        if (type == Type.OP_RESTRICTED)
            throw new UnsupportedOperationException();

        return list.delete(list.size() - 1);
    }

    public void display() {
        list.display();
    }
}
