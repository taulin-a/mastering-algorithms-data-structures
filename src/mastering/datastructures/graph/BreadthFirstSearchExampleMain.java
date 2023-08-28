package mastering.datastructures.graph;

import mastering.datastructures.linkedlist.LinkedList;
import mastering.datastructures.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchExampleMain {
    public static void main(String[] args) {
        LinkedList<Integer>[] nodes = new LinkedList[7];
        nodes[0] = new LinkedList<>();
        nodes[0].append(3);
        nodes[0].append(2);
        nodes[0].append(1);

        nodes[1] = new LinkedList<>();
        nodes[1].append(0);
        nodes[1].append(2);

        nodes[2] = new LinkedList<>();
        nodes[2].append(1);
        nodes[2].append(0);
        nodes[2].append(3);

        nodes[3] = new LinkedList<>();
        nodes[3].append(4);
        nodes[3].append(2);

        nodes[4] = new LinkedList<>();
        nodes[4].append(5);
        nodes[4].append(6);

        nodes[5] = new LinkedList<>();

        nodes[6] = new LinkedList<>();

        breadthFirstSearch(nodes, 0, -99);

        System.out.println("------------------");

        breadthFirstSearch(nodes, 0, 5);
    }

    private static Integer breadthFirstSearch(LinkedList<Integer>[] nodeList, int startingNode, int nodeToBeFound) {
        var searchQueue = new Queue<Integer>();
        List<Integer> nodesVisited = new ArrayList<>();

        searchQueue.enqueue(startingNode);
        nodesVisited.add(startingNode);
        System.out.println("Node visited: " + startingNode);

        while (!searchQueue.isEmpty()) {
            var current = searchQueue.dequeue();

            if (nodeList[current] == null || nodeList[current].isEmpty())
                continue;

            var iterator = nodeList[current].getIterator();
            while (!iterator.currentIsNull()) {
                if (!nodesVisited.contains(iterator.getValue())) {
                    System.out.println("Node visited: " + iterator.getValue());

                    if (iterator.getValue() == nodeToBeFound) {
                        System.out.println("Node " + nodeToBeFound + " has been found!");
                        return iterator.getValue();
                    }

                    nodesVisited.add(iterator.getValue());
                    searchQueue.enqueue(iterator.getValue());
                }

                iterator.next();
            }
        }

        return null;
    }
}
