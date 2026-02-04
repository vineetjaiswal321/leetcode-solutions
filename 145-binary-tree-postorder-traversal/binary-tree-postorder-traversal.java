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
    //left right root
    List<Integer> li;
    public void postOrder(TreeNode root){
        if(root==null)  return;
        postOrder(root.left);
        postOrder(root.right);
        li.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        li=new ArrayList<>();
        postOrder(root);
        return li;
    }
}