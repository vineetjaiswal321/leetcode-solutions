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
class Solution {
    List<Integer> li;
    public void inOrder(TreeNode root){
        if(root==null)  return;
        inOrder(root.left);
        li.add(root.val);
        inOrder(root.right);
    }
    public TreeNode solve(int l, int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(li.get(mid));
        root.left=solve(l, mid-1);
        root.right=solve(mid+1, r);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        li=new ArrayList<>();
        inOrder(root);
        return solve(0, li.size()-1);
    }
}