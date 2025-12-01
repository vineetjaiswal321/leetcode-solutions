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
    public boolean isValid(int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        DisjointSet ds=new DisjointSet(m*n);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)   continue;
                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};
                for(int k=0;k<4;k++){
                    int adjR=i+dr[k];
                    int adjC=j+dc[k];
                    if(isValid(adjR, adjC, m, n) && grid[adjR][adjC]==1){
                        int nodeNo=i*n+j;
                        int adjNodeNo=adjR*n+adjC;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int maxIs=Integer.MIN_VALUE;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)   continue;
                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};
                for(int k=0;k<4;k++){
                    int adjR=i+dr[k];
                    int adjC=j+dc[k];
                    if(isValid(adjR, adjC, m, n) && grid[adjR][adjC]==1){
                        int adjNodeNo=adjR*n+adjC;
                        int ulp=ds.findUPar(adjNodeNo);
                        set.add(ulp);
                    }
                }
                int cnt=1;
                for(int elem : set){
                    cnt+=ds.size.get(elem);
                }
                set.clear();
                maxIs=Math.max(maxIs, cnt);
            }
        }
        return (maxIs == Integer.MIN_VALUE) ? m*n : maxIs;
    }
}