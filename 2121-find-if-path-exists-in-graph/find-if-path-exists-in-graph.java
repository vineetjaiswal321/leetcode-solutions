class Solution {
    public void bfs(int source, boolean[] visted, List<List<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        visted[source]=true;
        while(q.size()>0)
        {
            int front=q.remove();
            for(int elem : adj.get(front))
            {
                if(!visted[elem])
                {
                    q.add(elem);
                    visted[elem]=true;
                }   
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visted=new boolean[n];
        bfs(source, visted, adj);
        return visted[destination];
    }
}