package mastering.algorithms.recursion;

public class TaylorSeriesRecursionExample {
    private static double p = 1;
    private static double f = 1;
    private static double s = 1;

    public static void main(String[] args) {
        System.out.println(taylorSeries(4, 15));
        System.out.println(taylorSeriesOptimized(4, 15));
        System.out.println(taylorSeriesIterative(4, 15));
        System.out.println(taylorSeriesIterativeAlternative(4, 15));
    }

    private static double taylorSeries(int x, int n) {
        if (n > 0) {
            double r = taylorSeries(x, n - 1);
            p *= x;
            f *= n;
            return r + (p / f);
        }

        return 1;
    }

    /**
     * Taylor Series applied with horner's rule
     * @param x
     * @param n
     * @return
     */
    private static double taylorSeriesOptimized(int x, int n) {
        if (n > 0) {
            s = 1 + x * s / n;
            return taylorSeriesOptimized(x, n - 1);
        }

        return s;
    }

    private static double taylorSeriesIterative(int x, int n) {
        double exponente = x;
        double fatorial = 1;

        double result = 1 + (exponente / fatorial);

        for (int i = 2; i <= n; i++) {
            exponente *= x;
            fatorial *= i;

            result = result + (exponente / fatorial);
        }

        return result;
    }

    /**
     * Taylor Series applied with horner's rule
     * @param x
     * @param n
     * @return
     */
    private static double taylorSeriesIterativeAlternative(int x, int n) {
        double result = 1;
        while (n > 0) {
            result = 1 + x * result / n;
            n--;
        }

        return result;
    }
}
