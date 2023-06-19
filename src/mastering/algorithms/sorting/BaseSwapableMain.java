package mastering.algorithms.sorting;

public class BaseSwapableMain {
    protected static void swap(int indexSource, int indexTarget, int[] arr) {
        var aux = arr[indexTarget];
        arr[indexTarget] = arr[indexSource];
        arr[indexSource] = aux;
    }
}
