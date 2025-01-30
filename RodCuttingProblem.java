package DP;
public class RodCuttingProblem {
    public static int knapsack( int[] value, int weight) {
        int[][] dp = new int[value.length + 1][weight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 0; j <= weight; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (value[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i][j - value[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[value.length][weight];
    }
    public static void main(String[] args) {
        int[] values = { 1, 5, 8, 9, 10, 17, 17,20 };
        int capacity = 8;
        System.out.println("Maximum value: " + knapsack(values, capacity));
    }
}
