class Solution {
    public boolean dfs(int in, boolean[] vis, boolean[] pathVis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[in]=true;
        pathVis[in]=true;
        for(int i : adj.get(in)){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, st, adj))    return true;
            }
            else if(pathVis[i]) return true;
        }

        pathVis[in]=false;
        st.add(in);
        st.add(in);//1 0
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        //Topological Sort
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)    adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        //DFS
        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, st, adj))   return false;
            }
        }
        return true;
        // ArrayList<Integer> topo=new ArrayList<>();
        // while(st.size()>0){
        //     topo.add(st.pop());
        // }

        // return !(topo.size()==V);   // if topo size equals V then there is no cycle 
    }
}