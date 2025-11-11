class Solution {
    class Trio{
        int row;
        int col;
        int time;
        Trio(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<Trio> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2){
                    q.add(new Trio(i, j, 0));
                    vis[i][j]=true;
                }
            }
        }

        //bfs
        int maxTime=0;
        while(q.size()>0){
            Trio t=q.poll();
            int row=t.row;
            int col=t.col;
            int time=t.time;
            maxTime=Math.max(maxTime, time);
            for(int delrow=-1;delrow<=1;delrow++)
            {
                for(int delcol=-1;delcol<=1;delcol++)
                {
                    if(Math.abs(delrow) + Math.abs(delcol)!=1)  continue;
                    int newRow=row+delrow;
                    int newCol=col+delcol;
                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && !vis[newRow][newCol]){
                        q.add(new Trio(newRow, newCol, time+1));
                        grid[newRow][newCol]=2;
                        vis[newRow][newCol]=true;
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)   return -1;
            }
        }
        return maxTime;
    }
}