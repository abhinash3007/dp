package DP;

import java.util.Arrays;

public class HouseRobbers2 {
     public int rob(int[] nums) {
        int[]dp=new int[nums.length];
        Arrays.fill(dp,-1);
       return  helper(nums,nums.length-1,dp);
    }
    public int helper(int[]nums,int n,int []dp){
        
        if(n==0){
            return nums[0];
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick=nums[n]+helper(nums,n-2,dp);
        int notPick=0+helper(nums,n-1,dp);
        dp[n]=Math.max(pick,notPick);
        return dp[n];
    }
}
