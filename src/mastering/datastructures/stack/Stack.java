package mastering.datastructures.stack;

import mastering.datastructures.linkedlist.LinkedList;

public class Stack<T> {
    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T element) {
        list.insert(element, 0);
    }

    public T pop() {
        return list.delete(0);
    }

    public T peek(int index) {
        if (index >= list.size())
            return null;

        var iterator = list.getIterator();
        for (int i = 0; i < index; i++) iterator.next();

        return iterator.getValue();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void display() {
        list.display();
    }
}
