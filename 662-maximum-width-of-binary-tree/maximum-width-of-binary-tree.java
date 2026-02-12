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
    int idx;
    Pair(TreeNode node, int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size=q.size();
            int l=0, r=0;
            int min=q.peek().idx;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                int idx=p.idx;
        
                int cur_idx=idx-min;
                if(i==0)    l=cur_idx;
                if(i==size-1)   r=cur_idx;

                if(node.left!=null) q.offer(new Pair(node.left, 2*cur_idx+1));
                if(node.right!=null) q.offer(new Pair(node.right, 2*cur_idx+2));
            }
            ans=Math.max(ans, r-l+1);
        }
        return ans;
    }
}