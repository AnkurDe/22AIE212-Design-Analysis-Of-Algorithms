package Lab1;

// Given an arrayA that is k-nearly sorted. You need to sort the array A of size N with the
//best time complexity possible where k<<<N.
//a) Which of the basic sorting techniques namely bubble sort, selection sort and insertion
//sort will be best suited for sorting As per your understanding. Explain and justify using
//detailed complexity analysis for all three techniques.
//b) In continuation to part (A), implement the best chosen sorting algorithm and any one
//of the remaining two. Also, plot the graphs for complexity analysis of the techniques
//implemented on a common data.

import java.util.Arrays;

public class Q1 {
    // Insertion sort
    static void sort(int[] arr) {
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

    static void main() {
        int[] arr = {10, 11, 5, -8, 7, 4, 8, 9, 3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
