package Lab1;

//Given a binary array of 0’s and 1’s. Segregate all 0’s followed by 1.
//Input a=[0, 1, 1 ,0 ,0, 1, 1, 1, 0, 1]

import java.util.Arrays;

public class Q5 {
    static void binarySort(int[] arr) {
        int[] count = new int[2];
        for (int ele : arr)
            count[ele]++;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count[k] > 0) {
                arr[i]=k;
                count[k]--;
            } else {
                k++;
            }
        }
    }

    static void main() {
        int[] arr = {0, 1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(Arrays.toString(arr));
        binarySort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
