package DP;

import java.util.*;

public class TriangularMaxPath {
    public static int tri(List<List<Integer>> triangle){
        int[][]dp=new int[triangle.size()][triangle.size()];
        for (int[] i:dp) {
            Arrays.fill(i, -1);
        }
        return helper(dp,0,0,triangle);
    }
    public static int helper(int[][]dp,int r,int c,List<List<Integer>> triangle){
        if(r==triangle.size()-1){
            return triangle.get(r).get(c);
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int moveCol=triangle.get(r).get(c)+helper(dp, r+1, c+1, triangle);
        int notMoveCol=triangle.get(r).get(c)+helper(dp, r+1, c, triangle);
        return dp[r][c]=Math.min(moveCol, notMoveCol);
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(5,6,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(tri(triangle));
    }
}

//     tabulation
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
        
//         // Initialize the last row of dp with the values from the last row of the triangle
//         for (int i = 0; i < n; i++) {
//             dp[n-1][i] = triangle.get(n-1).get(i);
//         }
        
//         // Fill up the dp table in a bottom-up manner
//         for (int i = n - 2; i >= 0; i--) {
//             for (int j = 0; j <= i; j++) {
//                 dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
//             }
//         }
        
//         // The minimum path sum is stored in dp[0][0]
//         return dp[0][0];
//     }
// }
