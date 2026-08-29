class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n= text1.length();
        int m = text2.length();

        int [][]dp = new int [n+1] [m+1];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return solve(dp,text1,text2,n,m);
        
    }

    private int solve(int [][]dp, String text1, String text2, int n ,int m){

        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(text1.charAt(n-1)==text2.charAt(m-1)){
            dp[n][m]= 1+ solve(dp,text1,text2,n-1,m-1);
        }else{
            dp[n][m]= Math.max(solve(dp,text1,text2,n-1,m), solve(dp,text1,text2,n,m-1));
        }
        return dp[n][m];

    }
}
