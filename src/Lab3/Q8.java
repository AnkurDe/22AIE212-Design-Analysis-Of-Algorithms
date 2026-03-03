package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Q8 {
    public static class Job {
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void scheduleJobs(Job[] jobs) {

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, Comparator.comparingInt((Job j) -> j.profit).reversed());

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slots = new int[maxDeadline + 1]; // 0 means empty
        int totalProfit = 0;

        for (Job job : jobs) {

            // Try to find a free slot before deadline
            for (int j = job.deadline; j > 0; j--) {

                if (slots[j] == 0) {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != 0)
                System.out.print("Job" + slots[i] + " ");
        }

        System.out.println("\nMaximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        scheduleJobs(jobs);
    }
}