class Solution {
    public void dfs(int[][] image, int sr, int sc, boolean[][] vis, int color, int ic){
        int m=image.length, n=image[0].length;
        vis[sr][sc]=true;
        image[sr][sc]=color;

        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1; delcol<=1;delcol++){
                if(Math.abs(delrow) + Math.abs(delcol)!=1)  continue;
                int newRow=sr+delrow;
                int newCol=sc+delcol;
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && image[newRow][newCol]==ic && !vis[newRow][newCol])
                {
                    dfs(image, newRow, newCol, vis, color, ic);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ic=image[sr][sc];
        int m=image.length, n=image[0].length;
        boolean[][] vis=new boolean[m][n];
        dfs(image, sr, sc, vis, color, ic);
        return image;
    }
}