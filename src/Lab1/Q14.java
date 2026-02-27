package Lab1;

//Given an array where all its elements are sorted except two swapped elements, sort it in linear time.
// Assume there are no duplicates in the array.

import java.util.Arrays;

public class Q14 {
    static void sortSwapped(int[] arr) {
        int length = arr.length;
        int x = -1, y = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (x == -1)
                    x = i;
                else {
                    y = i + 1;
                    break;
                }
            }
        }

        if (y == -1 && x != -1) {
            y = x + 1;
        }

        if (y != -1) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

    static void main() {
        int[] arr = {1, 4, 7, 18, 10, 15, 8, 20, 25};
        System.out.println(Arrays.toString(arr));
        sortSwapped(arr);
        System.out.println(Arrays.toString(arr));
    }
}
