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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node=node;
        this.num=num;
    }
}
class Solution {
    //root left right
    List<Integer> pre;
    List<Integer> in;
    List<Integer> post;
    public void preOrder(TreeNode root){
        if(root==null)  return;
        // li.add(root.val);
        // preOrder(root.left);
        // preOrder(root.right);
        // Stack<TreeNode> st=new Stack<>();
        // st.push(root);
        // while(!st.isEmpty()){
        //     TreeNode t=st.pop();
        //     li.add(t.val);
        //     if(t.right!=null)   st.push(t.right);
        //     if(t.left!=null)   st.push(t.left);
        // }

        // Stack<Pair> st=new Stack<>();
        // st.push(new Pair(root, 1));
        // while(!st.isEmpty()){
        //     Pair it=st.pop();
        //     if(it.num==1){
        //         it.num+=1;
        //         pre.add(it.node.val);
        //         st.push(it);
        //         if(it.node.left!=null)  st.push(new Pair(it.node.left, 1));
        //     }
        //     else if(it.num==2){
        //         it.num+=1;
        //         in.add(it.node.val);
        //         st.push(it);
        //         if(it.node.right!=null)
        //         st.push(new Pair(it.node.right, 1));
        //     }
        //     else{
        //         post.add(it.node.val);
        //     }
        // }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        pre=new ArrayList<>();
        // in = new ArrayList<>();
        // post = new ArrayList<>();
        // preOrder(root);
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                pre.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr) prev=prev.right;
                if(prev.right==null){
                    pre.add(curr.val);
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return pre;
    }
}