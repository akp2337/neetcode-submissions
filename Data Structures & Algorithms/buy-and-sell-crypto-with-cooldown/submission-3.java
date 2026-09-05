class Solution {
    public int maxProfit(int[] prices) {

        int n= prices.length;

        if(n<=1){
            return 0;
        }

        int hold= -prices[0];
        int sold = 0;
        int rest =0;

        for(int i=1;i<n;i++){

            int oldHold=hold;
            int oldSold= sold;
            int oldRest= rest;



            hold = Math.max(oldHold, oldRest-prices[i]);
            sold = oldHold + prices[i];

            rest = Math.max(oldSold,oldRest);
        }
        return Math.max(sold, rest);
    

    }




        
 
}
