package DP;
import java.util.*;;
public class FrogJump {
    public static int jump(int n,int[]dp,int arr[]){
        if(n==0){
            return 0;
        }if(dp[n]!=-1){
            return dp[n];
        };
        int left=jump(n-1, dp,arr)+Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=jump(n-2, dp,arr)+Math.abs(arr[n]-arr[n-2]);
        }
        return dp[n]=Math.min(left, right);
    }public static void main(String[] args) {
        int[]arr={20,30,40,20};
        int[]dp=new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(jump(arr.length-1 , dp, arr));
    }
}
