package Lab1;

//Given an array of size N, find the K largest elements in the array where
//K<<<N. For Example:
//Input: 1, 23, 11, 8, 31, 4, 50, 60, 2, 70} K=3
//Output = 70,60,50

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4 {
    static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int ele : arr) {
            minHeap.offer(ele);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        
        int[] arrs = new int[k];
        for (int i = k-1; i >= 0; i--) {
            arrs[i]=minHeap.poll();
        }
        return arrs;
    }

    static void main() {
        int[] arr = {1, 23, 11, 8, 31, 4, 50, 60, 2, 70};
        System.out.println(Arrays.toString(kLargest(arr, 3)));
    }
}
