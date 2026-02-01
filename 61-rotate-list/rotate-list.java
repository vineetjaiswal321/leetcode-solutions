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
    public int len(ListNode head){
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len+=1;
            temp=temp.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)   return head;
        ListNode slow=head, fast=head;
        int length=len(head);
        for(int i=0;i<k%length;i++){
            fast=fast.next;
        }
        if(k%length==0)  return head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode nextNode=slow.next;
        slow.next=null;
        fast.next=head;
        return nextNode;
    }
}