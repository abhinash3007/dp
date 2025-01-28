package DP;

public class KnapsackZeroAndOne {
    public static int knapsack(int[]nums,int[]value,int weight){
        int[][] dp = new int[nums.length + 1][weight + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= weight; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j] , value[i-1]+dp[i - 1][j - nums[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][weight];
    }
    public static void main(String[] args) {
            int[] weights = {2, 3, 4, 2, 5};
            int[] values = {6, 8, 9, 5, 10};
            int capacity = 10;
            System.out.println("Maximum value: " + knapsack(weights, values, capacity));
    }
}
