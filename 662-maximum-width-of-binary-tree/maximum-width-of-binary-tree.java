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
        while(q.size()>0){
            int size=q.size();
            int min=q.peek().idx;
            int l=0, r=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int cur_idx=p.idx-min;
                TreeNode node=p.node;
                
                if(i==0)    l=cur_idx;
                if(i==size-1)   r=cur_idx;
                if(node.left!=null) q.offer(new Pair(node.left, cur_idx*2+1));
                if(node.right!=null) q.offer(new Pair(node.right, cur_idx*2+2));
            }
            ans=Math.max(r-l+1, ans);
        }
        return ans;
    }
}