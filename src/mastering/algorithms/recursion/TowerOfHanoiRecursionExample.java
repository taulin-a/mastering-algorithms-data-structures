package mastering.algorithms.recursion;

import mastering.datastructures.Tower;

import java.util.Stack;

public class TowerOfHanoiRecursionExample {
    public static void main(String[] args) {
        System.out.println("----RECURSIVE----");
        towerOfHanoi(3, 1, 2, 3);
        System.out.println("\n----ITERATIVE----");
        towerOfHanoiIterative(3);
        System.out.println("\n----ITERATIVE ASSERTIVE----");
        towerOfHanoiIterativeAssertive(3);
    }

    private static void towerOfHanoi(int n, int source, int aux, int target) {
        if (n > 0) {
            towerOfHanoi(n - 1, source, target, aux);
            System.out.println("from " + source + " to " + target);
            towerOfHanoi(n - 1, aux, source, target);
        }
    }

    private static void towerOfHanoiIterative(final int nDiscs) {
        var nMoves = exponential(2, nDiscs) - 1;
        var source = 1;
        var aux = 2;
        var target = 3;
        var helper = 0;

        if (nDiscs % 2 == 0) {
            helper = aux;
            aux = target;
            target = helper;
        }

        for (int i = 1; i <= nMoves; i++) {
            if (i % 3 == 1) {
                System.out.println("between " + source + " to " + target);
            } else if (i % 3 == 2) {
                System.out.println("between " + source + " to " + aux);
            } else if (i % 3 == 0) {
                System.out.println("between " + aux + " to " + target);
            }
        }
    }

    private static void towerOfHanoiIterativeAssertive(final int nDiscs) {
        final var nMoves = exponential(2, nDiscs) - 1;

        var source = new Tower("1");
        for (int i = 1; i <= nDiscs; i++) {
            source.getStack().push(i);
        }

        var aux = new Tower("2");
        var target = new Tower("3");

        Tower helper;

        if (nDiscs % 2 == 0) {
            helper = aux;
            aux = target;
            target = helper;
        }

        for (int i = 1; i <= nMoves; i++) {
            if (i % 3 == 1) {
                checkAndExchangeTower(source, target);
            } else if (i % 3 == 2) {
                checkAndExchangeTower(source, aux);
            } else if (i % 3 == 0) {
                checkAndExchangeTower(aux, target);
            }
        }
    }

    private static void checkAndExchangeTower(Tower source, Tower target) {
        var n1 = source.getStack().empty() ? null : source.getStack().peek();
        var n2 = target.getStack().empty() ? null : target.getStack().peek();

        if (n2 == null || n1 != null && n1 > n2) {
            var poped = source.getStack().pop();
            target.getStack().push(poped);
            System.out.println("from " + source.getId() + " to " + target.getId());
        } else {
            var poped = target.getStack().pop();
            source.getStack().push(poped);
            System.out.println("from " + target.getId() + " to " + source.getId());
        }
    }

    private static int exponential(int n, int exponent) {
        var result = n;

        for (int i = 1; i < exponent; i++) {
            result *= n;
        }

        return result;
    }
}
