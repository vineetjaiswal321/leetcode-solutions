class Solution {
    public boolean canFinish(int V, int[][] edges) {
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

        return (topo.size()==V);
    }
}