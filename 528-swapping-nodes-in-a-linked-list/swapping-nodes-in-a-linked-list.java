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
    public ListNode swapNodes(ListNode head, int k) {
        int len=0;
        ListNode h=head;
        while(h!=null){
            h=h.next;
            len++;
        }
        h=head;
        ListNode h1=head, h2=head;
        for(int i=1;i<k;i++){
            h1=h1.next;
        }
        for(int i=0;i<len-k;i++){
            h2=h2.next;
        }
        int temp=h1.val;
        h1.val=h2.val;
        h2.val=temp;
        return head;

    }
}