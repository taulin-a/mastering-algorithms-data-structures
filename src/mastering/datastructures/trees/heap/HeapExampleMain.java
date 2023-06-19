package mastering.datastructures.trees.heap;

public class HeapExampleMain {
    public static void main(String[] args) {
        var heap = new Heap<>(Integer.class, 90);

        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(5);
        heap.insert(10);
        heap.insert(12);
        heap.insert(6);

        heap.display();

        heap.insert(40);

        System.out.println("------");

        heap.display();

        System.out.println("------");

        var heap2 = new Heap<>(Integer.class, 90, new Integer[]{30, 20, 15, 5, 10, 12, 6, 40});

        heap2.display();

        System.out.println("------");
        heap2.delete();
        heap2.display();

        System.out.println("------");

        var heap3 = new Heap<>(Integer.class, 90, new Integer[]{30, 20, 15, 5, 10, 12, 6, 43, 10, 35});
        var heap4 = new Heap<>(Integer.class, new Integer[]{30, 20, 15, 5, 10, 12, 6, 43, 10, 35});

        System.out.println("Heap create insert: ");
        heap3.display();

        System.out.println("Heap create heapify: ");
        heap4.display();
    }
}
