class Solution {
    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int [][]t = new int [n+1][amount+1];

        for(int [] arr: t){
            Arrays.fill(arr,-1);
        } 

        int ans= solve(coins,n,amount,t);  
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int solve(int [] coins, int n, int target, int[][] t){
        if(target==0){
            return 0;
        }

        if(n==0){
            return Integer.MAX_VALUE;
        }

        if(t[n][target]!=-1){
            return t[n][target];
        }

        if(coins[n-1]<=target){



            int take = solve(
                coins,
                n,
                target - coins[n - 1],
                t
            );

            int skip = solve(
                coins,
                n - 1,
                target,
                t
            );

            if (take == Integer.MAX_VALUE) {

                t[n][target] = skip;

            } else {

                t[n][target] = Math.min(
                    1 + take,
                    skip
                );
            }
            // t[n][target] = Math.min(1+solve(coins,n,target-coins[n-1],t),
            //                 solve(coins,n-1,target,t));
        }else{
            t[n][target]= solve(coins,n-1,target,t);
        }
        return t[n][target];
    }     
    
}
