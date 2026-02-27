package Lab1;

// Write an optimal code to implement maximum sum-subarray

public class Q15 {
    static long maxSubarraySum(int[] arr) {
        long currentSum = arr[0];
        long maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    static void main() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarraySum(arr)); // Output: 6
    }
}
