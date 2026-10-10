class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n= nums.length;

        int [] num = new int [n];

        int prifix=1;

        for(int i=0;i<n;i++){
            num[i]=prifix;
            prifix*=nums[i];
        }

        int sufix=1;

        for(int i=n-1;i>=0;i--){
            num[i]*=sufix;
            sufix*=nums[i];
        }
        return num;
        
    }
}  
