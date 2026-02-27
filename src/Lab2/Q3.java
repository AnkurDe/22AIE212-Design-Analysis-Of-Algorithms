package Lab2;

//You are working as a Software Engineer at Netflix. The platform tracks whether users
//are inactive (0) or active (1) during a specific time window. For performance
//optimization, the analytics team wants all inactive users (0) to appear first in the
//database, followed by active users (1), so that different processing strategies can be
//applied efficiently. However, the dataset is very large, and the segregation must be done
//in-place with minimum time and space complexity.
//INPUT: USER Activity = [0, 1, 1 ,0 ,0, 1, 1, 1, 0, 1]

import java.util.Arrays;

public class Q3 {
    static void binarySort(int[] arr) {
        int[] count = new int[2];
        for (int ele : arr) {
            count[ele]++;
        }

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count[k] > 0) {
                arr[i] = k;
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
