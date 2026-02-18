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
    Stack<TreeNode> st1=new Stack<>();
    Stack<TreeNode> st2=new Stack<>();
    public void BSTIterator1(TreeNode root){
        for(; root!=null; st1.push(root), root=root.left);
    }
    public void BSTIterator2(TreeNode root){
        for(; root!=null; st2.push(root), root=root.right);
    }
    public int next1(){
        TreeNode curr=st1.pop();
        BSTIterator1(curr.right);
        return curr.val;
    }
    public int next2(){
        TreeNode curr=st2.pop();
        BSTIterator2(curr.left);
        return curr.val;
    }
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator1(root);
        BSTIterator2(root);
        int x=next1(),  y=next2();
        while(x<y){
            if(x+y==k)  return true;
            else if(x+y>k){
                y=next2();
            }
            else{
                x=next1();
            }
        }
        return false;
    }
}