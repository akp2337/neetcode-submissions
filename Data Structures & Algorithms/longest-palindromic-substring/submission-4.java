class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        int max = 0;
        int start = 0;

        Boolean[][] dp = new Boolean[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (solve(s, i, j, dp)) {

                    int length = j - i + 1;

                    if (length > max) {
                        max = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }


    public boolean solve(
        String s,
        int n,
        int m,
        Boolean[][] dp
    ) {

        if (n >= m) {
            return true;
        }

        // Already calculated
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (s.charAt(n) == s.charAt(m)) {

            dp[n][m] = solve(
                s,
                n + 1,
                m - 1,
                dp
            );

        } else {

            dp[n][m] = false;
        }

        return dp[n][m];
    }
}