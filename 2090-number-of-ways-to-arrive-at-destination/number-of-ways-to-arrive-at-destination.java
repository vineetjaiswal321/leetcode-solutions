class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        for(int[] road : roads){
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist, (long)(1e18));
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist, b.dist));
        pq.add(new Pair(0, 0));
        int mod=(int)(1e9 + 7);

        while(pq.size()>0){
            Pair p=pq.poll();
            int node=p.node;
            long dis=p.dist;

            if (dis > dist[node]) continue;
            for(Pair t : adj.get(node)){
                if(dis + t.dist < dist[t.node]){
                    dist[t.node]=dis+t.dist;
                    ways[t.node]=ways[node];
                    pq.add(new Pair(t.node, dist[t.node]));
                }
                else if(dis + t.dist==dist[t.node]){
                    ways[t.node]=(ways[t.node] + ways[node])%mod;
                }
            }
        }
        return (ways[n-1])%mod;
    }
}