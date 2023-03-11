package mastering.algorithms.recursion;

/**
 * NESTED RECURSION - A recursive function will parameter as a recursive call. "It's recursion inside recursion".
 */
public class NestedRecursionExampleMain {
    public static void main(String[] args) {
        var result = fun(95);
        System.out.println(result);
    }

    private static int fun(int n) {
        if (n > 100) {
            return n - 10;
        }

        return fun(fun(n + 11));
    }
}
