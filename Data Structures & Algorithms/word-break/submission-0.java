class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n= s.length();

        Set<String> dict= new HashSet<>(wordDict);

        boolean [] dp = new boolean [n+1];

        dp[0]=true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){

                String word = s.substring(j,i);
                if(dp[j]&& dict.contains(word)){
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}
