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
    List<Integer> in;
    public void inOrder(TreeNode root){
        //if(root==null)  return;
        // inOrder(root.left);
        // li.add(root.val);
        // inOrder(root.right);
        // Stack<TreeNode> st=new Stack<>();
        // while(true){
        //     if(root!=null){
        //         st.push(root);
        //         root=root.left;
        //     }
        //     else{
        //         if(st.isEmpty())    break;
        //         TreeNode node=st.pop();
        //         li.add(node.val);
        //         root=node.right;
        //     }
        // }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // pre=new ArrayList<>();
        in = new ArrayList<>();
        // post = new ArrayList<>();
        // inOrder(root);
        // return in;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                in.add(curr.val);
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
                    in.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return in;
    }
}