class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        // s1+s2= sum
        // s1-s2= 2
        // 2s1=sum+2
        // s1=(sum+2)/2;

        int n= nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int tar= (sum+target)/2;

        // Impossible to reach target
        if (Math.abs(target) > sum) {
            return 0;
        }

        // sum + target must be even
        if ((sum + target) % 2 != 0) {
            return 0;
        }


        int [][] t= new int [n+1][tar+1];

        for(int [] arr: t){
            Arrays.fill(arr,-1);
        }

        return solve(t,nums,n,tar);
        
    }

    public int solve(int [][] t, int [] nums,
                            int n, int tar){

        if(n == 0){
    return tar == 0 ? 1 : 0;
}

        if(t[n][tar]!=-1){
            return t[n][tar];
        }

        if(nums[n-1]<=tar){
            t[n][tar]= solve(t,nums,n-1,tar-nums[n-1])+
            solve(t,nums,n-1,tar);
        }else{
            t[n][tar]= solve(t,nums,n-1,tar);
        }
        return t[n][tar];
    }
}
