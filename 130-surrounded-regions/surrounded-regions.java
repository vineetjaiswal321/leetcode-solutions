class Solution {
    public void dfs(int row, int col, boolean[][] vis, char[][] board){
        int m=board.length;
        int n=board[0].length;
        vis[row][col]=true;
        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                if(Math.abs(delrow) + Math.abs(delcol)!=1)  continue;
                int newRow=row+delrow;
                int newCol=col+delcol;
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !vis[newRow][newCol] && board[newRow][newCol]=='O'){
                    dfs(newRow, newCol, vis, board);
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(!vis[i][j] && board[i][j]=='O'){
                        dfs(i, j, vis, board);
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}