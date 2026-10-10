class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int ans=0;

        for(int num:nums){

            if(!set.contains(num-1)){
                int curr=num;
                int lengt=1;
                while(set.contains(curr+1)){
                    curr++;
                    lengt++;
                }

                ans=Math.max(ans,lengt);
            }
            
        }
        return ans;
        
    }
}
