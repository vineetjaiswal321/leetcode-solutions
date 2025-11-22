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
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++)    Arrays.fill(dist[i], (int)(1e9));
        dist[0][0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.dist-b.dist);
        pq.add(new Pair(0, 0, 0));

        while(pq.size()>0){
            Pair p=pq.poll();
            int row=p.row;
            int col=p.col;
            int d=p.dist;

            int[] delrow={-1, 0, 1, 0};
            int[] delcol={0, 1, 0, -1};

            for(int i=0;i<4;i++){
                int newRow=row+delrow[i];
                int newCol=col+delcol[i];
                
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    int newEfforts=Math.max(d, Math.abs(heights[newRow][newCol]-heights[row][col]));
                    if(newEfforts<dist[newRow][newCol]){
                        dist[newRow][newCol]=newEfforts;
                        pq.add(new Pair(newRow, newCol, dist[newRow][newCol]));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}