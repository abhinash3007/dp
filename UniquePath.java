package DP;

import java.util.Arrays;

import RECURSION.reverseArray;

public class UniquePath {
    public static int helper(int m,int n){
        int[][]dp=new int[m][n];
        for(int[]arr:dp){
            Arrays.fill(arr, -1);
        }
        return unique(dp,m-1, n-1);
    }
    public static int unique(int[][]dp,int m,int n){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        return dp[m][n]= unique(dp,m-1, n) + unique(dp,m, n-1);
    }public static void main(String[] args) {
        System.out.println(helper(3, 7));
    }
}
