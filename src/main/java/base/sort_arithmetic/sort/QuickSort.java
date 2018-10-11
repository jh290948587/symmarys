package base.sort_arithmetic.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/30.
 */
public class QuickSort {
    public static void main(String args[]) {
        QuickSort quicksort = new QuickSort();
        int[] arrays = new int[]{ 4, 12, 2, 13, 3, 14, 8, 8, 19 };
        quicksort.quickSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private void quickSort(int[] arrays) {
        subQuickSort(arrays, 0, arrays.length - 1);
    }

    private void subQuickSort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        int middleIndex = subQuickSortCore(arrays, start, end);
        subQuickSort(arrays, start, middleIndex - 1);
        subQuickSort(arrays, middleIndex + 1, end);
    }
//4, 12, 2, 13, 3, 14, 8, 8, 19
    private int subQuickSortCore(int[] arrays, int start, int end) {
        int key = arrays[start];
        while (start < end) {
            while (arrays[end] >= key && start < end) {
                end--;
            }
            arrays[start] = arrays[end];

            while (arrays[start] <= key && start < end) {
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = key;
        return start;
    }

}
