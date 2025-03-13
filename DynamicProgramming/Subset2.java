import java.util.*;

public class Subset2 {
    public boolean[][] subsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // Sum 0 is always possible with an empty subset
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];  // Exclude current element
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];  // Include or exclude
                }
            }
        }

        return dp;
    }

    public void printSubsets(int[] nums, int sum) {
        boolean[][] dp = subsetSum(nums, sum);
        if (!dp[nums.length][sum]) {
            System.out.println("No subsets with the given sum exist.");
            return;
        }

        List<Integer> path = new ArrayList<>();
        findSubsets(dp, nums, nums.length, sum, path);
    }

    private void findSubsets(boolean[][] dp, int[] nums, int i, int sum, List<Integer> path) {
        if (sum == 0) {
            System.out.println(path);
            return;
        }

        if (i == 0) return;

        if (dp[i - 1][sum]) {
            findSubsets(dp, nums, i - 1, sum, new ArrayList<>(path)); // Exclude current element
        }

        if (sum >= nums[i - 1] && dp[i - 1][sum - nums[i - 1]]) {
            path.add(nums[i - 1]);
            findSubsets(dp, nums, i - 1, sum - nums[i - 1], path); // Include current element
        }
    }

    public static void main(String[] args) {
        Subset2 obj = new Subset2();
        int arr[] = {2, 5, 7, 12, 17, 6};
        int target = 12;
        obj.printSubsets(arr, target);
    }
}
