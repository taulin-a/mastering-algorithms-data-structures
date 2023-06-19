package mastering.datastructures.trees.binarytree;

import mastering.datastructures.trees.binarytree.BinaryTree;
import mastering.datastructures.trees.binarytree.BinaryTreeArr;

public class BinaryTreeExampleMain {
    public static void main(String[] args) {
        var tree = new BinaryTreeArr<>(String.class, 7);
        tree.addNode("a", "b", "c");
        tree.addNode("b", "d", "e");
        tree.addNode("c", "f", "g");

        tree.display();

        System.out.println("----------------");

        var tree2 = new BinaryTree<Integer>();

        tree2.add(5);
        tree2.add(8);
        tree2.add(6);
        tree2.add(null);
        tree2.add(9);
        tree2.add(3);
        tree2.add(null);
        tree2.add(4);
        tree2.add(2);

        tree2.display();
        tree2.displayPreOrder();
        tree2.displayInOrder();
        tree2.displayPostOrder();
        tree2.displayLevelOrder();
        System.out.println("\nHeight of tree: " + tree2.getHeight());
        System.out.println("\nNumber of nodes in tree: " + tree2.getCount());
        System.out.println("\nNumber of leafs in tree: " + tree2.getLeafCount());
        System.out.println("\nNumber of nodes degree two: " + tree2.getNodesDegreeTwoCount());
        System.out.println("\nNumber of nodes degree one: " + tree2.getNodesDegreeOneCount());
    }
}
