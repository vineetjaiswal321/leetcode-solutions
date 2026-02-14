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
 //preorder :  root, left, right
 //inorder :  left root right
class Solution {
    public TreeNode createTree(int preL, int preH, int[] preorder, int inL, int inH, int[] inorder, Map<Integer, Integer> mp){
        if(preL>preH || inL>inH)    return null;
        TreeNode root=new TreeNode(preorder[preL]);
        int inroot=mp.get(root.val);
        int numLeft=inroot-inL;
        root.left=createTree(preL+1, preL+numLeft, preorder, inL, inroot-1, inorder, mp);
        root.right=createTree(preL+numLeft+1, preH, preorder, inroot+1, inH, inorder, mp);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)    mp.put(inorder[i], i);
        return createTree(0, n-1, preorder, 0, n-1, inorder, mp);
    }
}