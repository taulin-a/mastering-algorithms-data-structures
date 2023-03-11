package mastering.algorithms.recursion;

public class CombinationFormulaRecursionExample {
    private static int[][] memory;

    public static void main(String[] args) {
        memory = new int[10][10];

        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory.length; j++) {
                memory[i][j] = -1;
            }
        }

        System.out.println(combinationFormula(10, 2));
        System.out.println(combinationFormulaMemoization(10, 2));
        System.out.println(combinationFormulaIterative(10, 2));
    }

    /**
     * O(n²)
     *
     * @param n
     * @param r
     * @return
     */
    private static int combinationFormula(int n, int r) {
        if (r > n)
            throw new IllegalArgumentException("r must be equal or lesser than n");

        if (r == 0 || n == r)
            return 1;

        return combinationFormula(n - 1, r - 1) + combinationFormula(n - 1, r);
    }

    /**
     * Combination formula with memoization
     * ?
     *
     * @return
     */
    private static int combinationFormulaMemoization(int n, int r) {
        if (r > n)
            throw new IllegalArgumentException("r must be equal or lesser than n");

        if (r == 0 || n == r) {
            memory[n][r] = 1;
            return memory[n][r];
        }

        if (memory[n - 1][r - 1] == -1)
            memory[n - 1][r - 1] = combinationFormulaMemoization(n - 1, r - 1);

        if (memory[n - 1][r] == -1)
            memory[n - 1][r] = combinationFormulaMemoization(n - 1, r);

        memory[n][r] = memory[n - 1][r - 1] + memory[n - 1][r];

        return memory[n][r];
    }

    /**
     * O(3n + 1) = O(n)
     *
     * @param n
     * @param r
     * @return
     */
    private static long combinationFormulaIterative(long n, long r) {
        if (r > n)
            throw new IllegalArgumentException("r must be equal or lesser than n");

        if (r == 0 || n == r)
            return 1;

        var n1 = factorial(n);
        var n2 = factorial(r);
        var n3 = factorial(n - r);

        return n1 / (n2 * n3);
    }

    private static long factorial(long n) {
        if (n <= 1)
            return 1;

        var result = 1L;

        for (long i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
