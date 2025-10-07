class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int i, int j, boolean[][] visted, char[][] grid)
    {
        int m=grid.length, n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i, j));
        visted[i][j]=true;
        while(q.size()>0)
        {
            Pair front=q.remove();
            int row=front.row;
            int col=front.col;

            //top : row-1, col
            if(row>0 && !visted[row-1][col] && grid[row-1][col]=='1')
            {
                q.add(new Pair(row-1, col));
                visted[row-1][col]=true;
            }

            //bottom : row+1, col
            if(row+1<m && !visted[row+1][col] && grid[row+1][col]=='1')
            {
                q.add(new Pair(row+1, col));
                visted[row+1][col]=true; 
            }

            //left : row, col-1
            if(col>0 && !visted[row][col-1] && grid[row][col-1]=='1')
            {
                q.add(new Pair(row, col-1));
                visted[row][col-1]=true; 
            }

            //right : row, col+1
            if(col+1<n && !visted[row][col+1] && grid[row][col+1]=='1')
            {
                q.add(new Pair(row, col+1));
                visted[row][col+1]=true; 
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length, count=0;
        boolean[][] visted=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !visted[i][j])
                {
                    bfs(i, j, visted, grid);
                    count++;
                }
            }
        }
        return count;
    }
}