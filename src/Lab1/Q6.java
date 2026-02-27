package Lab1;

//Find the largest element ‘L’ in the random array under following constraints: ‘L’ is
//repeated more than n/2 no. of times in the array, where ‘n’ is the array size.
//Input = 6, 1, 6, 6, 6, 5, 2, 6, 5, 1 , 2, 6, 6, 3 ,4, 6

import java.util.Arrays;

public class Q6 {
    static int majorityElement(int[] arr) {
        int count = 0, candidate = 0;
        for (int ele : arr) {
            if (count == 0){
                count = 1;
                candidate = ele;
            } else if (ele == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for (int ele: arr){
            if (ele == candidate) count1++;
        }

        if (count1 > arr.length/2) return candidate;

        return -1;
    }

    static void main() {
        int[] arr = {6, 1, 6, 6, 6, 5, 2, 6, 5, 1, 2, 6, 6, 3, 4, 6};
        System.out.println(Arrays.toString(arr));
        System.out.println(majorityElement(arr));
    }
}
