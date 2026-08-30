class Solution {
    public int countSubstrings(String s) {
        StringBuilder s2= new StringBuilder(s);
        s2.reverse();
        String s1= s2.toString();

        int n=s.length();
        int m=n;

        int [][] dp = new int [n+1][m+1];

        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }

        Integer max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if( maxPal(s,s1,i,j,dp)==1){
                    max ++;
                }
            }
        }
        return max;
    }

    public int maxPal(String s, String s1, int n, int m, int[][] dp){

        if(n>=m){
            return 1;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(s.charAt(n)==s.charAt(m)){
            dp[n][m] =  maxPal(s,s1,n+1,m-1,dp);
        }else{
            dp[n][m]= 0;
        }
        return dp[n][m];
    }
}
