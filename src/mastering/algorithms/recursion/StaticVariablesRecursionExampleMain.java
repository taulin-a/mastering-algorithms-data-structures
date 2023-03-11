package mastering.algorithms.recursion;

public class StaticVariablesRecursionExampleMain {
    private static int I = 0;

    public static void main(String[] args) {
        System.out.println(fun(5));
    }

    private static int fun(int n) {
        if (n > 0) {
            I++;
            return fun(n - 1) + I;
        }

        return 0;
    }
}
