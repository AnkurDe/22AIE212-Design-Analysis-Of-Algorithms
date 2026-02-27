package Lab2;

public class Q6 {
    static long maxProd (int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > max1) {
                max2 = max1;
                max1 = ele;
            } else if (ele < max1 && ele > max2) {
                max2 = ele;
            }

            if (ele < min1) {
                min2 = min1;
                min1 = ele;
            } else if (ele > min1 && ele < min2) {
                min2 = ele;
            }
        }
        return Math.max(min1*min2, max1*max2);
    }
    static void main() {
        int[] arr= {1, 7, 4, 2, 8, 6, 3, 9, 5};
        System.out.println(maxProd(arr));
    }
}
