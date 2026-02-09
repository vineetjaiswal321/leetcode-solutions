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
    public void helper(TreeNode root, int level){
        if(root==null)  return;

        if(level==li.size())    li.add(root.val);
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        li=new ArrayList<>();
        helper(root, 0);
        return li;
    }
}