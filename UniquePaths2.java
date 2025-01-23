package DP;

import java.util.Arrays;

public class UniquePaths2 {
     public static int helper(int[][]grid,int m,int n){
        int[][]dp=new int[m][n];
        for(int[]arr:dp){
            Arrays.fill(arr, -1);
        }
        return unique(grid,dp,m-1, n-1);
    }
    public static int unique(int[][]grid,int[][]dp,int m,int n){
        if(m==0 && n==0){
            return grid[m][n] == 0? 1 : 0;
        }
        if(m<0 || n<0 || grid[m][n]==1){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        return dp[m][n]= unique(grid,dp,m-1, n) + unique(grid,dp,m, n-1);
    }public static void main(String[] args) {
        int[][]grid={{0,0,0},
                     {0,1,0},
                     {0,0,0}};
        System.out.println(helper(grid,3, 3));
    }
}
