class Solution {
    int [] dx = new int []{1,-1,0,0};
    int [] dy = new int []{0,0,-1,1};
    int r;
    int c;
    public int orangesRotting(int[][] grid) {

        r= grid.length;
        c=grid[0].length;

        Queue<int []> que = new LinkedList<>();
        int fresh=0;

        int ans=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    que.offer(new int []{i,j});
                }else if(grid[i][j]==1){
                    fresh+=1;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        if(que.size()==0){
            return -1;
        }

        while(!que.isEmpty()){


            int update =0;

            int sz= que.size();
            for(int i=0;i<sz;i++){

                int [] rt= que.poll();
                for(int k=0;k<4;k++){
                    int ii= rt[0]+dx[k];
                    int jj= rt[1]+dy[k];

                    if(ii<0 || jj<0 || ii>=r || jj>=c || (grid[ii][jj]==2 || grid[ii][jj]==0)){
                        continue;
                    }
                    grid[ii][jj]=2;
                    que.offer(new int []{ii,jj});
                    update=1;
                }
            }
            ans+=update;

        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]== 1){
                    return -1;
                }
            }
        }
        return ans;
        
    }
}
