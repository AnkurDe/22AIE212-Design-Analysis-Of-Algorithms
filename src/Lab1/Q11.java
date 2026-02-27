package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q11 {
    public static record Interval(int begin, int end) {
    }

    static void sortMergeSort(Interval[] intervals, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortMergeSort(intervals, left, mid);
            sortMergeSort(intervals, mid + 1, right);
            merge(intervals, left, mid, right);
        }
    }

    static void merge(Interval[] intervals, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;

        Interval[] leftArr = new Interval[n1];
        Interval[] rightArr = new Interval[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = intervals[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = intervals[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].begin() < rightArr[j].begin())
                intervals[k++] = leftArr[i++];
            else
                intervals[k++] = rightArr[j++];
        }
        while (i < n1) intervals[k++] = leftArr[i++];
        while (j < n2) intervals[k++] = rightArr[j++];
    }

    static Interval[] intervalsMerged(Interval[] intervals) {
        if (intervals.length ==0)
            return new Interval[0];

        List<Interval> list = new ArrayList<>();
        Interval current = intervals[0];
        sortMergeSort(intervals, 0, intervals.length-1);

        for (int i =1; i < intervals.length; i++) {
            Interval next = intervals[i];
            if (current.end() >= next.begin()) {
                current = new Interval(current.begin(), Math.max(current.end(), next.end()));
            } else {
                list.add(current);
                current = next;
            }
        }
        list.add(current);
        return list.toArray(new Interval[0]);
    }

    static void main() {
        Interval[] intervals = {
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(9, 12)
        };

        Interval[] merged = intervalsMerged(intervals);
        System.out.println(Arrays.toString(merged));
    }
}
