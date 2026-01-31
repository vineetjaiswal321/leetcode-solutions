/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLen(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len+=1;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m=getLen(headA), n=getLen(headB);
        if(m>n){
            for(int i=0;i<m-n;i++){
                headA=headA.next;
            }
        }
        else{
            for(int i=0;i<n-m;i++){
                headB=headB.next;
            }
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}