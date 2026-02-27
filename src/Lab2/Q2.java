package Lab2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2 {
    static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : arr) {
            pq.offer(ele);
            if (pq.size() > k)
                pq.poll();
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    static void main() {
        int[] arr = {1, 23, 11, 8, 31, 4, 50, 60, 2, 70};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(kLargest(arr, 4)));
    }
}
