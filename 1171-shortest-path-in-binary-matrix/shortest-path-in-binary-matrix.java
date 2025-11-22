class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1)   return -1;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++)    Arrays.fill(dist[i], (int)(1e9));
        dist[0][0]=1;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0, 0, 1));

        while(q.size()>0){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int d=p.dist;
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int newRow=row+delrow;
                    int newCol=col+delcol;
                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0 && d+1<dist[newRow][newCol]){
                        dist[newRow][newCol]=1+d;
                        if(newRow==n-1 && newCol==n-1)  break;
                        q.add(new Pair(newRow, newCol, dist[newRow][newCol]));
                    }
                }
            }
        }
        return dist[n-1][n-1]==(int)(1e9) ? -1 : dist[n-1][n-1];

    }
}