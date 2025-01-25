package DP;

public class NinjaAndFriends {
    class Solution {
        private int[][][] memo;
        private int n;
        private int m;
        
        public int cherryPickup(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            memo = new int[n][m][m];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        memo[i][j][k] = -1;
                    }
                }
            }
            
            return dfs(grid, 0, 0, m - 1);
        }
        
        private int dfs(int[][] grid, int r, int c1, int c2) {
            if (r >= n) {
                return 0;
            }
            
            if (memo[r][c1][c2]!= -1) {
                return memo[r][c1][c2];
            }
            
            int maxCherries = 0;
            for (int nextC1 = Math.max(0, c1 - 1); nextC1 <= Math.min(m - 1, c1 + 1); nextC1++) {
                for (int nextC2 = Math.max(0, c2 - 1); nextC2 <= Math.min(m - 1, c2 + 1); nextC2++) {
                    if (nextC1 <= nextC2) {
                        int cherries = grid[r][c1] + grid[r][c2];
                        if (c1 == c2) {
                            cherries /= 2;
                        }
                        maxCherries = Math.max(maxCherries, cherries + dfs(grid, r + 1, nextC1, nextC2));
                    }
                }
            }
            
            memo[r][c1][c2] = maxCherries;
            return maxCherries;
        }
    }
    
}
// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][][] dp = new int[n][m][m];
        
//         // Initialize the first row
//         for (int j1 = 0; j1 < m; j1++) {
//             for (int j2 = j1; j2 < m; j2++) {
//                 int cherries = grid[0][j1] + grid[0][j2];
//                 if (j1 == j2) {
//                     cherries /= 2;
//                 }
//                 dp[0][j1][j2] = cherries;
//             }
//         }
        
//         // Fill up the dp table
//         for (int i = 1; i < n; i++) {
//             for (int j1 = 0; j1 < m; j1++) {
//                 for (int j2 = j1; j2 < m; j2++) {
//                     int maxCherries = 0;
//                     for (int prevJ1 = Math.max(0, j1 - 1); prevJ1 <= Math.min(m - 1, j1 + 1); prevJ1++) {
//                         for (int prevJ2 = Math.max(0, j2 - 1); prevJ2 <= Math.min(m - 1, j2 + 1); prevJ2++) {
//                             if (prevJ1 <= prevJ2) {
//                                 maxCherries = Math.max(maxCherries, dp[i - 1][prevJ1][prevJ2]);
//                             }
//                         }
//                     }
//                     int cherries = grid[i][j1] + grid[i][j2];
//                     if (j1 == j2) {
//                         cherries /= 2;
//                     }
//                     dp[i][j1][j2] = maxCherries + cherries;
//                 }
//             }
//         }
        
//         // Find the maximum cherries in the last row
//         int maxCherries = 0;
//         for (int j1 = 0; j1 < m; j1++) {
//             for (int j2 = j1; j2 < m; j2++) {
//                 maxCherries = Math.max(maxCherries, dp[n - 1][j1][j2]);
//             }
//         }
        
//         return maxCherries;
//     }
// }
