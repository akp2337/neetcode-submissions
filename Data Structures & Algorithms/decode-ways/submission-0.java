class Solution {
    public int numDecodings(String s) {

        int n= s.length();

        int [] dp = new int [n+1];

        if(s.charAt(0)=='0'){
            return 0;
        }

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){

            int temp =s.charAt(i-1)-'0';

            if(1<=temp && temp<=9){
                dp[i]+=dp[i-1];
            }

            int two = (s.charAt(i-2)-'0') *10 + s.charAt(i-1)-'0';

            if(10<=two && two<=26){
                dp[i] +=dp[i-2];
            }
        }
        return dp[n];
        
    }
}
