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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1=list1, t2=list2, temp=new ListNode(-1), t=temp;
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                temp.next=t1;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                t2=t2.next;
            }
            temp=temp.next;
        }
        temp.next=(t1==null) ? t2 : t1;
        return t.next;
    }
}