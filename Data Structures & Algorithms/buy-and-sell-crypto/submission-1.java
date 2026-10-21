class Solution {
    public int maxProfit(int[] prices) {

        int ans=0;
        int n= prices.length;
        int minPrice= prices[0];
        for(int i=1;i<n;i++){
            minPrice=Math.min(minPrice, prices[i]);
            ans = Math.max(ans,prices[i]-minPrice);
        }
        return ans;
 
    }
}
