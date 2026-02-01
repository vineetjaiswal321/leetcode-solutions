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
    public ListNode getKNode(ListNode head, int k){
        ListNode temp=head;
        for(int i=1;i<k && temp!=null;i++){
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)   return head;
        ListNode newNode=reverseList(head.next);
        ListNode front=head.next;
        head.next=null;
        front.next=head;
        return newNode;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head, prev=null;
        while(temp!=null){
            ListNode kthNode=getKNode(temp, k);
            if(kthNode==null){
                if(prev!=null)    prev.next=temp;
                break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            ListNode revHead=reverseList(temp);
            
            if(temp==head){
                prev=temp;
                head=kthNode;
            }
            else{
                prev.next=revHead;
                prev=temp;
            }
            temp=nextNode;
        }
        return head;
    }
}