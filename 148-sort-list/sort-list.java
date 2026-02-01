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
    public ListNode findMiddle(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode t1, ListNode t2){
        ListNode dummy=new ListNode(-1), curr=dummy;
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                curr.next=t1;
                t1=t1.next;
            }
            else{
                curr.next=t2;
                t2=t2.next;
            }
            curr=curr.next;
        }

        curr.next=(t1==null) ? t2 : t1;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)   return head;

        ListNode middle=findMiddle(head);
        ListNode right=middle.next;
        middle.next=null;
        ListNode left=head;

        left=sortList(left);
        right=sortList(right);

        return mergeList(left, right);
    }
}