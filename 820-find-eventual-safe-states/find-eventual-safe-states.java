class Solution {
    public boolean dfsCheck(int in, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] check){
        vis[in]=true;
        pathVis[in]=true;

        for(int i : graph[in]){
            if(!vis[i]){
                if(dfsCheck(i, graph, vis, pathVis, check)){
                    check[in]=true;
                    return true;
                }
            }
            else if(pathVis[i]){
                check[in]=true;
                return true;
            }
        }
        pathVis[in]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> safeNode=new ArrayList<>();

        boolean[] vis=new boolean[n];
        boolean[] pathVis=new boolean[n];
        boolean[] check=new boolean[n]; //notSafe
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }

        for(int i=0;i<n;i++){
            if(!check[i]){   //false -> safe
                safeNode.add(i);
            }
        }
        return safeNode;
    }
}