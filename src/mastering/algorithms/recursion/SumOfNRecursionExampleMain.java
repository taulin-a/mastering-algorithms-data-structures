package mastering.algorithms.recursion;

public class SumOfNRecursionExampleMain {
    public static void main(String[] args) {
        var result = sum(5);
        System.out.println(result);

        result = iterativeSum(5);
        System.out.println(result);
    }

    private static int sum(int n) {
        if (n > 0) {
            return sum(n - 1) + n;
        }

        return n;
    }

    private static int iterativeSum(final int n) {
        var sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }
}
