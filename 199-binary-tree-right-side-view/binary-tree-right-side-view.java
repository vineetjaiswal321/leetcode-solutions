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
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        if(root==null)  return li;
        TreeMap<Integer, Integer> mp=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        while(q.size()>0){
            Pair p=q.poll();
            TreeNode node=p.node;
            int level=p.level;
            mp.put(level, node.val);
            if(node.left!=null) q.add(new Pair(node.left, level+1));
            if(node.right!=null) q.add(new Pair(node.right, level+1));
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            li.add(entry.getValue());
        }
        return li;
    }
}