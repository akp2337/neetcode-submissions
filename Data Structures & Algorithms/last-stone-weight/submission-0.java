class Solution {
    public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->b-a);

    for(int i=0;i<stones.length;i++){
        que.add(stones[i]);
    }

    while(que.size()>1){

        int stoneX =que.poll();
        int stoneY = que.poll();
        que.add(stoneX-stoneY);
    }
    return que.poll();
        
        
    }
}
