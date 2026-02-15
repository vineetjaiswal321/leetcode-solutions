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
    int cnt=0, ans=0;
    // public void helper(TreeNode root, int k){
    //     if(root==null)  return;
    //     helper(root.left, k);
    //     cnt+=1;
    //     if(cnt==k){
    //         ans=root.val;
    //         return;
    //     }
    //     helper(root.right, k);
    // }
    public int kthSmallest(TreeNode root, int k) {
        // helper(root, k);
        // return ans;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                cnt+=1;
                if(cnt==k)  return curr.val;
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr) prev=prev.right;
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    cnt+=1;
                    if(cnt==k)  return curr.val;
                    curr=curr.right;
                }
            }
        }
        return -1;
    }
}