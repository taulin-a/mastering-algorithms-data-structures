package mastering.algorithms.sorting.countsort;

import java.util.Arrays;

public class CountSortExampleMain {
    public static void main(String[] args) {
        var unsortedArr = new int[]{6, 3, 9, 10, 15, 6, 8, 12, 3, 6};
        countSort(unsortedArr);
        System.out.println(Arrays.toString(unsortedArr));
    }

    private static void countSort(int[] unsortedArr) {
        int max = unsortedArr[0];
        for (int i = 1; i < unsortedArr.length; i++) {
            if (unsortedArr[i] > max)
                max = unsortedArr[i];
        }

        var countArr = new int[max + 1];

        for (int n : unsortedArr)
            countArr[n]++;

        var insertPosIndex = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                unsortedArr[insertPosIndex++] = i;
                countArr[i]--;
            }
        }
    }
}
