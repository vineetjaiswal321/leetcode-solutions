class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row, int col, int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] highestPeak(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        boolean[][] vis=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=true;
                    mat[i][j]=0;
                }
            }
        }

        while(q.size()>0){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int dis=p.dis;

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow) + Math.abs(delcol)!=1)  continue;
                    int newRow=row+delrow;
                    int newCol=col+delcol;
                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !vis[newRow][newCol] && mat[newRow][newCol]==0){
                        q.add(new Pair(newRow, newCol, dis+1));
                        mat[newRow][newCol]=dis+1;
                        vis[newRow][newCol]=true;
                    }
                }
            }
        }
        return mat;
    }
}