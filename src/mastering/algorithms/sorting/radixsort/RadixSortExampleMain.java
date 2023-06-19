package mastering.algorithms.sorting.radixsort;

import mastering.datastructures.queue.Queue;

import java.util.Arrays;
import java.util.Objects;

public class RadixSortExampleMain {
    public static void main(String[] args) {
        var unorderedArr = new int[]{237, 146, 259, 348, 152, 163, 235, 48, 36, 62};
        radixSort(unorderedArr);
        System.out.println(Arrays.toString(unorderedArr));
    }

    @SuppressWarnings("unchecked")
    private static void radixSort(int[] unorderedArr) {
        int max = unorderedArr[0];
        for (int i = 1; i < unorderedArr.length; i++) {
            if (unorderedArr[i] > max)
                max = unorderedArr[i];
        }

        var passes = Integer.toString(max).length();

        var bucketArr = new Queue[10];

        int i = 0;
        int divisor = 1;
        while (i < passes) {
            for (int n : unorderedArr) {
                var calculatedIndex = (n / divisor) % 10;

                if (bucketArr[calculatedIndex] == null)
                    bucketArr[calculatedIndex] = new Queue<Integer>();

                bucketArr[calculatedIndex].enqueue(n);
            }

            int j = 0;
            for (Queue<Integer> bkt : bucketArr) {
                while (Objects.nonNull(bkt) && !bkt.isEmpty()) {
                    unorderedArr[j++] = bkt.dequeue();
                }
            }

            divisor *= 10;
            i++;
        }
    }
}
