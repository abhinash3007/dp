package DP;

public class MaxFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - 1); k <= Math.min(n - 1, j + 1); k++) {
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
    public static void main(String[] args) {
        int[][]matrix={{2,1,3},
                        {6,5,4},
                        {7,8,9}};
    System.out.println(minFallingPathSum(matrix));
    }
}
