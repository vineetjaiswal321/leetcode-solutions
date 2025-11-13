class Solution {
    public boolean bfs(int in, int[][] graph, int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(in);
        color[in]=0;
        while(q.size()>0){
            int node=q.poll();
            int currCol=color[node];
            for(int i : graph[node]){
                if(color[i]==-1){
                    color[i]= (currCol==0) ? 1 : 0;
                    q.add(i);
                }
                else if(color[i]==currCol){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int in, int currColor, int[][] graph, int[] color){
        color[in]=currColor;

        for(int i : graph[in]){
            if(color[i]==-1){
                int newColor=(currColor==0) ? 1 : 0;
                if(!dfs(i, newColor, graph, color)) return false;
            }
            else if(color[i]==currColor){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] color=new int[m];
        Arrays.fill(color, -1);

        for(int i=0;i<m;i++){
            if(color[i]==-1){
                // if(!bfs(i, graph, color))   return false;
                if(!dfs(i, 0, graph, color))   return false;
            }
        }
        return true;
    }
}