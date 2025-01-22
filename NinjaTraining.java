package DP;

import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int n, int[][] points) {
            int[][] dp = new int[n][4];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return helper(n - 1, 3, points, dp); // Start from the last day, with no activity performed on the previous day
        }
    
        private static int helper(int day, int last, int[][] points, int[][] dp) {
            if (day == -1) return 0; // Base case: No days left, no points
    
            if (dp[day][last] != -1) return dp[day][last];
    
            int maxPoints = 0;
            for (int activity = 0; activity < 3; activity++) {
                if (activity != last) { // Ensure no consecutive same activity
                    int currPoints = points[day][activity] + helper(day - 1, activity, points, dp);
                    maxPoints = Math.max(maxPoints, currPoints);
                }
            }
    
            dp[day][last] = maxPoints;
            return maxPoints;
        }
        public static void main(String[] args) {
            int[][]arr={{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
            System.out.println(ninjaTraining(3,arr));
    }

}
