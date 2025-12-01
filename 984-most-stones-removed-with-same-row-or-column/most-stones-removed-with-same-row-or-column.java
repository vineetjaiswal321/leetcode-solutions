class DisjointSet{
    List<Integer> par=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
            size.add(1);
        }
    }

    int findUPar(int node){
        if(par.get(node)==node){
            return node;
        }

        int ulp=findUPar(par.get(node));
        par.set(node, ulp);
        return ulp;
    }

    void unionBySize(int u, int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v)    return;

        if(size.get(ulp_u)<size.get(ulp_v)){
            //connect smaller to larger : u->v
            par.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            par.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v)+size.get(ulp_u));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;
        for(int[] stone : stones){
            maxRow=Math.max(maxRow, stone[0]);
            maxCol=Math.max(maxCol, stone[1]);
        }
        int offset=maxRow+1;

        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);

        Set<Integer> used=new HashSet<>();
        for(int[] stone : stones){
            int row=stone[0];
            int col=offset+stone[1];
            ds.unionBySize(row, col);
            used.add(row);
            used.add(col);
        }

        Set<Integer> set=new HashSet<>();
        for(int node : used){
            set.add(ds.findUPar(node));
        }
        int cnt=set.size();

        return n-cnt;
    }
}