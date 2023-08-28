package mastering.datastructures.graph;

import mastering.datastructures.linkedlist.LinkedList;
import mastering.datastructures.stack.Stack;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchMain {
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

        depthFirstSearch(nodes, 0, -99);

        System.out.println("------------------");

        depthFirstSearch(nodes, 0, 2);
    }

    private static Integer depthFirstSearch(LinkedList<Integer>[] nodeList, int startingNode, int nodeToBeFound) {
        var searchStack = new Stack<Integer>();
        List<Integer> nodesVisited = new ArrayList<>();

        searchStack.push(startingNode);
        nodesVisited.add(startingNode);
        System.out.println("Node visited: " + startingNode);

        while (!searchStack.isEmpty()) {
            var current = nodeList[searchStack.peek(0)];

            var nonVisitedNode = getNonVisitedNode(current, nodesVisited);

            if (nonVisitedNode == null) {
                searchStack.pop();
                continue;
            }

            System.out.println("Node visited: " + nonVisitedNode);

            if (nonVisitedNode == nodeToBeFound) {
                System.out.println("Node " + nodeToBeFound + " has been found!");
                return nonVisitedNode;
            }

            nodesVisited.add(nonVisitedNode);
            searchStack.push(nonVisitedNode);
        }

        return null;
    }

    public static Integer getNonVisitedNode(LinkedList<Integer> nodes, List<Integer> nodesVisited) {
        if (nodes.isEmpty())
            return null;

        var iterator = nodes.getIterator();
        while (!iterator.currentIsNull()) {
            if (!nodesVisited.contains(iterator.getValue())) {
                return iterator.getValue();
            }

            iterator.next();
        }

        return null;
    }
}
