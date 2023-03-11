package mastering.algorithms.recursion;

/**
 * INDIRECT RECURSION - In indirect recursion you have more than one function, and they are calling each other in a
 * circular fashion
 */
public class IndirectRecursionExampleMain {
    public static void main(String[] args) {
        funA(20);
    }

    private static void funA(int n) {
        if (n > 0) {
            System.out.println(n);
            funB(n - 1);
        }
    }

    private static void funB(int n) {
        if (n > 1) {
            System.out.println(n);
            funA(n / 2);
        }
    }
}
