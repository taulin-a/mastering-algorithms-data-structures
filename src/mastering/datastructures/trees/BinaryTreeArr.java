package mastering.datastructures.trees;

public class BinaryTreeArr {
    private final String[] nodes;

    public BinaryTreeArr(int size) {
        this.nodes = new String[size];
    }

    private int calculateLChildPos(int index) {
        return ((index + 1) * 2) - 1;
    }

    private int calculateRChildPos(int index) {
        return (index + 1) * 2;
    }

    public void addNode(String parentLabel, String lChildLabel, String rChildLabel) {
        if (nodes[0] == null) {
            nodes[0] = parentLabel;
            nodes[1] = lChildLabel;
            nodes[2] = rChildLabel;
            return;
        }

        int i = 0;
        while (!nodes[i].equals(parentLabel)) i++;

        nodes[calculateLChildPos(i)] = lChildLabel;
        nodes[calculateRChildPos(i)] = rChildLabel;
    }

    public void display() {
        for (int i = 0; i < nodes.length; i++) {
            final var lChildPos = calculateLChildPos(i);
            final var rChildPos = calculateRChildPos(i);

            if (lChildPos >= nodes.length || rChildPos >= nodes.length)
                break;

            var parent = nodes[i];
            var lChild = nodes[lChildPos];
            var rChild = nodes[rChildPos];

            if (lChild != null && rChild != null)
                System.out.println("parent (" + parent + "): leftChild(" + lChild + ") - rightChild(" + rChild + ")");
            else
                break;
        }
    }
}
