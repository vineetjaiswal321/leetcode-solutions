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
    //root left right
    List<Integer> li;
    public void preOrder(TreeNode root){
        if(root==null)  return;
        // li.add(root.val);
        // preOrder(root.left);
        // preOrder(root.right);

        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode t=st.pop();
            li.add(t.val);
            if(t.right!=null)   st.push(t.right);
            if(t.left!=null)   st.push(t.left);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        li=new ArrayList<>();
        preOrder(root);
        return li;
    }
}