/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode createNode(List<Integer> l, int lo, int hi)
    {
        if(lo>hi)   return null;
        int mid=(lo+hi)/2;
        TreeNode root=new TreeNode(l.get(mid));
        root.left=createNode(l, lo, mid-1);
        root.right=createNode(l, mid+1, hi);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int n=0;
        List<Integer> l=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null)
        {
            l.add(temp.val);
            n++;
            temp=temp.next;
        }
        return createNode(l, 0, n-1);
    }
}