class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>> adjR=new ArrayList<>();
        for(int i=0;i<n;i++)    adjR.add(new ArrayList<>());
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j : graph[i]){
                adjR.get(j).add(i);
                inDegree[i]+=1;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)  q.add(i);
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(q.size()>0){
            int node=q.poll();
            topo.add(node);

            for(int i : adjR.get(node)){
                inDegree[i]-=1;
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}