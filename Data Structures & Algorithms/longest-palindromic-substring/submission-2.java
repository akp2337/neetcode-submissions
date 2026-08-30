class Solution {
    public String longestPalindrome(String s) {

        int n= s.length();

        int max=0;
        int start=0;

        int [] [] dp = new int [n][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        } 

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                if(solve( s,  i, j, dp)==1){

                    int length=j-i+1;

                    if(length>max){
                        max=length;
                        start=i;
                    }

                }
            }
        }

        return s.substring(start,start+max);

    }

    public int solve(String s,int n,int m, int [][] dp){
        if(n>=m){
            return 1;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }


        if(s.charAt(n)==s.charAt(m)){
            dp[n][m]= solve(s,n+1,m-1,dp);
        }else{
            dp[n][m]=0;
        }

        return dp[n][m];

    }
}
