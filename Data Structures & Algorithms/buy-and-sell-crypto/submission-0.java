class Solution {
    public int maxProfit(int[] prices) {

        int ans=0;
        int n= prices.length;

        for(int i =0;i<n;i++){
            int temp =i;
            for(int j=i;j<n;j++){

                if(prices[j]>prices[i]){
                    if(prices[temp]<prices[j]){
                        temp=j;
                    }
                }

            }
            if(temp!=i){
                ans= Math.max(ans, prices[temp]-prices[i]);
            }
        }
        return ans;
 
    }
}
