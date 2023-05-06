package mastering.datastructures.queue;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue<T> {
    List<Queue<T>> queueList;

    public PriorityQueue() {
        queueList = new LinkedList<>();
    }

    public void enqueue(T element, int priority) {
        if (priority > queueList.size() + 1)
            throw new UnsupportedOperationException();

        if (queueList.isEmpty() || queueList.size() <= priority) {
            Queue<T> newQueue = new Queue<>();
            newQueue.enqueue(element);

            queueList.add(newQueue);
        } else {
            queueList.get(priority).enqueue(element);
        }
    }

    public T dequeue() {
        for (Queue<T> q : queueList) {
            if (!q.isEmpty())
                return q.dequeue();
        }

        return null;
    }

    public void display() {
        if (queueList.isEmpty()) {
            System.out.println("[empty]");
            return;
        }

        System.out.print("[ ");
        for (Queue<T> q : queueList) {
            if (q.isEmpty())
                continue;

            var iterator = q.getIterator();
            do {
                System.out.print(iterator.getValue() + (
                        !iterator.hasNext() && queueList.indexOf(q) == (queueList.size() - 1) ? "" : ", "));
                iterator.next();
            } while (!iterator.currentIsNull());
        }
        System.out.print("]\n");
    }
}
