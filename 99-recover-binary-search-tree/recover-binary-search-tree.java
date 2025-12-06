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
    TreeNode prev=null;
    TreeNode f=null;
    TreeNode s=null;
    public void swap(TreeNode first, TreeNode sec)
    {
        int temp=first.val;
        first.val=sec.val;
        sec.val=temp;
    }
    //By Recurssion
    // public void inorder(TreeNode root)
    // {
    //     if(root==null)  return;
    //     inorder(root.left);
    //     if(prev!=null)
    //     {
    //         if(prev.val>root.val){
    //             if(s!=null && s.val>root.val)  s=root;
    //             else{
    //                 f=prev;
    //                 s=root;
    //             }
    //         }
    //     }
    //     prev=root;
    //     inorder(root.right);        
    // }
    
    //By Morris Traversal
    public void morrisTrav(TreeNode root)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr)   pred=pred.right;
                if(pred.right==null){   //Linking pred->curr
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){   //UnLinking pred -/> curr
                    pred.right=null;
                    if(prev!=null)
                    {
                        if(prev.val>curr.val){
                            if(s!=null && s.val>curr.val)  s=curr;
                            else{
                                f=prev;
                                s=curr;
                            }
                        }
                    }
                    prev=curr;
                    curr=curr.right;
                }
            }
            else{
                if(prev!=null)
                {
                    if(prev.val>curr.val){
                        if(s!=null && s.val>curr.val)  s=curr;
                        else{
                            f=prev;
                            s=curr;
                        }
                    }
                }
                prev=curr;
                curr=curr.right;
            }
        }
    }
    public void recoverTree(TreeNode root) {
        morrisTrav(root);
        if(f!=null && s!=null)  swap(f,s);
        return;
    }
}