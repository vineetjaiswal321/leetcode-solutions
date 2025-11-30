class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp=findPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    void unionBySize(int u, int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);

        if(ulp_u==ulp_v)    return;

        if(size.get(ulp_u)<size.get(ulp_v)){
            //connect smaller size to larger size
            parent.set(ulp_u, ulp_v);   //u->v
            size.set(ulp_v, size.get(ulp_v)+size.get(ulp_u));   //size of v = size of u + size of v
        }
        else{
            //kissi ko kissi se 
            parent.set(ulp_v, ulp_u);   //v->u
            size.set(ulp_u, size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] edges) {
        DisjointSet ds=new DisjointSet(n);

        int extraEdge=0;
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            if(ds.findPar(u)!=ds.findPar(v)){
                ds.unionBySize(u, v);
            }
            else{
                extraEdge+=1;
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cnt+=1;
            }
        }

        int ans=cnt-1;
        if(ans>extraEdge)   return -1;
        return ans;
    }
}