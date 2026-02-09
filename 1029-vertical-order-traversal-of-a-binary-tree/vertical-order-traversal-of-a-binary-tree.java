/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int row, int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Pair{
    int row;
    int val;
    Pair(int row, int val){
        this.row=row;
        this.val=val;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        TreeMap<Integer, PriorityQueue<Pair>> mp=new TreeMap<>();
        while(q.size()>0){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int row=t.row;
            int col=t.col;

            if(!mp.containsKey(col)){
                mp.put(col, new PriorityQueue<>(
                    (a, b)->{
                        if(a.row!=b.row)    return a.row-b.row;
                        else    return a.val-b.val;
                    }
                ));
            }
            mp.get(col).add(new Pair(row,node.val));

            if(node.left!=null){
                q.add(new Tuple(node.left, row+1, col-1));
            }
            if(node.right!=null){
                q.add(new Tuple(node.right, row+1, col+1));
            }

        }

        for(Map.Entry<Integer, PriorityQueue<Pair>> entry : mp.entrySet()){
            PriorityQueue<Pair> pq=entry.getValue();
            List<Integer> li=new ArrayList<>();
            while(pq.size()>0){
                Pair p=pq.poll();
                li.add(p.val);
            }
            res.add(li);
        }
        return res;
    }
}