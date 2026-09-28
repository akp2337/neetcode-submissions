class Solution {

    int [] dx = new int []{1,-1,0,0};
    int [] dy = new int []{0,0,-1,1};
    int r;
    int c;
    int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {

        r= grid.length;
        c= grid[0].length;

        int area=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    area =dfs(i,j,grid, 0);
                    maxArea= Math.max(area,maxArea);
                }

            }
        }
        return maxArea;
        
    }

    public int dfs(int i, int j, int[][]grid, int area){

        if(i<0||j<0 || i>=r || j>=c || grid [i][j]!=1){
            return area;
        }
        grid[i][j]=2;
        area+=1;

        for(int k=0;k<4;k++){
            int ii= i+dx[k];
            int jj = j+dy[k];
            area=dfs(ii,jj,grid,area);
        }
        return area;
    }
}
