class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)    dist[i][j]=0;
                else    dist[i][j]=(int)(1e9);
            }
        }
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int minCity=n;
        int cityNo=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    cnt+=1;
                }
            }
            if(cnt<=minCity){
                minCity=cnt;
                cityNo=i;
            }
        }
        return cityNo;
    }
}