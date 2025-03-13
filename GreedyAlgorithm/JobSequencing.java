import java.util.*;

public class JobSequencing {
    private static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobScheduling(ArrayList<Job> jobs) {
        // Sort jobs in descending order of profit
        jobs.sort(Comparator.comparingInt((Job job) -> job.profit).reversed());

        // Find the maximum deadline
        int maxDeadline = jobs.stream().mapToInt(job -> job.deadline).max().orElse(0);

        // Array to store scheduled jobs
        boolean[] filledSlot = new boolean[maxDeadline];
        char[] scheduledJobs = new char[maxDeadline];
        int totalProfit = 0;

        // Iterate through all jobs
        for (Job job : jobs) {
            // Find a free slot (starting from the last available slot for this job)
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!filledSlot[j]) {
                    filledSlot[j] = true;
                    totalProfit += job.profit;
                    scheduledJobs[j] = job.id;
                    break;
                }
            }
        }

        // Print the job sequence and total profit
        System.out.print("Job Sequence: ");
        for (char job : scheduledJobs) {
            if (job != 0) System.out.print(job + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>(Arrays.asList(
            new Job('A', 2, 100),
            new Job('B', 1, 50),
            new Job('C', 2, 10),
            new Job('D', 1, 20),
            new Job('E', 3, 30)
        ));

        jobScheduling(jobs);
    }
}
