package mastering.algorithms.sorting.heapsort;

import mastering.datastructures.trees.heap.Heap;

import java.util.Arrays;

public class HeapSortExampleMain {
    public static void main(String[] args) {
        var unsortedArray = new Integer[]{50, 24, 32, 23, 17, 66, 9, 3};

        System.out.println("Unsorted arr: " + Arrays.toString(unsortedArray));

        var sortedArray = heapSort(unsortedArray);

        System.out.println("Sorted arr: " + Arrays.toString(sortedArray));
    }

    public static Integer[] heapSort(Integer[] unsortedArr) {
        var heap = new Heap<>(Integer.class, unsortedArr.length + 1, unsortedArr);

        var sortedArr = new Integer[unsortedArr.length];

        var indexToInsert = unsortedArr.length - 1;
        while (!heap.isEmpty()) {
            sortedArr[indexToInsert] = heap.delete();
            indexToInsert--;
        }

        return sortedArr;
    }
}
