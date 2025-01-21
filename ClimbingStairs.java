package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static int climbing(int n,int[]dp){
        Arrays.fill(dp,-1);
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        };
        return dp[n]=climbing(n-1, dp)+climbing(n-2, dp);
        //return dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        int[]dp=new int[n+1]; 
        System.out.println(climbing(n, dp));
    }
}
