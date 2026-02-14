/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)   return "";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.append("n ");
                continue;
            } 
            res.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))    return null;
        String[] values=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1;i<values.length;i+=2){
            TreeNode node=q.poll();
            if(!values[i].equals("n")){
                node.left=new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }

            if(i + 1 < values.length && !values[i+1].equals("n")){
                node.right=new TreeNode(Integer.parseInt(values[i+1]));
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));