package mastering.algorithms.recursion;

public class RecursionTypesExampleMain {
    public static void main(String[] args) {
        System.out.println("Tail recursion");
        funTail(3);

        System.out.println("\nHead recursion");
        funHead(3);

        System.out.println("\nTree recursion");
        funTree(3);
    }

    /**
     * TAIL RECURSION - the function doesn't have to perform operations at returning time, only calling time
     *
     * @param n
     */
    private static void funTail(int n) {
        if (n > 0) {
            System.out.println(n);
            funTail(n - 1);
        }
    }

    /**
     * HEAD RECURSION - the function doesn't heave to perform operation at calling time, only returning time
     *
     * @param n
     */
    private static void funHead(int n) {
        if (n > 0) {
            funHead(n - 1);
            System.out.println(n);
        }
    }

    /**
     * TREE RECURSION - recursive function call's itself more than one time
     *
     * @param n
     */
    private static void funTree(int n) {
        if (n > 0) {
            System.out.println(n);
            funTree(n - 1);
            funTree(n - 1) ;
        }
    }
}
