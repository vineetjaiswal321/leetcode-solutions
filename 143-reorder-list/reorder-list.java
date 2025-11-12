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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;
        //Middle of LinkedList
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //Reverse of the linkedlist
        ListNode curr=slow.next;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //connections
        slow.next=null;
        ListNode h1=head, h2=prev;
        ListNode ahead=null;
        while(h1!=null && h2!=null){
            ahead=h2.next;
            h2.next=h1.next;
            h1.next=h2;
            h1=h2.next;
            h2=ahead;
        }
    }
}