package DP;

import java.util.Arrays;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
      int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return paths(dp,grid,m-1,n-1);
    }
    public static int paths(int[][]dp,int[][] grid,int m,int n){
        if(m==0 && n==0){
            return grid[m][n];
        }if(m<0|| n<0){
            return Integer.MAX_VALUE;
        }if(dp[m][n]!=-1){
            return dp[m][n];
        } 
        int left= grid[m][n]+paths(dp,grid, m-1, n);
        int right=grid[m][n]+paths(dp,grid, m, n-1);
        return dp[m][n]=Math.min(left,right);
    }public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
