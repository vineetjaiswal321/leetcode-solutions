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
//inorder : left root right
//postorder : left right root
class Solution {
    public TreeNode createTree(int inl, int inh, int[] inorder, int postl, int posth, int[] postorder, Map<Integer, Integer> mp){
        if(inl>inh || postl>posth)      return null;
        TreeNode root=new TreeNode(postorder[posth]);
        int inroot=mp.get(root.val);
        int numLeft=inroot-inl;
        root.left=createTree(inl, inroot-1, inorder, postl, postl+numLeft-1, postorder, mp);
        root.right=createTree(inroot+1, inh, inorder, postl+numLeft, posth-1, postorder, mp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)    mp.put(inorder[i], i);
        return createTree(0, n-1, inorder, 0, n-1, postorder, mp);
    }
}