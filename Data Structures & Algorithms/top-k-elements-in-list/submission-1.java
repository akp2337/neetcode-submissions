class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> list  = new ArrayList<>();

        Map<Integer , Integer> map = new HashMap<>();
        for(int num :nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            pq.offer(new int[]{entry.getKey(),entry.getValue()});
            if(pq.size()>k){
                pq.poll();

            }
        }

        while(!pq.isEmpty()){
            list.add(pq.poll()[0]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
