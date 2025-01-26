package DP;

import java.util.*;

public class SubsetSumEqualToTarget {
    public static boolean subset(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length+1][target + 1];
        for (int i = 0; i <=nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
            }
        }return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] arr = { 1,4,78,5,6 };
        System.out.println(subset(arr, 47));
    }
}
