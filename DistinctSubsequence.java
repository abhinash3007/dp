package DP;

import java.util.Arrays;

public class DistinctSubsequence {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
    //     int[][]dp=new int[m+1][n+1];
    //     for(int i=0;i<=m;i++){
    //         for(int j=0;j<=n;j++){
    //             if(j==0){
    //                 dp[i][j]=1;
    //             }else if(i==0){
    //                 dp[i][j]=0;
    //             }else if (s.charAt(i - 1) == t.charAt(j - 1)) {
    //                 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    //             }else{
    //                 dp[i][j]= dp[i-1][j];
    //             }
    //         }
    //     }return dp[m][n];
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);   
       }
        return helper(s,t,m,n,dp);
    }
    public int helper(String s, String t,int m,int n,int[][]dp){
        if(n==0){
            return 1;
        }
        if(m==0){
            return 0;
        }if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s.charAt(m-1)==t.charAt(n-1)){
            dp[m][n]=helper(s,t,m-1, n-1,dp) +  helper(s,t,m-1, n, dp);
        }else{
            dp[m][n]= helper(s,t,m-1, n,dp);
        }return dp[m][n];
    }public static void main(String[] args) {
        
    }
}
