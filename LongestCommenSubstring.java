package DP;

public class LongestCommenSubstring {
    public static int longestCommonSubstring(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int maxLength=0;
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
        // int m=text1.length();
        // int n=text2.length();
        // if(m==0 || n==0){
        // return 0;
        // }
        // return helper(text1,text2,m,n);
        // }
        // public int helper(String text1, String text2,int m,int n){
        // if(m==0 || n==0){
        // return 0;
        // }
        // if(text1.charAt(m-1)==text2.charAt(n-1)){
        // return 1+helper(text1,text2,m-1,n-1);
        // }
        // return Math.max(helper(text1,text2,m-1,n),helper(text1,text2,m,n-1));
    }public static void main(String[] args) {
        String text1 = "ABCDGH";
        String text2 = "ACDGHR";
        System.out.println(longestCommonSubstring(text1, text2));
    }
}
