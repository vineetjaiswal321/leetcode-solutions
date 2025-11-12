class Solution {
    public void dfs(int row, int col, boolean[][] vis, int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=true;

        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                if(Math.abs(delrow) + Math.abs(delcol)!=1)  continue;
                int newRow=row+delrow;
                int newCol=col+delcol;
                if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && grid[newRow][newCol]==1 && !vis[newRow][newCol]){
                    dfs(newRow, newCol, vis, grid);
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1 && !vis[i][j]){
                        dfs(i, j, vis, grid);
                    }
                }
            }
        }   
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}