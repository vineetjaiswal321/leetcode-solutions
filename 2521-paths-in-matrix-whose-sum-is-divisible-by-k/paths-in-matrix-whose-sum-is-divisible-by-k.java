class Solution {
    static int mod=(int)(1e9+7);
    public int noOfPath(int i, int j, int[][] grid, int k, int sum, int[][][] dp){
        int m=grid.length;
        int n=grid[0].length;
        if(i>=m || j>=n)    return 0;
        sum+=grid[i][j]%k;
        if(i==m-1 && j==n-1){
            if(sum%k==0)    return 1;
            return 0;
        }
        if(dp[i][j][sum%k]!=-1)   return dp[i][j][sum%k];
                    
        int down=noOfPath(i+1, j, grid, k, sum%k, dp);
        int right=noOfPath(i, j+1, grid, k, sum%k, dp);

        return dp[i][j][sum%k]=(down+right)%mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][k];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)    Arrays.fill(dp[i][j], -1);
        }
        return noOfPath(0, 0, grid, k, 0, dp);
    }
}