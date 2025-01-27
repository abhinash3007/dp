package DP;

import java.util.Arrays;

public class CountSubsetEqualToK {
    public static int count(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(nums, nums.length - 1, target, dp);
    }

    public static int helper(int[] nums, int n, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int pick = 0;
        if (nums[n] <= target) {
            pick = helper(nums, n - 1, target - nums[n], dp);
        }
        int notPick = helper(nums, n - 1, target, dp);
        return dp[n][target] = pick + notPick;
    }
    

    public static int count2(int[] nums, int target) {
        int n=nums.length;
        int[][] dp = new int[n+1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j]=dp[i - 1][j - nums[i-1]]+dp[i - 1][j];
                }else{
                    dp[i][j]= dp[i - 1][j];
                }
            }
        }return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9, 6, 3 };
        System.out.println(count2(nums, 9));
    }
}
