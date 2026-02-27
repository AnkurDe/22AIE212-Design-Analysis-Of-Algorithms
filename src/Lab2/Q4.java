package Lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4 {

    static record Meeting(int start, int finish) {}

    // Merge sort by finish time
    static void sortMeetings(List<Meeting> meetings, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortMeetings(meetings, left, mid);
            sortMeetings(meetings, mid + 1, right);
            merge(meetings, left, mid, right);
        }
    }

    static void merge(List<Meeting> meetings, int left, int mid, int right) {
        int l1 = mid - left + 1;
        int l2 = right - mid;

        Meeting[] leftArr = new Meeting[l1];
        Meeting[] rightArr = new Meeting[l2];

        for (int i = 0; i < l1; i++)
            leftArr[i] = meetings.get(left + i);

        for (int i = 0; i < l2; i++)
            rightArr[i] = meetings.get(mid + 1 + i);

        int i = 0, j = 0, k = left;

        while (i < l1 && j < l2) {
            if (leftArr[i].finish() <= rightArr[j].finish())
                meetings.set(k++, leftArr[i++]);
            else
                meetings.set(k++, rightArr[j++]);
        }

        while (i < l1)
            meetings.set(k++, leftArr[i++]);

        while (j < l2)
            meetings.set(k++, rightArr[j++]);
    }

    static List<Meeting> scheduleMeetings(List<Meeting> meetings) {
        sortMeetings(meetings, 0, meetings.size() - 1);

        List<Meeting> result = new ArrayList<>();

        Meeting current = meetings.get(0);
        result.add(current);

        for (int i = 1; i < meetings.size(); i++) {
            Meeting next = meetings.get(i);

            if (next.start() >= current.finish()) {
                result.add(next);
                current = next;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Meeting> meetings = new ArrayList<>(Arrays.asList(
                new Meeting(1, 4),
                new Meeting(3, 5),
                new Meeting(0, 6),
                new Meeting(5, 7),
                new Meeting(3, 8),
                new Meeting(5, 9),
                new Meeting(6, 10),
                new Meeting(8, 11),
                new Meeting(8, 12),
                new Meeting(2, 13),
                new Meeting(12, 14)
        ));

        List<Meeting> scheduled = scheduleMeetings(meetings);

        for (Meeting m : scheduled)
            System.out.println("(" + m.start() + "," + m.finish() + ")");
    }
}