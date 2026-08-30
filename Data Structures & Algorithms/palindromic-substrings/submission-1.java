class Solution {
    public int countSubstrings(String s) {
        int n=s.length();

        int [][] dp = new int [n+1][n+1];

        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }

        Integer max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if( maxPal(s,i,j,dp)==1){
                    max ++;
                }
            }
        }
        return max;
    }

    public int maxPal(String s, int n, int m, int[][] dp){

        if(n>=m){
            return 1;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(s.charAt(n)==s.charAt(m)){
            dp[n][m] =  maxPal(s,n+1,m-1,dp);
        }else{
            dp[n][m]= 0;
        }
        return dp[n][m];
    }
}
