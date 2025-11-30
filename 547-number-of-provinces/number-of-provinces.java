class DisjointSet{
    ArrayList<Integer> size=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        
        int ulp=findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    void unionBySize(int u, int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        
        if(ulp_u==ulp_v)    return;
        
        if(size.get(ulp_u)<size.get(ulp_v)){
            //smaller ko  larger se connect karna hai : u->v
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            //kissi ko kissi se connect kr do
            parent.set(ulp_v, ulp_u);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        DisjointSet ds=new DisjointSet(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1){
                    if(ds.findUPar(i)!=ds.findUPar(j)){
                        ds.unionBySize(i, j);
                    }
                }
            }
        }
        
        int cnt=0;
        for(int i=0;i<V;i++){
            if(ds.parent.get(i)==i) cnt+=1;
        }
        return cnt;
    }
}