package Lab2;

//You are working as a Software Engineer at Emirates. The airline uses an automated
//system to generate a boarding priority list for passengers based on factors like loyalty
//status, ticket class, and special assistance. Ideally, the list should be fully sorted by
//priority. However, due to last-minute upgrades, seat changes, and manual overrides, the
//final list becomes k-nearly sorted, meaning:
//Each passenger is at most k positions away from their correct sorted position, where k is
//much smaller than N.
//Your manager wants you to efficiently sort this list before boarding begins, ensuring
//minimal delay.
//Input
//An example boarding priority array:
//A = [101, 103, 102, 104, 106, 105, 107]
//Here:N = 7 passengers
//k = 1 or 2 (each element is only slightly misplaced)
//a) You are asked to evaluate the following sorting algorithms:
//
//
//
//Bubble Sort
//Selection Sort
//Insertion Sort
//Identify which sorting technique is best suited for sorting a k-nearly sorted array when k
//<< N? Justify your answer using detailed time complexity analysis for: Best case,
//worst case and average case.
//Also explain why some algorithms do unnecessary comparisons? Why one algorithm
//performs better when the array is nearly sorted. The best chosen algorithm
//b. Implement the traditional and the improved versions of insertion sort and plot graphs for
//complexity analysis and comparisons.
//c. Discuss the impact of the improved insertion sort on the best case and average case
//with complexity analysis. It is helpful in such cases.? You can choose to plot graphs and
//check.

public class Q9 {
    static void insertionSort(int[] arr) {
        final int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int key = arr[j];
            while (j >= 0 && arr[j] >key) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = key;
        }
    }

    static void main() {

    }
}
