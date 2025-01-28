package DP;

public class CountPartitionTwoSubsetWithMinDifference {
    public static int countPartition(int[] nums, int d) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + d) % 2 != 0 || sum < d) {
            return 0; 
        }
        int target = (sum + d) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(countPartition(nums, 1)); 
        System.out.println(countPartition(nums, 0)); 
    }
}
