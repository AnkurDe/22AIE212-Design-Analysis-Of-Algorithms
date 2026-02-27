package Lab2;

//You are working as a Software Engineer at Tesla on the Autonomous Driving team.
//Each self-driving car continuously records temperature readings (in °C) from its
//battery sensors during a trip. For safety analysis, the system must quickly determine:The minimum temperature (to detect freezing risk)
//The maximum temperature (to detect overheating risk)
//Since the car generates millions of readings, your algorithm must be highly efficient
//and use minimum comparisons.
//Input: An array of sensor readings: arr = [34, 12, 45, 67, 23, 9, 56, 89, 15]
//OUPUT: 9, 89

import java.util.Arrays;

public class Q7 {
    static int[] minMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int ele : arr) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }
        return new int[] {min, max};
    }

    static void main() {
        int[] arr = {34, 12, 45, 67, 23, 9, 56, 89, 15};
        System.out.println(Arrays.toString(minMax(arr)));
    }
}
