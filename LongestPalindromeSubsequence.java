package DP;

import java.util.Arrays;

public class LongestPalindromeSubsequence {
    public static int longest(String s){
        String s2 = new StringBuilder(s).reverse().toString();
        // int[][]dp=new int[s.length()+1][s2.length()+1];
        // for(int i=0;i<=s.length();i++){
        //     for(int j=0;j<=s2.length();j++){
        //         if(i==0){
        //             dp[i][j]=0;
        //         }else if(j==0){
        //             dp[i][j]=0;
        //         }else if(s.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j]=1+dp[i-1][j-1];
        //         }else{
        //             dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }return dp[s.length()][s2.length()];
        int[][]dp=new int[s.length()+1][s2.length()+1];
        int m=s.length();
        int n=s2.length();
        if(m==0 || n==0){
            return 0;
        }for (int[] row : dp) {
        Arrays.fill(row, -1);
    }
        return helper(s,s2,m,n,dp);
    }
    public static int helper(String text1, String text2,int m,int n,int[][]dp){
        if(m==0 || n==0){
            return 0;
        }if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(text1.charAt(m-1)==text2.charAt(n-1)){
            return dp[m][n]= 1+helper(text1,text2,m-1,n-1,dp);
        }
        return dp[m][n]=Math.max(helper(text1,text2,m-1,n,dp),helper(text1,text2,m,n-1,dp));
    }public static void main(String[] args) {
        System.out.println(longest("bbbab"));
    }
}
