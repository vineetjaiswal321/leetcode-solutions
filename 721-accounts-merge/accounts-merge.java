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
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);

        Map<String, Integer> mp=new HashMap<>();
        //Connections
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!mp.containsKey(mail)){
                    mp.put(mail, i);
                }
                else{
                    ds.unionBySize(i, mp.get(mail));
                }
            }
        }

        ArrayList<ArrayList<String>> mergedMail=new ArrayList<>();
        for(int i=0;i<n;i++)    mergedMail.add(new ArrayList<>());

        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            String mail=entry.getKey();
            int node=entry.getValue();

            int ulp=ds.findUPar(node);
            mergedMail.get(ulp).add(mail);
        }

        List<List<String>> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMail.get(i).size()==0) continue;

            Collections.sort(mergedMail.get(i));
            ArrayList<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String str : mergedMail.get(i)){
                temp.add(str);
            }

            res.add(temp);
        }

        return res;
    }
}