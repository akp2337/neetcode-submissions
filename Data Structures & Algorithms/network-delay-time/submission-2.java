class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0;i<=n ;i++){
            adj.add(new ArrayList<>());
        }

   
        for(int [] t : times){
            int u = t[0];
            int v = t[1];
            int time= t[2];
            adj.get(u).add(new int []{v,time});
        }
        

        int []dist= new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int []> que = new PriorityQueue<>((a,b)->a[0]-b[0]);

        dist[k]=0;
        que.offer(new int []{0,k});

        while(!que.isEmpty()){
            int [] node = que.poll();
            int cNode= node[1];
            int cd= node[0];

            if(cd>dist[cNode]){
                continue;
            }
            for(int [] nbr:adj.get(cNode)){

                int nn =nbr[0];
                int newD= cd+nbr[1];

                if(newD<dist[nn]){
                    dist[nn]=newD;
                    que.offer(new int []{newD,nn});
                }
            }
        }

        int ans=0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
               return -1;
            }
            ans= Math.max(ans,dist[i]);
        }

        return ans;
        
    }
}
