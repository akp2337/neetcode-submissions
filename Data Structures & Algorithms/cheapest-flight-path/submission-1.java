class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int []>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            int sr=flight[0];
            int dstc=flight[1];
            int price=flight[2];
            adj.get(sr).add(new int []{dstc,price});
        }

        int[][] price = new int[n][k + 2];

        for(int i = 0; i < n; i++){
            Arrays.fill(price[i], Integer.MAX_VALUE);
        }


        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->a[0]-b[0]);

        price[src][0]=0;
        que.offer(new int []{0,src,0});
        while(!que.isEmpty()){
            int [] temp = que.poll();
            int cp= temp[0];
            int cn= temp[1];
            int cst=temp[2];
            if(cn==dst){
                return cp;
            }

            if(cst==k+1){
                continue;
            }

            for(int [] nbr :adj.get(cn)){
                int newNbr= nbr[0];
                int nPrice=nbr[1]+cp;
                if(nPrice<price[newNbr][cst+1]){
                    price[newNbr][cst+1]=nPrice;
                    que.offer(new int [] {nPrice,newNbr,cst+1});
                }
            }
        }
        return -1;

    }
}
