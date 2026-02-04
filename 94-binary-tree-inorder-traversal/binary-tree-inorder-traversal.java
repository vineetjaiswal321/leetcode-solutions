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
    //left root right
    List<Integer> li;
    public void inOrder(TreeNode root){
        if(root==null)  return;
        // inOrder(root.left);
        // li.add(root.val);
        // inOrder(root.right);
        Stack<TreeNode> st=new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                root=st.pop();
                li.add(root.val);
                root=root.right;
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        li=new ArrayList<>();
        inOrder(root);
        return li;
    }
}