class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int jump=0;
        int cEnd=0;
        int maxDist=0;

        for(int i =0;i<n-1;i++){

            maxDist= Math.max(maxDist, i+nums[i]);

            if(i==cEnd){
                jump+=1;
                cEnd=maxDist;
            }

        }
        return jump;
      
    }
}
