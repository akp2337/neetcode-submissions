class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int i=0,j=0;
        int max = nums[0];
        while(j<n-1){

            if (max == 0) {
                return false;
            }

            max--;
            j++;

            max = Math.max(max, nums[j]);

        }
        return true;
        
    }
}
