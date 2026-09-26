class Solution {

    int [] dx= new int []{1,-1,0,0};
    int [] dy = new int []{0,0,1,-1};
    int r;
    int c;
    public int numIslands(char[][] grid) {

        r= grid.length;
        c=grid[0].length;

        int count =0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
        
    }

    public void dfs(int i, int j , char[][] grid){

        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]!='1'){
            return;
        }

        grid[i][j]='2';

        for(int k=0;k<4;k++){
            int ii= i+dx[k];
            int jj = j+dy[k];
            dfs(ii,jj,grid);
        }
    }
}
