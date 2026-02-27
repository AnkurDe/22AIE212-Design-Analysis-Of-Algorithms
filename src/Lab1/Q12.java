package Lab1;

//Given an unsorted integer array, find a pair with the given sum in it.
// Input: 8, 7, 2, 5, 4, 1 and target = 10
// Output: Pair found: (8,2)
// If target = 7, Output=Not found

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q12 {
    static int[] sumPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int ele : arr) {
            set.add(ele);
        }

        for (int ele : arr) {
            if (set.contains(target-ele))
                return new int[] {Math.min(ele, target-ele), Math.max(ele, target-ele)};
        }
        return new int[]{-1, -1};
    }

    static void main() {
        int[] arr = {8, 7, 2, 5, 4, 1};
        System.out.println(Arrays.toString(sumPair(arr, 7)));
    }
}
