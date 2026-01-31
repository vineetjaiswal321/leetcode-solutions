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
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        ListNode curr=new ListNode(-1);
        ListNode newHead=curr;
        while(!st.isEmpty()){
            ListNode neww=new ListNode(st.pop());
            curr.next=neww;
            curr=curr.next;
        }
        return newHead.next;
    }
}