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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)    return head;
        ListNode odd=new ListNode(-1);
        ListNode o=odd;
        ListNode even=new ListNode(-1);
        ListNode e=even;
        ListNode temp=head;
        int i=1;
        while(temp!=null){
            ListNode nextNode=temp.next;
            temp.next=null;
            if(i%2==0){
                //even
                even.next=temp;
                even=even.next;
            }
            else{
                //odd
                odd.next=temp;
                odd=odd.next;
            }
            temp=nextNode;
            i+=1;
        }
        odd.next=e.next;
        return o.next;
    }
}