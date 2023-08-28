package mastering.datastructures.graph;

public class PrimsSpanningTreeExampleMain {
    private static final int ALREADY_INLCUDED = -99999;

    public static void main(String[] args) {
        var nodesMatrix = new Integer[7][7];
        nodesMatrix[0][5] = 5;
        nodesMatrix[0][1] = 25;

        nodesMatrix[1][0] = 25;
        nodesMatrix[1][2] = 12;
        nodesMatrix[1][6] = 10;

        nodesMatrix[2][1] = 12;
        nodesMatrix[2][3] = 8;

        nodesMatrix[3][2] = 8;
        nodesMatrix[3][4] = 16;
        nodesMatrix[3][6] = 14;

        nodesMatrix[4][3] = 16;
        nodesMatrix[4][5] = 20;
        nodesMatrix[4][6] = 18;

        nodesMatrix[5][0] = 5;
        nodesMatrix[5][4] = 20;

        nodesMatrix[6][1] = 10;
        nodesMatrix[6][3] = 14;
        nodesMatrix[6][4] = 18;

        var minTree = primsSpanningTree(nodesMatrix);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nodesMatrix.length - 1; j++) {
                System.out.print(minTree[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static Integer[][] primsSpanningTree(Integer[][] nodesMatrix) {
        var near = new Integer[nodesMatrix.length];
        var tree = new Integer[2][nodesMatrix.length - 1];

        var minEdge = findMinEdge(nodesMatrix);

        // Add minimum cost edge
        tree[0][0] = minEdge[0];
        tree[1][0] = minEdge[1];

        // Mark vertices in minimum cost edge as already included in tree
        near[minEdge[0]] = ALREADY_INLCUDED;
        near[minEdge[1]] = ALREADY_INLCUDED;

        for (int i = 0; i < nodesMatrix.length - 2; i++) {
            // Check nearest nodes
            for (int j = 0; j < near.length; j++) {
                if (near[j] != null && near[j] == ALREADY_INLCUDED) continue;

                var distanceToFirst = nodesMatrix[tree[0][i]][j];
                var distanceToSecond = nodesMatrix[tree[1][i]][j];

                if (distanceToFirst == null || (distanceToSecond != null && distanceToSecond < distanceToFirst)) {
                    near[j] = tree[1][i];
                } else {
                    near[j] = tree[0][i];
                }
            }

            int[] newMinEdge = null;
            // Check for minimum edge between nearest nodes
            for (int j = 0; j < near.length; j++) {
                if (near[j] != null && near[j] == ALREADY_INLCUDED || (nodesMatrix[j][near[j]] == null)) continue;

                if (newMinEdge == null || nodesMatrix[newMinEdge[0]][newMinEdge[1]] > nodesMatrix[j][near[j]]) {
                    if (newMinEdge == null) newMinEdge = new int[2];

                    newMinEdge[0] = j;
                    newMinEdge[1] = near[j];
                }
            }

            tree[0][i + 1] = newMinEdge[0];
            tree[1][i + 1] = newMinEdge[1];

            near[newMinEdge[0]] = ALREADY_INLCUDED;
            near[newMinEdge[1]] = ALREADY_INLCUDED;
        }

        return tree;
    }

    private static int[] findMinEdge(Integer[][] nodesMatrix) {
        var coordinates = new int[2];

        for (int i = 0; i < nodesMatrix.length; i++) {
            for (int j = 0; j < nodesMatrix.length; j++) {
                if (nodesMatrix[i][j] == null) continue;

                var currentCoordinateValue = nodesMatrix[coordinates[0]][coordinates[1]];

                if (currentCoordinateValue == null || nodesMatrix[i][j] < currentCoordinateValue) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }

        return coordinates;
    }
}
