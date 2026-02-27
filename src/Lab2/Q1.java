package Lab2;

//You are working as a Software Engineer at QuickCart, a fast-growing e-commerce
//company. The platform has multiple warehouses across different cities. Each warehouse
//maintains a sorted list of order dispatch times (in minutes) for the day.
//At the end of the day, the company wants to generate a single master dispatch timeline
//that shows all orders from all warehouses in globally sorted order so they can analyze
//delivery efficiency. However, since the number of warehouses and orders is large, the
//solution must be efficient and scalable.
//INPUT: You are given m sorted arrays, each containing n dispatch times:
//Warehouse 1: [10, 20, 30, 40]
//Warehouse 2: [15, 25, 35, 45]
//Warehouse 3: [27, 29, 37, 48]
//Warehouse 4: [31, 34, 40, 51]
//Warehouse 5: [18, 19, 22, 28]
//OUTPUT: [10, 15, 18, 19, 20, 22, 25, 27, 28, 29, 30, 31, 34, 35, 37, 40, 40, 45, 48, 51]

import java.util.*;

public class Q1 {
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
