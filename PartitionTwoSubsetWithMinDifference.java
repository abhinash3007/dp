package DP;

public class PartitionTwoSubsetWithMinDifference {
    public static int minDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];

        // Initialize: Subset with sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest sum to sum/2
        int closestSum = 0;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                closestSum = j;
                break;
            }
        }

        // Calculate and return the minimum difference
        return Math.abs(sum - 2 * closestSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9};
        System.out.println(minDifference(nums)); // Output: 3
    }
}
