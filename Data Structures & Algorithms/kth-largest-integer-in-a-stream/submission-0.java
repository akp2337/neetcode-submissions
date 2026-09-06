class KthLargest {

    PriorityQueue<Integer> que = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        int m= nums.length;
        for(int i=0;i<m;i++){
            que.add(nums[i]);
            if(que.size()>k){
                que.poll();
            }
        }
        
    }
    
    public int add(int val) {

        que.add(val);
        if(que.size()>k){
            que.poll();
        }

        return que.peek();
        
    }
}
