package Lab3;

import java.util.*;

public class Q7 {

    static class Node implements Comparable<Node> {
        int[] array;

        Node(int[] array) {
            this.array = array;
        }

        public int compareTo(Node other) {
            return this.array.length - other.array.length;
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length)
            result[k++] = a[i++];

        while (j < b.length)
            result[k++] = b[j++];

        return result;
    }

    public static int[] optimalMerge(List<int[]> arrays) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int[] arr : arrays) {
            pq.add(new Node(arr));
        }

        while (pq.size() > 1) {
            Node first = pq.poll();
            Node second = pq.poll();

            int[] merged = merge(first.array, second.array);
            pq.add(new Node(merged));
        }

        return pq.poll().array;
    }

    public static void main(String[] args) {

        List<int[]> arrays = new ArrayList<>();

        arrays.add(new int[]{1, 4, 7});
        arrays.add(new int[]{2, 5, 8});
        arrays.add(new int[]{3, 6, 9});

        int[] result = optimalMerge(arrays);

        System.out.println("Merged Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}