package mastering.algorithms.recursion;

public class FactorialRecursionExampleMain {
    public static void main(String[] args) {
        System.out.println(fact(5));

        System.out.println(iterativeFact(5));
    }

    private static int fact(int n) {
        if (n > 0) {
            return fact(n - 1) * n;
        }

        return 1;
    }

    private static int iterativeFact(final int n) {
        var fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}
