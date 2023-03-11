package mastering.algorithms.recursion;

public class ExponentRecursionExampleMain {
    public static void main(String[] args) {
        System.out.println(power(2, 9));
        System.out.println(optmizedPower(2, 9));
        System.out.println(iterativePower(2, 9)); 
    }

    private static int power(int m, int n) {
        if (n > 0) {
            return power(m, n - 1) * m;
        }

        return 1;
    }

    private static int optmizedPower(int m, int n) {
        if (n > 0) {
            if (n % 2 == 0) {
                return optmizedPower(m * m, n / 2);
            } else {
                return m * optmizedPower(m * m, (n - 1) / 2);
            }
        }

        return 1;
    }

    private static int iterativePower(int m, int n) {
        var result = 1;

        for (int i = 0; i < n; i++) {
            result *= m;
        }

        return result;
    }
}
