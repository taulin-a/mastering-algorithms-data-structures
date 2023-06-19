package mastering.algorithms.sorting.mergesort;

import java.util.Arrays;

public class MergeSortExampleMain {
    public static void main(String[] args) {
        var unorderedArr = new int[]{8, 3, 7, 4, 9, 2, 6, 5};
        recursiveMergeSort(unorderedArr, 0, unorderedArr.length);

        System.out.println(Arrays.toString(unorderedArr));
    }

    private static void mergeSort(int[] unorderedArr) {
        int height = unorderedArr.length / 2 - 1;

        int groupSize = 2;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < unorderedArr.length; ) {
                merge(unorderedArr, j, j + groupSize / 2, j + groupSize);

                j += groupSize;
            }

            groupSize *= 2;
        }
    }

    private static void recursiveMergeSort(int[] unorderedArr, int start, int limit) {
        if (start < limit - 1) {
            var middle = (start + limit) / 2;
            recursiveMergeSort(unorderedArr, start, middle);
            recursiveMergeSort(unorderedArr, middle, limit);
            merge(unorderedArr, start, middle, limit);
        }
    }

    private static void merge(int[] unorderedArr, int start, int middle, int limit) {
        var orderedArr = new int[unorderedArr.length];

        int i = start;
        int j = middle;
        int k = start;

        while (i < middle && j < limit) {
            if (unorderedArr[i] < unorderedArr[j]) {
                orderedArr[k++] = unorderedArr[i++];
            } else {
                orderedArr[k++] = unorderedArr[j++];
            }
        }

        while (i < middle) orderedArr[k++] = unorderedArr[i++];

        while (j < limit) orderedArr[k++] = unorderedArr[j++];

        int y = start;
        while (y < unorderedArr.length && orderedArr[y] != 0) {
            unorderedArr[y] = orderedArr[y];
            y++;
        }
    }
}
