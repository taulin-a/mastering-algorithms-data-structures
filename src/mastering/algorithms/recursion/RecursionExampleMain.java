package mastering.algorithms.recursion;

public class RecursionExampleMain {
    public static void main(String[] args) {
        fun(3);
    }

    static void fun(int n) {
        if (n > 0) {
            fun(n - 1);
            System.out.println(n);
            //fun(n - 1);
        }
    }
}
