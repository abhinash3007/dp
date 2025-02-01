package DP;

public class PrintLongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }int i=text1.length();
        int j=text2.length();
        StringBuilder s=new StringBuilder();
        while (i>0 && j>0) {
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                s.append(text1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }System.out.println(s.reverse().toString());
        return dp[text1.length()][text2.length()];
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
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
