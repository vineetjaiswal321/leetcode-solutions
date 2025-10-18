class Solution {
    public void bfs(int i, boolean[] visited, int[][] isConnected)
    {
        Queue<Integer> q=new LinkedList<>();
        int n=isConnected.length;
        q.add(i);
        visited[i]=true;
        while(q.size()>0)
        {
            int front=q.remove();
            for(int j=0;j<n;j++)
            {
                if(isConnected[front][j]==1 && !visited[j])
                {
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
    }
    public void dfs(int i, boolean[] visited, int[][] isConnected)
    {
        int n=isConnected.length;
        visited[i]=true;
        for(int j=0;j<n;j++)
        {
            if(isConnected[i][j]==1 && visited[j]==false)
            {
                dfs(j, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length, count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                //bfs(i, visited, isConnected);
                dfs(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }
}