class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n= nums.length;

        for(int i=0;i<n;i++){
            que.add(nums[i]);
            if(que.size()>k){
                que.poll();
            }
        }

        return que.peek();
        
    }
}
