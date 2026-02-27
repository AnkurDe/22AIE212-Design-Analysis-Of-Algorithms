package Lab1;

//2. Insertion sort divides the array into two part, a sorted part and an unsorted part. In each
//iteration it selects the top element E from the unsorted part, linearly searches for its best
//position P in the sorted part and inserts the element E at the position P by shifting the
//array elements in the forward direction
//a) Discuss how can we improvise the traditional insertion sort algorithm for its worst case
//where the data is placed at random in the array with the help of detailed complexity
//analysis for traditional and improved insertion sort.
//b) Implement the traditional and the improved versions of insertion sort and plot graphs for
//complexity analysis and comparisons.
//c) Discuss the impact of the improved insertion sort on the best case and average case with
//complexity analysis. It is helpful in such cases.? You can choose to plot graphs and
//check.

import java.util.Arrays;

public class Q2 {
    static void sortTraditional(int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length; i++) {
            final int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }
    }

    static void sortOptimized(int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length; i++) {
            int key = arr[i];
            int pos = binarySearch(arr, i - 1, i, key);

            int j = i - 1;
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[pos] = key;
        }
    }

    static int binarySearch(int[] arr, int high, int low, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid - 1;
        }
        return low;
    }

    static void main() {
        int[] arr = {10, 11, 5, -8, 7, 4, 8, 9, 3};
        int[] arr1= Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        sortTraditional(arr);
        System.out.println(Arrays.toString(arr));
        sortOptimized(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
