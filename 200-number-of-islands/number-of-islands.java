class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public void bfs(int row, int col, boolean[][] vis, char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col]=true;

        while(q.size()>0){
            Pair p=q.poll();
            int r=p.i;
            int c=p.j;

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow) + Math.abs(delcol) != 1) continue;
                    int newR=r+delrow;
                    int newC=c+delcol;
                    if(newR>=0 && newR<m && newC>=0 && newC<n && !vis[newR][newC] && grid[newR][newC]=='1'){
                        vis[newR][newC]=true;
                        q.add(new Pair(newR, newC));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!vis[i][j] && grid[i][j]=='1'){
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}