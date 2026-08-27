class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int ans = nums[0];
        int temp = nums[0];

        for(int i=1;i<n;i++){
            temp= Math.max(temp + nums[i], nums[i]);
            ans = Math.max(temp, ans);
        }
        return ans;
        
    }
}
