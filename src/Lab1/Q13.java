package Lab1;

//Given an unsorted integer array containing both positive and negative numbers, find a  pair with maximum product in it. Input: arr=[1,7,4,2,8,6,3,9,5] Output = 72
public class Q13 {
    static long maximumProd(int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > max1) {
                max2 = max1;
                max1 = ele;
            } else if (ele > max2 && ele < max1) {
                max2 = ele;
            }
            if (ele < min1) {
                min2 = min1;
                min1 = ele;
            } else if (ele < min2 && ele > min1) {
                min2 = ele;
            }
        }
        long l1 = (long) min1 * min2;
        long l2 = (long) max1 * max2;

        return Math.max(l1, l2);
    }

    static void main() {
        int[] arr = {1, 7, 4, 2, 8, 6, 3, 9, 5};
        System.out.println(maximumProd(arr));
    }
}
