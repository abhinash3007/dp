package DP;
import java.util.*;
public class Fibbonacci {
    public static int fib(int n,int[]dp){
        Arrays.fill(dp,-1);
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        };
        dp[n]=fib(n-1, dp)+fib(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        int[]dp=new int[n+1]; 
        System.out.println(fib(n, dp));
    }
}
