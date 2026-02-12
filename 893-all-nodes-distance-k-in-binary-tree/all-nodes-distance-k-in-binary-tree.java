/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        Map<TreeNode, TreeNode> mp=new HashMap<>();
        mp.put(root, null);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                mp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right!=null){
                mp.put(node.right, node);
                q.offer(node.right);
            }
        }
        Set<TreeNode> isVisted=new HashSet<>();
        q.offer(target);
        isVisted.add(target);
        int dis=0;
        while(true){
            if(dis==k)  break;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !isVisted.contains(node.left)){
                    q.offer(node.left);
                    isVisted.add(node.left);
                }
                if(node.right!=null && !isVisted.contains(node.right)){
                    q.offer(node.right);
                    isVisted.add(node.right);
                }
                if(mp.get(node)!=null && !isVisted.contains(mp.get(node))){
                    q.offer(mp.get(node));
                    isVisted.add(mp.get(node));
                }
            }
            dis+=1;
        }
        List<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            li.add(q.poll().val);
        }
        return li;
    }
}