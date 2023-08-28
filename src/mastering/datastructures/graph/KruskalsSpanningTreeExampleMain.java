package mastering.datastructures.graph;

import java.util.Arrays;

public class KruskalsSpanningTreeExampleMain {
    public static void main(String[] args) {
        var edgesMatrix = new int[3][9];
        edgesMatrix[0][0] = 0;
        edgesMatrix[1][0] = 1;
        edgesMatrix[2][0] = 25;

        edgesMatrix[0][1] = 0;
        edgesMatrix[1][1] = 5;
        edgesMatrix[2][1] = 5;

        edgesMatrix[0][2] = 1;
        edgesMatrix[1][2] = 2;
        edgesMatrix[2][2] = 12;

        edgesMatrix[0][3] = 1;
        edgesMatrix[1][3] = 6;
        edgesMatrix[2][3] = 10;

        edgesMatrix[0][4] = 2;
        edgesMatrix[1][4] = 3;
        edgesMatrix[2][4] = 8;

        edgesMatrix[0][5] = 3;
        edgesMatrix[1][5] = 4;
        edgesMatrix[2][5] = 16;

        edgesMatrix[0][6] = 3;
        edgesMatrix[1][6] = 6;
        edgesMatrix[2][6] = 14;

        edgesMatrix[0][7] = 4;
        edgesMatrix[1][7] = 5;
        edgesMatrix[2][7] = 20;

        edgesMatrix[0][8] = 4;
        edgesMatrix[1][8] = 6;
        edgesMatrix[2][8] = 18;

        var numOfEdges = 9;
        var numOfNodes = 7;

        var minTree = kruskalsSpanningTree(edgesMatrix, numOfEdges, numOfNodes);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numOfNodes - 1; j++) {
                System.out.print(minTree[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static Integer[][] kruskalsSpanningTree(int[][] edgesMatrix, int numOfEdges, int numOfNodes) {
        var included = new boolean[numOfEdges];
        var tree = new Integer[2][numOfNodes - 1];
        var set = new int[numOfNodes];
        Arrays.fill(set, -1);

        var currTreePos = 0;
        while (currTreePos < numOfNodes - 1) {
            var minEdge = findMinEdge(edgesMatrix, numOfEdges, included);

            if (minEdge == null) break;

            var parent1 = findParent(edgesMatrix[0][minEdge], set);
            var parent2 = findParent(edgesMatrix[1][minEdge], set);

            if (parent1 == parent2) {
                included[minEdge] = true;
                continue;
            }

            tree[0][currTreePos] = edgesMatrix[0][minEdge];
            tree[1][currTreePos] = edgesMatrix[1][minEdge];

            currTreePos++;

            included[minEdge] = true;

            unionSubset(parent1, parent2, set);
        }

        return tree;
    }

    private static Integer findMinEdge(int[][] edgesMatrix, int numOfEdges, boolean[] included) {
        Integer min = null;

        for (int i = 0; i < numOfEdges; i++) {
            if (included[i]) continue;

            if (min == null || edgesMatrix[2][i] < edgesMatrix[2][min])
                min = i;
        }

        return min;
    }

    public static void unionSubset(int firstNode, int secondNode, int[] set) {
        if (set[firstNode] < set[secondNode]) {
            set[firstNode] = set[firstNode] + set[secondNode];
            set[secondNode] = firstNode;
        } else {
            set[secondNode] = set[firstNode] + set[secondNode];
            set[firstNode] = secondNode;
        }
    }

    public static int findParent(int currentNode, int[] set) {
        int parent = currentNode;
        while (set[parent] > 0) {
            parent = set[parent];
        }

        return parent;
    }
}
