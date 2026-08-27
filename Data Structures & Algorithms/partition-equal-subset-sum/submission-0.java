class Solution {
    public boolean canPartition(int[] nums) {

        int n= nums.length;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        int target= sum/2;

        boolean [][]dp = new boolean [n+1][target+1];

        // for(int [] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        return isAvailable(dp,nums,n,target);
        
    }


    public boolean isAvailable(boolean[][]dp, int[] nums, int n, int target){
        if(target==0){
            return true;
        }

        if(n==0){
            return false;
        }
        if(dp[n][target]){
            return dp[n][target];
        }

        if(nums[n-1]<=target){
            dp[n][target]= isAvailable(dp,nums,n-1,target-nums[n-1]) || 
            isAvailable(dp,nums,n-1,target);
        }else{
            dp[n][target]=isAvailable(dp,nums,n-1,target);
        }
        return dp[n][target];
    }
}
