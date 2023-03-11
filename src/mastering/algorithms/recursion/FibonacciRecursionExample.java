package mastering.algorithms.recursion;

import java.util.Arrays;

public class FibonacciRecursionExample {
    private static int[] memory;

    public static void main(String[] args) {
        memory = new int[99];
        Arrays.fill(memory, -1);
        System.out.println(fib(65));
        System.out.println(fibMemoization(65));
        System.out.println(fibIterative(65));
    }

    /**
     * O(n²)
     *
     * @param n
     * @return
     */
    private static int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 2) + fib(n - 1);
    }

    /**
     * O(n+1) = O(n)
     *
     * @param n
     * @return
     */
    private static int fibMemoization(int n) {
        if (n <= 1) {
            memory[n] = n;
            return n;
        }

        if (memory[n - 2] == -1)
            memory[n - 2] = fibMemoization(n - 2);

        if (memory[n - 1] == -1)
            memory[n - 1] = fibMemoization(n - 1);

        memory[n] = memory[n - 2] + memory[n - 1];

        return memory[n];
    }

    /**
     * Implementação mais eficiente
     * O(n)
     *
     * @param n
     * @return
     */
    private static int fibIterative(int n) {
        if (n <= 1)
            return n;

        var n1 = 0;
        var n2 = 1;
        var result = 0;

        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }

        return result;
    }
}
