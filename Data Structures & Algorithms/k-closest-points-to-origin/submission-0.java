class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            return b[2]-a[2];
        });

        int n= points.length;

        for(int i=0;i<n;i++){

            int [] point = points[i];

            int d = point[0] * point[0] + point[1] * point[1];
            que.add(new int []{point[0], point[1],d});

            if(que.size()>k){
                que.poll();
            }
            

        }

        int [][] ans = new int [k][2];
        int i=k-1;
        while(!que.isEmpty()){

            int [] temp = que.poll();

            ans[i]= new int [] {temp[0], temp[1]};
            i--;

        }

        return ans;
        

    }
}
