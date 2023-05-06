package mastering.datastructures.queue;

public class QueueExampleMain {
    public static void main(String[] args) {
        var queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.display();

        System.out.println("Dequeued value: " + queue.dequeue());

        queue.display();

        System.out.println("----CIRCULAR QUEUE----");

        var queue2 = new CircularQueue<Integer>();

        queue2.enqueue(5);
        queue2.enqueue(6);
        queue2.enqueue(7);
        queue2.enqueue(8);
        queue2.enqueue(9);
        queue2.enqueue(10);

        queue2.display();

        System.out.println("Dequeued value: " + queue2.dequeue());

        queue2.display();

        System.out.println("----DOUBLE ENDED QUEUE----");

        var queue3 = new DoubleEndedQueue<Integer>(DoubleEndedQueue.Type.IP_RESTRICTED);

        queue3.enqueueRear(11);
        queue3.enqueueRear(12);
        queue3.enqueueRear(13);
        queue3.enqueueRear(14);

        queue3.display();

        queue3.dequeueFront();

        queue3.display();


        System.out.println("----PRIORITY QUEUE----");

        var queue4 = new PriorityQueue<Integer>();

        queue4.enqueue(1, 0);
        queue4.enqueue(2, 0);
        queue4.enqueue(3, 1);
        queue4.enqueue(4, 1);
        queue4.enqueue(7, 2);
        queue4.enqueue(8, 2);

        queue4.display();

        queue4.dequeue();

        queue4.display();

        System.out.println("----QUEUE WITH 2 STACKS----");

        var queue5 = new Queue2Stacks<Integer>();

        queue5.enqueue(1);
        queue5.enqueue(2);
        queue5.enqueue(3);

        System.out.println("Dequeued value: " + queue5.dequeue());
        System.out.println("Dequeued value: " + queue5.dequeue());
        System.out.println("Dequeued value: " + queue5.dequeue());
    }
}
