class Solution {
    public int[] findOrder(int V, int[][] edges) {
        //Topological Sort
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)    adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                inDegree[j]+=1;
            }
        }
        //BFS
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)  q.add(i);
        }

        while(q.size()>0){
            int node=q.poll();  
            topo.add(node);
            for(int i : adj.get(node)){
                inDegree[i]-=1;
                if(inDegree[i]==0)  q.add(i);
            }
        }

        if(topo.size()!=V)   return new int[0];   //cyclic
        int[] res=new int[topo.size()];
        for(int i=0;i<topo.size();i++){
            res[i]=topo.get(i);
        }
        return res;
    }
}