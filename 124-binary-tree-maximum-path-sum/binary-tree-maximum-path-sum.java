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
    int maxi;
    public int maxSum(TreeNode root){
        if(root==null)  return 0;

        int ls=Math.max(0, maxSum(root.left));
        int rs=Math.max(0, maxSum(root.right));
        maxi=Math.max(maxi, ls+rs+root.val);
        return root.val+Math.max(ls, rs);
    }
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        maxSum(root);
        return maxi;
    }
}