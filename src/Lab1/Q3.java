package Lab1;

//3. Given‘m’ sorted lists/arrays, each containing ‘n’ elements, print them efficiently in
//sorted order. For Example:
//Input:
//[10, 20, 30, 40]
//[15, 25, 35, 45]
//[27, 29, 37, 48]
//[31, 34, 40, 51]
//[19, 18, 22, 28]
//Output: [10, 15, 18, 19, 20, 22, ..., 51]

import java.util.*;

public class Q3 {
    static record Node(int value, int row, int col) {
    }

    static List<Integer> mergeSortedArrays(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::value));
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                pq.offer(new Node(matrix[i][0], i, 0));
            }
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            result.add(current.value);
            if (current.col + 1 < matrix[current.row].length) {
                pq.offer(new Node(matrix[current.row][current.col + 1], current.row, current.col + 1));
            }
        }
        return result;
    }


    static void print(int[][] matrix) {
        for (int[] a : matrix)
            System.out.println(Arrays.toString(a));
    }

    static void main() {
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {31, 34, 40, 51}, {19, 18, 22, 28}};
        print(matrix);
        System.out.println(mergeSortedArrays(matrix));
    }
}
