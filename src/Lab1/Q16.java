package Lab1;

//Write an optimal code to find minimum and maximum element in the array

import java.util.Arrays;

public class Q16 {
    static int[] minMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int ele : arr) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }
        return new int[] {min, max};
    }
    static void main() {
        int[] arr = {1, 23, 11, 8, 31, 4, 50, 60, 2, 70};
        System.out.println(Arrays.toString(minMax(arr)));
    }
}
