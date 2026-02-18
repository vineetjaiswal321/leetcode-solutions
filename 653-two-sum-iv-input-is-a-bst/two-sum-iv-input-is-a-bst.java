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
    public void pushLeft(TreeNode root){
        //inorder
        for(; root!=null; st1.push(root), root=root.left);
    }
    public int next1(){
        TreeNode curr=st1.pop();
        pushLeft(curr.right);
        return curr.val;
    }
    public void pushRight(TreeNode root){
        //reverse inorder
        for(; root!=null; st2.push(root), root=root.right);
    }
    public int next2(){
        TreeNode curr=st2.pop();
        pushRight(curr.left);
        return curr.val;
    }
    public boolean findTarget(TreeNode root, int k) {
        pushLeft(root);
        pushRight(root);
        int x=next1(), y=next2();
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