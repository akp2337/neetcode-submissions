class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();

        if(n + m != s3.length()){
            return false;
        }

        Boolean[][] dp = new Boolean[n + 1][m + 1];

        return solve(s1, s2, s3, n, m, dp);
    }

    private boolean solve(String s1, String s2, String s3,
                          int n, int m, Boolean[][] dp) {

        if(n == 0 && m == 0){
            return true;
        }

        if(dp[n][m] != null){
            return dp[n][m];
        }

        int k = n + m - 1;

        boolean result = false;

        if(n > 0 && s1.charAt(n - 1) == s3.charAt(k)){
            result = solve(s1, s2, s3, n - 1, m, dp);
        }

        if(!result && m > 0 && s2.charAt(m - 1) == s3.charAt(k)){
            result = solve(s1, s2, s3, n, m - 1, dp);
        }

        dp[n][m] = result;

        return result;
    }
}
