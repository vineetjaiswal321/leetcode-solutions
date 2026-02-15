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
    boolean flag=true;
    TreeNode prev=null;
    public void isValid(TreeNode root){
        if(root==null)  return;
        isValid(root.left);
        if(prev==null)  prev=root;
        else{
            if(prev.val>=root.val){
                flag=false;
                return;
            }
            else    prev=root;
        }
        isValid(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        isValid(root);
        return flag;
    }
}