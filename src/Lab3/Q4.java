package Lab3;

public class Q4 {

    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int maxSoFar = arr[0];
        int currentMax = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > currentMax + arr[i]) {
                currentMax = arr[i];
                tempStart = i;
            } else {
                currentMax += arr[i];
            }

            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum Sum = " + maxSoFar);
        System.out.println("Subarray from index " + start + " to " + end);
    }
}