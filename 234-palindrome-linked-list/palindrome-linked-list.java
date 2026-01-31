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
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)   return head;
        ListNode newNode=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;
    }
    public boolean isPalindrome(ListNode head) {
        //123321
        if(head==null || head.next==null)   return true;
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode revHead=reverseList(slow);
        ListNode temp1=head, temp2=revHead;
        while(temp1!=null && temp2!=null){
            if(temp1.val!=temp2.val)    return false;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
}