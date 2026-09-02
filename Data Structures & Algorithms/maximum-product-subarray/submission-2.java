class Solution {
    public int maxProduct(int[] nums) {


        int n= nums.length;
        int res= nums[0];

        int max=nums[0];

        int min = nums[0];

        for(int i=1;i<n;i++){
            // max = Math.max(max+nums[i],nums[i]);


            int tempMax= Math.max(nums[i], Math.max(nums[i]*max,nums[i]*min));
            int tempMin = Math.min(nums[i], Math.min(nums[i]*min, nums[i]*max));

            max= tempMax;
            min= tempMin;
            res= Math.max(max,res);
        }

        return res;
        
    }
}
