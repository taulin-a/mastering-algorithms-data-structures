package mastering.datastructures.trees.avltree;

public class AVLTreeExampleMain {
    public static void main(String[] args) {
        var tree = new AVLTree<Integer>();

        tree.addRecursive(10);
        tree.addRecursive(20);
        tree.addRecursive(30);
        tree.addRecursive(40);
        tree.addRecursive(29);
        tree.addRecursive(28);
        tree.addRecursive(41);
        tree.addRecursive(9);

        tree.displayPreOrder();

        tree.delete(10);
        tree.delete(9);
        tree.delete(29);

        tree.displayPreOrder();
    }
}
