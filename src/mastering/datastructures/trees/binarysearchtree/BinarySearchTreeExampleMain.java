package mastering.datastructures.trees.binarysearchtree;

import mastering.datastructures.trees.TraversalType;

public class BinarySearchTreeExampleMain {
    public static void main(String[] args) {
        var tree = new BinarySearchTree<Integer>();
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(10);
        tree.add(25);
        tree.add(35);
        tree.add(50);

        tree.displayPreOrder();
        tree.displayPostOrder();

        System.out.println();

        System.out.println(tree.recursiveSearch(25));
        System.out.println(tree.search(25));
        System.out.println(tree.search(123));

        var tree2 = new BinarySearchTree<Integer>();
        tree2.addRecursive(30);
        tree2.addRecursive(20);
        tree2.addRecursive(40);
        tree2.addRecursive(10);
        tree2.addRecursive(25);
        tree2.addRecursive(35);
        tree2.addRecursive(50);

        tree2.displayPreOrder();

        tree2.delete(20);

        tree2.displayPreOrder();

        var tree3 = new BinarySearchTree<>(TraversalType.PREORDER, "30,20,10,25,40,35,50", Integer.class);
        tree3.displayPreOrder();

        var tree4 = new BinarySearchTree<>(TraversalType.POSTORDER, "10,25,20,35,50,40,30", Integer.class);
        tree3.displayPreOrder();
    }
}
