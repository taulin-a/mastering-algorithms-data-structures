package mastering.algorithms.sorting.quicksort;

import mastering.algorithms.sorting.BaseSwapableMain;

import java.util.Arrays;

public class QuickSortExampleMain extends BaseSwapableMain {
    public static void main(String[] args) {
        var unorderedArr = new int[]{50, 70, 60, 90, 40, 80, 10, 20, 30};
        quickSort(0, unorderedArr, 0, unorderedArr.length - 1);

        System.out.println(Arrays.toString(unorderedArr));
    }

    private static void quickSort(int pivotIndex, int[] arr, int start, int end) {
        if (end <= start) return;

        int i = start;
        int j = end;

        while (true) {
            while (arr[i] < arr[pivotIndex]) i++;

            while (arr[j] > arr[pivotIndex]) j--;

            if (j <= i) break;

            swap(i, j, arr);
        }

        swap(pivotIndex, j, arr);

        quickSort(pivotIndex, arr, pivotIndex, j - 1);
        quickSort(j + 1, arr, j + 1, arr.length - 1);
    }
}
